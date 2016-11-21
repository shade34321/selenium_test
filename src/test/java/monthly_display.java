/**
 * Created by shade on 11/21/2016.
 */

import java.util.List;

import cucumber.api.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import cucumber.api.DataTable;

import static org.junit.Assert.assertTrue;

public class monthly_display {
    WebDriver driver;
    home_page home;
    monthly_page mp;
    String url = "https://rb-shoe-store.herokuapp.com";

    @Before
    public void init() {
        System.setProperty("webdriver.gecko.driver", "E:\\Utilities\\geckodriver-v0.11.1-win64\\geckodriver.exe");

        driver = new FirefoxDriver();

        home = new home_page(driver);
        mp = new monthly_page(driver);
    }

    @Given("^a user is on the home page$")
    public void go_home() throws Throwable {
        driver.get(url);
        assertTrue(driver.getTitle().equals("Shoe Store: Welcome to the Shoe Store"));
    }

    @When("^A user clicks on the month page$")
    public void check_monthly_pages(DataTable month_data) throws Throwable {
        List<List<String>> months = month_data.raw();
        for (List<String> m : months) {
            for (String month : m) {
                home.go_to_month(month);
            }
        }
    }

    @Then("^the monthly page should load$")
    public void monthly_page_load()  throws Throwable {
        assertTrue(driver.getCurrentUrl().contains("https://rb-shoe-store.herokuapp.com/months/"));
    }

    @Then("^a list of shoes with a description, image, and MSRP should be displayed$")
    public void check_table() throws Throwable {} {
        mp.check_for_shoe_list();
    }

    @After
    public void destroy() {
        driver.close();
    }
}
