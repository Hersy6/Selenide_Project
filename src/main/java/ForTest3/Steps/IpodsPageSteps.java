package ForTest3.Steps;

import ForTest3.Pages.IpodsPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

public class IpodsPageSteps {
    IpodsPage ipodsPage;
    @Step
    public IpodsPageSteps CheckText() {
        ipodsPage = new IpodsPage();
        ipodsPage.ipodTouch.scrollTo();
        ipodsPage.ipodTouch.hover();
        ipodsPage.touchText.shouldHave(Condition.text(ipodsPage.ipodTouch.getAttribute("title")));
        ipodsPage.ipodTouch.click();
        return this;
    }
}
