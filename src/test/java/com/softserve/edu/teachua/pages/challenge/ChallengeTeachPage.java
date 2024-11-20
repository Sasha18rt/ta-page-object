package com.softserve.edu.teachua.pages.challenge;

import com.softserve.edu.teachua.data.UrlContents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChallengeTeachPage extends ChallengePage {

    private WebElement commentLabel;
    private WebElement webinarIframe;

    public ChallengeTeachPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        commentLabel = driver.findElement(By.xpath("//p[contains(text(), 'Вуйтік')]"));
        webinarIframe = driver.findElement(By.xpath("//iframe[contains(@src, '/JMAF_pSOBws')]"));
    }

    // Page Object

    public WebElement getCommentLabel() {return commentLabel;}
    public String getCommentLabelText() {return commentLabel.getText();}

    public WebElement findWebinarIframeBySrc(String src) {
        return driver.findElement(By.xpath("//iframe[contains(@src, '" + src + "')]"));
    }

    public WebElement getWebinarIframe() {return webinarIframe;}
    public void clickWebinarIframe() {webinarIframe.click();}


    // Functional

    // Business Logic

    public YoutubeFrame gotoYoutubeFrame() {
        // TODO Switch To iFrame
        driver.switchTo().frame(getWebinarIframe());
        return new YoutubeFrame(driver);
    }

    public YoutubeFrame gotoYoutubeFrameBySrc(UrlContents urlContents) {
        WebElement targetIframe = driver.findElement(By.xpath("//iframe[contains(@src, '" + urlContents.getSearchVideo() + "')]"));

        driver.switchTo().frame(targetIframe);
        return new YoutubeFrame(driver);
    }


}
