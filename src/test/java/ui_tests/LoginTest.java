package ui_tests;

import dto.User;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends ApplicationManager {

    @Test
    public void loginPositiveTest(){
        User user = User.builder()
                .username("tony1256@gmail.com")
                .password("Password12345!")
                .build();
        new HomePage(getDriver()).clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        Assert.assertTrue(loginPage.isLoggedDisplayed());
    }

    @Test
    public void loginNegativeTest_wrongPassword(){
        User user = User.builder()
                .username("tony1256@gmail.com")
                .password("wrong password")
                .build();
        new HomePage(getDriver()).clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        Assert.assertTrue(loginPage.isLoggedIncorrect());
    }
}
