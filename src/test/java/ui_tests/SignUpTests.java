package ui_tests;

import dto.User;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignUpPage;

import java.time.Duration;

import static utils.UserFactory.positiveUser;

public class SignUpTests extends ApplicationManager {
    SignUpPage signUpPage;

    @BeforeMethod
    public void gotoSignUpPage(){
        new HomePage(getDriver()).clickBtnHeaderSingUp();
        signUpPage = new SignUpPage(getDriver());
    }

    @Test
    public void registrationPositiveTest(){
        User user = positiveUser();
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextDialogContainerPresent());

    }
    @Test
    public void registrationNegativeTest_emptyName(){
        User user = positiveUser();
        user.setFirstName("  ");

        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Name is required"));
    }

    @Test
    public void registrationNegativeEmptyPasswordTest(){
        User user = positiveUser();
        user.setPassword("");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();;
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Password is required"));
    }

    @Test
    public void registrationNegativeEmptyLastNameTests(){
        User user = positiveUser();
        user.setLastName("");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();;
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Last name is required"));
    }

    @Test
    public void registrationNegativeEmptyEmailTests(){
        User user = positiveUser();
        user.setUsername("");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();;
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Email is required"));
    }
    @Test
    public void registrationNegativeDuplicateEmailTests(){
        User user = positiveUser();
        user.setUsername("qwert123@gmail.com");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();;
        signUpPage.clickBtnYalla();
    }
}
