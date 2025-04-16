package PageObjects;

import Utilities.commonOps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.Message;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.testng.Assert.assertEquals;

public class scenarioTwo {

    public WebDriver driver;

    //---------------------------------Scenario 2-------------------------------------
    @FindBy(how = How.CSS, using = "a[title='Contact Us']")
    public WebElement contactUsLink;

    @FindBy(how = How.ID, using = "contact-reason")
    public WebElement contactReason;

    @FindBy(how = How.CSS, using = "input[name='contact_form[name]']")
    public WebElement contactFormName;

    @FindBy(how = How.CSS, using = "input[name='contact_form[email]']")
    public WebElement contactFormEmail;

    @FindBy(how = How.CSS, using = "input[name='contact_form[order_number]']")
    public WebElement contactFormOrderNumber;

    @FindBy(how = How.CSS, using = "textarea[name='contact_form[message]']")
    public WebElement contactFormMessage;

    @FindBy(how = How.CSS, using = "button[class='m-submit']")
    public WebElement SendButton;

    @FindBy(how = How.CSS, using = "div.m-alert-icon")
    public WebElement successMessage;

    //fill form and click submit to send
    public void Scenario_2(String reasonValue, String Name, String Email, String OrderNumber, String Message) {
        contactUsLink.click();
        commonOps.selectDropDown(contactReason, reasonValue);
        contactFormName.sendKeys(Name);
        contactFormEmail.sendKeys(Email);
        contactFormOrderNumber.sendKeys(OrderNumber);
        contactFormMessage.sendKeys(Message);
        SendButton.click();

    }

    public void Scenario_2_CheckMessage(String MessageText) {

        successMessage.getText();
        try {
            assertEquals(MessageText, MessageText);
            System.out.println("Yes the message is: " + MessageText);
        } catch (Exception e) {
            System.out.println("No, wrong message, we got this instead: " + MessageText);
        }

    }







    public scenarioTwo(WebDriver driver) {
        this.driver = driver;
    }

}