package Steps;

import Pages.MortgageCalcPage;
import Util.DriveManager;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MortgageCalcPageStep {
    MortgageCalcPage mortgageCalcPage = new MortgageCalcPage();

    @Then("Проверить, что на странице есть заголовок \"(.*)\"")
    public void stepCheckTheTitle(String expectedTitle){
        Assert.assertEquals(String.format("Заголовок должен быть равен - %s. А по факту равен - %s", expectedTitle, mortgageCalcPage.getTitle()),
                expectedTitle, mortgageCalcPage.getTitle());
        System.out.println(String.format("Заголовок: %s", mortgageCalcPage.getTitle()));
    }

    @Then("Проверить, что ежемесячный платеж равен \"(.*)\"")
    public void stepCheckTheMonthPay(String expectedPay){
        WebDriverWait wait = new WebDriverWait(DriveManager.getDriver(), 30);
        wait.withMessage(String.format("Ожидалось значение [%s]", expectedPay))
                .until((ExpectedCondition<Boolean>) driver -> {
                    if (mortgageCalcPage.getMonthPay().equals(expectedPay)) {
                        return true;
                    }
                    return false;
                });

        Assert.assertEquals(String.format("Ежемесячный платеж должен быть равен - %s. А по факту равен - %s", expectedPay, mortgageCalcPage.getMonthPay()),
                expectedPay, mortgageCalcPage.getMonthPay());
        System.out.println(String.format("Ежемесячный платеж: %s", mortgageCalcPage.getMonthPay()));
    }

    @Then("Проверить, что общая сумма выплат равна \"(.*)\"")
    public void stepCheckPayoutSum(String expectedPayoutSum){
        Assert.assertEquals(String.format("Общая сумма выплат должна быть равна - %s. А по факту равена - %s", expectedPayoutSum, mortgageCalcPage.getPayoutSum()),
                expectedPayoutSum, mortgageCalcPage.getPayoutSum());
        System.out.println(String.format("Общая сумма выплат: %s", mortgageCalcPage.getPayoutSum()));
    }

    @Then("Проверить, что сумма выплат по процентам равна \"(.*)\"")
    public void stepCheckInterestPayments(String expectedInterestPayments){
        Assert.assertEquals(String.format("Сумма выплат по процентам должна быть равна - %s. А по факту равена - %s", expectedInterestPayments, mortgageCalcPage.getInterestPayments()),
                expectedInterestPayments, mortgageCalcPage.getInterestPayments());
        System.out.println(String.format("Заголовок: %s", mortgageCalcPage.getInterestPayments()));
    }

    @Then("Проверить, что процентная ставка равна \"(.*)\"")
    public void stepCheckInterestRate(String expectedInterestRate){
        Assert.assertEquals(String.format("Процентная ставка должна быть равна - %s. А по факту равена - %s", expectedInterestRate, mortgageCalcPage.getInterestRate()),
                expectedInterestRate, mortgageCalcPage.getInterestRate());
        System.out.println(String.format("Заголовок: %s", mortgageCalcPage.getInterestRate()));
    }

    @When("Выбираем город: \"(.*)\"")
    public void stepSelectCity(String city) {
     mortgageCalcPage.selectCity(city);
    }

    @When("Отмечаем чекбокс 'Знаю свою ипотечную программу'")
    public void stepСhooseMortgageProgrammeCheckbox(){
        mortgageCalcPage.chooseMortgageProgrammeCheckbox();
    }

    @When("Выбираем вид ипотечной программы: \"(.*)\"")
    public void stepSelectProgrammeButton(String programme){
        mortgageCalcPage.selectProgrammeButton(programme);
    }

    @When("Выбираем кем я являюсь: \"(.*)\"")
    public void stepSelectIAm(String iAm){
        mortgageCalcPage.selectIAm(iAm);
    }

    @When("Заполняем, сколько возьму в банке: (.*)")
    public void stepFillFieldTakeFromBank(String takeFromBank){
        mortgageCalcPage.fillFieldTakeFromBank(takeFromBank);
    }

    @When("Выбираем чем подтверждаем уровень дохода: \"(.*)\"")
    public void stepSelectIncomeRate(String incomeRate){
        mortgageCalcPage.selectIncomeRate(incomeRate);
    }

    @When("Заполняем первоначальный взнос: (.*)")
    public void stepFillFieldContribution(String contribution){
        mortgageCalcPage.fillFieldContribution(contribution);
    }

    @When("Заполняем срок кредита лет: (.*)")
    public void stepFillFieldCreditTerm(String creditTerm){
        mortgageCalcPage.fillFieldCreditTerm(creditTerm);
    }

    @When("Нажимаем на кнопку 'Рассчитать'")
    public void stepClickOnCalculateButton(){
        mortgageCalcPage.clickOnCalculateButton();
    }
}
