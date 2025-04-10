package uk.co.mhl.timezonetracker.feature.timezones

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import uk.co.mhl.timezonetracker.core.data.repository.CityRepository
import uk.co.mhl.timezonetracker.core.data.repository.TimeRepository
import uk.co.mhl.timezonetracker.core.data.repository.UserDataRepository
import javax.inject.Inject

@HiltViewModel
class TimeZonesViewModel @Inject constructor(
    currentTimeRepository: TimeRepository,
    cityRepository: CityRepository,
    userDataRepository: UserDataRepository,
) : ViewModel() {
    //region State

    val state: StateFlow<TimeZonesUiState> = currentTimeRepository
        .getCurrentTime()
        .map {
            TimeZonesUiState(currentTime = it)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = TimeZonesUiState(),
        )

    //endregion

    // region Testing

    // TODO: Remove testing code.
    init {
        viewModelScope.launch {
            cityRepository.observeByIds(setOf(1, 11, 111, 2, 22, 222, 3, 33, 333)).collect { cities ->
                Log.i("TZVM_StoredCities", cities.toString())
            }
        }
        viewModelScope.launch {
            userDataRepository.observeTrackedCityIds().collect { cityIds ->
                Log.i("TZVM_TrackedCities", cityIds.toString())
            }
        }
    }
    // TODO: Remove testing code.

    //endregion
}