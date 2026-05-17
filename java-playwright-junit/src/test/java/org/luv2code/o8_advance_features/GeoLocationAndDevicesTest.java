package org.luv2code.o8_advance_features;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Geolocation;
import org.junit.jupiter.api.Test;

public class GeoLocationAndDevicesTest {

    @Test
    void geoLocationAndDevicesTest() {

        Playwright lPlaywright = Playwright.create();
        Browser lBrowser = lPlaywright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
        );

        // set Geolocation
        Geolocation lGeolocation = new Geolocation(37.7749, -122.4194);

        // create browser context with device emulation, geolocation

        BrowserContext lBrowserContext = lBrowser.newContext(new Browser.NewContextOptions()
                .setViewportSize(390, 844)
                .setDeviceScaleFactor(3)
                .setIsMobile(true)
                .setGeolocation(lGeolocation)
        );

        Page lPage = lBrowserContext.newPage();

        // navigate to luv2test site
        lPage.navigate("https://www.luv2test.com/#/");
        lPage.locator("//h3[text()='Authentication']").click();

        System.out.println("Login for heading "+ lPage.locator("//h2[text()='Login']").isVisible());

        lPage.waitForTimeout(3000);

        lPage.close();
        lBrowserContext.close();
        lBrowser.close();
        lPlaywright.close();
    }

}
