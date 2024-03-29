package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.TestBase;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }

    @Test
    public void loginSuccess1(){
        logger.info("Test start with test data --->/n" + "email : 'vorronkovkirill@gmail.com' & password : 'Kirill123456!'");
        User user = new User().setEmail("vorronkovkirill@gmail.com").setPassword("Kirill123456!");
        //user.setEmail("vorronkovkirill@gmail.com");
        //user.setPassword("Kirill123456!");

        logger.info("Test start with test data --->" + user.toString());
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        //Assert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        //app.getHelperUser().clickOKButton();


    }
    @Test
    public void loginSuccess(){
        logger.info("Test start with test data --->/n" + "email : 'vorronkovkirill@gmail.com' & password : 'Kirill123456!'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("vorronkovkirill@gmail.com", "Kirill123456!");
        app.getHelperUser().submit();
        //Assert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        //app.getHelperUser().clickOKButton();


    }

    @Test
    public void loginSuccessModel(){
        logger.info("Test start with test data --->/n" + "email : 'vorronkovkirill@gmail.com' & password : 'Kirill123456!'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("vorronkovkirill@gmail.com", "Kirill123456!");
        app.getHelperUser().submit();
        //Assert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        //app.getHelperUser().clickOKButton();


    }

    @Test
    public void loginWrongEmail(){
        logger.info("Test negative check if it possible to login with wrong format email ");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("vorronkovkirillgmail.com", "Kirill123456!");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "It'snot look like email");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

    }


    @Test
    public void loginWrongPassword(){
        logger.info("Test negative check if it possible to login with wrong format password ");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("vorronkovkirill@gmail.com", "rill123456!");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");
    }

    @Test
    public void loginWrongUnregisteredUser() {
        logger.info("Test negative check if it possible to login with valid format data unregistered user ");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("vorronkov@gmail.com", "Kirill123456!");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
    }



    @AfterMethod
    public void postCondition(){
        app.getHelperUser().clickOKButton();
    }

}
