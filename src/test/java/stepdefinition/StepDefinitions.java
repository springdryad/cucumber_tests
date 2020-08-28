package stepdefinition;

import com.google.common.io.Files;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.CreateIssueWindow;
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

  // Login tests
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

  //Create Issue test
  @Then("^I click Create Issue button$")
  public void clickCreateIssueButton() {
    new HomePage().clickCreateIssue();
  }

  @Then("^I enter Project - \"(.*?)\"$")
  public void enterProject(String text) {
    new CreateIssueWindow().enterProject(text);
  }

  @Then("^I enter Issue Type - \"(.*?)\"$")
  public void enterIssueType(String text) {
    new CreateIssueWindow().enterIssueType(text);
  }

  @Then("^I enter Summary - \"(.*?)\"$")
  public void enterSummary(String text) {
    new CreateIssueWindow().enterSummary(text);
  }

  @Then("^I enter Reporter - \"(.*?)\"$")
  public void enterReporter(String text) {
    new CreateIssueWindow().enterReporter(text);
  }

  @Then("^I enter Description - \"(.*?)\"$")
  public void enterDescription(String text) {
    new CreateIssueWindow().enterDescription(text);
  }

  @Then("^I click to submit issue$")
  public void clickSubmitIssue() {
    new CreateIssueWindow().pressSubmitIssueButton();
  }

  @When("^I see issue created pop up - \"(.*?)\"$")
  public void isIssueCreated(String expectedResult) {
    assert new HomePage().isIssueCreated(expectedResult);
  }

  @When("^I debug$")
  public void debug() {
    int a = 0;
  }
}
