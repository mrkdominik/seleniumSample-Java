package com.GoogleCalcTests.Tests;

import com.GoogleCalcTests.Common.Browser;
import com.GoogleCalcTests.Common.Drivers.DriverFactory;
import com.GoogleCalcTests.Models.CalculatorBlock;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Test
public class TestBase {

    private static WebDriver webDriver;
    private String baseUrl;
    protected CalculatorBlock calculatorBlock;

    @BeforeTest
    public void SetUpTest() {
        webDriver = DriverFactory.CreateInstanceDesktop(Browser.Chrome);
    }

    @AfterTest
    public static void AfterTestRun() {
        try {
            if (webDriver != null) {
                webDriver.close();
                webDriver.quit();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @BeforeMethod
    public void BeforeMethod() {
        baseUrl = "https://www.google.com/search?q=calculator";
        calculatorBlock = new CalculatorBlock(webDriver, baseUrl);
    }

    @AfterMethod
    public void AfterMethod() {
        calculatorBlock = null;
    }

}
