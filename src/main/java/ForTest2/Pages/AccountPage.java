package ForTest2.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AccountPage {
    public SelenideElement
            LapAndNot = $(By.xpath("//a[contains(text(),'Laptops & Notebooks')]")),
            ShowAll = $(By.xpath("//a[contains(text(), 'Show All Laptops & Notebooks')]"));

}
