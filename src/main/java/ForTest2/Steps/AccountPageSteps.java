package ForTest2.Steps;

import ForTest2.Pages.AccountPage;
import io.qameta.allure.Step;

public class AccountPageSteps {
    AccountPage accountPage;
    @Step
    public AccountPageSteps GoToList() {
        accountPage = new AccountPage();
        accountPage.LapAndNot.hover();
        accountPage.ShowAll.click();

        return this;
    }
}
