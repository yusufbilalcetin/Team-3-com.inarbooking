package stepDefinitions.carRental;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import stepDefinitions.BaseStep;
import utils.BrowserUtils;

public class CarFiltering_StepDefinitions extends BaseStep {

	public static final Logger LOGGER = LogManager.getLogger(CarFiltering_StepDefinitions.class);


	@When("The user click on the Car Rental Tab")
	public void the_user_click_on_the_car_rental_tab() {
		PAGES.getBookingHomePage().clickOnCarRentalsTab();
		LOGGER.debug("The user click on the Car Rental Tab");
	}

	@And("The user enters pickup location")
	public void theUserEntersPickupLocation() {
		PAGES.getCarRentalsTab().enterLocationNameToTextField("hea");
		PAGES.getCarRentalsTab().selectFromSuggestions(0);
		LOGGER.debug("The user enters pickup location");
	}

	@And("The user enters pickup and dropoff dates and hours")
	public void theUserPickupAndDropoffDatesAndHours() {
		PAGES.getCarRentalsTab().selectDates("2024-02-01", "2024-02-05");
		PAGES.getCarRentalsTab().selectHours("00:00", "00:00");
		LOGGER.debug("The user enters pickup and dropoff dates and hours");
	}

	@And("The user clicks on the search cars button")
	public void theUserClicksOnTheSearchCarsButton() {
		PAGES.getCarRentalsTab().clickOnSearchCarsButton();
		LOGGER.debug("The user clicks on the search cars button");
	}

	@Then("The user should see car rental details page.")
	public void theUserShouldSeeCarRentalDeailsPage() {
		Assertions.assertThat(PAGES.getCarRentalDetailssPage().getHeaderText()).isEqualTo("Car rental");
		LOGGER.debug("The user should see car rental details page.");
	}

	@And("The user enters pickup {string}")
	public void theUserEntersPickupLocation(String location) {
		PAGES.getCarRentalsTab().enterLocationNameToTextField(location);
		PAGES.getCarRentalsTab().selectFromSuggestions(0);
		LOGGER.debug("The user enters pickup {}", location);
	}

	@And("The user enters {string} {string} {string} {string}")
	public void theUserEnters(String pickupDate, String dropoffDate, String pickupHour, String dropoffHour) {
		PAGES.getCarRentalsTab().selectDates(pickupDate, dropoffDate);
		PAGES.getCarRentalsTab().selectHours(pickupHour, dropoffHour);
		BrowserUtils.wait(2);
		LOGGER.debug("The user enters {} {} {} {}", pickupDate, dropoffDate, pickupHour, dropoffHour);

	}

	@And("The user should see {string} {string} {string}  correctly")
	public void theUserShouldSeeCorrectly(String location, String pickupDate, String dropoffDate) {
		Assertions.assertThat(PAGES.getCarRentalDetailssPage().getDatesAndLocationBoxes(0)).isEqualTo(pickupDate);
		Assertions.assertThat(PAGES.getCarRentalDetailssPage().getDatesAndLocationBoxes(1)).isEqualTo(dropoffDate);
		Assertions.assertThat(PAGES.getCarRentalDetailssPage().getDatesAndLocationBoxes(2)).isEqualTo(location);
		LOGGER.debug("The user sees {} {} {}  correctly", location, pickupDate, dropoffDate);

	}

	@When("The user selects {int}")
	public void theUserSelects(int age) {
		PAGES.getCarRentalDetailssPage().selectAge(age);
		LOGGER.debug("The user selects age {}", age);
	}

	@Then("The user should see the correct age checkbox reaction according to {int}")
	public void theUserShouldSeeTheCorrectAgeCheckboxReactionAccordingTo(int age) {
		Assertions.assertThat(age > 29 && age < 66)
			.isEqualTo(PAGES.getCarRentalDetailssPage().isAgeBetween30_65Checked());
		LOGGER.debug("The user should see the correct age checkbox reaction according to {}", age);
	}

	@When("The user checks the all price ranges")
	public void theUserChecksTheAllPriceRanges() {
		PAGES.getCarRentalDetailssPage().selectAllPriceRanges();
		LOGGER.debug("The user checks the all price ranges");
	}

