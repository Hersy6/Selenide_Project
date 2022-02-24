package ForTest4.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutPopUpPage {
    public SelenideElement
            cartTotal = $(By.id("cart-total")),
            CheckoutLink = $(By.xpath("//strong[contains(text(),'Checkout')]"));

}
