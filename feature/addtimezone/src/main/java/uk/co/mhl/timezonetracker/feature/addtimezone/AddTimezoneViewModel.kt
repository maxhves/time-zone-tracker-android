package uk.co.mhl.timezonetracker.feature.addtimezone

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uk.co.mhl.timezonetracker.core.data.repository.CityRepository
import javax.inject.Inject

@HiltViewModel
class AddTimezoneViewModel @Inject constructor(
    cityRepository: CityRepository,
) : ViewModel() {
    //region State

    //endregion
}