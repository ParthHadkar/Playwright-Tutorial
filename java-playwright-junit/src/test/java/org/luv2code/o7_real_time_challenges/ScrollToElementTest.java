package org.luv2code.o7_real_time_challenges;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class ScrollToElementTest extends BaseTest {

    @Test
    void scrollToElementTest() {

        // locate about link
        Locator lAboutLink = page.locator("//h3[text()='About']");
        highlightElement(lAboutLink);
        waitInSeconds(2);

        // scroll to element
        lAboutLink.scrollIntoViewIfNeeded();
        waitInSeconds(2);

        // click on about link
        lAboutLink.click();
        waitInSeconds(2);

        Locator lAboutHeading = page.locator("//h1[text()='Luv2Code Team and Automation Practice Site']");
        waitInSeconds(2);

        lAboutHeading.scrollIntoViewIfNeeded();
        highlightElement(lAboutHeading);
        waitInSeconds(2);


    }

}
