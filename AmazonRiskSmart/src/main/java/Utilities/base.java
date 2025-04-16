package Utilities;

import PageObjects.scenarioOne;
import PageObjects.scenarioThree;
import PageObjects.scenarioTwo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class base {

    public static WebDriver driver;

    public static scenarioOne scenOne;
    public static scenarioTwo scenTwo;
    public static scenarioThree scenThree;

    //---------------------------Browser Selection, open Browser--------------------------
    public static void initBrowser(String browserType) throws ParserConfigurationException, SAXException, IOException {
        switch (browserType.toLowerCase())  //for now we only have chrome installed
        {
            //when all drivers installed, will put them here, for now only chrome installed
            case "firefox":
                driver = initChromeDriver();
                break;
            case "ie":
                driver = initChromeDriver();
                break;
            case "chrome":
                driver = initChromeDriver();
                break;
        }

        driver.navigate().to("https://www.designbyhumans.com//");  //hard coded URL for now, for future will use external file (xml) so it will be more dynamic
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }

//-------------------------------- all the annotations that are not @Test -----------------------------


    @BeforeClass
    public static void openBrowser() throws IOException, SAXException, ParserConfigurationException {
        initBrowser("chrome");
        PageObjects.managePages.init();
    }

    @AfterMethod
    public static void BackToHomePage() throws InterruptedException {
        Thread.sleep(2000);
        driver.navigate().to("https://www.designbyhumans.com//");
    }


    @AfterClass
    public static void BrowserClose() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}