package uk.co.mhl.timezonetracker.feature.timezones

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import uk.co.mhl.timezonetracker.core.model.City
import uk.co.mhl.timezonetracker.core.testing.TestCityRepository
import uk.co.mhl.timezonetracker.core.testing.TestTimeRepository
import uk.co.mhl.timezonetracker.core.testing.TestUserDataRepository
import uk.co.mhl.timezonetracker.core.testing.util.MainDispatcherRule
import java.time.Instant
import kotlin.test.assertEquals

class TimeZonesViewModelTest {

    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    private val currentTimeRepository = TestTimeRepository()
    private val cityRepository = TestCityRepository()
    private val userDataRepository = TestUserDataRepository()

    private lateinit var viewModel: TimeZonesViewModel

    @Before
    fun setup() {
        viewModel = TimeZonesViewModel(
            currentTimeRepository = currentTimeRepository,
            cityRepository = cityRepository,
            userDataRepository = userDataRepository,
        )
    }

    @Test
    fun whenInitialized_trackedCities_isEmpty() = runTest {
        assertEquals(emptyList(), viewModel.trackedCitiesState.value)
    }

    @Test
    fun currentTimeState_emitsCorrectTime() = runTest {
        backgroundScope.launch(UnconfinedTestDispatcher()) { viewModel.currentTimeState.collect() }

        val instantNow = Instant.now()
        currentTimeRepository.sendTime(instantNow)

        val currentTimeState = viewModel.currentTimeState.value

        assertEquals(instantNow, currentTimeState)
    }

    @Test
    fun trackedCitiesState_correctlyEmitsTrackedCity() = runTest {
        backgroundScope.launch(UnconfinedTestDispatcher()) { viewModel.trackedCitiesState.collect() }

        cityRepository.sendCities(testCities)
        userDataRepository.setCityIdTracked(1, true)

        val trackedCitiesState = viewModel.trackedCitiesState.value

        assertEquals(testCities[0], trackedCitiesState[0])
    }

    @Test
    fun onRemoveCity_unTracksCityId() = runTest {
        backgroundScope.launch(UnconfinedTestDispatcher()) { viewModel.trackedCitiesState.collect() }

        cityRepository.sendCities(testCities)
        userDataRepository.sendTrackedCities(testCityIds)

        viewModel.onRemoveCityClick(2)

        val trackedCitiesState = viewModel.trackedCitiesState.value

        assertEquals(listOf(1, 3), trackedCitiesState.map { it.id })
    }
}

private val testCities = listOf(
    City(
        id = 1,
        name = "London",
        country = "United Kingdom",
        zoneId = "Europe/London",
    ),
    City(
        id = 2,
        name = "Tokyo",
        country = "Japan",
        zoneId = "Asia/Tokyo",
    ),
    City(
        id = 3,
        name = "Auckland",
        country = "New Zealand",
        zoneId = "Pacific/Auckland",
    )
)

private val testCityIds = setOf(1, 2, 3)