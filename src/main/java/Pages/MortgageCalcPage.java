package Pages;

import Util.DriveManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MortgageCalcPage extends BasePage {

    @FindBy(xpath = "//h1[@class='e-title e-title--h2']")
    public WebElement title;

    @FindBy(xpath = "//ul[@aria-labelledby=\"form_city-button\"]//li") // список город
    public List<WebElement> cityButton;

    @FindBy(xpath = "//span[@id='form_city-button']") // кнопка город
    public WebElement cityClick;

    @FindBy(xpath = "//label[@class='checkbox-block__label']") //чекбокс "знаю свою ипотечную программу"
    public WebElement mortgageProgrammeCheckbox;

    @FindBy(xpath = "//ul[@id='form_program-menu']/li") //вид ипотечной программы
    public List<WebElement> programmeButton;

    @FindBy(xpath = "//ul[@id='form_category-menu']/li") //я являюсь
    public List<WebElement> iAmButton;

    @FindBy(xpath = "//ul[@id='form_documents-menu']/li") // уровень дохода подтверждаю
    public List<WebElement> incomeRateButton;

    @FindBy(xpath = "//input[@id='form_credit_amount']") //в банке возьму
    public WebElement takeFromBank;

    @FindBy(xpath = "//input[@id='form_initial']") //первоначальный взнос
    public WebElement contribution;

    @FindBy(xpath = "//input[@id='form_period']") //срок кредита
    public WebElement creditTerm;

    @FindBy (xpath = "//input[@class='button-invert']") //кнопка рассчитать
    public WebElement calculateButton;

    @FindBy(xpath = "//span[@class='monthly-payment']") //ежемесячный платеж
    public WebElement monthPay;

    @FindBy(xpath = "//div[@class='b-calc-result__text--right total-payment']") //общая сумма выплат
    public WebElement payoutSum;

    @FindBy(xpath = "//div[@class='b-calc-result__text--right percent-sum']") //сумма выплат по процентам
    public WebElement interestPayments;

    @FindBy(xpath = "//div[@class='b-calc-result__text--right interest-rate']") //процентная ставка
    public WebElement interestRate;

    public void selectCity(String city) {
        DriveManager.getDriver().findElement(By.xpath("//select[@id='form_city']/parent::div")).click();
        selectMenuItem(cityButton, city);

    }

    public void selectProgrammeButton(String programme){
        waitForLoadPage();
        ((JavascriptExecutor)DriveManager.getDriver()).executeScript("arguments[0].scrollIntoView(false);", contribution);
        DriveManager.getDriver().findElement(By.xpath("//select[@id='form_program']/parent::div")).click();
        selectMenuItem(programmeButton, programme);

    }

    public void selectIAm(String iAm){
        waitForLoadPage();
        ((JavascriptExecutor)DriveManager.getDriver()).executeScript("arguments[0].scrollIntoView(false);", creditTerm);
        DriveManager.getDriver().findElement(By.xpath("//select[@id='form_category']/parent::div")).click();
        selectMenuItem(iAmButton, iAm);
    }

    public void selectIncomeRate(String incomeRate){
        waitForLoadPage();
        ((JavascriptExecutor)DriveManager.getDriver()).executeScript("arguments[0].scrollIntoView(false);", calculateButton);
        DriveManager.getDriver().findElement(By.xpath("//select[@id='form_documents']/parent::div")).click();
        selectMenuItem(incomeRateButton, incomeRate);
    }

    public void fillFieldTakeFromBank (String sum){
        waitForLoadPage();
        new WebDriverWait(DriveManager.getDriver(),10)
                .until(ExpectedConditions.elementToBeClickable(takeFromBank)).click();
        for (int i = 0; i < 21; i++) {
            takeFromBank.sendKeys(Keys.BACK_SPACE);
        }
        fillfield(takeFromBank, sum);

    }

    public void fillFieldContribution (String sum){
        waitForLoadPage();
        new WebDriverWait(DriveManager.getDriver(),10)
                .until(ExpectedConditions.elementToBeClickable(contribution)).click();

        for (int i = 0; i < 20; i++) {
            contribution.sendKeys(Keys.BACK_SPACE);
        }
       fillfield(contribution, sum);


    }

    public void fillFieldCreditTerm (String sum){
        waitForLoadPage();
        new WebDriverWait(DriveManager.getDriver(),10)
                .until(ExpectedConditions.elementToBeClickable(creditTerm)).click();
        for (int i = 0; i < 22; i++) {
            creditTerm.sendKeys(Keys.BACK_SPACE);
        }
        fillfield(creditTerm, sum);

    }

    public void clickOnCalculateButton(){
        click(calculateButton);

    }


    public void chooseMortgageProgrammeCheckbox (){
        waitForLoadPage();
        click(mortgageProgrammeCheckbox);

    }

    public String getTitle(){
        return title.getText();
    }

    public String getMonthPay(){
        return monthPay.getText();
    }

    public String getPayoutSum(){
        return payoutSum.getText();
    }

    public String getInterestPayments(){
        return interestPayments.getText();
    }

    public String getInterestRate(){
        return interestRate.getText();
    }





}
