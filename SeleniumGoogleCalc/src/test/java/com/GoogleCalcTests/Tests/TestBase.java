package com.GoogleCalcTests.Tests;

import com.GoogleCalcTests.Common.Browser;
import com.GoogleCalcTests.Common.Drivers.DriverFactory;
import com.GoogleCalcTests.Models.CalculatorBlock;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Test
public class TestBase {

    private static WebDriver webDriver;
    protected CalculatorBlock calculatorBlock;

    @BeforeTest
    public void SetUpTest() {
        webDriver = DriverFactory.CreateInstanceDesktop(Browser.Chrome);
        webDriver.navigate().to("https://www.google.com/search?q=calculator");
        calculatorBlock = new CalculatorBlock(webDriver);

        //CalculatorBlock.CloseBanner(); //pipeline run test
    }

    @AfterTest
    public static void AfterTestRun() {
        try {
            if (webDriver != null) {
                webDriver.quit();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @BeforeMethod
    public void BeforeMethod() {
        calculatorBlock = new CalculatorBlock(webDriver);
    }

    @AfterMethod
    public void AfterMethod() {
        webDriver.navigate().refresh();
    }

}
