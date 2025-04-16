package TestCases;

// import Utilities.base;
import Utilities.base;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //to make sure tests are running by a certain order test01 test02 etc
public class techChallange extends base {


//---------------- every hardcoded text, will and should be replaced by a dynamic external xml file that gives and feed information -----------------

    @Test
    public void test01_AddItemToCartAndTotal() throws InterruptedException
    {
        scenOne.Scenario_1("4");
        scenOne.Scenario_1_TotalCartPrice("25.00");
    }

    @Test
    public void test02_contactUs() {
        scenTwo.Scenario_2("6", "John doe", "test@example.com", "1234", "this is test message");
        scenTwo.Scenario_2_CheckMessage("Success Human! Your message has been submitted to the proper department. Please allow 1-4 business days for a response.");
    }

    @Test
    public void test03_searchFunctionality()  {

        scenThree.scenario_3("pilot");

    }
}
