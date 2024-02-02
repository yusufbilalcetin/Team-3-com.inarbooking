package stepDefinitions.flightBooking;

import config.ConfigurationManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.BDDAssertions;
import stepDefinitions.BaseStep;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.BrowserUtils;

import static org.assertj.core.api.BDDAssertions.then;

public class EndToEndFlight_StepDefs extends BaseStep {

	public static final Logger LOGGER = LogManager.getLogger(FlightTab_StepDefs.class);

	@When("The user click on the Flight Tab")
	public void the_user_click_on_the_flight_tab() {
		PAGES.getBookingHomePage().clickOnFlightsTab();
		LOGGER.info("The user click on the Flight Tab");
	}

	@When("The user selected {string} button")
	public void the_user_selected_button(String string) {
		PAGES.getFlightTab().chooseFlightType(string);
		LOGGER.info("The user selected button type " + string + " travel");

	}

	@When("The user selected button type {string} travel")
	public void the_user_selected_button_type_travel(String string) {
		PAGES.getFlightTab().chooseClass(string);
		LOGGER.info("The user selected button type " + string + " travel");

	}

	@When("the user selected {string} as departure country")
	public void the_user_selected_as_departure_country(String string) {
		PAGES.getFlightTab().chooseDepartureCountry(string);
		LOGGER.info("the user selected" + string + " as departure country");
	}

	@When("the user selected {string} as arrival country")
	public void the_user_selected_as_arrival_country(String string) {
		PAGES.getFlightTab().chooseArrivalCountry(string);
		LOGGER.info("the user selected " + string + " as arrival country");

	}

	@And("the user selected Departure and Return Dates")
	public void theUserSelectedDepartureAndReturnDates() {
		PAGES.getFlightTab().clickOnDateField();
		PAGES.getFlightTab().selectFirstDate(4); ///
		PAGES.getFlightTab().selectLastDate(11);
		LOGGER.info("the user selected Departure and Return Dates");

	}

	@When("The user click on the Search Flights Button")
	public void the_user_click_on_the_search_flights_button() {
		PAGES.getFlightTab().clickOnSearchFlight();
		LOGGER.info("The user click on the Search Flights Button");
	}

	@Then("the user sees the Flights Page")
	public void the_user_sees_the_flights_page() {
		BrowserUtils.wait(2);
		Assertions.assertThat(PAGES.getFlightsPage().getFlightPageText()).isEqualTo("Flights");
		LOGGER.info("the user sees the Flights Page");
	}

	@When("the user click on Search Button")
	public void the_user_click_on_search_button() {
		PAGES.getFlightsPage().clickOnSearcButton();
		LOGGER.info("the user click on Search Button");
	}

	@When("the user click on {string} tab")
	public void the_user_click_on_tab(String string) {
		BrowserUtils.scrollUpWithPageUpButton(2);
		PAGES.getFlightsPage().clickOnCheapestTab();
		LOGGER.info("the user click on" + string + " tab");
	}

	@When("the user click on Select Ticket button")
	public void theUserClickOnSelectTicketButton() {
		PAGES.getFlightsPage().clickOnSelectTicketButton();
		LOGGER.info("the user click on Select Ticket button");
	}

	@When("the user click on Select Return Ticket Button")
	public void theUserClickOnSelectReturnTicketButton() {
		PAGES.getFlightsPage().clickOnSelectReturnTicketButton();
		LOGGER.info("the user click on Select Return Ticket Button");
	}

	@Then("the user sees the Choose your fare Page.")
	public void the_user_sees_the_choose_your_fare_page() {
		Assertions.assertThat(PAGES.getChooseYourFarePage().getChooseYourFareTexts()).isEqualTo("Choose your fare");
		LOGGER.info("the user sees the Choose your fare Page.");

	}

	@When("the user click on {string} fare")
	public void the_user_click_on_fare(String string) {
		BrowserUtils.scrollDownWithPageDownButton(1);
		PAGES.getChooseYourFarePage().clickOnFareChoices();
		LOGGER.info("the user click on " + string + "fare");
	}

	@When("the user click on Select Who's flying button")
	public void the_user_click_on_select_who_s_flying_button() {
		PAGES.getChooseYourFarePage().clickOnWhosFlyingButton();
		LOGGER.info("the user click on Select Who's flying button");
	}

	@Then("the user sees the Who is flying page")
	public void the_user_sees_the_who_is_flying_page() {
		BrowserUtils.wait(2);
		Assertions.assertThat(PAGES.getWhosFlyingPage().getWhosFlyingText()).isEqualTo("Who's flying?");
		LOGGER.info("the user sees the Who is flying page");
	}

	@When("the user fills the email box with {string}")
	public void the_user_fills_the_email_box_with(String string) {
		PAGES.getWhosFlyingPage().enterEmail(string);
		LOGGER.info("the user fills the email box with" + string);

	}

	@And("the user selects the phoneNumberType")
	public void theUserSelectsThePhoneNumberType() {
		PAGES.getWhosFlyingPage().choosePhoneCode();
		LOGGER.info("the user selects the phone code");
	}

	@When("the user fills the phone number box with the {string}")
	public void the_user_fills_the_phone_number_box_with_the(String string) {
		PAGES.getWhosFlyingPage().enterPhoneNumberInputField(string);
		LOGGER.info("the user fills the phone number box with the" + string);
	}

	@When("the user selects the Get Free Text Messages Checkbox")
	public void the_user_selects_the_get_free_text_messages_checkbox() {
		PAGES.getWhosFlyingPage().clickOnCheckBoxForFreeMessages();
		LOGGER.info("the user selects the Get Free Text Messages Checkbox");
	}

