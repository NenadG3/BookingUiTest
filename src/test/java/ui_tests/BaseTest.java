package ui_tests;

import static utils.WebDriverFactory.getChromeDriver;
import static utils.WebDriverFactory.setChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

public class BaseTest {

  public SoftAssert softAssert;

  @BeforeMethod
  public void setUp() {
    setChromeDriver();
    softAssert = new SoftAssert();
  }

  //  @AfterMethod
  public void tearDown() {
    if (getChromeDriver() != null) {
      getChromeDriver().quit();
    }
  }

  public HomePage openHomePage() {
    return new HomePage();
  }
}
