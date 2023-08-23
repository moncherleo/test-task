package org.okta.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InnerPage extends BasePage {
    public InnerPage(WebDriver driver) {
        super(driver);
    }

    //TODO Add css selector
    private static final By BY_WELCOME_TEXT_ELEMENT = By.cssSelector("");

    public String getWelcomeText() {
        //TODO Implement welcome text validation
        return driver.findElement(BY_WELCOME_TEXT_ELEMENT).getText();
    }
}