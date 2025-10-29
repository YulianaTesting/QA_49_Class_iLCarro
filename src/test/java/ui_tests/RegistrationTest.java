package ui_tests;

import dto.User;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;
import pages.SignUpPage;

import static utils.UserFactory.positiveUser;

public class RegistrationTest extends ApplicationManager {



    @Test
    public void RegistrationPositiveTest(){
        User user = User.builder().firstName("Mark").lastName("Tomas").username("mark@gmail.com").password("Password54321!").build();
        new HomePage(getDriver()).clickBtnSingUpHeader();
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationForm(user);
        Assert.assertTrue(registrationPage.isLoggerRegIncorrect());
    }

    @Test
    public void RegistrationNegativeTest_wrongEmail(){
        User user = User.builder().firstName("Dic").lastName("Bony").username("123@gmail.com").password("Password54321!").build();
        new HomePage(getDriver()).clickBtnSingUpHeader();
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationForm(user);
        Assert.assertTrue(registrationPage.isLoggerRegIncorrect());
    }

}
