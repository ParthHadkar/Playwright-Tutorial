package org.luv2code.o3_quick_start;

import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class FinalTest extends BaseTest {

    @Test
    void runFinalTest() {
        // click on Authentication link
        page.click("text=Authentication");

        // verify Login heading is present.
        boolean lIsHeadingPresent = page.locator("//h2[text()='Login']").isVisible();
        System.out.println("Is Login form heading present: "+ lIsHeadingPresent);
    }

}
