package org.luv2code.o5_wait_mechanisms;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class ExplicitWaitTest extends BaseTest {

    @Test
    void explicitWaitTest() {

        // navigate to dynamic-elements page
        page.navigate("https://www.luv2test.com/#/dynamic-elements");

        // locate the dynamic tip and highlight the same
        Locator lDynamicLocator = page.locator("//li[text()='Tip: Use keyboard shortcuts to improve productivity']");
        highlightElement(lDynamicLocator);
        waitInSeconds(2);

        // slider element
        Locator lSlider = page.locator("//input[@data-test='load-time-slider']");
        lSlider.click(new Locator.ClickOptions().
                setPosition( (lSlider.boundingBox().width) * 0.5,
                        lSlider.boundingBox().height / 2));

        // explicit wait in playwright
        Locator lDidYouKnow = page.locator("//li[text()='Did you know? You can undo closed tabs with Ctrl+Shift+T']");
//        lDidYouKnow.waitFor(new Locator.WaitForOptions().setTimeout(20000));
//        highlightElement(lDidYouKnow);
        waitInSeconds(2);

        // wait for selector
        page.waitForSelector("//li[text()='Did you know? You can undo closed tabs with Ctrl+Shift+T']",
                new Page.WaitForSelectorOptions().setTimeout(20000));
        highlightElement(lDidYouKnow);
        waitInSeconds(2);

    }

}
