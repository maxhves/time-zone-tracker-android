package uk.co.mhl.timezonetracker.feature.timezones

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import uk.co.mhl.timezones.core.data.repository.TimeRepository
import java.time.ZoneId
import javax.inject.Inject

@HiltViewModel
class TimezonesViewModel @Inject constructor(
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