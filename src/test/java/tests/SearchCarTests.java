package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchCarTests extends TestBase{
@Test
    public void searchCurrentMonthSuccess(){
        app.getHelperCar().searchCurrentMonth("Tel Aviv, Israel", "1/17/2024", "1/23/2024");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
    }


    @Test
    public void searchCurrentYearSuccess(){
    app.getHelperCar().searchCurrentYear("Tel Aviv, Israel", "2/20/2024", "5/23/2024");
    app.getHelperCar().submit();
    Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
    }

//    @Test
//    public void searchAnyPeriodSuccess(){
//    app.getHelperCar().searchAnyPeriod("Tel Aviv, Israel", "4/20/2024", "1/07/2025");
//    app.getHelperCar().submit();
//    Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
//    }
}
