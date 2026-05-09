package org.luv2code.o3_quick_start;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.List;

public class FirstPlaywrightTest {

    public static void main(String[] args) {

        // Launch chrome browser
        Playwright lPlaywright = Playwright.create();
        Browser lBrowser = lPlaywright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setArgs(List.of("--start-maximized"))
        );
        // create context without viewport (true maximize effect)
        Page lPage = lBrowser.newContext(new Browser.NewContextOptions().setViewportSize(null)).newPage();

        // navigate to luv2test site
        lPage.navigate("https://www.luv2test.com/");
        System.out.println("Home page Title: "+lPage.title());

        // click on Authentication link
        lPage.click("text=Authentication");

        // verify Login heading is present.
        boolean lIsHeadingPresent = lPage.locator("//h2[text()='Login']").isVisible();
        System.out.println("Is Login form heading present: "+ lIsHeadingPresent);

        // close the browser
        lBrowser.close();
        lPlaywright.close();
    }
}
