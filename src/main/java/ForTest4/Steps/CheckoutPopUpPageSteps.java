package ForTest4.Steps;

import ForTest4.Pages.CheckoutPopUpPage;
import io.qameta.allure.Step;

public class CheckoutPopUpPageSteps {
    CheckoutPopUpPage checkoutPopUpPage;
    @Step
    public CheckoutPopUpPageSteps GoToCheckout(){
        checkoutPopUpPage=new CheckoutPopUpPage();
        checkoutPopUpPage.cartTotal.click();
        checkoutPopUpPage.CheckoutLink.click();
        return this;
    }
}
