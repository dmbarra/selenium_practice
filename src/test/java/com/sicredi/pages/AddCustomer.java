package com.sicredi.pages;

import com.sicredi.hooks.CustomerData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCustomer {

    private WebDriver driver;

    @FindBy(id = "field-customerName")
    private WebElement fieldCustomerName;

    @FindBy(id = "field-contactLastName")
    private WebElement fieldContactLastName;

    @FindBy(id = "field-contactFirstName")
    private WebElement fieldContactFirstName;

    @FindBy(id = "field-phone")
    private WebElement fieldPhone;

    @FindBy(id = "field-addressLine1")
    private WebElement fieldAddressLine1;

    @FindBy(id = "field-addressLine2")
    private WebElement fieldAddressLine2;

    @FindBy(id = "field-city")
    private WebElement fieldCity;

    @FindBy(id = "field-state")
    private WebElement fieldState;

    @FindBy(id = "field-postalCode")
    private WebElement fieldPostalCode;

    @FindBy(id = "field-country")
    private WebElement fieldCountry;

    @FindBy(id = "field_salesRepEmployeeNumber_chosen")
    private WebElement fieldSalesRepEmployeeNumber;

    @FindBy(id = "field-creditLimit")
    private WebElement fieldCreditLimit;

    @FindBy(id = "form-button-save")
    private WebElement buttonSave;

    @FindBy(id = "report-success")
    private WebElement reportSuccess;

    private By locatorOfInputField = By.cssSelector("input[type='text']");

    public AddCustomer(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,  this);
    }

    public void fillFormNewCustomer(){
        fieldCustomerName.sendKeys(CustomerData.NAME);
        fieldContactLastName.sendKeys(CustomerData.LAST_NAME);
        fieldContactFirstName.sendKeys(CustomerData.CONTACT_FIRST_NAME);
        fieldPhone.sendKeys(CustomerData.PHONE);
        fieldAddressLine1.sendKeys(CustomerData.ADDRESS_LINE_1);
        fieldAddressLine2.sendKeys(CustomerData.ADDRESS_LINE_2);
        fieldCity.sendKeys(CustomerData.CITY);
        fieldState.sendKeys(CustomerData.STATE);
        fieldPostalCode.sendKeys(CustomerData.POSTAL_CODE);
        fieldCountry.sendKeys(CustomerData.COUNTRY);
        selectFromEmployeer(CustomerData.FROM_EMPLOYEER);
        fieldCreditLimit.sendKeys(CustomerData.CREDIT_LIMIT);
    }

    public void saveForm(){
        buttonSave.click();
    }

    public String successMessage(){
        return reportSuccess.getText();
    }

    private void selectFromEmployeer(String from) {
        fieldSalesRepEmployeeNumber.click();
        fieldSalesRepEmployeeNumber.findElement(locatorOfInputField).sendKeys(from);
    }


    public void waitForSuccessMessage(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, 15, 500);
        wait.until(ExpectedConditions.textToBePresentInElement(reportSuccess, expectedMessage));
    }
}
