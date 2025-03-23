package uk.co.mhl.timezonetracker.feature.timezones

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import uk.co.mhl.timezones.core.data.TimeRepository
import java.time.ZoneId

class TimezonesViewModel(
    zonedTimeRepository: TimeRepository,
) : ViewModel() {
    //region State

    val state: StateFlow<TimezonesUiState> = zonedTimeRepository
        .getZonedCurrentTime(ZoneId.systemDefault())
        .map { TimezonesUiState(currentTime = it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = TimezonesUiState(),
        )

    //endregion
}