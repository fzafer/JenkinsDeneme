package cydeo;

import static org.junit.Assert.fail;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;


public class StepDefs {

    @Given("^I am on the home page$")
    public void i_am_on_the_home_page() throws Throwable {
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get("http://etsy.com");
/*
        String environment = System.getProperty("environment");
        if (environment != null) {
            switch (environment) {
                case "qa":
                    Driver.getDriver().get("http://qa1.vytrack.com");
                    break;
                case "dev":
                    Driver.getDriver().get("http://dev.vytrack.com");
                    break;
                case "stage":
                    Driver.getDriver().get("http://stage.vytrack.com");
                    break;
            }
        } else {
            String url = ConfigurationReader.getProperty("environment");
            Driver.getDriver().get(url);
        }
*/
    }

    @When("^I search for \"([^\"]*)\"$")
    public void i_search_for(String search) throws Throwable {
        Driver.getDriver().findElement(By.cssSelector("[id*='search-query']")).sendKeys(search + Keys.ENTER);
    }

    @Then("^I should see the results$")
    public void i_should_see_the_results() throws Throwable {
        Thread.sleep(2000);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("search"));
    }

    @Then("^I should see more results$")
    public void i_should_see_more_results() throws Throwable {
        Thread.sleep(2000);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("search"));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }
    @Given("user is on Google search page")
    public void user_is_on_google_search_page() {
        Driver.getDriver().get("https://www.google.com/");
    }
    @When("user types apple and clicks enter")
    public void user_types_apple_and_clicks_enter() {
        Driver.getDriver().findElement(By.id("q")).sendKeys("apple"  + Keys.ENTER);
    }
    @Then("user sees apple in the google title")
    public void user_sees_apple_in_the_google_title() {
        Assert.assertEquals(Driver.getDriver().getTitle(), "apple - Google'da Ara");
    }
}
