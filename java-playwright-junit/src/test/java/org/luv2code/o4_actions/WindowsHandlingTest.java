package org.luv2code.o4_actions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class WindowsHandlingTest extends BaseTest {

    @Test
    void windowsHandlingTest() {

        // navigate to tabs-windows page
        page.navigate("https://www.luv2test.com/#/tabs-windows");

        // store the current page (original window)
        Page originalPage = page;
        System.out.println("Original Tab URL: "+originalPage.url());

        // click on 'Open Home Page (New Window) button'
        Locator lNewWindowButton = page.locator("//button[@data-test='open-home-window']");
        highlightElement(lNewWindowButton);
        waitInSeconds(2);

        // wait for new page (Window) to open
        Page lNewWindow = context.waitForPage(() -> {
            lNewWindowButton.click();
        });
        lNewWindow.waitForLoadState();

        // verify new window title and heading
        // we are in new tab
        System.out.println("Title of new window: "+lNewWindow.title());
        Locator lHeading = lNewWindow.locator("//h1[text()='Luv2Code Automation Practice (Web and Mobile Web)']");
        highlightElement(lHeading);
        waitInSeconds(2);

        // switch back to original window
        originalPage.bringToFront();
        System.out.println("Title of original tab: "+originalPage.title());

        // click on check all button
        originalPage.locator("//button[@data-test='check-all-button']").click();
        waitInSeconds(2);

    }

}
