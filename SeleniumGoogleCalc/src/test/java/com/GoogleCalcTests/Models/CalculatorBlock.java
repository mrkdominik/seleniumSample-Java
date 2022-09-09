package com.GoogleCalcTests.Models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorBlock {
    @FindBy(xpath = "//button[@id='L2AGLb']")
    @CacheLookup
    private static WebElement Banner;

    @FindBy(xpath = "//div[text()='0']")
    @CacheLookup
    private static WebElement Number0;

    @FindBy(xpath = "//div[text()='1']")
    @CacheLookup
    private static WebElement Number1;

    @FindBy(xpath = "//div[text()='2']")
    @CacheLookup
    private static WebElement Number2;

    @FindBy(xpath = "//div[text()='3']")
    @CacheLookup
    private static WebElement Number3;

    @FindBy(xpath = "//div[text()='4']")
    @CacheLookup
    private static WebElement Number4;

    @FindBy(xpath = "//div[text()='5']")
    @CacheLookup
    private static WebElement Number5;

    @FindBy(xpath = "//div[text()='6']")
    @CacheLookup
    private static WebElement Number6;

    @FindBy(xpath = "//div[text()='7']")
    @CacheLookup
    private static WebElement Number7;

    @FindBy(xpath = "//div[text()='8']")
    @CacheLookup
    private static WebElement Number8;

    @FindBy(xpath = "//div[text()='9']")
    @CacheLookup
    private static WebElement Number9;

    @FindBy(xpath = "//div[text()='+']")
    @CacheLookup
    private static WebElement Plus;

    @FindBy(xpath = "//div[text()='-']")
    @CacheLookup
    private static WebElement Minus;

    @FindBy(xpath = "//div[text()='*']")
    @CacheLookup
    private static WebElement Multiply;

    @FindBy(xpath = "//div[text()='÷']")
    @CacheLookup
    private static WebElement Devide;

    @FindBy(xpath = "//div[text()='=']")
    @CacheLookup
    private static WebElement Equal;

    @FindBy(xpath = "//div[text()='.']")
    @CacheLookup
    private static WebElement Dot;

    @FindBy(xpath = "//div[text()='%']")
    @CacheLookup
    private static WebElement Percent;

    @FindBy(xpath = "//div[text()='(']")
    @CacheLookup
    private static WebElement LeftBracket;

    @FindBy(xpath = "//div[text()=')']")
    @CacheLookup
    private static WebElement RightBracket;

    @FindBy(xpath = "//div[text()='AC']")
    @CacheLookup
    private static WebElement AllClear;

    @FindBy(xpath = "//div[text()='CE']")
    @CacheLookup
    private static WebElement ClearEntry;

    @FindBy(xpath = "//span[@id='cwos']")
    private static WebElement Result;


    public double GetDoubleResult()
    {
        Equal.click();
        String result = Result.getText().trim();
        return Double.parseDouble(result);
    }

    public String GetTextResult()
    {
        Equal.click();
        return Result.getText();
    }

    public CalculatorBlock(WebDriver webDriver)
    {
        PageFactory.initElements(webDriver,this);
        // sadly, its needed just right in that that moment to load model.
    }

    public static void ClickWholeEquation(String equation)
    {
        //todo: filter only acceptable chars
        for (char character : equation.trim().toCharArray())
            ClickElement(character);
    }

    public static void CloseBanner()
    {
        if (Banner.isDisplayed())
            Banner.click();
    }
    
    private static void ClickElement(char character)
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
