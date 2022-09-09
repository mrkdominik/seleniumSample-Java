package com.GoogleCalcTests.Common.Drivers;

import com.GoogleCalcTests.Common.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.List;
import java.util.Set;

public final class BrowserStackDriver implements WebDriver {

    private final WebDriver _driver;
    private final Browser _browser;

    /**
     * Create new instance of browserstack webDriver based on required browser
     * @param browser browser
     */
    public BrowserStackDriver(Browser browser) {
        _browser = browser;
        _driver = CreateDriverLegacy();
    }

    private WebDriver CreateDriverLegacy()
    {
        //todo: atm are caps hardcoded, but have to be separated away
        //Officially supported by BS, but obsolete, in future we will be force to explicit browserOptions solution..
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", _browser.toString());
        caps.setCapability("browserstack.user", "foo");
        caps.setCapability("browserstack.key", "foo");
        caps.setCapability("os", "Windows");
        caps.setCapability("osVersion", "10");
        caps.setCapability("resolution", "1024x768");

        try
        {
            return new RemoteWebDriver(new URL("http://hub-cloud.browserstack.com/wd/hub/"), caps);
        }
        catch (Exception ex)
        {
            throw new WebDriverException(String.format("Couldn't create BrowserStack driver %s", ex.getMessage() ));
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
