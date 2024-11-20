package com.softserve.edu.teachua.pages.club;

import com.softserve.edu.teachua.pages.top.TopPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ClubsContainer {

    public final String CLUBS_NOT_FOUND = "There is no club that matches the search criteria.";
    private final String CLUBS_COMPONENT_CSSSELECTOR = "div.ant-card.ant-card-bordered";
    private static final String PAGINATION_NUMBERS = "ul.ant-pagination li.ant-pagination-item.ant-pagination-item-%d";

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

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

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

        return !getPreviousPageLink()
                .getAttribute(TopPart.TAG_ATTRIBUTE_VALUE)
                .contains("pagination-disabled");
    }

    public boolean isEnableNextPageLink() {

        return !getNextPageLink()
                .getAttribute(TopPart.TAG_ATTRIBUTE_VALUE)
                .contains("pagination-disabled");
    }

    // nextPageLink
    public WebElement getNextPageLink() {
        return nextPageLink;
    }

    public void clickNextPageLink() {
        getNextPageLink().click();
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
       WebElement pagelink = null;
       List<WebElement>  paginationNumbers = driver.findElements
               (By.cssSelector(String.format(PAGINATION_NUMBERS, numberPage)));
       if (paginationNumbers.size() > 0) {
           paginationNumbers.get(0).click();
       }
       throw new RuntimeException("Pagination number: " + numberPage + " not Found.");
    }

    // Business Logic

}

