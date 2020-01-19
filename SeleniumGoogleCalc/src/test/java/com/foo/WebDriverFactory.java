package com.foo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {

    private WebDriver _webDriver;
    private Browser _browser;

    private void Initialize() {
        if (Browser.Chrome == _browser)
        {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            _webDriver = new ChromeDriver();
        }
        else if (Browser.IE == _browser)
        {
            System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
            _webDriver = new InternetExplorerDriver();
        }
        else
        {
            _webDriver = new FirefoxDriver();
        }
    }

    public WebDriver GetInstance(Browser browser)
    {
        if(_webDriver == null)
        {
            _browser = browser;
            Initialize();
        }

        return _webDriver;
    }
}

