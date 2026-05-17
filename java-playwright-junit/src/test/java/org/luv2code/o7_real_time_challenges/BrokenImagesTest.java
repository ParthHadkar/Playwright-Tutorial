package org.luv2code.o7_real_time_challenges;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

import java.util.List;

public class BrokenImagesTest extends BaseTest {

    @Test
    void brokenImagesTest() {

        // navigate to broken images page
        page.navigate("https://www.luv2test.com/#/broken-images");

        // get all image URLs
        List<String> lImageUrls = (List<String>) page.locator("img").evaluateAll(
                "elements => elements.map(el => el.src)"
        );

        System.out.println("Total images found: "+lImageUrls.size());

        // create a playwright request context
        APIRequestContext lApiRequestContext = page.context().request();

        for (String lImageUrl : lImageUrls) {
            try {
                APIResponse lApiResponse = lApiRequestContext.get(lImageUrl);
                int lStatus = lApiResponse.status();
                if (lStatus >= 400) {
                    System.err.println("Broken Image: "+lImageUrl+" -Status: "+lStatus);
                }
                else {
                    System.out.println("Valid Image: "+lImageUrl+" -Status: "+lStatus);
                }
            } catch (Exception lEx) {
                System.err.println("Error checking Image: "+lImageUrl+" - "+lEx.getMessage());
            }
        }

    }

}
