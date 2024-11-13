package com.softserve.edu.teachua.pages.club;

import com.softserve.edu.teachua.pages.top.TopSearchPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdvancedClubPage extends ClubPage {

    private WebElement useButton;

    public AdvancedClubPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        useButton = driver.findElement(By.cssSelector("div.use-clear-button button.use-button"));
    }

    // Page Object

    // useButton
    public WebElement getUseButton() {
        return useButton;
    }

    public String getUseButtonText() {
        return getUseButton().getText();
    }

    public void clickUseButton() {
        getUseButton().click();
    }

    // Functional

    // Business Logic

    @Override
    public AdvancedClubPage nextClubPagination() {
        // TODO
        return new AdvancedClubPage(driver);
    }
}
