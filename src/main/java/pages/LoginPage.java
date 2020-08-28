package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;

public class LoginPage {

  private By userNameInput = By.id("login-form-username");
  private By passwordInput = By.id("login-form-password");
  private By loginButton = By.id("login");

  public void enterUserName(String username) {
    new WebDriverWait(WebDriverFactory.getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(userNameInput)).clear();
    WebDriverFactory.getDriver().findElement(userNameInput).sendKeys(username);
  }

  public void enterPassword(String password) {
    WebDriverFactory.getDriver().findElement(passwordInput).sendKeys(password);
  }

  public void clickLoginButton() {
    WebDriverFactory.getDriver().findElement(loginButton).click();
  }

  public boolean errorMessageIsPresent(String message) {
    new WebDriverWait(WebDriverFactory.getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), \"" + message + "\")]")));
    return WebDriverFactory.getDriver().findElement(By.xpath("//*[contains(text(), \"" + message + "\")]")).isDisplayed();
  }
}
