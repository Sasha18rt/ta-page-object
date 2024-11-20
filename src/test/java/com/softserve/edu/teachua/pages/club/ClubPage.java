package com.softserve.edu.teachua.pages.club;

import com.softserve.edu.teachua.data.Cities;
import com.softserve.edu.teachua.pages.top.TopSearchPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ClubPage extends TopSearchPart {

    private ClubsContainer clubsContainer;

    public ClubPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        clubsContainer = new ClubsContainer(driver);
    }

    // Page Object

    // clubsContainer
    public ClubsContainer getClubContainer() {
        return clubsContainer;
    }

    // Functional
    public boolean isExistClubByPartialName(String partialName) {
        boolean isExist = getClubContainer().isExistClubComponentByPartialTitle(partialName);
        return isExist;


    }
    public void clickPreviousClubPagination(){
        if (!getClubContainer().isEnablePreviousPageLink()) {
            throw new RuntimeException("The previous page is not available");
        }
        getClubContainer().clickPreviousPageLink();

    }

    public void clickNextClubPagination(){
        if (!getClubContainer().isEnableNextPageLink()) {
            throw new RuntimeException("The next page is not available");

        }
        getClubContainer().clickNextPageLink();
    }
    // Business Logic




    public ClubPage previousClubPagination() {
        clickPreviousClubPagination();
        return new ClubPage(driver);
    }

    public ClubPage nextClubPagination() {
        clickNextClubPagination();
        return new ClubPage(driver);
    }

    public ClubPage chooseClubPaginationNumber(int numberPage) {
        getClubContainer().clickPageLinkByNumber(numberPage);
        return new ClubPage(driver);
    }

}
