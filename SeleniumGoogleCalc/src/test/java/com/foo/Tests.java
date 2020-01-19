package com.foo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class Tests {

    private static WebDriver _webDriver;
    private static String _baseUrl;
    private static Browser _browser;

    @BeforeTest
    public static void SetUpTest() {
        _browser = Browser.Chrome;
        _webDriver = new WebDriverFactory().GetInstance(_browser);
        _baseUrl = "https://www.google.com/search?q=calculator";
    }

    @AfterTest
    public static void AfterTestRun() {
        try {
            if (_webDriver != null) {
                _webDriver.close();
                _webDriver.quit();
            }
        } catch (Throwable  t) {
            t.printStackTrace();
        }
    }

    @Test(description = "Addition test of sixteen and four")
    public static void AdditionSixteenAndFour() {
        PageObjectModel pom = new PageObjectModel(_webDriver,_baseUrl);
        pom.AdditionSixteenAndFour();
        int result = pom.GetResult();

        Assert.assertEquals(result,20);
    }
}
