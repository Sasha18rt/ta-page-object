package com.softserve.edu.teachua.pages.challenge;

import com.softserve.edu.teachua.pages.top.TopPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YoutubeFrame {

    private WebDriver driver;
    //
    private WebElement videoPlayerLink;
    private WebElement youtubeLink;
    // TODO

    public YoutubeFrame(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // Uncomment
        //videoPlayerLink = driver.findElement(By.cssSelector("div.html5-video-player"));
        //youtubeLink = driver.findElement(By.cssSelector("a[title='Watch on YouTube']"));
        // TODO
    }

    // Page Object

    // TODO

    public String getYoutubeLinkText() {
        // TODO
        return null;
    }

    // Functional

    // Business Logic

    public ChallengeTeachPage gotoChallengeTeachPage() {
        // TODO Return to ChallengeTeachPage
        return new ChallengeTeachPage(driver);
    }

}
