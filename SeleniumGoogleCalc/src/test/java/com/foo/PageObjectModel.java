package com.foo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

import javax.management.remote.rmi._RMIConnection_Stub;

public class PageObjectModel {

    private WebDriver _webDriver;
    private String _baseUrl;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(5) > td:nth-child(1) > div > div")
    @CacheLookup
    static WebElement Number0;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(4) > td:nth-child(1) > div > div")
    @CacheLookup
    static WebElement Number1;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(4) > td:nth-child(2) > div > div")
    @CacheLookup
    static WebElement Number2;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(4) > td:nth-child(3) > div > div")
    @CacheLookup
    static WebElement Number3;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(3) > td:nth-child(1) > div > div")
    @CacheLookup
    static WebElement Number4;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(3) > td:nth-child(2) > div > div")
    @CacheLookup
    static WebElement Number5;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(3) > td:nth-child(3) > div > div")
    @CacheLookup
    static WebElement Number6;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(2) > td:nth-child(1) > div > div")
    @CacheLookup
    static WebElement Number7;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(2) > td:nth-child(2) > div > div")
    @CacheLookup
    static WebElement Number8;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(2) > td:nth-child(3) > div > div")
    @CacheLookup
    static WebElement Number9;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(5) > td:nth-child(4) > div > div")
    @CacheLookup
    static WebElement Plus;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(4) > td:nth-child(4) > div > div")
    @CacheLookup
    static WebElement Minus;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(3) > td:nth-child(4) > div > div")
    @CacheLookup
    static WebElement Multiply;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(2) > td:nth-child(4) > div > div")
    @CacheLookup
    static WebElement Devide;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(5) > td:nth-child(3) > div > div")
    @CacheLookup
    static WebElement Equals;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(5) > td:nth-child(2) > div > div")
    @CacheLookup
    static WebElement Dot;

    @FindBy(css = "#cwmcwd > div > div > div.BRpYC > div.TIGsTb > div.fB3vD > div > div")
    static WebElement Result;

    public PageObjectModel(WebDriver webDriver, String baseUrl)
    {
        _webDriver = webDriver;
        _baseUrl = baseUrl;
        PageFactory.initElements(_webDriver, this);
    }

    public void AdditionSixteenAndFour()
    {
        _webDriver.navigate().to(_baseUrl);
        Number1.click();
        Number6.click();
        Plus.click();
        Number4.click();
        Equals.click();
    }

    public int GetResult()
    {
        if (Result != null)
            return Integer.parseInt(Result.getText());

        return 0;
    }
}
