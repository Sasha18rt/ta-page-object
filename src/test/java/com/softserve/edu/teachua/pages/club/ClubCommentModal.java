package com.softserve.edu.teachua.pages.club;

import org.openqa.selenium.WebDriver;

public class ClubCommentModal {

    private WebDriver driver;

    // TODO

    public ClubCommentModal(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
    }

    // Page Object

    // Functional

    // Business Logic

    public ClubDetailsPage submitComment(String commentText) {
        // TODO
        return new ClubDetailsPage(driver);
    }
}
