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

public class ProductPage{

    WebDriver driver;


    //Initialise objects in this page
    public ProductPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    Actions action;

    private static int notesCount;
    private static int remindersCount;
    private static int labelsCount;
    private WebDriverWait wait = new WebDriverWait(driver, 30);


    @FindBy(css = "#productTitle")
    WebElement productTitleLink;

    @FindBy(id = "add-to-cart-button")
    WebElement addToBasketBtn;

    @FindBy(id = "confirm-text")
    WebElement addNotification;

    @FindBy(className = "nav-cart-icon nav-sprite")
    WebElement goToBasketBtn;

    public String getProductPageTitle() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#productTitle")));
        return driver.getTitle();

    }

    public boolean verifyProductLink() {
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#productTitle")));
        assertNotNull(productTitleLink);
        return productTitleLink.isDisplayed();
    }


    public boolean addToBasketVisible() {
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#productTitle")));
        assertNotNull(productTitleLink);
        return productTitleLink.isDisplayed();
    }
    public void addToBasket() throws InterruptedException {
        action = new Actions(driver);
        action.moveToElement(addToBasketBtn).click().perform();
    }

    public String getProductAddedToBasketConfirmationText() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("confirm-text")));
        assertNotNull(addNotification);
        return addNotification.getText();
    }

    public void goToBasket() throws InterruptedException {
        action = new Actions(driver);
        action.moveToElement(goToBasketBtn).click().perform();
    }


}