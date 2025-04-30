package web.stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageSteps {

    WebDriver driver;

    @Given("I navigate to the demoblaze homepage")
    public void iNavigateToTheDemoblazeHomepage() {
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/");
    }

    @Then("I should see the title {string}")
    public void iShouldSeeTheTitle(String title) {
        Assert.assertTrue(driver.getPageSource().contains(title));
        driver.quit();
    }

    @When("I click on the {string} category")
    public void iClickOnTheCategory(String category) {
        driver.findElement(By.linkText(category)).click();
    }

    @Then("I should see phones listed")
    public void iShouldSeePhonesListed() {
        Assert.assertTrue(driver.getPageSource().contains("Samsung"));
        driver.quit();
    }

    @When("I click on the first product")
    public void iClickOnTheFirstProduct() {
        driver.findElement(By.cssSelector("#tbodyid .card-title a")).click();
    }

    @Then("I should see the product details")
    public void iShouldSeeTheProductDetails() {
        Assert.assertTrue(driver.getPageSource().contains("Product description"));
        driver.quit();
    }

    @When("I login with {string} and {string}")
    public void iLoginWithAnd(String username, String password) {
        driver.findElement(By.id("login2")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
        driver.findElement(By.id("loginusername")).sendKeys(username);
        driver.findElement(By.id("loginpassword")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    @Then("I should see a login error")
    public void iShouldSeeALoginError() {
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().toLowerCase().contains("wrong"));
        alert.accept();
        driver.quit();
    }

    @And("I add it to the cart")
    public void iAddItToTheCart() {
        driver.findElement(By.linkText("Add to cart")).click();
    }

    @Then("I should see a confirmation alert")
    public void iShouldSeeAConfirmationAlert() {
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("Product added"));
        alert.accept();
        driver.quit();
    }

    @And("I go to the cart and place the order with details")
    public void iGoToTheCartAndPlaceTheOrderWithDetails() {
        driver.findElement(By.id("cartur")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
        driver.findElement(By.id("name")).sendKeys("Test User");
        driver.findElement(By.id("country")).sendKeys("Indonesia");
        driver.findElement(By.id("city")).sendKeys("Jakarta");
        driver.findElement(By.id("card")).sendKeys("1234123412341234");
        driver.findElement(By.id("month")).sendKeys("12");
        driver.findElement(By.id("year")).sendKeys("2025");
        driver.findElement(By.xpath("//button[text()='Purchase']")).click();
    }

    @Then("I should see a purchase confirmation")
    public void iShouldSeeAPurchaseConfirmation() {
        WebElement confirmation = driver.findElement(By.className("sweet-alert"));
        Assert.assertTrue(confirmation.getText().contains("Thank you"));
        driver.quit();
    }
}