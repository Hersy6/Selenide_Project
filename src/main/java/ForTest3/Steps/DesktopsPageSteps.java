package ForTest3.Steps;

import ForTest3.Pages.DesktopsPage;
import io.qameta.allure.Step;

public class DesktopsPageSteps {
    DesktopsPage desktopsPage;
    @Step
    public DesktopsPageSteps GotoMp3() {
        desktopsPage = new DesktopsPage();
        desktopsPage.mp3.scrollTo();
        desktopsPage.mp3.click();
        return this;
    }
}
