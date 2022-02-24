package ForTest3.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
public class IpodTouchPage {
    public SelenideElement
    addCart = $(By.id("button-cart")),
    cartTotal = $(By.id("cart-total")),
    price = $(By.xpath("//h2[contains(text(),'$')]"));
}
