package com.sicredi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

public class MainPage {

    private WebDriver driver;

    @FindBy(id = "switch-version-select")
    private WebElement switchVersion;

    @FindBy(css = "#gcrud-search-form > div.header-tools > div.floatL.t5 > a" )
    private WebElement btnAddNewCustomer;

    @FindBy(css = "i.fa.fa-search" )
    private WebElement btnSearchCustomer;

    @FindBy(css = "input.search-input" )
    private WebElement fieldSearchCustomer;

    @FindBy(css = "table.table.table-bordered.grocery-crud-table.table-hover")
    private WebElement tableOfResults;

    @FindBy(css = "div.delete-multiple-confirmation.modal.fade.in.show")
    private WebElement modalDialog;

    @FindBy(css = "span[data-growl='message']")
    private WebElement successMessage;

    private By locatorLoadingMessage = By.cssSelector("div.container-fluid.gc-container.loading-opacity");
    private By locatorOfFirstColumnOnTable = By.cssSelector("tbody > tr");
    private By locatorOfCheckbox = By.cssSelector("input.select-row[type='checkbox']");
    private By locatorDeleteOptionForActions = By.cssSelector("a.btn.btn-default.delete-selected-button");
    private By locatorOfDeleteButtonInModal = By.cssSelector("button.btn.btn-danger.delete-multiple-confirmation-button");
    private By locatorOfTbody = By.cssSelector("td");
    private By locatorModalMessage = By.cssSelector("p.alert-delete-multiple-one");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,  this);
    }

    public void selectVersion(String value) {
        Select select= new Select(switchVersion);
        select.selectByValue(value);
    }

    public void addNewCustomer(){
        btnAddNewCustomer.click();
    }

    public void searchByCustomer(String customer) {
        btnSearchCustomer.click();
        fieldSearchCustomer.sendKeys(customer);
        fieldSearchCustomer.sendKeys(Keys.ENTER);
    }

    public void removeFirstCustomer(){
        WebDriverWait wait = new WebDriverWait(driver, 10, 50);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locatorLoadingMessage));

        tableOfResults.findElements(locatorOfTbody);

        WebElement firstColumnOfTable = tableOfResults.findElements(locatorOfFirstColumnOnTable).get(0);
        firstColumnOfTable.findElement(locatorOfCheckbox).click();

        tableOfResults.findElements(locatorDeleteOptionForActions).get(0).click();
    }

    public String waitForModalDialogAndReturnMessage(){
        WebDriverWait wait = new WebDriverWait(driver, 15, 500);
        wait.until(visibilityOfAllElements(modalDialog));
        return modalDialog.findElement(locatorModalMessage).getText();
    }

    public void confirmDeleteCustomer(){
        modalDialog.findElement(locatorOfDeleteButtonInModal).click();
    }

    public String returnSuccesMessage(){
        WebDriverWait wait = new WebDriverWait(driver, 15, 500);
        wait.until(visibilityOfAllElements(successMessage));
        return successMessage.getText();
    }
}
