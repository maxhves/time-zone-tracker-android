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
import javax.inject.Inject

@HiltViewModel
class TimezonesViewModel @Inject constructor(
    currentTimeRepository: TimeRepository,
    cityRepository: CityRepository,
) : ViewModel() {
    //region State

    val state: StateFlow<TimezonesUiState> = currentTimeRepository
        .getCurrentTime()
        .map {
            TimezonesUiState(currentTime = it)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = TimezonesUiState(),
        )

    //endregion

    // region Testing

    init {
        viewModelScope.launch {
            cityRepository.observeAll().collect { cities ->
                Log.i("TimezonesViewModel", cities.toString())
            }
        }
    }

    //endregion
}