package org.luv2code.o6_options_cookies_browser;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

public class EdgeLaunchTest {

    @Test
    void edgeLaunchTest() {

        // lunch edge
        Playwright lPlaywright = Playwright.create();
        BrowserContext lBrowserContext = lPlaywright.chromium()
                .launch(new BrowserType.LaunchOptions()
                        .setChannel("msedge")
                        .setHeadless(false)).newContext();
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