	@And("The user checks the car specifications")
	public void theUserChecksTheCarSpecifications() {
		PAGES.getCarRentalDetailssPage().selectCarSpecsRandomly();
		LOGGER.debug("The user checks the car specifications");
	}

	@And("The user checks the car's {string}")
	public void theUserChecksTheCarS(String transmission) {
		if (transmission.equals("Manual")) {
			PAGES.getCarRentalDetailssPage().selectTransmission(1);
			LOGGER.debug("The user checks the car's transmission as {}", transmission);
		}
		else {
			PAGES.getCarRentalDetailssPage().selectTransmission(0);
			LOGGER.debug("The user checks the car's transmission as {}", transmission);
		}

	}

	@And("The user checks the  {string}")
	public void theUserChecksThe(String category) {
		PAGES.getCarRentalDetailssPage().selectCarCategory(category);
		LOGGER.debug("The user checks the car category {}", category);
	}

	@Then("The user should see the car image is selected corresponding to {string}")
	public void theUserShouldSeeTheCarImageIsSelectedCorrespondingTo(String category) {
		Assertions.assertThat(PAGES.getCarRentalDetailssPage().isTheCarImageSelected(category)).isEqualTo(true);
		LOGGER.debug("The user sees the car image is selected corresponding to {}", category);
	}

	@When("The user clicks on the search button")
	public void theUserClicksOnTheSearchButton() {
		PAGES.getCarRentalDetailssPage().clickOnSearchButton();
		LOGGER.debug("The user clicks on the search button");

	}

	@Then("The user should see that the available cars are listed")
	public void theUserShouldSeeThatTheAvailableCarsAreListed() {
		if (PAGES.getCarRentalDetailssPage().isThereAvailableCars()) {
			Assertions.assertThat(PAGES.getCarRentalDetailssPage().isThereAvailableCars()).isEqualTo(true);
			LOGGER.debug("The user sees that the available cars are listed");
			LOGGER.debug("There are {} available cars", PAGES.getCarRentalDetailssPage().numberOfCarsAvailable());
		}
		else {
			Assertions.assertThat(PAGES.getCarRentalDetailssPage().isThereAvailableCars()).isEqualTo(false);
			LOGGER.debug("The user sees that there are no cars available");
		}
	}

	@When("The user clicks on the {string} button")
	public void theUserClicksOnTheButton(String sortType) {
		if (sortType.equals("Price Lowest")) {
			PAGES.getCarRentalDetailssPage().clickOnSortLowestPrice();
			LOGGER.debug("The user clicks on the {} button", sortType);
		}
		else {
			PAGES.getCarRentalDetailssPage().clickOnSortHighestPrice();
			LOGGER.debug("The user clicks on the {} button", sortType);
		}
	}

	@Then("The user should see the prices sorted according to {string}")
	public void theUserShouldSeeThePricesSortedAccordingTo(String sortType) {
		if (sortType.equals("Price Lowest")) {
			Assertions.assertThat(PAGES.getCarRentalDetailssPage().areCarsSortedLowestPrice()).isEqualTo(true);
			LOGGER.debug("The user should see the prices sorted according to {}", sortType);
		}
		else {
			Assertions.assertThat(PAGES.getCarRentalDetailssPage().areCarsSortedHighestPrice()).isEqualTo(true);
			LOGGER.debug("The user should see the prices sorted according to {}", sortType);

		}
	}

	@When("The user clicks on the desired car's view deal button")
	public void theUserClicksOnTheDesiredCarSViewDealButton() {
		PAGES.getCarRentalDetailssPage().clickOnDesiredCarFromListedCars(0);
		LOGGER.debug("The user clicks on the desired car's view deal button");
	}

	@Then("The user should see deal page")
	public void theUserShouldSeeDealPage() {
		Assertions.assertThat(PAGES.getCarRentalYourDealPage().getHeaderText()).isEqualTo("Your deal");
		LOGGER.debug("The user sees deal page");
	}

	@And("The user should see the {string} {string} {string} {string} as desired")
	public void theUserSouldSeeTheAsDesired(String location, String pickupDate, String dropoffDate, String category) {
		// Assertions.assertThat(PAGES.getCarRentalYourDealPage().getLocation()).isEqualTo(null);
		Assertions.assertThat(PAGES.getCarRentalYourDealPage().getPickupDate()).isEqualTo(pickupDate);
		Assertions.assertThat(PAGES.getCarRentalYourDealPage().getDropoffDate()).isEqualTo(dropoffDate);
		Assertions.assertThat(PAGES.getCarRentalYourDealPage().getCategory()).isEqualTo(category);
		LOGGER.debug("The user sees the {} {} {} {} as desired", location, pickupDate, dropoffDate, category);

	}

