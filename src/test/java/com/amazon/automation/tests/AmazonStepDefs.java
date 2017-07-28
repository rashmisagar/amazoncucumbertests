package com.amazon.automation.tests;

import com.amazon.automation.pages.BasketPage;
import com.amazon.automation.pages.HomePage;
import com.amazon.automation.pages.ProductPage;
import com.amazon.automation.pages.ResultsPage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class AmazonStepDefs{

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected HomePage homePage;
    protected ResultsPage resultsPage;
    protected ProductPage productPage;
    protected BasketPage basketPage;

    public static String browserType;
    public static String url="https://www.amazon.co.uk";
    public String homePageTitle="Amazon.co.uk: Low Prices in Electronics, Books, Sports Equipment & more";


    // Passing Browser parameter from TestNG xml
    @Before
    public void beforeTest() {

        //Default Firefox driver
        if (null == browserType || browserType.equalsIgnoreCase("firefox")) {
            System.out.println("*************** Firefox ***********");
            System.setProperty("webdriver.firefox.marionette","/Users/rashmisagarsen/IdeaProjects/jars_n_execs/geckodriver");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();


        } else if (browserType.equalsIgnoreCase("chrome")) {
            System.out.println("*************** Chrome ***********");
            System.setProperty("webdriver.chrome.driver", "/Users/rashmisagarsen/IdeaProjects/jars_n_execs/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        }

        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        homePage = PageFactory.initElements(driver, HomePage.class);
        resultsPage = PageFactory.initElements(driver, ResultsPage.class);
        productPage = PageFactory.initElements(driver, ProductPage.class);
        basketPage = PageFactory.initElements(driver, BasketPage.class);

    }


    @Given("^Amazon Homepage is open$")
    public void amazonHomepageIsOpen() throws Throwable {
        Assert.assertEquals(true, homePage.getPageURL().contains(url));
        Assert.assertEquals(true, homePage.getHomePageTitle().contains(homePageTitle));
    }

    @When("^I search for item \"([^\"]*)\"$")
    public void iSearchForItem(String item) throws Throwable {
        homePage.searchItem(item);
    }


    @Then("^I verify the price for first 5 results$")
    public void iSeeTheSearchResults() throws Throwable {
        resultsPage.getSearchResults();

    }

    @Given("^I see the search results page$")
    public void iAmOnTheResultsPage() throws Throwable {
        Assert.assertEquals(true, resultsPage.getResultsPageTitle().contains("iphone"));
    }

    @Given("^I see the sort dropdown in results page$")
    public void i_see_the_sort_dropdown() throws Throwable {
        resultsPage.verifySortDropdownDisplayed();
    }


    @When("^I select sort by Lowest Price$")
    public void i_select_sort_by_Lowest_Price() throws Throwable {
        resultsPage.selectSortOption("Price: Low to High");
    }

    @Then("^I see the results sorted by Lowest Price$")
    public void i_see_the_results_sorted_by_Lowest_Price() throws Throwable {
        resultsPage.getSearchResults();

    }

    @When("^I select the First item$")
    public void iSelectTheFirstItem() throws Throwable {
        resultsPage.getFirstSearchResultTitle();
    }

    @Then("^I am on the Product Details Page$")
    public void iAmOnTheProductDetailsPage() throws Throwable {
        Assert.assertEquals(true, productPage.getProductPageTitle().contains("Apple iphone"));

    }

    @When("^I click Add to Basket Link$")
    public void iClickAddToBasketLink() throws Throwable {
        productPage.addToBasket();
    }

    @Then("^I see the notification of the item added to the basket$")
    public void iSeeTheNotificationOfTheItemAddedToTheBasket() throws Throwable {
        Assert.assertTrue(productPage.getProductAddedToBasketConfirmationText().contains("Added to Basket"));
    }

    @When("^I click on the Basket button$")
    public void iClickOnTheBasketButton() throws Throwable {
        productPage.goToBasket();
    }

    @Then("^I go to Basket page$")
    public void iGoToBasketPage() throws Throwable {
        Assert.assertEquals(true, basketPage.getBasketPageTitle().contains("Shopping Basket"));
    }

    @Then("^I see the cheapest item added to the basket$")
    public void iSeeTheCheapestItemAddedToTheBasket() throws Throwable {
        basketPage.getProductTitle();
    }

    @After
    public void endTest(){

        driver.quit();
    }
}

