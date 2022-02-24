package ForTest1.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    public SelenideElement
            firstName = $("#input-firstname"),
            lastName = $("#input-lastname"),
            email = $("#input-email"),
            telephone = $("#input-telephone"),
            password = $("#input-password"),
            conPassword = $("#input-confirm"),
            agreeTC = $(By.name("agree")),
            Continue = $(By.xpath("//input[@value ='Continue']"));
}
