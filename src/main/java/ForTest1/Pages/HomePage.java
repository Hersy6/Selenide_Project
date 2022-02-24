package ForTest1.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    public SelenideElement
            myAccount = $(By.xpath("//a[@title='My Account']")),
            registration = $(By.xpath("//*[@id='top-links']//a[text()='Register']"));


}
