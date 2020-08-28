package stepdefinition;

import com.google.common.io.Files;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.HomePage;
import pages.LoginPage;
import utils.WebDriverFactory;
import java.io.File;
import java.io.IOException;

public class StepDefinitions {

  @Before
  public void beforeCucumberScenario(Scenario scenario) {
    WebDriverFactory.createInstance("Chrome");
  }

  @After
  public void afterCucumberScenario(Scenario scenario) {
    if (scenario.getStatus().toString().contains("FAILED")) {
      try {
        takeScreenshot();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    WebDriverFactory.getDriver().close();
  }

  public void takeScreenshot() throws IOException {
    File scrFile = ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
    File trgtFile = new File(System.getProperty("user.dir") + "//screenshots/screenshot.png");
    System.out.println("SAVING Screenshot to " + trgtFile.getAbsolutePath());
    trgtFile.getParentFile().mkdir();
    trgtFile.createNewFile();
    Files.copy(scrFile, trgtFile);
  }

  @Then("^I navigate to Jira Login Page$")
  public void navigateToLoginPage() {
    new HomePage().navigateToHomePage();
  }

  @Then("^I enter user name - \"(.*?)\"$")
  public void enterUserName(String userName) {
    new LoginPage().enterUserName(userName);
  }

  @Then("^I enter password - \"(.*?)\"$")
  public void enterPassword(String password) {
    new LoginPage().enterPassword(password);
  }

  @Then("^I click on the login button$")
  public void clickLoginButton() {
    new LoginPage().clickLoginButton();
  }

  @When("^I found user icon$")
  public void foundUserIcon() {
    assert new HomePage().findUserIcon();
  }

  @When("^I see error message - \"(.*?)\"$")
  public void errorMessage(String expectedResult) {
    assert new LoginPage().errorMessageIsPresent(expectedResult);
  }

  @When("^I debug$")
  public void debug() {
    int a = 0;
  }
}
