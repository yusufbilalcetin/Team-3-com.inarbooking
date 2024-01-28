package utils;

import lombok.Data;
import pages.HomePage;
import pages.headerSection.FlightTab;
import pages.headerSection.HotelTab;
import pages.headerSection.TabBar;
import pages.hotels.Hotel_DetailPage;
import pages.hotels.Hotels_FilterAndList_Page;

@Data
public class Pages {

	private HomePage homePage;

	private HotelTab hotelTab;

	private FlightTab flightTab;

	private Hotel_DetailPage hotel_detailPage;

	private Hotels_FilterAndList_Page hotels_filterAndList_page;

	private TabBar tabBar;

	public Pages() {
		homePage = new HomePage();

		hotelTab = new HotelTab();
		flightTab = new FlightTab();

		hotel_detailPage = new Hotel_DetailPage();
		hotels_filterAndList_page = new Hotels_FilterAndList_Page();

		tabBar = new TabBar();
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

	public TabBar getTabBar() {
		return tabBar;
	}

}
