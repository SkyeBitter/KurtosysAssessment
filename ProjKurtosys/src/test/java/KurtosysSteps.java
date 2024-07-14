import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class KurtosysSteps {
    WebDriver driver;

    @Given("I navigate to the KurtosysSteps website")
    public void i_navigate_to_the_kurtosys_website() {
        System.setProperty("webdriver.chrome.driver", "\"C:\\Users\\siphokazi.bitterhout\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe\"");
        driver = new ChromeDriver();
        driver.get("https://www.kurtosys.com/");
    }
    @When("I navigate to the INSIGHTS section")
    public void i_navigate_to_the_insights_section() {
        WebElement insightsMenu = driver.findElement(By.linkText("kurtosys-menu-item-75710"));
        insightsMenu.click();
    }
    @When("I click on WHITEPAPERS & EBOOKS")
    public void i_click_on(String linkText) {
        WebElement link = driver.findElement(By.linkText("White Papers &amp; eBooks"));
        link.click();
    }
    @Then("I should see the title WHITE PAPERS")
    public void i_should_see_the_title(String expectedTitle) {
        WebElement title = driver.findElement(By.tagName("(h2.elementor-heading-title.elementor-size-default"));
        assert title.getText().equals(expectedTitle);
    }
    @When("I fill in the First Name field with {string}")
    public void i_fill_in_the_first_name_field_with(String firstName) {
        WebElement firstNameField = driver.findElement(By.id("first-name"));
        firstNameField.sendKeys(firstName);
    }

    @When("I fill in the Last Name field with {string}")
    public void i_fill_in_the_last_name_field_with(String lastName) {
        WebElement lastNameField = driver.findElement(By.id("last-name"));
        lastNameField.sendKeys(lastName);
    }

    @When("I fill in the Company field with {string}")
    public void i_fill_in_the_company_field_with(String company) {
        WebElement companyField = driver.findElement(By.id("company"));
        companyField.sendKeys(company);
    }

    @When("I fill in the Industry field with {string}")
    public void i_fill_in_the_industry_field_with(String industry) {
        WebElement industryField = driver.findElement(By.id("industry"));
        industryField.sendKeys(industry);
    }

    @When("I click SUBSCRIBE")
    public void i_click_button(String buttonText) {
        WebElement button = driver.findElement(By.xpath("//button[text()='" + buttonText + "']"));
        button.click();
    }

    @Then("I take a screenshot of the error messages")
    public void i_take_a_screenshot_of_the_error_messages() throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(screenshot, new File("C:\\Users\\siphokazi.bitterhout\\Desktop\\Kurtosys Screenshots\screenshot.png"));
    }

    @Then("I should see error messages")
    public void i_should_see_error_messages() {
        List<WebElement> errorMessages = driver.findElements(By.className("error-message"));
        assert !errorMessages.isEmpty();
        for (WebElement errorMessage : errorMessages) {
            System.out.println(errorMessage.getText());
        }
        driver.quit();
    }
}






