
package web.stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class HomePageSteps {

    private WebDriver driver;

    @Given("I navigate to the demoblaze homepage")
    public void i_navigate_to_the_demoblaze_homepage() {
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/");
    }

    @Then("I should see the logo")
    public void i_should_see_the_logo() {
        WebElement logo = driver.findElement(By.id("nava"));
        assertTrue(logo.isDisplayed());
        driver.quit();
    }
}


    @Then("I should see the {string} section")
    public void i_should_see_the_section(String sectionText) {
        WebElement category = driver.findElement(By.xpath("//a[text()='" + sectionText + "']"));
        assertTrue(category.isDisplayed());
        driver.quit();
    }
