package utils;

import lombok.Data;
import pages.HomePage;
import pages.carRentals.CarRentalDetails_Page;
import pages.carRentals.YourDeal_Page;
import pages.flights.Flights_FilterAndList_Page;
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

	private CarRentalDetails_Page carRentalDetailsPage;

	private YourDeal_Page yourDealPage;

	public Pages() {
		homePage = new HomePage();

		hotelTab = new HotelTab();
		flightTab = new FlightTab();

		hotel_detailPage = new Hotel_DetailPage();
		hotels_filterAndList_page = new Hotels_FilterAndList_Page();

		bookingHomePage = new BookingHomePage();

		flightsFilterAndListPage = new Flights_FilterAndList_Page();

		carRentalDetailsPage = new CarRentalDetails_Page();
		yourDealPage = new  YourDeal_Page();

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

	public CarRentalDetails_Page getCarRentalDetailsPage() { return carRentalDetailsPage; }

	public YourDeal_Page getYourDealPage() { return yourDealPage; }

}
