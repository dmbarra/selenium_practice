package com.sicredi.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MainPage {

    @FindBy(id = "switch-version-select")
    private WebElement switchVersion;

    @FindBy(css = "#gcrud-search-form > div.header-tools > div.floatL.t5 > a" )
    private WebElement btnAddNewCustomer;

    public void selectVersion(String value) {
        Select select= new Select(switchVersion);
        select.selectByValue(value);
    }

    public void addNewCustomer(){
        btnAddNewCustomer.click();
    }
}
