/**
 * Created by shade on 11/20/2016.
 */

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class monthly_page {
    WebDriver driver;
    List<WebElement> shoe_list = By.xpath(By.xpath("//div[@id='...']/ul/li"));

    public monthly_page(WebDriver driver) {
        this.driver = driver;
    }

    // http://stackoverflow.com/questions/6198947/how-to-get-text-from-each-cell-of-an-html-table
    // http://stackoverflow.com/questions/16154318/how-to-check-all-elements-in-a-ul-list-using-selenium-webdriver
    // Don't really understand this - need to come back and check it over
    public void check_for_shoe_list(){
        for (WebElement e : shoe_list) {

            WebElement shoe_table = driver.findElement(By.xpath("//*[@id='" + e + "']/table/tbody"));
            List<WebElement> table_rows = shoe_table.findElements(By.tagName("tr"));
            List<WebElement> table_data = table_rows.get(0).findElements(By.tagName("td"));
            assertTrue(table_data.get(0).getText().contains("Brand"));
        }
    }
}