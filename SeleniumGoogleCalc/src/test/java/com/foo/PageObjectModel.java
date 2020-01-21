package com.foo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectModel {
    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(5) > td:nth-child(1) > div > div")
    @CacheLookup
    private static WebElement Number0;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(4) > td:nth-child(1) > div > div")
    @CacheLookup
    private static WebElement Number1;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(4) > td:nth-child(2) > div > div")
    @CacheLookup
    private static WebElement Number2;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(4) > td:nth-child(3) > div > div")
    @CacheLookup
    private static WebElement Number3;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(3) > td:nth-child(1) > div > div")
    @CacheLookup
    private static WebElement Number4;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(3) > td:nth-child(2) > div > div")
    @CacheLookup
    private static WebElement Number5;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(3) > td:nth-child(3) > div > div")
    @CacheLookup
    private static WebElement Number6;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(2) > td:nth-child(1) > div > div")
    @CacheLookup
    private static WebElement Number7;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(2) > td:nth-child(2) > div > div")
    @CacheLookup
    private static WebElement Number8;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(2) > td:nth-child(3) > div > div")
    @CacheLookup
    private static WebElement Number9;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(5) > td:nth-child(4) > div > div")
    @CacheLookup
    private static WebElement Plus;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(4) > td:nth-child(4) > div > div")
    @CacheLookup
    private static WebElement Minus;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(3) > td:nth-child(4) > div > div")
    @CacheLookup
    private static WebElement Multiply;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(2) > td:nth-child(4) > div > div")
    @CacheLookup
    private static WebElement Devide;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(5) > td:nth-child(3) > div > div")
    @CacheLookup
    private static WebElement Equals;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(5) > td:nth-child(2) > div > div")
    @CacheLookup
    private static WebElement Dot;

    @FindBy(css = "#cwmcwd > div > div > div.BRpYC > div.TIGsTb > div.fB3vD > div > div")
    private  WebElement Result;

    public PageObjectModel(WebDriver webDriver, String baseUrl)
    {
        PageFactory.initElements(webDriver, this);
        webDriver.navigate().to(baseUrl);
    }

    public double GetAdditionSixteenAndFour()
    {
        Number1.click();
        Number6.click();
        Plus.click();
        Number4.click();
        Equals.click();

        return GetResult();
    }

    public double GetAdditionZeroAndZero()
    {
        Number0.click();
        Plus.click();
        Number0.click();
        Equals.click();

        return GetResult();
    }

    public double GetAdditionMinusOneAndZero()
    {
        Minus.click();
        Number1.click();
        Plus.click();
        Number0.click();
        Equals.click();

        return GetResult();
    }

    public double GetAdditionMinusOneAndMinusOne()
    {
        Minus.click();
        Number1.click();
        Plus.click();
        Minus.click();
        Number1.click();
        Equals.click();

        return GetResult();
    }

    public double GetAdditionZeroAndMinusOne()
    {
        Number0.click();
        Minus.click();
        Number1.click();
        Equals.click();

        return GetResult();
    }

    public double GetResult()
    {
        if (Result != null)
            return Double.parseDouble(Result.getText());

        return 0;
    }
}
