package com.GoogleCalcTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class AdditionTests {

    private static WebDriver webDriver;
    private static String baseUrl;

    @BeforeTest
    public static void SetUpTest() {
        webDriver = new BrowserDriver(Browser.Chrome);
        baseUrl = "https://www.google.com/search?q=calculator";
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

    @Test(description = "Addition test of sixteen and four")
    public static void AddSixteenAndFour()
    {
        CalculatorBlockModel pom = new CalculatorBlockModel(webDriver,baseUrl);
        double result = pom.GetAdditionSixteenAndFour();

        Assert.assertEquals(result,20);
    }

    @Test(description = "Addition test of zero and zero")
    public void AddZeroAndZero()
    {
        CalculatorBlockModel pom = new CalculatorBlockModel(webDriver,baseUrl);
        double result = pom.GetAdditionZeroAndZero();

        Assert.assertEquals(result,0);
    }


    @Test(description = "Addition test of minus one and zero")
    public void AddMinusOneAndZero()
    {
        CalculatorBlockModel pom = new CalculatorBlockModel(webDriver,baseUrl);
        double result = pom.GetAdditionMinusOneAndZero();

        Assert.assertEquals(result,-1);
    }

    @Test(description = "Addition test of minus one and minus one")
    public void AddMinusOneAndMinusOne()
    {
        CalculatorBlockModel pom = new CalculatorBlockModel(webDriver,baseUrl);
        double result = pom.GetAdditionMinusOneAndMinusOne();

        Assert.assertEquals(result,-2);
    }

    @Test(description = "Addition test of zero and minus one")
    public void AddZeroAndMinusOne()
    {
        CalculatorBlockModel pom = new CalculatorBlockModel(webDriver,baseUrl);
        double result = pom.GetAdditionZeroAndMinusOne();

        Assert.assertEquals(result,-1);
    }
}
