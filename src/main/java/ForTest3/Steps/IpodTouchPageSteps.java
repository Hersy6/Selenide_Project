package ForTest3.Steps;

import ForTest3.Pages.IpodTouchPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

public class IpodTouchPageSteps {
    IpodTouchPage ipodTouchPage;
    @Step
    public IpodTouchPageSteps addCart() {
        ipodTouchPage = new IpodTouchPage();
        ipodTouchPage.addCart.click();
        return this;
    }
    @Step
    public IpodTouchPageSteps CheckAction() {
    ipodTouchPage.cartTotal.shouldHave(Condition.text(ipodTouchPage.price.getText()));
        return this;
    }
}
