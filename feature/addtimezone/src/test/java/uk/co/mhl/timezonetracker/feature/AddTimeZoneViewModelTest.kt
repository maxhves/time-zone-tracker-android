package uk.co.mhl.timezonetracker.feature

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import uk.co.mhl.timezonetracker.core.testing.TestCityRepository
import uk.co.mhl.timezonetracker.core.testing.TestUserDataRepository
import uk.co.mhl.timezonetracker.core.testing.data.citiesTestData
import uk.co.mhl.timezonetracker.core.testing.util.MainDispatcherRule
import uk.co.mhl.timezonetracker.feature.addtimezone.AddTimeZoneViewModel
import kotlin.test.assertEquals

class AddTimeZoneViewModelTest {

    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    private val cityRepository = TestCityRepository()
    private val userDataRepository = TestUserDataRepository()

    private lateinit var viewModel: AddTimeZoneViewModel

    @Before
    fun setup() {
        viewModel = AddTimeZoneViewModel(
            cityRepository = cityRepository,
            userDataRepository = userDataRepository,
        )
    }

    @Test
    fun whenInitialized_allCitiesAreEmitted() = runTest {
        backgroundScope.launch(UnconfinedTestDispatcher()) { viewModel.uiState.collect() }

        cityRepository.sendCities(citiesTestData)
        val uiState = viewModel.uiState.value

        assertEquals(citiesTestData, uiState.cities.flatMap { it.value })
    }

    @Test
    fun onSearchQueryChange_matchingCitiesAreEmitted() = runTest {
        backgroundScope.launch(UnconfinedTestDispatcher()) { viewModel.uiState.collect() }

        cityRepository.sendCities(citiesTestData)
        viewModel.onSearchQueryChange(citiesTestData[3].name)
        val uiState = viewModel.uiState.value

        assertEquals(listOf(citiesTestData[3]), uiState.cities.flatMap { it.value })
    }

    @Test
    fun onCityClick_correctlyTracksCityId() = runTest {
        viewModel.onCityClick(citiesTestData[0])
        val trackedCityIds = userDataRepository.observeTrackedCityIds().first()

        assertEquals(setOf(citiesTestData[0].id), trackedCityIds)
    }
}