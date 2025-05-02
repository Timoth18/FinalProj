package web.stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class HomePageSteps {

    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless"); // Use "--headless" if using older Chrome versions
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");

    // Initialize the WebDriver with headless Chrome
    WebDriver driver = new ChromeDriver(options);

    // Wait setup
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    @Given("I navigate to the demoblaze homepage")
    public void iNavigateToTheDemoblazeHomepage() {
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();
    }

    @Then("I should see the title {string}")
    public void iShouldSeeTheTitle(String expectedTitle) {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nava")));
        Assert.assertTrue(title.getText().contains(expectedTitle));
    }

    @When("I click on the {string} category")
    public void iClickOnTheCategory(String category) {
        WebElement categoryElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='" + category + "']")));
        categoryElement.click();
    }

    @Then("I should see phones listed")
    public void iShouldSeePhonesListed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Samsung galaxy')]")));
        Assert.assertTrue(driver.findElements(By.className("card-title")).size() > 0);
    }

    @When("I click on the first product")
    public void iClickOnTheFirstProduct() {
        WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".card-title a")));
        firstProduct.click();
    }

    @Then("I should see the product details")
    public void iShouldSeeTheProductDetails() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("name")));
        Assert.assertTrue(driver.findElement(By.className("name")).isDisplayed());
    }

    @When("I login with {string} and {string}")
    public void iLoginWithAnd(String username, String password) throws InterruptedException {
        driver.findElement(By.id("login2")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        driver.findElement(By.id("loginusername")).sendKeys(username);
        driver.findElement(By.id("loginpassword")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        Thread.sleep(3000); // Wait for alert
    }

    @Then("I should see a login error")
    public void iShouldSeeALoginError() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alert.getText().toLowerCase().contains("user does not exist."));
        alert.accept();
    }

    @And("I add it to the cart")
    public void iAddItToTheCart() throws InterruptedException {
        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add to cart']")));
        addToCart.click();
        Thread.sleep(2000); // Wait for alert
    }

    @Then("I should see a confirmation alert")
    public void iShouldSeeAConfirmationAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alert.getText().toLowerCase().contains("product added"));
        alert.accept();
    }

    @And("I go to the cart and place the order with details")
    public void iGoToTheCartAndPlaceTheOrderWithDetails() throws InterruptedException {
        driver.findElement(By.id("cartur")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Place Order']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys("Test User");
        driver.findElement(By.id("country")).sendKeys("Testland");
        driver.findElement(By.id("city")).sendKeys("Test City");
        driver.findElement(By.id("card")).sendKeys("1234123412341234");
        driver.findElement(By.id("month")).sendKeys("04");
        driver.findElement(By.id("year")).sendKeys("2025");
        driver.findElement(By.xpath("//button[text()='Purchase']")).click();
    }

    @Then("I should see a purchase confirmation")
    public void iShouldSeeAPurchaseConfirmation() {
        WebElement confirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sweet-alert")));
        Assert.assertTrue(confirmation.getText().contains("Thank you for your purchase!"));
        driver.findElement(By.xpath("//button[text()='OK']")).click();
        driver.quit();
    }
}