package com.softserve.edu.teachua.pages.club;

import com.softserve.edu.teachua.pages.top.TopPart;
import org.openqa.selenium.WebDriver;

public class ClubDetailsPage extends TopPart {

    // TODO
    private CommentsContainer commentsContainer;

    public ClubDetailsPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        commentsContainer = new CommentsContainer(driver);
    }

    // Page Object

    // commentContainer
    public CommentsContainer getCommentContainer() {
        return commentsContainer;
    }

    // Functional

    // Business Logic

    public ClubCommentModal openClubCommentModal() {
        // TODO
        return new ClubCommentModal(driver);
    }

    public ClubDetailsPage chooseShowMoreComments(int numberPage) {
        getCommentContainer().clickShowMoreButton();
        return new ClubDetailsPage(driver);
    }

}
