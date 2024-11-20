package com.softserve.edu.teachua.pages.club;

import com.softserve.edu.teachua.pages.top.TopPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClubDetailsPage extends TopPart {


    private WebElement createCommentButton;
    private WebElement nameField;

    // TODO
    private CommentsContainer commentsContainer;

    public ClubDetailsPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {

        nameField = driver.findElement(By.xpath("//span[@class='club-name']"));
        createCommentButton = driver.findElement(By.xpath("//button[contains(@class, 'comment-button')]"));
        commentsContainer = new CommentsContainer(driver);
    }

    // Page Object
    public String getClubName() {return nameField.getText();}
    public void clickCreateCommentButton() {createCommentButton.click();}
    // commentContainer
    public CommentsContainer getCommentContainer() {
        return commentsContainer;
    }

    // Functional

    // Business Logic

    public ClubCommentModal openClubCommentModal() {
        clickCreateCommentButton();
        return new ClubCommentModal(driver);
    }

    public ClubDetailsPage chooseShowMoreComments(int numberPage) {
        getCommentContainer().clickShowMoreButton();
        return new ClubDetailsPage(driver);
    }

}
