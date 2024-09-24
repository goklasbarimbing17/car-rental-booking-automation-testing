package org.example;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author SQA_DIKA
 * @date 24/09/2024
 */

public class CarRentalBookingPage {
    private WebDriver driver;
    private Faker faker = new Faker();

    public CarRentalBookingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "car-product")
    WebElement carProduct;
    @FindBy(xpath = "//[@id='tabWithoutDriver']")
    WebElement withoutDriver;
    @FindBy(id = "pickup-location")
    WebElement pickupLocation;
    @FindBy(id = "pickup-date")
    WebElement pickupDate;
    @FindBy(id = "pickup-time")
    WebElement pickupTime;
    @FindBy(id = "dropoff-date")
    WebElement dropoffDate;
    @FindBy(id = "dropoff-time")
    WebElement dropoffTime;
    @FindBy(xpath = "//button[@id='search-car']")
    WebElement searchCarButton;
    @FindBy(id = "car-field")
    WebElement selectCar;
    @FindBy(id = "provider")
    WebElement selectProvider;
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement continueButton;
    @FindBy(xpath = "//select[@id='rental-office-pickup']")
    WebElement rentalOfficePickup;
    @FindBy(xpath = "//select[@id='location-dropoff']")
    WebElement locationDropoff;
    @FindBy(xpath = "//textarea[@id='notes']")
    WebElement notes;
    @FindBy(id = "book-now")
    WebElement bookNowButton;
    @FindBy(xpath = "//input[@class='contact-details']")
    WebElement contactDetails;
    @FindBy(xpath = "//input[@class='driver-details']")
    WebElement driverDetails;
    @FindBy(id = "continue-details")
    WebElement continueDetailsButton;
    @FindBy(id = "rental-requirements")
    WebElement rentalRequirements;
    @FindBy(xpath = "//button[normalize-space()='Continue Requirements")
    WebElement continueRequirementsButton;
    @FindBy(xpath = "//select[@id='payment-method']")
    WebElement paymentMethod;
    @FindBy(id = "proceed-payment")
    WebElement proceedPaymentButton;
    @FindBy(xpath = "//*[contains(text(), 'Payment Successfully')]")
    WebElement resultPaymentSuccess;

    public void clickCarProduct() {
        this.carProduct.click();
    }

    public void clickWithoutDriver(String tabName) {
        if (tabName.equals("Without Driver")) {
            withoutDriver.click();
        }
    }

    public void setPickupLocation(String location) {
        Select dropdownPickupLocation = new Select(pickupLocation);
        dropdownPickupLocation.selectByValue(location);
    }

    public String getDateAfterDays(int days) {
        LocalDate date = LocalDate.now().plusDays(days);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }

    public void setPickupDate(int days) {
        this.pickupDate.sendKeys(getDateAfterDays(days));
    }

    public void setPickupTime(String time) {
        this.pickupTime.sendKeys(time);
    }

    public void setDropOffDate(int days) {
        this.dropoffDate.sendKeys(getDateAfterDays(days));
    }

    public void setDropOffTime(String time) {
        this.dropoffTime.sendKeys(time);
    }

    public void clickBtnSearchCar() {
        this.searchCarButton.click();
    }

    public void setSelectCar() {
        this.selectCar.click();
    }

    public void setSelectProvider() {
        this.selectProvider.click();
    }

    public void clickBtnContinue() {
        this.continueButton.click();
    }

    public void setRentalOfficePickup(String rentalOfficePickup) {
        Select dropdownRentalOffice = new Select(this.rentalOfficePickup);
        dropdownRentalOffice.selectByValue(rentalOfficePickup);
    }

    public void setLocationDropOff(String locationDropoff) {
        Select dropdownRentalOffice = new Select(this.locationDropoff);
        dropdownRentalOffice.selectByValue(locationDropoff);
    }

    public void setNotes() {
        this.notes.sendKeys(faker.lorem().sentence()); //Faker is used to generate random characters/sentences.
    }

    public void clickBtnBookNow() {
        this.bookNowButton.click();
    }

    public void setContactDetails() {
        this.contactDetails.sendKeys(
                faker.name().fullName() + ", "
                        + faker.internet().emailAddress() + ", "
                        + faker.phoneNumber()); //generate random fullname, email and phone number
    }

    public void setDriverDetails() {
        this.driverDetails.sendKeys(
                faker.name().fullName() + ", "
                        + faker.internet().emailAddress() + ", "
                        + faker.phoneNumber()); //generate random fullname, email and phone number
    }

    public void clickBtnContinueDetails() {
        this.continueDetailsButton.click();
    }

    public void checkRentalRequirements() {
        this.rentalRequirements.click();
    }

    public void clickBtnContinueRequirements(){
        this.continueRequirementsButton.click();
    }

    public void setPaymentMethod(String paymentMethod){
        Select dropdownPaymentMethod = new Select(this.paymentMethod);
        dropdownPaymentMethod.selectByValue(paymentMethod);
    }

    public void clickBtnProceedPayment(){
        this.proceedPaymentButton.click();
    }

    public String getResultPaymentSuccess(){
        return this.resultPaymentSuccess.getText();
    }
}
