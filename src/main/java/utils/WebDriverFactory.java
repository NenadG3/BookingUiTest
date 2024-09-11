package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {

  private static WebDriver driver;

  public static void setChromeDriver() {
    ChromeOptions opt = new ChromeOptions();
    opt.addArguments("start-maximized");
    driver = new ChromeDriver(opt);
  }

  public static WebDriver getChromeDriver() {
    return driver;
  }
}
