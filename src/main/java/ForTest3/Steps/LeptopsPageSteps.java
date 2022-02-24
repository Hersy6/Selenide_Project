package ForTest3.Steps;

import ForTest3.Pages.LeptopsPage;
import io.qameta.allure.Step;

public class LeptopsPageSteps {
    LeptopsPage leptopsPage;
    @Step
    public LeptopsPageSteps GoToLeptops() {
        leptopsPage = new LeptopsPage();
        leptopsPage.Desktops.hover();
        leptopsPage.ShowAllDesktops.click();
        return this;
    }
}
