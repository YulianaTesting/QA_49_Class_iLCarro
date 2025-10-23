package pages;

import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {

    @Setter
    static WebDriver driver;


    public boolean elementIsDisplayed(WebElement element){
        return element.isDisplayed();
    }
}
