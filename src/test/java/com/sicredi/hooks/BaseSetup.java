package com.sicredi.hooks;

import com.sicredi.pages.AddCustomer;
import com.sicredi.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseSetup {

    protected WebDriver driver;
    protected MainPage mainPage;
    protected AddCustomer addCustomer;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage = PageFactory.initElements(driver, MainPage.class);
        addCustomer = new AddCustomer(driver);
        driver.get("https://www.grocerycrud.com/demo/bootstrap_theme");
    }

    @AfterTest
    public void before() {
        driver.close();
        driver.quit();
    }

}
