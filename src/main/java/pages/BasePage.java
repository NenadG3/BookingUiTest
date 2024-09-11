package pages;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;

public class BasePage {

  private static final long EXPLICIT_WAIT = 5;
  private final WebDriver driver;
  private final WebDriverWait wait;
  private final JavascriptExecutor js;

  BasePage() {
    this.driver = WebDriverFactory.getChromeDriver();
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
    js = (JavascriptExecutor) driver;
  }

  void click(WebElement element) {
    waitForElementDisplayed(element);
    element.click();
  }

  void enterText(WebElement element, String text) {
    waitForElementDisplayed(element);
    element.clear();
    element.sendKeys(text);
  }

  WebDriverWait waitFor() {
    return wait;
  }

  JavascriptExecutor useJs() {
    return js;
  }

  /**
   * Waiters
   */

  private void waitForElementDisplayed(WebElement element) {
    wait.until(ExpectedConditions.elementToBeClickable(element));
  }

}
