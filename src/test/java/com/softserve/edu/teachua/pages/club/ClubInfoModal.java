package com.softserve.edu.teachua.pages.club;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClubInfoModal {

    private WebDriver driver;

    private WebElement clubName;
    private WebElement moreAboutClubButton;
    private WebElement closeButton;
    private WebElement clubDescription;
    public ClubInfoModal(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        clubName = driver.findElement(By.xpath("//div[@class='club-name']"));
        closeButton = driver.findElement(By.xpath("//button[@aria-label='Close']"));
        clubDescription = driver.findElement(By.xpath("//div[@class='description']"));
        moreAboutClubButton =  driver.findElement(By.xpath("//button[contains(@class, 'more-button')]"));
    }

    // Page Object
    public String getClubName() {return clubName.getText();}

    public void clickMoreAboutClubButton() {moreAboutClubButton.click();}
    public WebElement getMoreAboutClubButton() {return moreAboutClubButton;}

    public String getClubDescriptionText() {return clubDescription.getText();}
    public WebElement getClubDesription() {return clubDescription;}

    public void clickCloseButton() {closeButton.click();}
    // Functional

    // Business Logic

    public ClubPage closeClubInfoModal() {
        clickCloseButton();
        return new ClubPage(driver);
    }

    // moreAboutClub
    public ClubDetailsPage gotoClubDetailsPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(getMoreAboutClubButton()));
        clickMoreAboutClubButton();
        return new ClubDetailsPage(driver);
    }

}
