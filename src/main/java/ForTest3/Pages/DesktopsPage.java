package ForTest3.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
public class DesktopsPage {
    public SelenideElement
    mp3 = $(By.xpath("//*[@id='column-left']//a[contains(text(),'MP3 Players')]"));

}
