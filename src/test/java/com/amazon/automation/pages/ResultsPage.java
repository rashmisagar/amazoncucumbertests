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

public class ResultsPage{

    WebDriver driver;

    //Initialise objects in this page
    public ResultsPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    Actions action;

    private static int searchCount;

    private WebDriverWait wait = new WebDriverWait(driver, 30);


    @FindBy(className = "s-access-title")
    WebElement firstItemTitleElement;

    @FindBy(css = "#result_0")
    WebElement firstItemTitleElement2;

    @FindBy(id = "s-result-count")
    WebElement actualCount;

    @FindBy(css = "#sort")
    WebElement sortDropDown;

    @FindBy(id = "noResultsTitle")
    WebElement noSearchResult;


    public String getResultsPageTitle() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sort")));
        return driver.getTitle();

    }

    public int getSearchResultCount() throws InterruptedException {
        Thread.sleep(2000);
        if(noSearchResult.isDisplayed())
            return 0;
        else{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("s-results-list-atf")));
            List<WebElement> searchResultsList = driver.findElements(By.id("s-results-list-atf"));
            searchCount = searchResultsList.size();
            return searchCount;
        }
    }

    public void getSearchResults() {
        List<WebElement> results = driver.findElements(By.cssSelector("#s-results-list-atf li"));
        Assert.assertTrue(!results.isEmpty());
        System.out.println("The size of the list: " + results.size());
        Assert.assertNotNull(results.size());
        for (int i = 0; i <= 5; i++) {
            WebElement ele = results.get(i);
            System.out.println(ele.getText());
        }

    }


    public boolean verifySortDropdownDisplayed() {
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#sort")));
        return sortDropDown.isDisplayed();
    }

    public void selectSortOption(String string) throws InterruptedException {
        String[] availableOptions={"Relevance","Price: Low to High", "Price: High to Low", "Avg. Customer Review", "Newest Arrivals"};
        assertTrue(ArrayUtils.contains(availableOptions, string));
        Thread.sleep(3000);
        Actions action = new Actions(driver);
        WebElement subElement = driver.findElement(By.linkText(string));
        action.moveToElement(subElement).click().perform();
    }

    public String getFirstSearchResultTitle(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("s-access-title")));
        return firstItemTitleElement.getText();
    }

    public String noSearchResults(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("noResultsTitle")));
        return noSearchResult.getText();
    }

    public void goToFirstProductResultDetails(){
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.className("s-access-title")));
        firstItemTitleElement.click();
    }

    protected boolean isTextPresent(String text){
        try{
            boolean b = driver.getPageSource().contains(text);
            return b;
        }
        catch(Exception e){
            return false;
        }
    }
}