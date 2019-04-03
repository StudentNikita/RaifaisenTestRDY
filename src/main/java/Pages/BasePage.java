package Pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import Util.DriveManager;


import java.util.concurrent.TimeUnit;

public class BasePage {
    WebDriverWait wait = new WebDriverWait(DriveManager.getDriver(), 60);

    public BasePage(){
        PageFactory.initElements(DriveManager.getDriver(), this);
    }


    public void waitForLoadPage(){
        WebDriverWait wait = new WebDriverWait(DriveManager.getDriver(), 30);
        wait.ignoring(NoSuchElementException.class).until((ExpectedCondition<Boolean>) driver ->
                !isElementPresent(By.xpath("//*[@class='helpers-params loading']")));
    }

    public boolean isElementPresent (By by) {
        try {
            DriveManager.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            DriveManager.getDriver().findElement(by);
            return true;
        } catch (java.util.NoSuchElementException e) {
            return false;
        }
        finally {
            DriveManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    public boolean isElementPresent (WebElement element) {
        try {
            DriveManager.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            return element.isDisplayed();
        } catch (java.util.NoSuchElementException e) {
            return false;
        }
        finally {
            DriveManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    public void fillfield (WebElement element, String value){
        ((JavascriptExecutor)DriveManager.getDriver()).executeScript("arguments[0].scrollIntoView(false);", element);
        element.clear();
        element.sendKeys(value);
    }

    public void click(WebElement element) {
        ((JavascriptExecutor)DriveManager.getDriver()).executeScript("arguments[0].scrollIntoView(false);", element);
        Wait<WebDriver> wait = new WebDriverWait(DriveManager.getDriver(), 15);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }


}
