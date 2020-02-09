package com.GoogleCalcTests.Common.Drivers;
import com.GoogleCalcTests.Common.Browser;

public class DriverFactory {
    public static BrowserDriver CreateInstanceDesktop(Browser browser)
    {
        return new BrowserDriver(browser);
    }

    public static BrowserStackDriver CreateInstanceBrowserStack(Browser browser) { return new BrowserStackDriver(browser); }
}
