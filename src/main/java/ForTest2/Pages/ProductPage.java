package ForTest2.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductPage {
    public String SortOption = "Price (High > Low)";
    public SelenideElement
            Dropdown = $("#input-sort");

    public ElementsCollection
            priceList = $$(By.xpath("//p[@class='price']")).filterBy(Condition.visible);
}


