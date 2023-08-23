package org.interview.task.okta.pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver driver;
    protected String websiteURL = "https://www.okta.com/";


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
