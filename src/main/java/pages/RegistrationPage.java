package pages;

import dto.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RegistrationPage extends BasePage{

    public RegistrationPage(WebDriver driver){
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//input[@formcontrolname='firstName']")
    WebElement inputFirstName;

    @FindBy(xpath = "//input[@formcontrolname='lastName']")
    WebElement inputLastName;

    @FindBy(xpath = "//input[@formcontrolname='email']")
    WebElement inputEmail;

    @FindBy(xpath = "//input[@formcontrolname='password']")
    WebElement inputPassword;

    @FindBy(id = "terms-of-use")
    WebElement btnLabelTerms;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnYalla;

    @FindBy(xpath = "//button[text()='Ok']")
    WebElement popUpRegistrationIncorrect;

    public void typeRegistrationForm(User user){
        inputFirstName.sendKeys(user.getFirstName());
        inputLastName.sendKeys(user.getLastName());
        inputEmail.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
        btnLabelTerms.click();
        btnYalla.click();
    }

    public boolean isLoggerRegIncorrect(){
        return elementIsDisplayed(popUpRegistrationIncorrect);
    }

}
