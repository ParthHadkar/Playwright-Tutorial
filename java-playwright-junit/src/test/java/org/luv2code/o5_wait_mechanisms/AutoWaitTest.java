package org.luv2code.o5_wait_mechanisms;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class AutoWaitTest extends BaseTest {

    @Test
    void autoWaitTest() {

        // navigate to dynamic-elements page
        page.navigate("https://www.luv2test.com/#/dynamic-elements");

        // set timeout (page-level)
        page.setDefaultTimeout(2000); // 2 seconds

        // set navigation timeout
        page.setDefaultNavigationTimeout(3000); // 2 seconds

        // playwright automatically waits for elements to appear, be visible and stable
        Locator lDynamicLocator = page.locator("//li[text()='Tip: Use keyboard shortcuts to improve productivity']");
        highlightElement(lDynamicLocator);
        waitInSeconds(2);

        // auto-wait ensures these calls wait until element is ready
        System.out.println(lDynamicLocator.isVisible());
        System.out.println(lDynamicLocator.textContent());
    }

}
