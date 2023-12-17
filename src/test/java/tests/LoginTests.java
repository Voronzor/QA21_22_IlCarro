package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.TestBase;

public class LoginTests extends TestBase {

    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("vorronkovkirill@gmail.com", "Kirill123456!");
        app.getHelperUser().submitLogin();
        //Assert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        app.getHelperUser().clickOKButton();


    }
}
