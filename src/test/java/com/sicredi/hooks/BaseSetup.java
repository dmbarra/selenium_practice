package com.sicredi.hooks;

import com.sicredi.pages.AddCustomer;
import com.sicredi.pages.MainPage;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseSetup {

    protected WebDriver driver;
    protected MainPage mainPage;
    protected AddCustomer addCustomer;

    @BeforeTest
    public static void setupClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
        addCustomer = new AddCustomer(driver);
        driver.get("https://www.grocerycrud.com/demo/bootstrap_theme");
    }

    @AfterMethod
    public void before() {
        driver.close();
        driver.quit();
    }

}
