package ForTest4.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {

    public SelenideElement
            firstName = $(By.id("input-payment-firstname")),
            lastName = $(By.id("input-payment-lastname")),
            address = $(By.id("input-payment-address-1")),
            city = $(By.id("input-payment-city")),
            zip = $(By.id("input-payment-postcode")),
            country = $(By.id("input-payment-country")),
            region = $(By.id("input-payment-zone")),
            personalInfoContinue = $(By.id("button-payment-address")),
            DeliveryDetailsContinue = $(By.id("button-shipping-address")),
            flatRateRadio = $(By.xpath("//input[@name='shipping_method']/parent::label")),
            flatRate = $(By.xpath("//strong[text()='Flat Shipping Rate:']")).parent().sibling(0),
            terms = $(By.name("agree")),
            deliveryMethodsContinue = $(By.id("button-shipping-method")),
            paymentMethodsContinue = $(By.id("button-payment-method")),
            cart = $(By.id("cart-total")),
            SubTotal = $(By.xpath("//strong[text()='Sub-Total:']")).parent().sibling(0),
            total = $(By.xpath("//strong[text()='Total:']")).parent().sibling(0),
            deliveryMethodClick = $(By.xpath("//a[contains(text(),'Step 4:')]")),
            confirm =$(By.id("button-confirm"));

}
