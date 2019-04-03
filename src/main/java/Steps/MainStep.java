package Steps;

import Pages.MainPage;
import cucumber.api.java.en.When;

public class MainStep {
    MainPage mainPage = new MainPage();

    @When("Закрыто всплывающее окно")
    public void stepClickOnCloseWindow(){
        mainPage.clickOnCloseWindow();
    }

    @When("Выбран пункт меню 'Ипотека'")
    public void stepСlickOnMortgage(){
        mainPage.clickOnMortgage();
    }

    @When("Выбран подпункт меню 'Ипотечный калькулятор'")
    public void stepСlickOnMortgageCalculator(){
        mainPage.clickOnMortgageCalculator();
    }
}
