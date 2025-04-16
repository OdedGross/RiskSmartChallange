package PageObjects;

// port Utilities.base;
import Utilities.commonOps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.Assert.fail;
import static org.testng.Assert.assertEquals;

public class scenarioOne {

    public WebDriver driver;

    // ------------------- Scenario 1 -------------------------------------------------//
    @FindBy(how = How.CLASS_NAME, using = "ltkpopup-close")
    public WebElement closeIcon;

    @FindBy(how = How.XPATH, using = "//a[@href='/shop/mens-t-shirts/']")
    public WebElement Popular;

    @FindBy(how = How.XPATH, using = "//a[@href='/shop/t-shirt/men/minimal-paper-airplane-take-off/1502257/']")
    public WebElement Tshirt;

    @FindBy(how = How.ID, using = "product_options[style]")
    public WebElement MenStyle;

    @FindBy(how = How.CLASS_NAME, using = "add-to-cart")
    public WebElement PDPAddCart;

    @FindBy(how = How.CLASS_NAME, using = "header-cart")
    public WebElement headerCart;

    @FindBy(how = How.ID, using = "cboxClose")
    public WebElement successAddWindowClose;

    @FindBy(how = How.ID, using = "pd-title")
    public WebElement PDPTitle;

    @FindBy(how = How.ID, using = "pd-price")
    public WebElement PDPPrice;

    @FindBy(how = How.CSS, using = "a.title")
    public WebElement CartPDPTitle;

    @FindBy(how = How.CSS, using = "strong.price.m-label")
    public WebElement CartPDPPrice;

    @FindBy(how = How.CSS, using = "span.currency-amount")
    public WebElement TotalPriceInCart;

    public void Scenario_1(String styleValue) {
        closeIcon.click();
        Popular.click();
        Tshirt.click();
        commonOps.selectDropDown(MenStyle, styleValue);
        String actualItemName = PDPTitle.getText();
        String actualItemPrice = PDPPrice.getText();
        PDPAddCart.click();
        successAddWindowClose.click();
        headerCart.click();
        Scenario_1_CartItemNamePriceAssert(actualItemName, actualItemPrice);
    }

    public void Scenario_1_CartItemNamePriceAssert(String ActualName, String ActualPrice) {
        String expectedItemName = CartPDPTitle.getText();
        String expectedItemPrice = CartPDPPrice.getText();

        assertEquals(ActualName, expectedItemName, "product name correct");
        assertEquals(ActualPrice, expectedItemPrice, "price per product correct"); //check price per product, even if Qty > 1
    }


    //just checked the total cost displayed on cart
    public void Scenario_1_TotalCartPrice (String actualTotalCost)
    {
        String TotalCost = TotalPriceInCart.getText();
        try {
            assertEquals(actualTotalCost, TotalCost);
            System.out.println("Yes the total cost is " + actualTotalCost);
        } catch (Exception e) {
            System.out.println("wrong price :(");
        }


    }

    public scenarioOne(WebDriver driver) {
        this.driver = driver;
    }

}

