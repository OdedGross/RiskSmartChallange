package PageObjects;

import Utilities.base;
import org.openqa.selenium.support.PageFactory;

public class managePages extends base {

    //this is where I do all the pages initialization to make Sanity and testCases more clean
    public static void init()
    {

        scenOne = PageFactory.initElements(driver, scenarioOne.class);
        scenTwo = PageFactory.initElements(driver, scenarioTwo.class);
        scenThree = PageFactory.initElements(driver, scenarioThree.class);

    }
}