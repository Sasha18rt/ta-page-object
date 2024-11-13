package com.softserve.edu.teachua.pages.club;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CommentsContainer {

    public final String COMMENT_NOT_FOUND = "There is no comments that matches the search criteria.";
    private final String COMMENT_COMPONENT_CSSSELECTOR = "li div.ant-comment";
    //
    protected WebDriver driver;
    //
    private List<CommentComponent> commentComponents;
    private WebElement showMoreButton;

    public CommentsContainer(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
        commentComponents = new ArrayList<>();
        for (WebElement current : driver.findElements(By.cssSelector(COMMENT_COMPONENT_CSSSELECTOR))) {
            commentComponents.add(new CommentComponent(driver, current));
        }
        showMoreButton = driver.findElement(By.cssSelector("button.show-more-button"));
    }

    // Page Object

    // showMoreButton

    public void clickShowMoreButton() {
        // TODO
    }

    // Functional

    // Business Logic

}
