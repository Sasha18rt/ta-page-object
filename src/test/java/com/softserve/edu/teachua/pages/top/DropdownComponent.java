package com.softserve.edu.teachua.pages.top;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownComponent {

    protected final String OPTIONNAME_NOT_FOUND = "OptionName not Found.";
    protected WebDriver driver;
    private List<WebElement> listOptions;

    public DropdownComponent(WebDriver driver, By searchLocator) {
        this.driver = driver;
        initElements(searchLocator);
    }

    private void initElements(By searchLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchLocator));
        listOptions = driver.findElements(searchLocator);
        if (listOptions.isEmpty()) {
            throw new RuntimeException("Dropdown is empty or elements are not loaded. Locator: " + searchLocator);
        }
        System.out.println("Dropdown options found: " + listOptions.size());
    }

    public List<WebElement> getListOptions() {
        return listOptions;
    }

    public WebElement getDropdownOptionByPartialName(String optionName) {
        WebElement result = null;
        for (WebElement current : getListOptions()) {
            if (current.getText().toLowerCase().contains(optionName.toLowerCase())) {
                result = current;
                break;
            }
        }
        if (result == null) {
            throw new RuntimeException(
                    String.format("Option '%s' not found in dropdown. Available options: %s", optionName, getListOptionsText())
            );
        }
        return result;
    }

    public List<String> getListOptionsText() {
        List<String> result = new ArrayList<>();
        for (WebElement current : getListOptions()) {
            result.add(current.getText());
        }
        return result;
    }

    public boolean isExistDropdownOptionByPartialName(String optionName) {
        for (String current : getListOptionsText()) {
            if (current.toLowerCase().contains(optionName.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public void clickDropdownOptionByPartialName(String optionName) {
        WebElement option = getDropdownOptionByPartialName(optionName);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(option));
        option.click();
    }
}
