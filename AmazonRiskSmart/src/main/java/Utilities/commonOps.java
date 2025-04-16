package Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class commonOps extends base {


    //function that verify element, need to get WebElement to see if it does exists or not
    public static void verifyElementExist(WebElement elem)  {
        try {
            elem.isDisplayed();
            System.out.println("Element Exists");
        } catch (Exception e) {
            System.out.println("Element does not Exists! ");
            fail("Element does not Exists");
        }

    }

    //Function that verify if a value exsist
    public static void verifyValueExist(WebElement elem, String expectedValue) {
        try {
            String actual = elem.getText();
            assertEquals(expectedValue, actual);
            System.out.println("Value Exists");
        } catch (Exception e) {
            System.out.println("Value does not Exists! ");
            fail("Element does not Exists");

        } catch (AssertionError ea) {
            System.out.println("Assert Failed " + ea.getMessage());
            fail("the value was different then the original");
        }

    }

    //function that select from a drop down.
    public static void selectDropDown(WebElement elem, String valueMenu) {
        try {
            elem.click();
            Select myValue = new Select(elem);
            myValue.selectByValue(valueMenu);
            System.out.println("Element Selected");
        } catch (Exception e) {
            System.out.println("Element was not Selected! ");
            fail("Element was not Selected");
        }

    }

    public static void verifyClick(WebElement elem)  {
        try {
            elem.click();
            System.out.println("Element found and Clicked");
        } catch (Exception e) {
            System.out.println("Element is not Clickable! ");
            fail("Element is not Clickable!");
        }
    }

}
