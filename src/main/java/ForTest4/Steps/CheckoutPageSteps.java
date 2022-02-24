package ForTest4.Steps;

import ForTest4.Pages.CheckoutPage;
import ListenersPack.ConnToDB;
import ListenersPack.InsertQuery;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckoutPageSteps {


    CheckoutPage checkoutPage;


    @Step
    public CheckoutPageSteps FillAddress() {
        checkoutPage = new CheckoutPage();
        InsertQuery.main();
        try (Connection conn = ConnToDB.getConnection();
             Statement stat = conn.createStatement();
             ResultSet rs = stat.executeQuery("SELECT top 1 * FROM [users].[dbo].[users] ORDER BY ID DESC")) {
            while (rs.next()) {
                checkoutPage.firstName.sendKeys(rs.getString("firstName"));
                checkoutPage.lastName.sendKeys(rs.getString("lastName"));
                checkoutPage.address.scrollTo();
                checkoutPage.address.sendKeys(rs.getString("address"));
                checkoutPage.city.sendKeys(rs.getString("city"));
                checkoutPage.zip.sendKeys(rs.getString("zip"));
                checkoutPage.country.selectOption(rs.getString("country"));
                checkoutPage.region.selectOption(rs.getString("state"));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        checkoutPage.personalInfoContinue.click();
        return this;
    }

    @Step
    public CheckoutPageSteps DeliveryDetails() {
        checkoutPage.DeliveryDetailsContinue.scrollTo();
        checkoutPage.DeliveryDetailsContinue.click();
        return this;
    }

    public String x;

    @Step
    public CheckoutPageSteps DeliveryMethods() {
        // აქ ხან მოაქ სრული ტექსტი ხან ვერა როცა მოაქვს ყველაფერი სწორია
        x = checkoutPage.flatRateRadio.getText();
        checkoutPage.deliveryMethodsContinue.scrollTo();
        checkoutPage.deliveryMethodsContinue.click();

        return this;
    }

    @Step
    public CheckoutPageSteps terms() {
        checkoutPage.terms.click();
        checkoutPage.paymentMethodsContinue.click();
        return this;
    }

    @Step
    public <x> CheckoutPageSteps checkFlatRate() {
        SoftAssert softAssert = new SoftAssert();
        double flatRadio = Double.parseDouble(x.replaceAll("[^0-9.]", ""));
        double flatCheck = Double.parseDouble(checkoutPage.flatRate.getText().replaceAll("[^0-9.]", ""));
        boolean b = flatCheck == flatRadio;
        softAssert.assertTrue(b);

        return this;

    }

    @Step
    public CheckoutPageSteps checkSub() {
        SoftAssert softAssert = new SoftAssert();
        double cart = Double.parseDouble(checkoutPage.cart.getText().replaceAll("[^0-9.]", ""));
        double sub = Double.parseDouble(checkoutPage.SubTotal.getText().replaceAll("[^0-9.]", ""));
        boolean b = cart == sub;
        softAssert.assertTrue(b);

        return this;

    }

    @Step
    public CheckoutPageSteps checkTotal() {
        SoftAssert softAssert = new SoftAssert();

        double subtot = Double.parseDouble(checkoutPage.SubTotal.getText().replaceAll("[^0-9.]", ""));
        double rate = Double.parseDouble(checkoutPage.flatRate.getText().replaceAll("[^0-9.]", ""));
        double total = Double.parseDouble(checkoutPage.total.getText().replaceAll("[^0-9.]", ""));
        boolean b = subtot + rate == total;
        softAssert.assertTrue(b);

        return this;
    }

    @Step
    public CheckoutPageSteps placeOrder(){
        checkoutPage.confirm.click();
        return this;
    }

}
