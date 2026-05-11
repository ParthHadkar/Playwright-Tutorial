package org.luv2code.o4_actions;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class ShadowDomHandlingTest extends BaseTest {

    @Test
    void shadowDomHandlingTest() {

        // navigate to shadow Dom page
        page.navigate("https://www.luv2test.com/#/shadow-dom");

        // click on "Click Me!" button inside shadow dom
        Locator lClickMeButton = page.locator("div[data-test='shadow-host']").locator("button.shadow-button");
        lClickMeButton.click();
        System.out.println(lClickMeButton.textContent() + " :: Clicked Successfully");

        // access NESTED Shadow DOM
        var lNestedShadowTitle = page.locator("div[data-test=\"shadow-host\"]")
                .locator("#nested-shadow-host")
                .locator(".nested-content > h3");

        //highlightElement(lNestedShadowTitle);
        lNestedShadowTitle.highlight();

        // handle iframe inside nested Shadow DOM
        var lIframe = page.locator("div[data-test=\"shadow-host\"]")
                .locator("#nested-shadow-host")
                .locator("#nested-iframe");

        highlightElement(lIframe);

        // switch into iframe using frame locator

        var lIframeShadowHost = page.frameLocator("div[data-test='shadow-host'] #nested-shadow-host #nested-iframe")
                        .locator("#iframe-shadow-host");
        lIframeShadowHost.highlight();

        // shadow dom inside iframe -> click dark mode toggle button
        page.frameLocator("div[data-test='shadow-host'] #nested-shadow-host #nested-iframe")
                .locator("#iframe-shadow-host")
                .locator("#dark-mode-toggle")
                .click();

        // switch to regular dom
        highlightElement(page.locator("//h3[text()='Regular DOM Content']"));

        System.out.println("Success");
    }
}
