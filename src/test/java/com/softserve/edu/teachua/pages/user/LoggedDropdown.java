package com.softserve.edu.teachua.pages.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoggedDropdown {

    private WebDriver driver;
    //
    private WebElement addClubLink;
    private WebElement addCenterLink;
    private WebElement searchCertificatesLink;
    private WebElement personalProfileLink;
    private WebElement signOutLink;

    public LoggedDropdown(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    // TODO
    private void initElements() {
        addClubLink = driver.findElement(By.cssSelector("//TODO"));
        addCenterLink = driver.findElement(By.cssSelector("//TODO"));
        searchCertificatesLink = driver.findElement(By.cssSelector("//TODO"));
        personalProfileLink = driver.findElement(By.cssSelector("//TODO"));
        signOutLink = driver.findElement(By.cssSelector("//TODO"));
    }

    // Page Object

    // addClubLink;
    public WebElement getAddClubLink() {
        return addClubLink;
    }

    public String getAddClubLinkText() {
        return getAddClubLink().getText();
    }

    public void clickAddClubLink() {
        getAddClubLink().click();
    }

    // addCenterLink;
    public WebElement getAddCenterLink() {
        return addCenterLink;
    }

    public String getAddCenterLinkText() {
        return getAddCenterLink().getText();
    }

    public void clickAddCenterLink() {
        getAddCenterLink().click();
    }

    // searchCertificatesLink;
    public WebElement getSearchCertificatesLink() {
        return searchCertificatesLink;
    }

    public String getSearchCertificatesLinkText() {
        return getSearchCertificatesLink().getText();
    }

    public void clickSearchCertificatesLink() {
        getSearchCertificatesLink().click();
    }

    // personalProfileLink;
    public WebElement getPersonalProfileLink() {
        return personalProfileLink;
    }

    public String getPersonalProfileLinkText() {
        return getPersonalProfileLink().getText();
    }

    public void clickPersonalProfileLink() {
        getPersonalProfileLink().click();
    }

    // signOutLink;
    public WebElement getSignOutLink() {
        return signOutLink;
    }

    public String getSignOutLinkText() {
        return getSignOutLink().getText();
    }

    public void clickSignOutLink() {
        getSignOutLink().click();
    }

    // Functional

    // Business Logic

}
