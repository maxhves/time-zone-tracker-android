package uk.co.mhl.timezonetracker.feature.addtimezone

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import uk.co.mhl.timezonetracker.core.data.repository.CityRepository
import uk.co.mhl.timezonetracker.core.model.City
import javax.inject.Inject

@HiltViewModel
class AddTimezoneViewModel @Inject constructor(
    private val cityRepository: CityRepository,
) : ViewModel() {
    //region State

    private val _filterState = MutableStateFlow("")
    private val _citiesState = MutableStateFlow(emptyList<City>())

    val state = combine(
        _filterState,
        _citiesState
    ) { query, cities ->
        val filteredGroupedCities = cities.filterThenGroupAlphabetically(query)
        AddTimezoneUiState(cities = filteredGroupedCities)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = AddTimezoneUiState(),
    )

    //endregion

    //region Initialization

    init {
        getAllCities()
    }

    private fun getAllCities() {
        viewModelScope.launch {
            _citiesState.update {
                cityRepository.getAll()
            }
        }
    }

    //endregion

    //region Helper

    private fun List<City>.filterThenGroupAlphabetically(query: String): Map<Char, List<City>> {
        return asSequence()
            .filter { query.isBlank() || it.name.contains(query, ignoreCase = true) }
            .groupBy { it.name.first().uppercaseChar() }
    }

    //endregion
}