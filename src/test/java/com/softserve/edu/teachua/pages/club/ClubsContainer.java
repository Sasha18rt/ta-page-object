package com.softserve.edu.teachua.pages.club;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ClubsContainer {

    public final String CLUBS_NOT_FOUND = "There is no club that matches the search criteria.";
    private final String CLUBS_COMPONENT_CSSSELECTOR = "div.ant-card.ant-card-bordered";
    //
    protected WebDriver driver;
    //
    private List<ClubComponent> clubComponents;
    private WebElement previousPageLink;
    private WebElement nextPageLink;

    public ClubsContainer(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
        clubComponents = new ArrayList<>();
        for (WebElement current : driver.findElements(By.cssSelector(CLUBS_COMPONENT_CSSSELECTOR))) {
            clubComponents.add(new ClubComponent(driver, current));
        }
        if (clubComponents.size() == 0) {
            throw new RuntimeException(CLUBS_NOT_FOUND);
        }
        previousPageLink = driver.findElement(By.cssSelector("li[title='Previous Page'] > button"));
        nextPageLink = driver.findElement(By.cssSelector("li[title='Next Page'] > button"));
    }

    // Page Object

    // clubComponents
    public List<ClubComponent> getClubComponents() {
        return clubComponents;
    }

    // previousPageLink
    public WebElement getPreviousPageLink() {
        return previousPageLink;
    }

    public void clickPreviousPageLink() {
        getPreviousPageLink().click();
    }

    public boolean isEnablePreviousPageLink() {
        // TODO
        return true;
    }

    // nextPageLink
    public WebElement getNextPageLink() {
        return nextPageLink;
    }

    public void clickNextPageLink() {
        getNextPageLink().click();
    }

    public boolean isEnableNextPageLink() {
        // TODO
        return true;
    }

    // Functional

    public int getClubComponentsCount() {
        return getClubComponents().size();
    }

    public List<String> getClubComponentTitles() {
        List<String> productComponentNames = new ArrayList<>();
        for (ClubComponent current : getClubComponents()) {
            productComponentNames.add(current.getTitleLinkText());
        }
        return productComponentNames;
    }

    public ClubComponent getFirstClubComponent() {
        if (getClubComponentsCount() == 0) {
            // TODO Develop Custom Exception
            // Use String.format()
            throw new RuntimeException(CLUBS_NOT_FOUND);
        }
        return  getClubComponents().get(0);
    }

    public ClubComponent getClubComponentByTitle(String clubTitle) {
        ClubComponent result = null;
        for (ClubComponent current : getClubComponents()) {
            if (current.getTitleLinkText().toLowerCase()
                    .equals(clubTitle.toLowerCase())) {
                result = current;
                break;
            }
        }
        if (result == null) {
            // TODO Develop Custom Exception
            // Use String.format()
            throw new RuntimeException("ClubTitle: " + clubTitle + " not Found.");
        }
        return result;
    }

    public ClubComponent getClubComponentByPartialTitle(String partialTitle) {
        ClubComponent result = null;
        for (ClubComponent current : getClubComponents()) {
            if (current.getTitleLinkText().toLowerCase()
                    .contains(partialTitle.toLowerCase())) {
                result = current;
                break;
            }
        }
        if (result == null) {
            // TODO Develop Custom Exception
            // Use String.format()
            throw new RuntimeException("Club partialTitle: " + partialTitle + " not Found.");
        }
        return result;
    }

    public boolean isExistClubComponentByPartialTitle(String partialTitle) {
        boolean isFound = false;
        for (String current : getClubComponentTitles()) {
            if (current.toLowerCase().contains(partialTitle.toLowerCase())) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }

    public void clickPageLinkByNumber(int numberPage) {
       // TODO
    }

    // Business Logic

}

