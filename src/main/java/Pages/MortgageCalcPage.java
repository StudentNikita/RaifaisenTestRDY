package Pages;

import Util.DriveManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MortgageCalcPage extends BasePage {

    @FindBy(xpath = "//h1[@class='e-title e-title--h2']")
    WebElement title;

    @FindBy(xpath = "//span[@id='form_city-button']") //город
    WebElement cityButton;

    @FindBy(xpath = "//span[@class='checkbox-block__span']") //чекбокс "знаю свою ипотечную программу"
    WebElement mortgageProgrammeCheckbox;

    @FindBy(xpath = "//span[@id='form_program-button']") //вид ипотечной программы
    WebElement programmeButton;

    @FindBy(xpath = "//span[@id='form_category-button']") //я являюсь
    WebElement iAmButton;

    @FindBy(xpath = "//span[@id='form_documents-button']") // уровень дохода подтверждаю
    WebElement incomeRateButton;

    @FindBy(xpath = "//input[@id='form_credit_amount']") //в банке возьму
    WebElement takeFromBank;

    @FindBy(xpath = "//input[@id='form_initial']") //первоначальный взнос
    WebElement contribution;

    @FindBy(xpath = "//input[@id='form_period']") //срок кредита
    WebElement creditTerm;

    @FindBy (xpath = "//input[@class='button-invert']") //кнопка рассчитать
    WebElement calculateButton;

    @FindBy(xpath = "//span[@class='monthly-payment']") //ежемесячный платеж
    WebElement monthPay;

    @FindBy(xpath = "//div[@class='b-calc-result__text--right total-payment']") //общая сумма выплат
    WebElement payoutSum;

    @FindBy(xpath = "//div[@class='b-calc-result__text--right percent-sum']") //сумма выплат по процентам
    WebElement interestPayments;

    @FindBy(xpath = "//div[@class='b-calc-result__text--right interest-rate']") //процентная ставка
    WebElement interestRate;

    public void selectCity(String city){
        waitForLoadPage();
        ((JavascriptExecutor)DriveManager.getDriver()).executeScript("arguments[0].scrollIntoView(false);", takeFromBank);
        Select select = new Select(cityButton);
        select.selectByVisibleText(city);
    }

    public void selectProgrammeButton(String programme){
        waitForLoadPage();
        ((JavascriptExecutor)DriveManager.getDriver()).executeScript("arguments[0].scrollIntoView(false);", contribution);
        Select select = new Select(programmeButton);
        select.selectByVisibleText(programme);
    }

    public void selectIAm(String iAm){
        waitForLoadPage();
        ((JavascriptExecutor)DriveManager.getDriver()).executeScript("arguments[0].scrollIntoView(false);", creditTerm);
        Select select = new Select(iAmButton);
        select.selectByVisibleText(iAm);
    }

    public void selectIncomeRate(String incomeRate){
        waitForLoadPage();
        ((JavascriptExecutor)DriveManager.getDriver()).executeScript("arguments[0].scrollIntoView(false);", calculateButton);
        Select select = new Select(incomeRateButton);
        select.selectByVisibleText(incomeRate);
    }

    public void fillFieldTakeFromBank (String sum){
        waitForLoadPage();
        new WebDriverWait(DriveManager.getDriver(),10)
                .until(ExpectedConditions.elementToBeClickable(takeFromBank)).click();
        do fillfield(takeFromBank, sum);
        while (takeFromBank.getText().equals(sum));
    }

    public void fillFieldContribution (String sum){
        waitForLoadPage();
        new WebDriverWait(DriveManager.getDriver(),10)
                .until(ExpectedConditions.elementToBeClickable(contribution)).click();
        do fillfield(contribution, sum);
        while (contribution.getText().equals(sum));
    }

    public void fillFieldCreditTerm (String sum){
        waitForLoadPage();
        new WebDriverWait(DriveManager.getDriver(),10)
                .until(ExpectedConditions.elementToBeClickable(creditTerm)).click();
        do fillfield(creditTerm, sum);
        while (creditTerm.getText().equals(sum));
    }

    public void clickOnCalculateButton(){
        click(calculateButton);
        waitForLoadPage();
    }


    public void chooseMortgageProgrammeCheckbox (boolean onOff){
        waitForLoadPage();
        if (isElementPresent(mortgageProgrammeCheckbox)){
            if (onOff == true || !mortgageProgrammeCheckbox.isSelected()){
                new WebDriverWait(DriveManager.getDriver(),10)
                        .until(ExpectedConditions.elementToBeClickable(mortgageProgrammeCheckbox)).click();
                return;
            } else if (onOff == false || mortgageProgrammeCheckbox.isSelected()){
                new WebDriverWait(DriveManager.getDriver(),10)
                        .until(ExpectedConditions.elementToBeClickable(mortgageProgrammeCheckbox)).click();
                return;
            }
        }
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
