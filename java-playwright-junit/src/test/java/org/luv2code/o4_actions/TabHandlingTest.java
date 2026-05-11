package org.luv2code.o4_actions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class TabHandlingTest extends BaseTest {

    @Test
    void tabHandlingTest() {

        // navigate to tab & windows page
        page.navigate("https://www.luv2test.com/#/tabs-windows");

        //store the original page or tab
        Page originalPage = page;
        System.out.println("Original Tab URL: "+originalPage.url());

        // click on "Open Home Page (New Tab)"
        Locator lNewTabButton = page.locator("//button[@data-test='open-home-tab']");
        highlightElement(lNewTabButton);
        waitInSeconds(2);

        // wait for new tab to open and get the page object
        Page lNewTab = context.waitForPage(() -> {
            lNewTabButton.click();
        });

        // ensure new tab is fully loaded
        lNewTab.waitForLoadState();

        // we are in new tab
        System.out.println("Title of new tab: "+lNewTab.title());

        // verify headingin the new tab
        Locator lHeading = lNewTab.locator("//h1[text()='Luv2Code Automation Practice (Web and Mobile Web)']");
        highlightElement(lHeading);
        waitInSeconds(2);

        // switch back to our original tab
        originalPage.bringToFront();
        System.out.println("Title of original tab: "+originalPage.title());

        // continue working on original page/tab
        originalPage.locator("//button[@data-test='check-all-button']").click();
        waitInSeconds(2);

        System.out.println("Success");
    }

}
