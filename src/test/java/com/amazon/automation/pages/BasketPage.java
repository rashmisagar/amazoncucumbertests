package com.amazon.automation.pages;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasketPage{

    WebDriver driver;
    //Initialise objects in this page
    public BasketPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    Actions action;

    private static int notesCount;
    private static int remindersCount;
    private static int labelsCount;
    private WebDriverWait wait = new WebDriverWait(driver, 30);


    @FindBy(css = "#productTitle")
    WebElement productTitleLink;


    public String getBasketPageTitle() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("#productTitle")));
        return driver.getTitle();

    }

    public String getProductTitle(){
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#productTitle")));
        return productTitleLink.getText();
    }


}