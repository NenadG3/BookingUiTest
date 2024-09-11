package ui_tests;

import static data.Constants.URL;
import static org.testng.Assert.assertTrue;
import static utils.WebDriverFactory.getChromeDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;

public class SearchTests extends BaseTest {

  private final String destination = "Paris";
  private final String age = "8 years old";
  private final int initialNumberOfProperties = 25;

  @Test
  public void searchProperty() {
    getChromeDriver().get(URL);
    HomePage homePage = openHomePage();
    homePage.dismissModal();
    homePage.enterDestination(destination);
    homePage.selectDates(2024, 10, 10, 24, 30);
    homePage.addChild(age);
    SearchPage searchPage = homePage.submit();
    assertTrue(searchPage.getResultDestination().contains(destination));
  }

  @Test
  public void searchPagination() {
    getChromeDriver().get(URL);
    HomePage homePage = openHomePage();
    homePage.dismissModal();
    homePage.enterDestination(destination);
    homePage.selectDates(2024, 10, 10, 24, 30);
    homePage.addChild(age);
    SearchPage searchPage = homePage.submit();
    int initialNumOfProperties = searchPage.getNumberOfProperties();
    softAssert.assertEquals(initialNumOfProperties, initialNumberOfProperties);
    searchPage.scrollPage();
    searchPage.waitUntilPropertiesLoaded();
    int numberAfterScrolling = searchPage.getNumberOfProperties();
    softAssert.assertTrue(numberAfterScrolling > initialNumberOfProperties);
    softAssert.assertAll();
  }
}
