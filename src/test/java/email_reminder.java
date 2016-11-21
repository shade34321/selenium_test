/**
 * Created by shade on 11/20/2016.
 */

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import cucumber.api.DataTable;

import static org.junit.Assert.assertTrue;

public class email_reminder {
    WebDriver driver;
    home_page home;
    String url = "https://rb-shoe-store.herokuapp.com";

    @Before
    public void init() {
        System.setProperty("webdriver.gecko.driver", "E:\\Utilities\\geckodriver-v0.11.1-win64\\geckodriver.exe");

        driver = new FirefoxDriver();

        home = new home_page(driver);
    }

    @Given("^a user is on the home page$")
    public void go_home() throws Throwable {
        driver.get(url);
        assertTrue(driver.getTitle().equals("Shoe Store: Welcome to the Shoe Store"));
    }

    @When("^there is a button for the user to use that submits their email address$")
    public void check_for_email_button() throws Throwable {
        assertTrue(home.email_button_exists());
    }

    @When("^the user enters a bad email address$")
    public void check_bad_email(DataTable email) throws Throwable {
        List<List<String>> email_addresses = email.raw();
        for (List<String> element : email_addresses) {
            for (String ea : element) {
                home.submit_email(ea);
            }
        }
    }

    // We should be able to DRY some of this up. I'll look it up later
    @When("A user enters a valid email address$")
    public void check_valid_email(DataTable email) throws Throwable {
        List<List<String>> email_addresses = email.raw();
        for (List<String> element : email_addresses) {
            for (String ea : element) {
                home.submit_email(ea);
            }
        }
    }

    @Then("^a success message should appear$")
    public void check_for_success_msg() throws Throwable {
        String success_msg = "Thanks! We will notify you of our new shoes at this email: test@example.com";
        assertTrue(home.email_results().equals(success_msg));
    }

    @Then("^an error message should appear$")
    public void check_for_error_msg() throws Throwable {
        assertTrue(home.email_results().equals("Invalid email format. Ex. name@example.com"));
    }

    @Then("^the text should say Subscribe$")
    public void check_for_correct_text_on_button() throws Throwable {
        assertTrue(home.get_submit_button_text().equals("Subscribe"));
    }

    @After
    public void destroy() {

        driver.close();
    }
}