	@When("the user fills the name box with the {string}")
	public void the_user_fills_the_name_box_with_the_alex(String string) {
		PAGES.getWhosFlyingPage().enterNameInputField(string);
		LOGGER.info("the user fills the name box with the " + string);
	}

	@When("the user fills the surname box with the {string}")
	public void the_user_fills_the_surname_box_with_the(String string) {
		PAGES.getWhosFlyingPage().enterLastNameInputField(string);
		LOGGER.info("the user fills the surname box with the " + string);
	}

	@When("the user selects the {string}")
	public void the_user_selects_the(String string) {
		PAGES.getWhosFlyingPage().selectGender(string);
		LOGGER.info("the user selects the gender");
	}

	@When("the user selects the birthdate year as {string}")
	public void the_user_selects_the_birthdate_year_as(String string) {
		PAGES.getWhosFlyingPage().setYearFromDropDownMenu(string);
		LOGGER.info("the user selects the birthdate year as " + string);
	}

	@When("the user selects the month as {string}")
	public void the_user_selects_the_month_as(String string) {
		PAGES.getWhosFlyingPage().setMonthFromDropDownMenu(string);
		LOGGER.info("the user selects the month as " + string);
	}

	@When("the user selects the birthdate day as {string}")
	public void the_user_selects_the_birthdate_day_as(String string) {
		PAGES.getWhosFlyingPage().setDayFromDropDownMenu(string);
		LOGGER.info("the user selects the birthdate day as" + string);
	}

	@When("the user click on Select Extras button")
	public void the_user_click_on_select_extras_button() {
		PAGES.getWhosFlyingPage().clickOnSelectExtrasButton();
		LOGGER.info("the user click on Select Extras button");
	}

	@Then("the user sees Extras for your Flight Page")
	public void the_user_sees_extras_for_your_flight_page() {
		Assertions.assertThat(PAGES.getExtrasForYourFlightPage().getExtrasForYourFlightText())
			.isEqualTo("Extras For Your Flight");
		LOGGER.info("the user sees Extras for your Flight Page");

	}

	@When("the user selects meal as {string}")
	public void the_user_selects_meal_as(String string) {
		PAGES.getExtrasForYourFlightPage().chooseMealType(string);
		LOGGER.info("the user selects meal as " + string);
	}

	@When("the user selects {string}")
	public void the_user_selects(String string) {
		PAGES.getExtrasForYourFlightPage().clickOnCheckBoxesForExtras();
		LOGGER.info("the user selects " + string);

	}

	@When("the user click on Go To Checkout Button")
	public void the_user_click_on_go_to_checkout_button() {
		PAGES.getExtrasForYourFlightPage().clickOnCheckOutButton();
		LOGGER.info("the user click on Go To Checkout Button");
	}

	@Then("the user sees the CheckOut Page")
	public void the_user_sees_the_check_out_page() {
		Assertions.assertThat(PAGES.getCheckAndPayPage().getCheckAndPayPageText()).isEqualTo("Check and pay");
		LOGGER.info("the user sees the CheckOut Page");
	}

	@When("the user fills the Cartholder's Name field with {string}")
	public void theUserFillsTheCartholderSNameFieldWith(String string) {
		PAGES.getCheckAndPayPage().enterCardHoldersName(string);
		LOGGER.info("the user fills the Cartholder's Name field with " + string);
	}

	@When("the user fills the card Number field with {string}")
	public void the_user_fills_the_card_number_field_with(String string) {
		PAGES.getCheckAndPayPage().enterCardNumber(string);
		LOGGER.info("the user fills the card Number field with " + string);
	}

	@When("the user fills the expiry date field with {string}")
	public void the_user_fills_the_expiry_date_field_with(String string) {
		PAGES.getCheckAndPayPage().enterExpirationDate(string);
		LOGGER.info("the user fills the expiry date field with " + string);

	}

	@When("the user fills the cvv field with {string}")
	public void the_user_fills_the_cvv_field_with(String string) {
		PAGES.getCheckAndPayPage().enterCvvCode(string);
		LOGGER.info("the user fills the cvv field with " + string);
	}

	@And("the user selects the acceptanceCheckBox of updates")
	public void theUserSelectsTheAcceptanceCheckBoxOfUpdates() {
		PAGES.getCheckAndPayPage().click_On_Accept_For_Transportation_CheckBox();
		LOGGER.info("the user selects the of updates");
	}

	@When("the user click on Complete Booking button")
	public void the_user_click_on_complete_booking_button() {
		PAGES.getCheckAndPayPage().clickOnCompleteBookingButton();
		LOGGER.info("the user click on Complete Booking button");
	}

	@Then("the user sees the Confirmation Page")
	public void the_user_sees_the_confirmation_page() {
		Assertions.assertThat(PAGES.getConfirmationPage().getConfirmationText()).isEqualTo("Confirmation Number");
		LOGGER.info("the user sees the Confirmation Page");

	}

	@When("the user click on Close button")
	public void theUserClickOnCloseButton() {
		PAGES.getConfirmationPage().clickOnCloseButoon();
		LOGGER.info("the user click on Close button");
	}

	@Then("the user sees the HomePage")
	public void the_user_sees_the_home_page() {
		Assertions.assertThat(PAGES.getBookingHomePage().getHeaderTitle()).isEqualTo("Find your next stay");
		LOGGER.info("the user sees the HomePage");
	}

}
