package org.luv2code.o7_real_time_challenges;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

import java.util.List;

public class BrokenLinksTest extends BaseTest {

    @Test
    void brokenLinksTest() {

        // get all link URLs
        List<String> lLinkUrls = (List<String>) page.locator("a").evaluateAll(
                "elements => elements.map(el => el.href)"
        );

        System.out.println("Total links found: "+lLinkUrls.size());

        // create a playwright request context
        APIRequestContext lApiRequestContext = page.context().request();

        for (String lLinkUrl : lLinkUrls) {
            try {
                APIResponse lApiResponse = lApiRequestContext.get(lLinkUrl);
                int lStatus = lApiResponse.status();
                if (lStatus >= 400) {
                    System.err.println("Broken Link: "+lLinkUrl+" -Status: "+lStatus);
                }
                else {
                    System.out.println("Valid Link: "+lLinkUrl+" -Status: "+lStatus);
                }
            } catch (Exception lEx) {
                System.err.println("Error checking Link: "+lLinkUrl+" - "+lEx.getMessage());
            }
        }

    }

}
