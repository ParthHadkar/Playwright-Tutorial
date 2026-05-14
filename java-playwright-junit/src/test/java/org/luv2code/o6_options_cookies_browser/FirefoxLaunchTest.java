package org.luv2code.o6_options_cookies_browser;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

public class FirefoxLaunchTest {

    @Test
    void firefoxLaunchTest() {

        // lunch firefox
        Playwright lPlaywright = Playwright.create();
        BrowserContext lBrowserContext = lPlaywright.firefox()
                .launch(new BrowserType.LaunchOptions().setHeadless(false)).newContext();
        Page lPage = lBrowserContext.newPage();
        lPage.navigate("https://www.luv2test.com/#/");

        // wait for heading to appear
        lPage.waitForSelector("h1");
        System.out.println("Page title: "+lPage.title());

        lPage.waitForTimeout(3000);

        lPage.close();
        lBrowserContext.close();
        lPlaywright.close();
    }

}
