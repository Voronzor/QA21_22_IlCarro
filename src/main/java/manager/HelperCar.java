package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelperCar extends HelperBase{
    public HelperCar(WebDriver wd) {
        super(wd);
    }

    public void openCarForm() {
        pause(500);
        click(By.xpath("//a[text()=' Let the car work ']"));

    }

    public void fillCarForm(Car car) {
        typeLocation(car.getLocation());
        type(By.id("make"),car.getManufacture());
        type(By.cssSelector("#model"),car.getModel());
        type(By.cssSelector("#year"),car.getYear());
        select(By.id("fuel"),car.getFuel());
        type(By.id("seats"),String.valueOf(car.getSeats()));
        type(By.cssSelector("#class"),car.getCarClass());
        type(By.cssSelector("#serialNumber"),car.getCarRegNumber());
        type(By.cssSelector("#price"),car.getPrice()+"");
        type(By.cssSelector("#about"),car.getAbout());
    }

    private void select(By locator, String options) {
        Select select = new Select(wd.findElement(locator));
        select.selectByValue(options);

        //gas
        //select.selectByIndex(5);
        //select.selectByValue("Gas");
        //select.selectByVisibleText(" Gas ");
    }

    private void typeLocation(String location) {
        type(By.id("pickUpPlace"), location);
        click(By.cssSelector("div.pac-item"));
    }

    public void returnToHome() {
        click(By.xpath("//button[text()= 'Search cars']"));
    }

    public void attachPhoto(String link) {
        wd.findElement(By.cssSelector("#photos")).sendKeys(link);
    }

    public void searchCurrentMonth(String city, String dateFrom, String dateTo){
        typeCity(city);
        click(By.id("dates"));

        String[] from = dateFrom.split("/");

        String locatorFrom = "//div[text() = ' " + from[1] + " ']";
        click(By.xpath(locatorFrom));
        String[] to = dateTo.split("/");
        click(By.xpath("//div[text() = ' " + to[1] + " ']"));

    }

    private void typeCity(String city) {
        type(By.id("city"),city);
        click(By.cssSelector("div.pac-item"));
    }

    public boolean isListOfCarsAppeared(){
        return isElementPresent(By.cssSelector("a.car-container"));
    }


    public void searchCurrentYear(String city, String dateFrom, String dateTo) {
        typeCity(city);
        click(By.id("dates"));

        LocalDate now = LocalDate.now();
        System.out.println(now); //2024-01-14
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        LocalDate from = LocalDate.parse(dateFrom, DateTimeFormatter.ofPattern("M/d/yyyy"));
        LocalDate to = LocalDate.parse(dateTo, DateTimeFormatter.ofPattern("M/d/yyyy"));
        //LocalDate from1 = LocalDate.parse("2013:23/05", DateTimeFormatter.ofPattern("yyyy:dd/MM"));
        //System.out.println(from1);

        int diffMonth = from.getMonthValue()-month;

        if (diffMonth>0){
            clickNextMonth(diffMonth);
        }

        click(By.xpath("//div[text() = ' " + from.getDayOfMonth() + " ']"));


        diffMonth = to.getMonthValue()-from.getDayOfMonth();

        if (diffMonth>0){
            clickNextMonth(diffMonth);
        }
//div[text() = ' " + from[1] + " ']";
        String locator = String.format("//div[text() = ' %s ']", to.getDayOfMonth());
        click(By.xpath(locator));


    }

    private void clickNextMonth(int diffMonth) {
        for (int i = 0; i < diffMonth; i++) {
            click(By.cssSelector("button[aria-label ='Next month']"));

        }
    }
}
