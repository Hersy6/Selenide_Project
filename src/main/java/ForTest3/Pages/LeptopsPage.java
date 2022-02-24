package ForTest3.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LeptopsPage {
    public SelenideElement
            Desktops = $(By.xpath("//a[contains(text(),'Desktops')]")),
            ShowAllDesktops = $(By.xpath("//a[contains(text(), 'Show All Desktops')]"));
}
