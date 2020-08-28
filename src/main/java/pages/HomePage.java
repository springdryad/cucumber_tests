package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;

public class HomePage {

  private By createIssueButton = By.id("create_link");
  private By tempWindowIssueCreated = By.xpath("//*[contains(@class,'aui-will-close')]");
  private By createIssueDialog = By.id("create-issue-dialog");
  private By userIcon = By.id("header-details-user-fullname");
  private By browseLink = By.id("browse_link");


  public void navigateToHomePage() {
    WebDriverFactory.getDriver().get("https://jira.hillel.it/secure/Dashboard.jspa");
  }

  public void clickCreateIssue() {
    WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
    wait.until(ExpectedConditions.elementToBeClickable(browseLink));
    wait.until(ExpectedConditions.elementToBeClickable(createIssueButton)).click();

  }

  public boolean isIssueCreated(String text) {
    WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 3);
    return wait.until(ExpectedConditions.visibilityOfElementLocated(tempWindowIssueCreated)).isDisplayed()
        && WebDriverFactory.getDriver().findElement(tempWindowIssueCreated).getText().contains(text);
  }

  public boolean findUserIcon() {
    WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 10);
    return wait.until(ExpectedConditions.visibilityOfElementLocated(userIcon)).isDisplayed();
  }
}