package utils;

import lombok.Data;
import org.checkerframework.checker.units.qual.C;
import pages.HomePage;
import pages.carRentals.CarRentalBilling_Page;
import pages.carRentals.CarRentalConfirmation_Page;
import pages.carRentals.CarRentalDetails_Page;
import pages.carRentals.CarRentalYourDeal_Page;
import pages.flights.Flights_FilterAndList_Page;
import pages.headerSection.CarRentalsTab;
import pages.headerSection.FlightTab;
import pages.headerSection.HotelTab;

import pages.headerSection.BookingHomePage;

import pages.hotels.Hotel_DetailPage;
import pages.hotels.Hotels_FilterAndList_Page;

@Data
public class Pages {

	private HomePage homePage;

	private HotelTab hotelTab;

	private FlightTab flightTab;

	private Hotel_DetailPage hotel_detailPage;

	private Hotels_FilterAndList_Page hotels_filterAndList_page;

	private BookingHomePage bookingHomePage;

	private Flights_FilterAndList_Page flightsFilterAndListPage;

	private CarRentalsTab carRentalsTab;

	private CarRentalDetails_Page carRentalDetailsPage;

	private CarRentalBilling_Page carRentalBillingPage;

	private CarRentalYourDeal_Page carRentalYourDealPage;

	private CarRentalConfirmation_Page carRentalConfirmationPage;

	public Pages() {
		homePage = new HomePage();
		hotelTab = new HotelTab();
		flightTab = new FlightTab();
		hotel_detailPage = new Hotel_DetailPage();
		hotels_filterAndList_page = new Hotels_FilterAndList_Page();
		bookingHomePage = new BookingHomePage();
		flightsFilterAndListPage = new Flights_FilterAndList_Page();
		carRentalsTab = new CarRentalsTab();
		carRentalConfirmationPage = new CarRentalConfirmation_Page();
		carRentalBillingPage = new CarRentalBilling_Page();
		carRentalYourDealPage = new CarRentalYourDeal_Page();
		carRentalDetailsPage = new CarRentalDetails_Page();
	}

	public HomePage getHomePage() {
		return homePage;
	}

	public HotelTab getHotelTab() {
		return hotelTab;
	}

	public FlightTab getFlightTab() {
		return flightTab;
	}

	public Hotel_DetailPage getHotel_detailPage() {
		return hotel_detailPage;
	}

	public Hotels_FilterAndList_Page getHotels_filterAndList_page() {
		return hotels_filterAndList_page;
	}

	public BookingHomePage getBookingHomePage() {
		return bookingHomePage;
	}

	public Flights_FilterAndList_Page getFlightsFilterAndListPage() {
		return flightsFilterAndListPage;
	}

	public CarRentalsTab getCarRentalsTab() {
		return carRentalsTab;
	}

	public CarRentalDetails_Page getCarRentalDetailsPage() {
		return carRentalDetailsPage;
	}

	public CarRentalBilling_Page getCarRentalBillingPage() {
		return carRentalBillingPage;
	}

	public CarRentalYourDeal_Page getCarRentalYourDealPage() {
		return carRentalYourDealPage;
	}

	public CarRentalConfirmation_Page getCarRentalConfirmationPage() {
		return carRentalConfirmationPage;
	}

}
