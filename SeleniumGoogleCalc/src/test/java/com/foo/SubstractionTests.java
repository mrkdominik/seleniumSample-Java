package com.foo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class SubstractionTests {

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
    public static void Dummy()
    {
        PageObjectModel pom = new PageObjectModel(webDriver,baseUrl);
        double result = pom.GetAdditionSixteenAndFour();

        Assert.assertEquals(result,20);
    }
}
