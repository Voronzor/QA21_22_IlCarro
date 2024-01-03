package tests;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCarTests extends TestBase{

    @BeforeClass
    public void preCondition(){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().setEmail("vorronkovkirill@gmail.com").setPassword("Kirill123456!"));
        }

    }


    @Test
    public void addNewCarSuccessAll(){
        int i = new Random().nextInt(10000)+1000;
        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Mazda")
                .model("M3")
                .year("2022")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .carRegNumber("678-900-"+i)
                .price(50)
                .about("Very nice car")
                .build();

        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().attachPhoto("C:\\Users\\Voronzor\\Desktop\\Projects GitHub\\QA21_22_IlCarro\\305px-Wikiniva13a.jpg");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperUser().getMessage().contains("added successful"));
        Assert.assertEquals(app.getHelperUser().getMessage(),car.getManufacture()+ " "+car.getModel()+ " added successful");

    }

    @Test
    public void addNewCarReaSuccessA(){
        int i = new Random().nextInt(10000)+1000;
        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Mazda")
                .model("M3")
                .year("2022")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .carRegNumber("678-900-"+i)
                .price(50)
                .build();

        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperUser().getMessage().contains("added successful"));
        Assert.assertEquals(app.getHelperUser().getMessage(),car.getManufacture()+ " "+car.getModel()+ " added successful");
    }

    @AfterMethod
    public void postCondition(){
        app.getHelperCar().returnToHome();
    }

}
