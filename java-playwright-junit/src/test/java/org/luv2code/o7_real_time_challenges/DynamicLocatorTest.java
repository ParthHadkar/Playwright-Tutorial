package org.luv2code.o7_real_time_challenges;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class DynamicLocatorTest extends BaseTest {

    @Test
    void dynamicLocatorTest() {

        // navigate to 'dynamic elements' page
        page.navigate("https://www.luv2test.com/#/dynamic-elements");

        // locate the dynamic id button
        Locator lDynamicIdButton = page.locator("//button[contains(@id, 'btn_')]");
        highlightElement(lDynamicIdButton);
        lDynamicIdButton.click();

        // verify dynamic content
        Locator lDynamicContent =  page.locator("//div[contains(text(), 'Dynamic button clicked successfully!')]");
        System.out.println("Dynamic button clicked "+lDynamicContent.isHidden());
    }

}
