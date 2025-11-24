package ui_tests;

import dto.CarDto;
import dto.User;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LetTheCarWorkPage;
import pages.LoginPage;
import utils.enums.HeaderMenuItem;

import java.util.Random;


public class LetCarWorkTests extends ApplicationManager {
    LoginPage loginPage;
    LetTheCarWorkPage letTheCarWorkPage;

    @BeforeMethod(alwaysRun = true)
    public void login(){
        User user = User.builder()
                .username("tony1256@gmail.com")
                .password("Password12345!")
                .build();
        new HomePage(getDriver()).clickButtonHeader(HeaderMenuItem.LOGIN);
        loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
       // loginPage.clickBtnOk();
        letTheCarWorkPage = loginPage.clickButtonHeader(HeaderMenuItem.LET_THE_CAR_WORK);


    }

    @Test(groups = "smoke")
    public void addNewCarPositiveTest(){
        CarDto car = CarDto.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("Astra")
                .year("2020")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-"+ new Random().nextInt(10000))
                .pricePerDay(100.77)
                .about("about")
                .image("IMG_7581.JPG")
                .build();
        letTheCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letTheCarWorkPage.btnOkPopUpPresent());
    }



    @Test(groups = "negative")
    public void addNewCarNegativeTest_woManufacture(){
        CarDto car = CarDto.builder()
                .city("Haifa")
                .manufacture(" ")
                .model("Astra")
                .year("2020")
                .fuel("Petrol")
                .fuel("")
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-"+ new Random().nextInt(10000))
                .pricePerDay(100.77)
                .about("about")
                .image("IMG_7581.JPG")
                .build();
        letTheCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letTheCarWorkPage.isTextInErrorPresent("Make is required"));

    }
}
