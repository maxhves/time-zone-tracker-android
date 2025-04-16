package uk.co.mhl.timezonetracker.feature.addtimezone

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
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

    val searchQueryState = MutableStateFlow("")

    val uiState = searchQueryState.flatMapLatest { query ->
        cityRepository.searchAllCities(query).map { cities ->
            AddTimeZoneUiState(
                cities = cities,
            )
        }
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

    //region Events

    fun onSearchQueryChange(query: String) {
        searchQueryState.update { query }
    }

    fun onCityClick(city: City) {
        viewModelScope.launch {
            userDataRepository.setCityIdTracked(cityId = city.id, tracked = true)
            _effects.emit(OnCityTracked)
        }
    }

    //endregion
}