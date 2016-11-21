/**
 * Created by shade on 11/20/2016.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class home_page {
    WebDriver driver;

    By email = By.id("remind_email_input");
    By submit_email_btn = By.id("remind_email_submit");

    By promo = By.id("promo_code_input");
    By promo_btn = By.id("promo_code_submit");

    By email_msg = By.id("flash");

    List<WebElement> months;

    public home_page(WebDriver driver) {
        this.driver = driver;
    }

    public String get_title() {
        return driver.getTitle();
    }

    public Boolean email_button_exists() {
        boolean present;

        try {
            driver.findElement(By.id("remind_email_submit"));
            present = true;
        } catch (NoSuchElementException e)  {
            present = false;
        }

        return present;
    }

    public String get_submit_button_text(){
        return submit_email_btn.getText();
    }

    public String get_promo_button_text() {
        return promo_btn.gertText();
    }

    public void submit_promo(String promo_code) {
        promo.sendKeys(promo_code);
        promo_btn.click();
    }

    public void submit_email(String email_address) {
        email.sendKeys(email_address);
        submit_email_btn.click();
    }

    public String email_results() {

        return email_msg.getText();
    }

    public void go_to_month(String month) {
        List<WebElement> month_list = driver.findElements(By.xpath(".//*[@id='header_nav']/nav/ul/li"));
        for (WebElement m : month_list) {
            if(m.getText().equalsIgnoreCase(month)) {
                m.click();
            }
        }
    }
}