package ui_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import static data.Constants.*;
import static utils.WebDriverFactory.getChromeDriver;

public class LoginTests extends BaseTest {

    @Test(enabled = false)
    public void successfulloginTest() {
        getChromeDriver().get(URL);
        HomePage homePage = openHomePage();
        homePage.dismissModal();
        homePage.clickSignInButton();
        homePage.enterUsername(USERNAME);
        homePage.clickEmailButton();
        homePage.enterPassword(PASSWORD);
        homePage.clickSignInOnFormButton();
        //this is a try of automating Test flow 1, but booking.com probably have security mechanism which detects
        //automated behavior and doesn't allow test to procced, it displays press and hold button but even if
        //it is done manually when automated test stops it won't allow login
    }

    @Test(enabled = false)
    public void unsuccessfulLogin() {
        getChromeDriver().get(URL);
        HomePage homePage = openHomePage();
        homePage.dismissModal();
        homePage.clickSignInButton();
        homePage.enterUsername(USERNAME);
        homePage.clickEmailButton();
        homePage.enterPassword("WRONG_PASSWORD");
        homePage.clickSignInOnFormButton();
        Assert.assertTrue(homePage.isLoginErrorDisplayed());
        //here in first try I was able to assert error message but which each new run it would lead to issue stated in
        //comment above
    }
}
