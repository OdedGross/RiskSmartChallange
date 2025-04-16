package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class scenarioThree {
    public WebDriver driver;

    @FindBy(how = How.CSS, using = "input[id='common_search-input'")
    public WebElement search;

    @FindBy(how = How.CSS, using = "h1[class='tcenter'")
    public WebElement SearchResult;

    @FindBy(how = How.CSS, using = "li.col.listing-col")
    public List<WebElement> listingCol; // Locate the list of <li> elements with class "col listing-col" for each item

    public void scenario_3(String SearchText){

        search.sendKeys(SearchText + Keys.ENTER);
        // Check if elements are found
        if (listingCol.isEmpty()) {
            System.out.println("No result items found.");
        } else {
            System.out.println("Result items found:");

            // Iterate through the list and perform actions/assertions
            for (WebElement item : listingCol) {
                // Print the text of each result item
                System.out.println(item.getText());

                // Example: Check that each result item contains some expected text
                if (item.getText().contains(SearchText)) {
                    System.out.println("Item contains expected text -->" + SearchText);
                } else {
                    System.out.println("Item does not contain expected text "+ SearchText);
                }
            }
        }

}

    public scenarioThree(WebDriver driver) {
        this.driver = driver;
    }
}