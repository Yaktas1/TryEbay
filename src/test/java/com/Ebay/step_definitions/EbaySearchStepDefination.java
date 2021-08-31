package com.Ebay.step_definitions;


import com.Ebay.pages.EbaySearchPage;
import com.Ebay.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EbaySearchStepDefination {
    EbaySearchPage ebaysearch = new EbaySearchPage();

    Driver driver;
    List<WebElement> allLinks;
    String lastItem;


    @Given("User is on the Ebay home page")
    public void user_is_on_the_Ebay_home_page() {
        driver.getDriver().get(" https://www.sandbox.ebay.com/");
    }


    @When("User searches {string} in the ebay search page")
    public void user_searches_in_the_ebay_search_page(String Toys) throws InterruptedException {
        ebaysearch.searchBox.sendKeys(Toys + Keys.ENTER);
        Thread.sleep(3000);
        ebaysearch.expandNumberofSearch.click();
        Thread.sleep(2000);
        ebaysearch.Search200.click();


        allLinks = driver.getDriver().findElements(By.xpath("//div[@id='srp-river-results']/ul/li"));
        System.out.println(allLinks.size());
        Thread.sleep(2000);

        System.out.println("Item 1 is " + allLinks.get(0).getText() + " This End of Item");

        for (WebElement link : allLinks) {

            String eachlink = link.getText();
            System.out.println(link.getText());


        }

    }

    @Then("User should see {string} in the ebay title")
    public void user_should_see_in_the_ebay_title(String expectedInTitle) {
        String actualTitle = driver.getDriver().getTitle();
        System.out.println("ActualTitle is   " + actualTitle);

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
        System.out.println("true");
    }

    @Then("User should be able to see the last item")
    public void userShouldBeAbleToSeeTheLastItem() {
        int lastItemNumbwer = allLinks.size() - 1;
        lastItem = allLinks.get(lastItemNumbwer).getText();
        System.out.println("Last item is " + lastItem);

    }

    @Then("User should be able to save data")
    public void userShouldBeAbleToSaveData() throws IOException {


        allLinks = driver.getDriver().findElements(By.xpath("//div[@id='srp-river-results']/ul/li"));

        StringBuilder csvoutput = new StringBuilder();
        for (WebElement link : allLinks) {
            String output = link.getText();
            csvoutput.append(output + "," + "\n");

            //   System.out.println(csvoutput);

            File filedata = new File("src/csvfile.csv");
            try (
                    BufferedWriter writer = new BufferedWriter(new FileWriter(filedata))) {
                    writer.write(String.valueOf(csvoutput));
                    writer.flush();

            } catch (IOException e) {
            }

        }
        System.out.println("Succes");


        boolean ammount = lastItem.contains(String.valueOf(10));
        System.out.println(ammount);

    }
}
