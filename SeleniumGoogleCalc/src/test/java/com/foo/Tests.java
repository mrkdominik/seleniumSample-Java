package com.foo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tests {

    @Test
    public static void POCTest()
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver webDriver = new ChromeDriver();
        webDriver.navigate().to("https://google.com");
        System.out.println("Processed");
        webDriver.quit();
    }
}
