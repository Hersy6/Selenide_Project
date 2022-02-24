package ListenersPack;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Configuration.timeout;

public class BasePage {



    public void Config() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        Configuration.browserCapabilities = options;
        Configuration.browserSize = null;
        Configuration.holdBrowserOpen = true;
        Configuration.savePageSource = false;
        timeout = 5000;

    }

}