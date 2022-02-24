package ForTest2.Steps;

import ForTest2.Pages.ProductPage;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductPageSteps {
    ProductPage productPage;

    @Step
    public ProductPageSteps Sort() {
        productPage = new ProductPage();
        productPage.Dropdown.selectOption(productPage.SortOption);
        return this;
    }

    @Step
    public ProductPageSteps CheckSort() {
        SoftAssert softAssert = new SoftAssert();
        List priceList = new ArrayList<>();
        for (SelenideElement i : productPage.priceList) {
            String x = i.getText();
            int z = x.indexOf("\n");
            Double m = Double.parseDouble(i.getText().substring(1, z).replaceAll("[^0-9.$]", ""));
            System.out.println(m);
            priceList.add(m);

        }
        double maxPrice = (double) Collections.max(priceList);
        double firstItemPrice = Double.parseDouble(productPage.priceList.get(0).getText().substring(1, productPage.priceList.get(0).getText().indexOf("\n"))
                .replaceAll("[^0-9.$]", ""));
        Boolean b = maxPrice == firstItemPrice;
        softAssert.assertTrue(b);


        return this;
    }
}


