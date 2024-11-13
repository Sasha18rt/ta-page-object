package com.softserve.edu.teachua.pages.club;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommentComponent {

    protected WebDriver driver;
    private WebElement clubCard;
    //
    private WebElement authorLabel;
    private WebElement datetimeLabel;
    private WebElement commentLabel;

    public CommentComponent(WebDriver driver, WebElement clubCard) {
        this.driver = driver;
        this.clubCard = clubCard;
        initElements();
    }

    private void initElements() {
        // TODO init elements
    }

    // Page Object

    // Functional

    // Business Logic

}
