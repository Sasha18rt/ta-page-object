package com.softserve.edu.teachua.pages.challenge;

import com.softserve.edu.teachua.pages.top.TopPart;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YoutubeFrame {

    private WebDriver driver;
    //
    private WebElement videoPlayerLink;
    private WebElement youtubeLink;
    private WebElement videoPlaybutton;


    public YoutubeFrame(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // Uncomment

        videoPlaybutton = driver.findElement(By.xpath("//button[contains(@class, 'large-play-button')]"));
        youtubeLink = driver.findElement(By.cssSelector("a[title='Watch on YouTube']"));
        videoPlayerLink = driver.findElement(By.xpath("//div[contains(@class,'html5-video-player')]"));

    }

    // Page Object

    public WebElement getVideoPlayerLink() {return videoPlayerLink;}
    public void clickVideoPlayerLink() {videoPlayerLink.click();}

    public WebElement getYoutubeLink() {return youtubeLink;}
    public String getYotubeLinkText() {return getYoutubeLink().getAttribute(TopPart.TAG_ATTRIBUTE_HREF);}


    public WebElement getVideoPlaybutton() {return videoPlaybutton;}
    public void clickLargePlayButton() {
        getVideoPlaybutton().sendKeys(Keys.ENTER);
    }


    public String getYoutubeLinkText() {

        return getYotubeLinkText();
    }

    // Functional

    // Business Logic

    public YoutubeFrame playVideoContent() {
        clickLargePlayButton();
        return this;
    }

    public ChallengeTeachPage gotoChallengeTeachPage() {
        driver.switchTo().defaultContent();
        return new ChallengeTeachPage(driver);
    }

}
