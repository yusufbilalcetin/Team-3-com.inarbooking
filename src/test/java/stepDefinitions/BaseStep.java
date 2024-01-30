package stepDefinitions;

import org.openqa.selenium.WebDriver;
import pages.flights.Flights_FilterAndList_Page;
import pages.headerSection.BookingHomePage;
import pages.hotels.Hotels_FilterAndList_Page;
import utils.DriverManager;
import utils.Pages;

public class BaseStep {

	protected final Pages PAGES = new Pages();

	protected final BookingHomePage HOMEPAGE = PAGES.getBookingHomePage();

	protected final Hotels_FilterAndList_Page HOTELSFILTER = PAGES.getHotels_filterAndList_page();

	protected final Flights_FilterAndList_Page FLIGHTSFILTER = PAGES.getFlightsFilterAndListPage();

	protected final WebDriver DRIVER = DriverManager.getDriver();

}