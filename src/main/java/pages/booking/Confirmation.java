package pages.booking;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import data.BookingData;
import data.DateTime;
import data.LocationsData;
import data.ServicesData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by bigdrop on 10/4/2018.
 */
public class Confirmation extends BasePage {

    @FindBy(css = ".selected-service li span")
    private WebElement durationText;

    @FindBy(css = ".selected-service li")
    private WebElement serviceText;

    @FindBy(css = ".location-info h4")
    private WebElement locationText;

    @FindBy(xpath = "//div[@class='service-info']//i[@class='icon-specific_employee']//ancestor::li")
    private WebElement therapistText;

    @FindBy(xpath = "//div[@class='service-info']//i[@class='icon-date']//ancestor::li")
    private WebElement dateText;

    @FindBy(xpath = "(//ul[@class='total-list']/li)[1]")
    private WebElement subTotaltext;

    @FindBy(xpath = "(//ul[@class='total-list']/li)[2]")
    private WebElement taxText;

    @FindBy(xpath = "(//ul[@class='total-list']/li)[3]")
    private WebElement totaltext;

    @FindBy(css = "#success-message header h1")
    private WebElement successHeading;

    @FindBy(id = "barcode")
    private WebElement barCode;

    @FindBy(id = "addtocalendar-link")
    private WebElement addToCalendarBut;

    @FindBy(xpath = "//a[contains(text(), 'Book Another Appointment')]")
    private WebElement bookAnotherAppBut;

    @FindBy(css = "a.download-link")
    private WebElement downloadFormBut;

    @FindBy(xpath = "//div[@data-id='modalBookingErrors']//h3")
    private WebElement titleInfoPopup;

    @FindBy(xpath = "//div[@data-id='modalBookingErrors']//div[contains(@id, 'booking-error-described')]")
    private WebElement errorDescribe;

    public WebElement getSuccessHeading() {
        return successHeading;
    }

    public WebElement getBarCode() {
        return barCode;
    }

    public WebElement getAddToCalendarBut() {
        return addToCalendarBut;
    }

    public WebElement getBookAnotherAppBut() {
        return bookAnotherAppBut;
    }

    public WebElement getDownloadFormBut() {
        return downloadFormBut;
    }

    public boolean containsDuration(String duration) {
        if(durationText.getText().contains(duration))
            return true;
        else return false;
    }

    public boolean containsService(String service) {
        if(serviceText.getText().contains(service))
            return true;
        else return false;
    }

    public boolean containsLocation(String location) {
        if(locationText.getText().contains(location))
            return true;
        else return false;
    }

    public boolean containsTherapist(String therapist) {
        if(therapistText.getText().contains(therapist))
            return true;
        else return false;
    }

    public boolean containsDate(String date) {
        if(dateText.getText().contains(date))
            return true;
        else return false;
    }

    public String getSubTotalText() {
        String arr[] = subTotaltext.getText().split("\n", 10);
        String Word = arr[1];
        return Word;
    }

    public String getTaxText() {
        String arr[] = taxText.getText().split("\n", 10);
        String Word = arr[1];
        return Word;
    }

    public String getTotalText() {
        String arr[] = totaltext.getText().split("\n", 10);
        String Word = arr[1];
        return Word;
    }

    public String getDurationText() {
        return durationText.getText();
    }

    public String getServiceText() {
        String arr[] = serviceText.getText().split("\n", 10);
        String Word = arr[0];
        return Word;
    }

    public String getLocationText() {
        return locationText.getText();
    }

    public String getTherapistText() {
        String arr[] = therapistText.getText().split("\n", 10);
        String Word = arr[1];
        return Word;
    }

    public String getDateText() {
        return dateText.getText();
    }

    public void generateBookingFile() throws IOException {
        File file = new File("src/main/resources/booking.json");
        List<BookingData> bookingData = generateBookingData();
        save(bookingData, file);
    }

    private void save(List<BookingData> bookingData, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(bookingData);
        Writer writer = new BufferedWriter(new FileWriter(file, true));;
        writer.write(json);
        writer.close();
    }

    private List<BookingData> generateBookingData() {
        List<BookingData> bookingData = new ArrayList();
        bookingData.add(new BookingData().setCurrentDate(new Date().toString()).setLocation(getLocationText()).setDate(getDateText())
                .setTherapist(getTherapistText()).setService(getServiceText())
                .setDuration(getDurationText()).setSubTotal(getSubTotalText())
                .setTax(getTaxText()).setTotal(getTotalText()));
        return bookingData;

    }

    public void checkingSuccessBooking(LocationsData locationsData, ServicesData servicesData, String therapist, DateTime dateTime) throws IOException {
        element(getSuccessHeading()).waitUntilVisible();
        generateBookingFile();
        softAssert.assertEquals(getSuccessHeading().getText(), "CONGRATULATIONS!");
        softAssert.assertEquals(getAddToCalendarBut().getText(), "ADD TO CALENDAR");
        softAssert.assertEquals(getBookAnotherAppBut().getText(), "BOOK ANOTHER APPOINTMENT");
        softAssert.assertTrue(containsLocation(locationsData.getShortLocationName()), "Location " + locationsData.getShortLocationName() + " not found");
        softAssert.assertTrue(containsService(servicesData.getServiceName()), "Service " + servicesData.getServiceName() + " not found");
        softAssert.assertTrue(containsTherapist(therapist), "Therapist " + therapist + " not found");
        softAssert.assertTrue(containsDuration(servicesData.getDuration()), "Duration " + servicesData.getDuration() + " not found");
        softAssert.assertTrue(containsDate(dateTime.getDate()), "Date " + dateTime.getDate() + " not found");
        softAssert.assertAll();
    }

    public void checkingErrorBooking() {
        element(titleInfoPopup).waitUntilVisible();
        softAssert.assertEquals(titleInfoPopup.getText(), "Errors");
        softAssert.assertTrue(element(errorDescribe).isPresent(), "Error describe text not found");
        softAssert.assertAll();
    }

    public void checkingSuccessLMDBooking() {
        element(getSuccessHeading()).waitUntilVisible();
        softAssert.assertEquals(getSuccessHeading().getText(), "CONGRATULATIONS!");
        softAssert.assertEquals(getAddToCalendarBut().getText(), "ADD TO CALENDAR");
        softAssert.assertEquals(getBookAnotherAppBut().getText(), "BOOK ANOTHER APPOINTMENT");
        softAssert.assertEquals(getDownloadFormBut().getText(), "DOWNLOAD INTAKE FORM");
        softAssert.assertTrue(element(getBarCode()).isPresent(), "Bar code not found");
        softAssert.assertAll();
    }
}
