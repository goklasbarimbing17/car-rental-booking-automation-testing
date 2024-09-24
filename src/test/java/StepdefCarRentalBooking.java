import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.CarRentalBookingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * @author SQA_DIKA
 * @date 24/09/2024
 */

public class StepdefCarRentalBooking {

    public static WebDriver driver;
    public CarRentalBookingPage carRentalBookingPage = new CarRentalBookingPage(driver);

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @Given("I am on the car rental booking page {string}")
    public void i_am_on_the_car_rental_booking_page(String url) {
        driver.get("url");
    }

    @When("select the car product")
    public void select_the_car_product() {
        carRentalBookingPage.clickCarProduct();
    }

    @When("select the {string} tab")
    public void select_the_tab(String tabName) {
        carRentalBookingPage.clickWithoutDriver(tabName);
    }

    @When("select pick-up location as {string}")
    public void select_pick_up_location_as(String location) {
        carRentalBookingPage.setPickupLocation(location);
    }

    @When("select pick-up date {int} days from today at {string}")
    public void select_pick_up_date_days_from_today_at(Integer day, String time) {
        carRentalBookingPage.setPickupDate(day);
        carRentalBookingPage.setPickupTime(time);
    }

    @When("select drop-off date {int} days from today at {string}")
    public void select_drop_off_date_days_from_today_at(Integer day, String time) {
        carRentalBookingPage.setDropOffDate(day);
        carRentalBookingPage.setDropOffTime(time);
    }

    @When("click the search car button")
    public void click_the_search_car_button() {
        carRentalBookingPage.clickBtnSearchCar();
    }

    @When("select a car from the list")
    public void select_a_car_from_the_list() {
        carRentalBookingPage.setSelectCar();
    }

    @When("select the car provider")
    public void select_the_car_provider() {
        carRentalBookingPage.setSelectProvider();
    }

    @When("click the continue button on product detail")
    public void click_the_continue_button_on_product_detail() {
        carRentalBookingPage.clickBtnContinue();
    }

    @When("select drop-off location as {string}")
    public void select_drop_off_location_as(String locationDropOff) {
        carRentalBookingPage.setLocationDropOff(locationDropOff);
    }

    @When("select rental office pick-up location as {string}")
    public void select_rental_office_location_as(String rentalOffice) {
        carRentalBookingPage.setRentalOfficePickup(rentalOffice);
    }

    @When("input Pick-upDrop-off notes")
    public void input_pickup_dropoff_notes() {
        carRentalBookingPage.setNotes();
    }
    @When("click the book now button")
    public void click_the_book_now_button() {
        carRentalBookingPage.clickBtnBookNow();
    }

    @When("fill the contact details")
    public void fill_the_contact_details() {
        carRentalBookingPage.setContactDetails();
    }

    @When("fill the driver details")
    public void fill_the_driver_details() {
        carRentalBookingPage.setDriverDetails();
    }

    @When("click continue")
    public void click_continue() {
        carRentalBookingPage.clickBtnContinueDetails();
    }

    @When("check all rental requirements")
    public void check_all_rental_requirements() {
        carRentalBookingPage.checkRentalRequirements();
    }

    @When("click continue to proceed")
    public void click_continue_to_proceed() {
        carRentalBookingPage.clickBtnContinueRequirements();
    }

    @When("select the payment method {string} and proceed payment")
    public void select_the_payment_method_and_proceed_payment(String paymentMethod) {
        carRentalBookingPage.setPaymentMethod(paymentMethod);
        carRentalBookingPage.clickBtnProceedPayment();
    }

    @Then("the car rental booking should be successful")
    public void the_car_rental_booking_should_be_successful() {
        Assert.assertEquals(carRentalBookingPage.getResultPaymentSuccess(), "Payment Successfully");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
