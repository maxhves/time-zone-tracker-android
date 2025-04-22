package uk.co.mhl.timezonetracker.feature.timezones

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import uk.co.mhl.timezonetracker.core.data.repository.CityRepository
import uk.co.mhl.timezonetracker.core.data.repository.TimeRepository
import uk.co.mhl.timezonetracker.core.data.repository.UserDataRepository
import java.time.Instant
import javax.inject.Inject

@HiltViewModel
class TimeZonesViewModel @Inject constructor(
    currentTimeRepository: TimeRepository,
    cityRepository: CityRepository,
    private val userDataRepository: UserDataRepository,
) : ViewModel() {
    //region State

    val currentTimeState = currentTimeRepository.getCurrentTime()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = Instant.now(),
        )

    val trackedCitiesState = userDataRepository.observeTrackedCityIds()
        .flatMapLatest { cityRepository.observeByIds(it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )

    //endregion

    //region Events

    fun onRemoveCityClick(cityId: Int) {
        viewModelScope.launch {
            userDataRepository.setCityIdTracked(cityId, false)
        }
    }

    //endregion
}