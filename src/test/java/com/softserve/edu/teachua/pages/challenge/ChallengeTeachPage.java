package com.softserve.edu.teachua.pages.challenge;

import com.softserve.edu.teachua.pages.top.TopSearchPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChallengeTeachPage extends ChallengePage {

    private WebElement commentLabel;
    private WebElement webinalIframe;

    public ChallengeTeachPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        commentLabel = driver.findElement(By.xpath("//p[contains(text(), 'Вуйтік')]"));
        webinalIframe = driver.findElement(By.xpath("//iframe[contains(@src, '/JMAF_pSOBws')]"));
    }

    // Page Object

    // TODO

    // Functional

    // Business Logic

    public YoutubeFrame gotoYoutubeFrame() {
        // TODO Switch To iFrame
        return new YoutubeFrame(driver);
    }
}
