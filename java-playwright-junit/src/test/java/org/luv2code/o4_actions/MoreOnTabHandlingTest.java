package org.luv2code.o4_actions;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

import java.util.List;

public class MoreOnTabHandlingTest extends BaseTest {

    @Test
    void moreOnTabHandlingTest() {

        // navigate to tabs-windows page
        page.navigate("https://www.luv2test.com/#/tabs-windows");

        // store original tab
        Page originalPage = page;

        // open 3 new tabs
        for (int i=0; i < 3; i++) {
            Page lNewTab = context.waitForPage(() -> {
                page.locator("//button[@data-test='open-home-tab']").click();
            });

            // ensure new tab is fully loaded
            lNewTab.waitForLoadState();

            // switch back to our original tab
            originalPage.bringToFront();
            waitInSeconds(1);
        }

        // get list of all tabs
        List<Page> lAllTabs = context.pages();

        // switch to all tabs one-by-one
        for (Page page1: lAllTabs) {
            page1.bringToFront();
            waitInSeconds(1);
        }

        // open a blank new tab
        Page lBlankPage = context.newPage();
        lBlankPage.bringToFront();
        waitInSeconds(1);

        // switch back to original tab
        originalPage.bringToFront();
        waitInSeconds(1);

        // access tabs by index
        if (lAllTabs.size() > 2) {
            lAllTabs.get(2).bringToFront();
            waitInSeconds(1);
        }

        // close all tabs except original
        for (Page page1: context.pages()) {
            if (page1 != originalPage)
                page1.close();
        }

        // switch back to original tab
        originalPage.bringToFront();
        waitInSeconds(2);

        // click on 'Uncheck All'
        originalPage.locator("//button[@data-test='uncheck-all-button']").click();
        waitInSeconds(2);

        System.out.println("Success");
    }

}
