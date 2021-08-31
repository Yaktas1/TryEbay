package com.Ebay.pages;


import com.Ebay.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbaySearchPage {

    public EbaySearchPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath= "//div[@id='gh-ac-box']//input[@class='gh-tb ui-autocomplete-input']")
    public WebElement searchBox;


    @FindBy(xpath= "//button[@class='fake-menu-button__button expand-btn expand-btn--small']")
    public WebElement expandNumberofSearch;

    @FindBy(xpath= "//a[@href='https://www.sandbox.ebay.com/sch/i.html?_from=R40&_nkw=car&_sacat=0&_ipg=200']")
    public WebElement Search200;

}
