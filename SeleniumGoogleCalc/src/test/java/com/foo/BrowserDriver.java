package com.foo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.util.List;
import java.util.Set;

public final class BrowserDriver implements WebDriver {

    private WebDriver driver;
    private final Browser browser;
    private final String chromeDriverPath = "src/test/resources/chromedriver.exe";
    private final String firefoxDriverPath = "src/test/resources/geckodriver.exe";
    private final String IEDriverPath = "src/test/resources/IEDriverServer.exe";

    public BrowserDriver(Browser browser) {
        this.browser = browser;
        this.driver = createDriver(browser);
    }

    private WebDriver createDriver(Browser browser) {
        if (browser == Browser.Chrome)
            return chromeDriver();

        if (browser == Browser.Firefox)
            return firefoxDriver();

        if (browser == Browser.IE)
            return IEDriver();

        throw new RuntimeException("Invalid browser name");
    }

    private WebDriver chromeDriver() {
        checkDriver(Browser.Chrome, chromeDriverPath);

        try {
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            return new ChromeDriver();
        } catch (Exception ex) {
            throw new RuntimeException("Couldn't create chrome driver");
        }
    }

    private WebDriver firefoxDriver() {
        checkDriver(Browser.Firefox, firefoxDriverPath);

        try {
            System.setProperty("webdriver.firefox.driver", firefoxDriverPath);
            return new FirefoxDriver();
        } catch (Exception ex) {
            throw new RuntimeException("Couldn't create chrome driver");
        }
    }

    private WebDriver IEDriver() {
        checkDriver(Browser.IE, IEDriverPath);

        try {
            System.setProperty("webdriver.ie.driver", IEDriverPath);
            return new InternetExplorerDriver();
        } catch (Exception ex) {
            throw new RuntimeException("Couldn't create chrome driver");
        }
    }

    private void checkDriver(Browser browser, String driverPath) {
        if (!new File(driverPath).exists())
            throw new RuntimeException(browser.name() + "driver does not exist!");
    }

    public String toString() {
        return this.browser.name();
    }

    public WebDriver driver() {
        return this.driver;
    }

    // Implements interface

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
};
