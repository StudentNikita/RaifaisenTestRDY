package Pages;


import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import Util.DriveManager;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
    WebDriverWait wait = new WebDriverWait(DriveManager.getDriver(), 60);

    public BasePage(){
        PageFactory.initElements(DriveManager.getDriver(), this);
    }


    public void waitForLoadPage(){
        WebDriverWait wait = new WebDriverWait(DriveManager.getDriver(), 30);
        wait.ignoring(NoSuchElementException.class).until((ExpectedCondition<Boolean>) driver ->
                !isElementPresent( By.xpath("//*[@class='helpers-params loading']")));
    }

    public boolean isElementPresent (By locator) {
        try {
            DriveManager.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            return DriveManager.getDriver().findElement(locator).isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }finally {
            DriveManager.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
    }


    public void fillfield (WebElement element, String value){

        element.click();
        element.clear();
        element.sendKeys(value);
    }

    public void click(WebElement element) {

        Wait<WebDriver> wait = new WebDriverWait(DriveManager.getDriver(), 15);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void selectMenuItem(List<WebElement> menuElements, String name){
        for (WebElement element : menuElements ){
            if (element.getText().equalsIgnoreCase(name)){
                element.click();
                return;
            }
        }
        Assert.fail("Не найден элмент коллеции - " + name);
    }


}
