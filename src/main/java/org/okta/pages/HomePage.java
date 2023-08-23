package org.okta.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    private final String TRIAL_PAGE_URL = "https://okta.com/free-trial/";
    private final By BY_SIGN_UP_BUTTON = By.cssSelector(".header_ctas a[href='" + TRIAL_PAGE_URL + "']");
    private final By BY_COOKIES_BANNER_CLOSE_BUTTON = By.xpath("//div[@id='onetrust-close-btn-container']//button[@aria-label='Close']");
    private final By BY_ACCEPT_ALL_COOKIES_BUTTON = By.xpath("//button[@id='onetrust-accept-btn-handler']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        driver.get(websiteURL);
        acceptAllCookies();
        return this;
    }

    HomePage acceptAllCookies() {

        // This is a very bad practice, however I used this as a quick workaround
        // TODO Fix this delay
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement acceptAllCookiesButton = wait.until(ExpectedConditions.visibilityOfElementLocated(BY_ACCEPT_ALL_COOKIES_BUTTON));
        acceptAllCookiesButton.click();
        return this;
    }

    public TrialPage openTrialPage() {
        driver.findElement(BY_SIGN_UP_BUTTON).click();
        return new TrialPage(driver);
    }
}
