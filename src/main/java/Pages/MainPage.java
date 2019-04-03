package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div[@class='informer__close js-region-check-close']")
    WebElement closeWindow;

    @FindBy(xpath = "//a[contains(text(),'Ипотека')]")
    WebElement mortgage;

    @FindBy(xpath = ("//a[contains(text(),'Ипотечный калькулятор')]"))
    WebElement mortgageCalculator;

    public void clickOnCloseWindow(){
        click(closeWindow);
    }

    public void clickOnMortgageCalculator(){
        click(mortgageCalculator);
    }

    public void clickOnMortgage(){
        click(mortgage);
    }
}
