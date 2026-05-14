package org.luv2code.o6_options_cookies_browser;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LaunchOptionsTest {

    @Test
    void launchOptionsTest() {

        // setup the playwright
        Playwright lPlaywright = Playwright.create();

        BrowserType.LaunchOptions lLaunchOptions = new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setArgs(Arrays.asList(new String[]{
                        "--Start-maximized", // maximized browser window
                        "--ignore-certificate-errors", // accept bad SSL
                        "--allow-insecure-localhost", // allow localhost SSL issues
                        //"--headless=new", // for headless
                        //"--window-size=1024,1366", // launch browser in fix size
                        "--disable-extensions", // disable extensions
                        "--disable-popup-blocking", // disable popups
                        "--disable-notificaion", // disable notificaion
                }));

        Browser lBrowser = lPlaywright.chromium().launch(lLaunchOptions);

        // create context (acts like incognito if you want isolated session)
        BrowserContext lBrowserContext = lBrowser.newContext(new Browser.NewContextOptions()
                .setViewportSize(null) // reliable maximize
                .setIgnoreHTTPSErrors(true) //same as -ignore-certificate-errors
        );

        Page lPage = lBrowserContext.newPage();
        lPage.waitForTimeout(2000);

        lPage.navigate("https://expired.badssl.com/");
        lPage.waitForTimeout(3000);

        lPage.navigate("https://www.luv2test.com/#/");
        lPage.waitForTimeout(3000);
    }

}
