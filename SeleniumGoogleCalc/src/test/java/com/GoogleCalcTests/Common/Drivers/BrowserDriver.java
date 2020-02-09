package com.GoogleCalcTests.Drivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.util.List;
import java.util.Set;

public final class BrowserDriver implements WebDriver {

    private WebDriver driver;
    private final Browser browser;

    private final String chromeDriverPath = "src/test/resources/chromedriver.exe";
    private final String msEdgeDriverPath = "src/test/resources/msedgedriver.exe";
    private final String ieDriverPath = "src/test/resources/IEDriverServer.exe";

    public BrowserDriver(Browser browser) {
        this.browser = browser;
        this.driver = CreateDriver(browser);
    }

    private WebDriver CreateDriver(Browser browser) {

        if (driver != null)
            return driver;

        switch (driver)
        {
            case Browser.Chrome:
                return ChromeDriver();
            case Browser.Edge:
                return MsEdgeDriver();
            case Browser.Ie:
                return IeDriver();
            case Browser.Safari:
            case Browser.Firefox:
            case Browser.Opera:
            case Browser.PhantomJs:
                    throw new IllegalArgumentException(String.format("{0} browser not implemented yet", driver));
            default:
                throw new WebDriverException("Invalid browser name");
        }

        throw new RuntimeException("Invalid browser name");
    }

    private void checkDriver(Browser browser, String driverPath) {
        if (!new File(driverPath).exists())
            throw new RuntimeException(browser.name() + "driver does not exist!");
    }

    private WebDriver ChromeDriver() {
        checkDriver(Browser.Chrome, chromeDriverPath);

        try {
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            return new ChromeDriver();
        } catch (Exception ex) {
            throw new RuntimeException("Couldn't create Chrome driver");
        }
    }

    private WebDriver MsEdgeDriver() {
        checkDriver(Browser.Edge, msEdgeDriverPath);

        try {
            System.setProperty("webdriver.edge.driver", msEdgeDriverPath);
            return new InternetExplorerDriver();
        } catch (Exception ex) {
            throw new RuntimeException("Couldn't create Edge driver");
        }
    }

    private WebDriver IeDriver() {
        checkDriver(Browser.Ie, ieDriverPath);

        try {
            System.setProperty("webdriver.ie.driver", ieDriverPath);
            return new InternetExplorerDriver();
        } catch (Exception ex) {
            throw new RuntimeException("Couldn't create IE driver");
        }
    }

    public String toString() {
        return this.browser.name();
    }

    //region interface implementation
    @Override
    public void get(String url) {
        driver.get(url);
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    @Override
    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    @Override
    public String getPageSource() {
        return driver.getPageSource();
    }

    @Override
    public void close() {
        driver.close();
    }

    @Override
    public void quit() {
        driver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return driver.navigate();
    }

    @Override
    public Options manage() {
        return driver.manage();
    }
    //endregion
};