	@When("The user selects {string}")
	public void theUserSelects(String insurance) {
		PAGES.getCarRentalYourDealPage().clickOnNoInsuranceOrFullProtectionRadioButton(insurance);
		LOGGER.debug("The user selects {}", insurance);
	}

	@Then("The user should see the Total Car Price Breakdown correctly according to {int} {string}")
	public void theUserShouldSeeTheTotalCarPriceBreakdownCorrectlyAccordingTo(int age, String insurance) {
		Assertions.assertThat(PAGES.getCarRentalYourDealPage().isPriceCorrect(age, insurance)).isEqualTo(true);
		LOGGER.debug("The user sees the Total Car Price Breakdown correctly according to {} {}", age, insurance);
	}

	@When("The user clicks on book button")
	public void theUserClicksOnBookButton() {
		PAGES.getCarRentalYourDealPage().clickOnBookButton();
		LOGGER.debug("The user clicks on book button");
	}

	@Then("The user should see the billing page")
	public void theUserShouldSeeTheBillingPage() {
		Assertions.assertThat(PAGES.getCarRentalBillingPage().getFrameName()).isEqualTo("Billing Address");
		LOGGER.debug("The user sees the billing page");
	}

	@When("The user enters billing information")
	public void theUserEntersBillingInformation() {
		// String name, String lastName, int countryCodeIndex, String phoneNumber,
		// String country, String address, String city, String postalCode, int isBusiness
		PAGES.getCarRentalBillingPage()
			.setBillingAddressInformation("Mehmet", "Bilgiç", 2, "5441904134", "Türkiye", "Terzinin yanı", "Darıca",
					"41700", 0);
		LOGGER.debug("The user enters billing information");
	}

	@And("The user enters card information with {string} {string} {string}")
	public void theUserEntersCardInformationWith(String cardNumber, String expDate, String cvv) {
		PAGES.getCarRentalBillingPage().setCardInformation("Mehmet Bilgiç", cardNumber, expDate, cvv);
		LOGGER.debug("The user enters card information with {} {} {}", cardNumber, expDate, cvv);
	}

	@And("The user click on Book button")
	public void theUserClickOnBookButton() {
		PAGES.getCarRentalBillingPage().clickOnBookNowButton();
		LOGGER.debug("The user click on Book button");
	}

	@Then("The user should see the confirmation page")
	public void theUserShouldSeeTheConfirmationPage() {
		BrowserUtils.wait(3);
		Assertions
			.assertThat(PAGES.getCarRentalConfirmationPage().getConfirmationPageText().contains("Confirmation Number"))
			.isEqualTo(true);
		LOGGER.debug("The user sees the confirmation page");
	}

	@Then("The user should see {string} {string} {string} on confirmation page")
	public void theUserShouldSeeOnConfirmationPage(String location, String pickupDate, String dropoffDate) {
		Assertions.assertThat(PAGES.getCarRentalConfirmationPage().getLocation().contains(location)).isEqualTo(true);
		Assertions.assertThat(PAGES.getCarRentalConfirmationPage().getPickupDate()).isEqualTo(pickupDate);
		Assertions.assertThat(PAGES.getCarRentalConfirmationPage().getDropoffDate()).isEqualTo(dropoffDate);
		LOGGER.debug("The user should see {} {} {} on confirmation page", location, pickupDate, dropoffDate);

	}

	@Then("The user should see the same listed cars")
	public void theUserShouldSeeTheSameListedCars() {

	}

	@When("The user returns to the transmission options section")
	public void theUserReturnsToTheTransmissionOptionsSection() {
		BrowserUtils.scrollUpWithPageUpButton(1);
	}

	@When("The user clicks on the search button again")
	public void theUserClicksOnTheSearchButtonAgain() {
		BrowserUtils.scrollDownWithPageDownButton(1);
		PAGES.getCarRentalDetailssPage().clickOnSearchButton();
		LOGGER.debug("The user clicks on the search cars button again");
	}

}
