package uk.co.mhl.timezonetracker.feature.timezones

import org.junit.Before
import org.junit.Rule
import uk.co.mhl.timezonetracker.core.testing.TestCityRepository
import uk.co.mhl.timezonetracker.core.testing.TestTimeRepository
import uk.co.mhl.timezonetracker.core.testing.TestUserDataRepository
import uk.co.mhl.timezonetracker.core.testing.util.MainDispatcherRule

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
}