/**
 * Created by shade on 11/19/2016.
 */

import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static junit.framework.TestCase.assertTrue;


public class first_test {

    @Test
    public void goToWebPage()
    {
        System.setProperty("webdriver.gecko.driver", "E:\\Utilities\\geckodriver-v0.11.1-win64\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.get("https://rb-shoe-store.herokuapp.com/");
        assertTrue(driver.getTitle().equals("Shoe Store: Welcome to the Shoe Store"));

        WebElement email = driver.findElement(By.id("remind_email_input"));
        WebElement submit_email = driver.findElement(By.id("remind_email_submit"));
        WebElement email_success = driver.findElement(By.id("flash"));

        String email_address = "test@test.com";
        String success_msg = "Thanks! We will notify you of our new shoes at this email: " + email_address;


        email.sendKeys(email_address);
        submit_email.click();
        try {
            Thread.sleep(1000); // Look up how to wait until a element is on a page or write a method to do it
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(email_success.getText().equals(success_msg));

        email_address = "a@b.co";
        String failure_msg = "Invalid email format. Ex. name@example.com" + email_address;

        email.sendKeys(email_address);
        submit_email.click();
        try {
            Thread.sleep(1000); // Look up how to wait until a element is on a page or write a method to do it
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(email_success.getText().equals(success_msg));

        driver.quit();
    }

}
