package org.interview.task.okta.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class TrialPage extends BasePage {
    private static final By BY_FIRST_NAME_INPUT_FIELD = By.id("edit-first-name");
    private static final By BY_LAST_NAME_INPUT_FIELD = By.id("edit-last-name");
    private static final By BY_WORK_EMAIL_INPUT_FIELD = By.id("edit-email");
    private static final By BY_EDIT_PHONE_NUMBER_FIELD = By.id("edit-phone");
    private static final By BY_COUNTRY_DDL = By.id("edit-country-field-countryfield-country");
    private static final By BY_PROVINCE_DDL = By.id("edit-country-field-countryfield-province");
    private static final By BY_GET_STARTED_BUTTON = By.id("edit-submit-button");
    private static final By BY_CAPTHCA_ALERT = By.cssSelector("div[aria-label='Error message'] blockquote");

    TrialPage(WebDriver driver) {
        super(driver);
    }

    public TrialPage fillInSignUpFormGeneric(String firstName, String lastName, String workEmail, String phoneNumber, String country) {
        driver.findElement(BY_FIRST_NAME_INPUT_FIELD).sendKeys(firstName);
        driver.findElement(BY_LAST_NAME_INPUT_FIELD).sendKeys(lastName);
        driver.findElement(BY_WORK_EMAIL_INPUT_FIELD).sendKeys(workEmail);
        driver.findElement(BY_EDIT_PHONE_NUMBER_FIELD).sendKeys(phoneNumber);
        new Select(driver.findElement(BY_COUNTRY_DDL)).selectByVisibleText(country);

        return this;
    }

    public TrialPage signUpFromCanada(String firstName, String lastName, String workEmail, String phoneNumber, String country, String province) {
        fillInSignUpFormGeneric(firstName, lastName, workEmail, phoneNumber, country).
                selectProvince(province).
                agreeWithMarketingCommunication().
                passCaptcha().
                clickGetStartedButton();
        return this;
    }

    private TrialPage passCaptcha() {
        //TODO Implement captcha
        return this;
    }

    private InnerPage clickGetStartedButton() {
        driver.findElement(BY_GET_STARTED_BUTTON).click();
        return new InnerPage(driver);
    }

    private TrialPage agreeWithMarketingCommunication() {
        //TODO Implement checkbox manipulation and validation
        return this;
    }

    private TrialPage selectProvince(String province) {
        new Select(driver.findElement(BY_PROVINCE_DDL)).selectByVisibleText(province);
        return this;
    }

    public String readCaptchaAlertMessage() {
        return driver.findElement(BY_CAPTHCA_ALERT).getText();
    }

}
