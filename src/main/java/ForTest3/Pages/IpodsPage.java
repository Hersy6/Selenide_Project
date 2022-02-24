package ForTest3.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class IpodsPage {
    public SelenideElement
            ipodTouch = $(By.xpath("//img[@title='iPod Touch']")),
            touchText =$(By.xpath("//a[contains(text(),'iPod Touch')]"));
}
