package com.GoogleCalcTests.Models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorBlockModel {
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
    private static WebElement Equal;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(5) > td:nth-child(2) > div > div")
    @CacheLookup
    private static WebElement Dot;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(1) > td:nth-child(3) > div > div")
    @CacheLookup
    private static WebElement Percent;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(1) > td:nth-child(1) > div > div")
    @CacheLookup
    private static WebElement LeftBracket;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(1) > td:nth-child(2) > div > div")
    @CacheLookup
    private static WebElement RightBracket;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(1) > td:nth-child(4) > div > div:nth-child(1)")
    @CacheLookup
    private static WebElement AllClear;

    @FindBy(css = "#cwmcwd > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(1) > td:nth-child(4) > div > div:nth-child(2)")
    @CacheLookup
    private static WebElement ClearEntry;

    @FindBy(css = "#cwmcwd > div > div > div.BRpYC > div.TIGsTb > span")
    @CacheLookup
    private static WebElement History;

    @FindBy(css = "#cwmcwd > div > div > div.BRpYC > div.tR3EBc > div:nth-child(3) > div.CpV0xd")
    @CacheLookup
    private static WebElement HistoryList;

    @FindBy(css = "#cwmcwd > div > div > div.BRpYC > div.TIGsTb > div.fB3vD > div > div")
    private  WebElement Result;


    public double GetDoubleResult()
    {
        if (Result != null)
            return Double.parseDouble(Result.getText());

        return 0;
    }

    public String GetTextResult()
    {
        if (Result != null)
            return Result.getText();

        return null;
    }

    public CalculatorBlockModel(WebDriver webDriver)
    {
        PageFactory.initElements(webDriver, this);
    }

    public void ClickWholeEquation(String equation)
    {
        //todo: filter only acceptable chars
        for (char character : equation.trim().toCharArray())
            ClickElement(character);
    }
    
    private void ClickElement(char character)
    {
        // Without explicit char parsing, it should be faster.
        switch ((int)character)
        {
            case 37:
                Percent.click();
                break;

            case 40:
                LeftBracket.click();
                break;

            case 41:
                RightBracket.click();
                break;

            case 42:
                Multiply.click();
                break;

            case 43:
                Plus.click();
                break;

            case 45:
                Minus.click();
                break;

            case 44: // ,
                Dot.click();
                break;

            case 46: // .
                Dot.click();
                break;

            case 47:
                Devide.click();
                break;

            case 48:
                Number0.click();
                break;

            case 49:
                Number1.click();
                break;

            case 50:
                Number2.click();
                break;

            case 51:
                Number3.click();
                break;

            case 52:
                Number4.click();
                break;

            case 53:
                Number5.click();
                break;

            case 54:
                Number6.click();
                break;

            case 55:
                Number7.click();
                break;

            case 56:
                Number8.click();
                break;

            case 57:
                Number9.click();
                break;

            case 61:
                Equal.click();
                break;
        }
    }
}
