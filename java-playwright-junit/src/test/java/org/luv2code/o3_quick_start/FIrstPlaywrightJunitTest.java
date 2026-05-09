package org.luv2code.o3_quick_start;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class FIrstPlaywrightJunitTest {

    Playwright playwright;
    Browser browser;
    Page page;

    @BeforeEach
    void setUp() {
        // Launch chrome browser
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                        new BrowserType.LaunchOptions()
                                .setHeadless(false)
                                .setArgs(List.of("--start-maximized"))
        );
        // create context without viewport (true maximize effect)
        page = browser.newContext(new Browser.NewContextOptions().setViewportSize(null)).newPage();

        // navigate to luv2test site
        page.navigate("https://www.luv2test.com/");
        System.out.println("Home page Title: "+page.title());
    }

    @Test
    void firstPlaywightJunitTest() {
        // click on Authentication link
        page.click("text=Authentication");

        // verify Login heading is present.
        boolean lIsHeadingPresent = page.locator("//h2[text()='Login']").isVisible();
        System.out.println("Is Login form heading present: "+ lIsHeadingPresent);
    }

    @AfterEach
    void tearDown() {
        // close the browser
        browser.close();
        playwright.close();
    }

}
