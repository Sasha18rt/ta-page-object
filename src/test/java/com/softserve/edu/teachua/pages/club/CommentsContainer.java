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

    public List<CommentComponent> getCommentComponents() {
        return commentComponents;
    }
    public int getCommentComponentsCount() {return getCommentComponents().size();}

    public List<String> getClubCommentAuthors(){
        List<String> clubCommentAuthors = new ArrayList<>();
        for (CommentComponent current : commentComponents) {
            clubCommentAuthors.add(current.getAuthorLabelText());
        }
        return clubCommentAuthors;
    }

    public List<String> getClubCommentComments(){
        List<String> clubCommentComments = new ArrayList<>();
        for (CommentComponent current : commentComponents) {
            clubCommentComments.add(current.getCommentLabelText());

        }
        return clubCommentComments;
    }

    public WebElement getShowMoreButton() {
        return showMoreButton;
    }
    // showMoreButton

    public void clickShowMoreButton() {
        getShowMoreButton().click();
    }

    // Functional

    public CommentComponent getCommentByPartialAuthor(String partialAuthor) {
        for (CommentComponent current : getCommentComponents()) {
            if (current.getAuthorLabelText().toLowerCase().contains(partialAuthor.toLowerCase())) {
                return current;
            }
        }
        throw new RuntimeException("Comment with author containing '" + partialAuthor + "' not found.");
    }
    public CommentComponent getClubComponentByPartialDate(String partialDate) {
        CommentComponent result = null;
        for (CommentComponent current : getCommentComponents()) {
            if (current.getDatetimeLabelText().toLowerCase().contains(partialDate.toLowerCase())) {
                result = current;
                break;
            }
        }
        if (result == null) {
            throw new RuntimeException("Comment partialDate: " + partialDate + " not Found.");
        }
        return result;
    }

    public boolean isExistClubComponentByPartialAuthor(String partialAuthor) {
        boolean isFound = false;
        for (String current : getClubCommentAuthors()) {
            if (current.toLowerCase().contains(partialAuthor.toLowerCase())) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }


    // Business Logic

}
