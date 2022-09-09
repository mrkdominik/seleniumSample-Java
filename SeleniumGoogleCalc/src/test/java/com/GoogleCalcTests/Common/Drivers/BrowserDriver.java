package com.GoogleCalcTests.Common.Drivers;

import com.GoogleCalcTests.Common.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.List;
import java.util.Set;

public final class BrowserDriver implements WebDriver {

    private final WebDriver _driver;
    private final Browser _browser;

    /**
     * Create new local instance of webDriver based on required browser
     * @param browser browser
     */
    public BrowserDriver(Browser browser) {
        _browser = browser;
        _driver = CreateDriver();
    }

    private WebDriver CreateDriver() {

        if (_driver != null)
            return _driver;

        switch (_browser)
        {
            case Chrome:
                return ChromeDriver();
            case Edge:
                return MsEdgeDriver();
            case Ie:
                return IeDriver();
            case Safari:
            case Firefox:
            case Opera:
            case PhantomJs:
                throw new WebDriverException(String.format("%s browser not implemented yet",_browser));
            default:
                throw new WebDriverException("Invalid browser name");
        }
    }

    private WebDriver ChromeDriver() {
        try {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } catch (Exception ex) {
            throw new WebDriverException(String.format("Couldn't create %s _driver %s", _browser, ex.getMessage()));
        }
    }

    private WebDriver MsEdgeDriver() {
        try {
            WebDriverManager.edgedriver().setup();
            return new InternetExplorerDriver();
        } catch (Exception ex) {
            throw new WebDriverException(String.format("Couldn't create %s _driver %s", _browser, ex.getMessage()));
        }
    }

    private WebDriver IeDriver() {
        try {
            WebDriverManager.iedriver().setup();
            return new InternetExplorerDriver();
        } catch (Exception ex) {
            throw new WebDriverException(String.format("Couldn't create %s _driver %s", _browser, ex.getMessage()));
        }
    }

    //region interface implementation
    @Override
    public void get(String url) {
        _driver.get(url);
    }

    @Override
    public String getCurrentUrl() {
        return _driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return _driver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By locator) {
        return _driver.findElements(locator);
    }

    @Override
    public WebElement findElement(By locator) {
        return _driver.findElement(locator);
    }

    @Override
    public String getPageSource() {
        return _driver.getPageSource();
    }

    @Override
    public void close() {
        _driver.close();
    }

    @Override
    public void quit() {
        _driver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return _driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return _driver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return _driver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return _driver.navigate();
    }

    @Override
    public Options manage() {
        return _driver.manage();
    }
    //endregion
}
