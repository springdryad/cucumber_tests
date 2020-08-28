package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;

public class CreateIssueWindow {

  private By projectField = By.id("project-field");
  private By issueTypeField = By.id("issuetype-field");
  private By summaryField = By.id("summary");
  private By reporterField = By.id("reporter-field");
  private By summaryMode = By.xpath("//ul/li[@data-mode='source']");
  private By issueDescription = By.id("description");
  private By createIssueSubmit = By.id("create-issue-submit");

  public void enterProject(String text) {
    WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 10);
    wait.until(ExpectedConditions.visibilityOfElementLocated(projectField)).sendKeys(text, Keys.TAB);
  }

  public void enterIssueType(String text) {
    WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 10);
    wait.until(ExpectedConditions.elementToBeClickable(issueTypeField)).clear();
    WebDriverFactory.getDriver().findElement(issueTypeField).sendKeys(text, Keys.TAB);
  }

  public void enterSummary(String text) {
    WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 10);
    wait.until(ExpectedConditions.elementToBeClickable(summaryField)).sendKeys(text);
  }

  public void enterReporter(String text) {
    WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 10);
    wait.until(ExpectedConditions.elementToBeClickable(reporterField)).clear();
    WebDriverFactory.getDriver().findElement(reporterField).sendKeys(text);
  }

  public void enterDescription(String text) {
    WebDriverFactory.getDriver().findElement(summaryMode).click();
    WebDriverFactory.getDriver().findElement(issueDescription).sendKeys(text);
  }

  public void pressSubmitIssueButton() {
    WebDriverFactory.getDriver().findElement(createIssueSubmit).click();
  }
}
