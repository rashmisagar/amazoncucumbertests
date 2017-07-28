package com.amazon.automation.pages;

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
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage{

    WebDriver driver;
    //Initialise objects in this page
    public HomePage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    Actions action;

    private static int notesCount;
    private static int remindersCount;
    private static int labelsCount;
    private WebDriverWait wait = new WebDriverWait(driver, 30);

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;

    @FindBy(id = "issDiv0")
    WebElement searchBtn;


    public String getPageURL() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("twotabsearchtextbox")));
        return driver.getCurrentUrl();
    }

    public String getHomePageTitle() {
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id='gbm:f']/a/span")));
        return driver.getTitle();

    }

    public void searchItem(String item) {
        assertNotNull(searchBox);
        searchBox.sendKeys(item);
        searchBox.sendKeys(Keys.ENTER);
    }

}