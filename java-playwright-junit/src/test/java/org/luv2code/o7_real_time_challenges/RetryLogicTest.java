package org.luv2code.o7_real_time_challenges;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class RetryLogicTest extends BaseTest {

    @Test
    void retryLogicTest() {

        // locate authentication link
        Locator lAuthenticationLink = page.locator("//h3[text()='Authentication']");

        // refresh the page
        page.reload();

        // playwright locator is live, so this  works directly without retry
        lAuthenticationLink.click();

        // retry logic (rarely needed in playwright)
        int lAttempts = 0;
        while (lAttempts < 3) {
            try {
                lAuthenticationLink.click();
                break; //success
            }
            catch (Exception pEx) {
                System.out.println("Playwright exception caught. Retrying.... "+(lAttempts + 1));
                lAuthenticationLink = page.locator("//h3[text()='Authentication']");
            }
            lAttempts++;
        }

        if (lAttempts == 3) {
            System.out.println("failed to click after retries");
        }
        waitInSeconds(2);
    }

}
