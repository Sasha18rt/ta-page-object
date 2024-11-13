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

    // Business Logic

    public ClubPage chooseCity(Cities city) {
        // TODO
        return new ClubPage(driver);
    }

    public ClubPage previousClubPagination() {
        if (!getClubContainer().isEnablePreviousPageLink()) {
            // throw new RuntimeException("The previous page is not available");
            return this;
        }
        getClubContainer().clickPreviousPageLink();
        return new ClubPage(driver);
    }

    public ClubPage nextClubPagination() {
        if (!getClubContainer().isEnableNextPageLink()) {
            // throw new RuntimeException("The next page is not available");
            return this;
        }
        getClubContainer().clickNextPageLink();
        return new ClubPage(driver);
    }

    public ClubPage chooseClubPaginationNumber(int numberPage) {
        getClubContainer().clickPageLinkByNumber(numberPage);
        return new ClubPage(driver);
    }

}
