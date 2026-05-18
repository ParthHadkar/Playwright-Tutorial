package org.luv2code.framework.base;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.luv2code.framework.constants.TestDataConstant;

import java.nio.file.Paths;
import java.util.List;

public class BaseTest {

    public Playwright playwright;
    public Browser browser;
    public BrowserContext context;
    public Page page;

    @BeforeEach
    void setUp() {
        // Launch chrome browser
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setSlowMo(1000)
                        .setArgs(List.of("--start-maximized"))
        );
        // create context without viewport (true maximize effect)
        //page = browser.newContext(new Browser.NewContextOptions().setViewportSize(null)).newPage();
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null)
                .setRecordVideoDir(Paths.get("target/videos"))
                .setRecordVideoSize(1280, 720)
        );
        page = context.newPage();

        page.setDefaultTimeout(15000); // set to 15 seconds

        // navigate to luv2test site
        page.navigate(TestDataConstant.BASE_URL);
        System.out.println("Home page Title: "+page.title());
    }

    // method to handle highlight elements
    public static void highlightElement(Locator pLocator) {
        ElementHandle lElementHandle = pLocator.elementHandle();
        if (lElementHandle != null) {
            pLocator.page().evaluate("e => { e.style.border='3px solid red';}", lElementHandle);
        }
    }

    // wait in seconds method
    public void waitInSeconds(long pSec) {
        try {
            Thread.sleep(1000 * pSec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    void tearDown() {
        // close the browser
        browser.close();
        context.close();
        playwright.close();
    }

}
