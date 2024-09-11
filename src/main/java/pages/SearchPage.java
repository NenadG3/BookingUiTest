package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.WebDriverFactory.getChromeDriver;

public class SearchPage extends BasePage {

    private static final int INITIAL_NUMBER_OF_PROPERTIES = 25;

    private final By propertyCard = By.cssSelector("div[data-testid=\"property-card\"]");
    private final By destinationName = By.cssSelector("h1[aria-live=\"assertive\"]");

    public String getResultDestination() {
        return waitFor().until(ExpectedConditions.visibilityOfElementLocated(
                destinationName)).getText();
    }

    public int getNumberOfProperties() {
        return getChromeDriver().findElements(propertyCard).size();
    }

    public void waitUntilPropertiesLoaded() {
        waitFor().until(d -> getNumberOfProperties() > INITIAL_NUMBER_OF_PROPERTIES);
    }

    public void scrollPage() {
        useJs().executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
