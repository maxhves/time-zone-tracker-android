package uk.co.mhl.timezonetracker.feature.addtimezone

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import uk.co.mhl.timezonetracker.core.data.repository.CityRepository
import uk.co.mhl.timezonetracker.core.data.repository.UserDataRepository
import uk.co.mhl.timezonetracker.core.model.City
import javax.inject.Inject

@HiltViewModel
class AddTimeZoneViewModel @Inject constructor(
    private val cityRepository: CityRepository,
    private val userDataRepository: UserDataRepository,
) : ViewModel() {
    //region State

    private val _searchQueryState = MutableStateFlow("")
    private val _citiesState = MutableStateFlow(emptyList<City>())

    val state = combine(
        _searchQueryState,
        _citiesState
    ) { query, cities ->
        val filteredGroupedCities = cities.filterThenGroupAlphabetically(query)
        AddTimeZoneUiState(
            searchQuery = query,
            cities = filteredGroupedCities
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = AddTimeZoneUiState(),
    )

    //endregion

    //region Effects

    private val _effects = MutableSharedFlow<AddTimeZoneViewEffect>()
    val effects = _effects.asSharedFlow()

    //endregion

    //region Initialization

    init {
        getAllCities()
    }

    // TODO: Replace this functionality into a better flow, I don't like it.
    private fun getAllCities() {
        viewModelScope.launch {
            _citiesState.update {
                cityRepository.getAll()
            }
        }
    }

    //endregion

    //region Events

    fun onSearchQueryChange(query: String) {
        _searchQueryState.update { query }
    }

    fun onCityClick(city: City) {
        viewModelScope.launch {
            userDataRepository.setCityIdTracked(cityId = city.id, tracked = true)
            _effects.emit(OnCityTracked)
        }
    }

    //endregion

    //region Helper

    private fun List<City>.filterThenGroupAlphabetically(query: String): Map<Char, List<City>> {
        return if (query.isBlank()) {
            groupBy { it.name.first().uppercaseChar() }
        } else {
            asSequence()
                .filter { "${it.name} ${it.country}".contains(query, ignoreCase = true) }
                .groupBy { it.name.first().uppercaseChar() }
        }
    }

    //endregion
}