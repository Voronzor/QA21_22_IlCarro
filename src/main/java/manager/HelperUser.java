package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }


    public void openLoginForm(){
        click(By.xpath("//a[text()=' Log in ']"));
    }

    public void fillLoginForm(String email, String password){
        type(By.id("email"),email);
        type(By.id("password"), password);
    }


    //overloading
    public void fillLoginForm(User user){
        type(By.id("email"),user.getEmail());
        type(By.id("password"),user.getPassword());
    }

    public void submit(){
        wd.findElement(By.xpath("//button[@type='submit']"))
                .click();
    }


    public void clickOKButton() {
        if(isElementPresent(By.xpath("//button[text()='Ok']")))
            click(By.xpath("//button[text()='Ok']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//*[text()=' Logout ']"));
    }

    public void logout(){
        click(By.xpath("//*[text()=' Logout ']"));
    }


    public String getErrorText() {
        return wd.findElement(By.cssSelector("div.error")).getText();

    }

    //**********************************Registration***********************************
    public void openRegistrationForm() {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getFirstName());
        type(By.id("lastName"),user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());

    }

    public void checkPolicy() {
        click(By.cssSelector("label[for ='terms-of-use']"));
    }

}