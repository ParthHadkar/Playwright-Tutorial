package org.luv2code.o4_actions;

import com.microsoft.playwright.FrameLocator;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class FrameHandlingTest extends BaseTest {

    @Test
    void frameHandlingTest() {

        // navigate to alert page
        page.navigate("https://www.luv2test.com/#/iframes");

        // locate the input field and fill name (Note this will not work because the text field is inside iframe)
        //page.locator("#input-name").fill("ValPinto");

        // locate the input field under "Single Iframe" and perform fill operations
        var lSingleIframe = page.frameLocator("#iframe1");
        lSingleIframe.locator("#input-name").fill("ValPinto");
        lSingleIframe.locator("#input-password").fill("ValPinto");

        // SWITCH TO IFRAME 2 then inner iframe
        var lIframe2 = page.frameLocator("#iframe2");
        lIframe2.frameLocator("iframe").locator("#inner-input-name").fill("BhaJha");
        lIframe2.frameLocator("iframe").locator("#inner-input-password").fill("BhaJha");

        //get text from parent iframe (outer frame)
        String lOuterFrameDescription = lIframe2.locator("//p[text()='This iframe contains a nested inner iframe.']").innerText();
        System.out.println("Outer frame description: "+lOuterFrameDescription);

        //back to main page
        String lPageDescription = page.locator("//p[contains(text(),'Practice working with iframes,')]").innerText();
        System.out.println("Page description: "+lPageDescription);


        System.out.println("Success");
    }
}
