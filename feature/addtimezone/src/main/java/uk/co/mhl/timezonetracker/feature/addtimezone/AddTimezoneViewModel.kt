package uk.co.mhl.timezonetracker.feature.addtimezone

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import uk.co.mhl.timezonetracker.core.data.repository.CityRepository
import javax.inject.Inject

@HiltViewModel
class AddTimezoneViewModel @Inject constructor(
    private val cityRepository: CityRepository,
) : ViewModel() {
    //region State

    private val _state = MutableStateFlow(AddTimezoneUiState())
    val state = _state.asStateFlow()

    //endregion

    //region Initialization

    init {
        getAllCities()
    }

    private fun getAllCities() {
        viewModelScope.launch {
            _state.update { state ->
                state.copy(cities = cityRepository.getAll())
            }
        }
    }

    //endregion
}