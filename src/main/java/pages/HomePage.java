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

  public void navigateToHomePage() {
    WebDriverFactory.getDriver().get("https://jira.hillel.it/secure/Dashboard.jspa");
  }

  public void clickCreateIssue() {
    clickOnElementWithRetry(createIssueButton, createIssueDialog, 3, 3);
  }

  private void clickOnElementWithRetry(By elementToBeClicked, By successCriteriaElement, int attempts, int timeOutInSeconds) {
    WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), timeOutInSeconds);
    for (int i = 0; i < attempts; i++) {
      try {
        wait.until(ExpectedConditions.elementToBeClickable(elementToBeClicked));
        WebDriverFactory.getDriver().findElement(elementToBeClicked).click();
        break;
      } catch (TimeoutException e) {
      }
    }
    wait.until(ExpectedConditions.visibilityOfElementLocated(successCriteriaElement)).isDisplayed();
  }

  public boolean isCreateIssueButtonPresent() {
    WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
    return wait.until(ExpectedConditions.elementToBeClickable(createIssueButton)).isDisplayed();
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