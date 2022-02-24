import ForTest1.Steps.HomePageSteps;
import ForTest1.Steps.RegistrationPageSteps;
import ForTest2.Steps.AccountPageSteps;
import ForTest2.Steps.ProductPageSteps;
import ForTest3.Steps.DesktopsPageSteps;
import ForTest3.Steps.IpodTouchPageSteps;
import ForTest3.Steps.IpodsPageSteps;
import ForTest3.Steps.LeptopsPageSteps;
import ForTest4.Steps.CheckoutPageSteps;
import ForTest4.Steps.CheckoutPopUpPageSteps;
import ListenersPack.BasePage;
import ListenersPack.RetryCountIfFailed;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

@Epic("Computer technique webpage automation testing ")
@Feature("registration,product find, checkout")

public class FinalTests extends BasePage implements ITestListener {
    HomePageSteps homePageSteps;
    RegistrationPageSteps registrationPageSteps;
    AccountPageSteps accountPageSteps;
    ProductPageSteps productPageSteps;
    LeptopsPageSteps leptopsPageSteps;
    DesktopsPageSteps desktopsPageSteps;
    IpodsPageSteps ipodsPageSteps;
    IpodTouchPageSteps ipodTouchPageSteps;
    CheckoutPopUpPageSteps checkoutPopUpPageSteps;
    CheckoutPageSteps checkoutPageSteps;
    public WebDriver driver;

    @BeforeTest
    public void setUp() {

        BasePage basePage = new BasePage();
        basePage.Config();
        open("http://tutorialsninja.com/demo/");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

    }

    @Story("Registration with Data from Database")
    @Test(priority = 0, groups = "Resgression1")
    public void test1() {
        homePageSteps = new HomePageSteps();
        registrationPageSteps = new RegistrationPageSteps();
        homePageSteps.goToRegistration();
        registrationPageSteps.insert();
        registrationPageSteps.nextPage();
    }

    @Story("lists and sorting")
    @Test(priority = 1, groups = "Resgression1")
    public void Test2() {
        accountPageSteps = new AccountPageSteps();
        productPageSteps = new ProductPageSteps();
        accountPageSteps.GoToList();
        productPageSteps.Sort();
        productPageSteps.CheckSort();
    }

    @Feature("check and add product")
    @Test(priority = 2, groups = "Resgression2", dependsOnMethods = "test1")
    public void Test3() {
        leptopsPageSteps = new LeptopsPageSteps();
        desktopsPageSteps = new DesktopsPageSteps();
        ipodsPageSteps = new IpodsPageSteps();
        ipodTouchPageSteps = new IpodTouchPageSteps();
        leptopsPageSteps.GoToLeptops();
        desktopsPageSteps.GotoMp3();
        ipodsPageSteps.CheckText();
        ipodTouchPageSteps.addCart();
        ipodTouchPageSteps.CheckAction();

    }

    @Story("checking checkout steps, registering address got from Database and checking numbers")
    @Test(priority = 3, groups = "Resgression2", dependsOnMethods = "Test3")
    @RetryCountIfFailed(3)
    public void Test4() {
        checkoutPopUpPageSteps = new CheckoutPopUpPageSteps();
        checkoutPageSteps = new CheckoutPageSteps();
        checkoutPopUpPageSteps.GoToCheckout();
        checkoutPageSteps.FillAddress();
        checkoutPageSteps.DeliveryDetails();
        checkoutPageSteps.DeliveryMethods();
        checkoutPageSteps.terms();
        checkoutPageSteps.checkFlatRate();
        checkoutPageSteps.checkSub();
        checkoutPageSteps.checkTotal();
        checkoutPageSteps.placeOrder();


    }

    @AfterTest
    public void tearDown() throws IOException {
        screenshot();
        closeWindow();
    }

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.getLastScreenshot();
        return screenshot == null ? null : Files.toByteArray(screenshot);
    }


}
