package ForTest1.Steps;

import ForTest1.Pages.HomePage;
import io.qameta.allure.Step;

public class HomePageSteps {
    HomePage homePage;


    @Step
    public HomePageSteps goToRegistration() {
        homePage = new HomePage();
        homePage.myAccount.click();
        homePage.registration.click();

        return this;
    }
}
