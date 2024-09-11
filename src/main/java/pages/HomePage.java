package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static utils.WebDriverFactory.getChromeDriver;

public class HomePage extends BasePage {

    private static final String DATA_DATE = "//span[@data-date";
    private final By ageDropdown = By.name("age");

    @FindBy(css = "[aria-label='Dismiss sign-in info.']")
    private WebElement closeModalBtn;

    @FindBy(css = "[data-testid='header-sign-in-button']")
    private WebElement signInBtn;

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(css = "form button")
    private WebElement emailButton;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = "form button[type='submit']")
    private WebElement signInOnFormButton;

    @FindBy(id = "password-note")
    private WebElement loginError;

    @FindBy(id = ":rh:")
    private WebElement whereTo;

    @FindBy(css = "[data-testid='date-display-field-start']")
    private WebElement datePicker;

    @FindBy(css = "[data-testid='searchbox-form-button-icon']")
    private WebElement numsPicker;

    @FindBy(css = "[id='group_children']~div>[class*='f4d78af12a']")
    private WebElement addChildBtn;

    @FindBy(css = "[type='submit']")
    private WebElement searchBtn;

    public void dismissModal() {
        try {
            click(closeModalBtn);
        } catch (WebDriverException e) {
            System.out.println(e.getMessage());
        }
    }

    public void clickSignInButton() {
        click(signInBtn);
    }

    public void enterUsername(String username) {
        enterText(usernameField, username);
    }

    public void clickEmailButton() {
        click(emailButton);
    }

    public void enterPassword(String password) {
        enterText(passwordField, password);
    }

    public void clickSignInOnFormButton() {
        click(signInOnFormButton);
    }

    public boolean isLoginErrorDisplayed() {
        return waitFor().until(ExpectedConditions.visibilityOf(loginError)).isDisplayed();
    }

    public void enterDestination(String destination) {
        enterText(whereTo, destination);
    }

    public void selectDates(int year, int monthIn, int monthOut, int dayIn, int dayOut) {
        click(datePicker);
        selectDate(LocalDate.of(year, monthIn, dayIn));
        selectDate(LocalDate.of(year, monthOut, dayOut));
    }

    public void addChild(String age) {
        click(numsPicker);
        click(addChildBtn);
        new Select(getChromeDriver().findElement(ageDropdown)).selectByVisibleText(age);
    }

    public SearchPage submit() {
        click(searchBtn);
        return new SearchPage();
    }

    private void selectDate(LocalDate date) {
        getChromeDriver().findElement(By.xpath(String.format(DATA_DATE + "='%s']",
                DateTimeFormatter.ISO_LOCAL_DATE.format(date)))).click();
    }
}
