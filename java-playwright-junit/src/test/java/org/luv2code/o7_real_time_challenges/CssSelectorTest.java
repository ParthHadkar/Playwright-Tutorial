package org.luv2code.o7_real_time_challenges;

import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class CssSelectorTest extends BaseTest {

    @Test
    void cssSelectorTest() {

        // navigate to our User Registration Form
        page.navigate("https://www.luv2test.com/#/registration-form");

        // 1. Css Selector by Tag Name
        highlightElement(page.locator("input").first());// resolved to 9 elements
        waitInSeconds(2);

        // 2. Css Selector by ID
        page.locator("#fullName");
        waitInSeconds(2);

        // 3. Css Selector by Class Name
        page.locator("w-32.text-right.font-medium");

        // 4. Css Selector by Attributes
        page.locator("[type='password']");

        // 5. Css Selector by Tag + Class
        page.locator("input.accent-blue-500");

        // 6. Css Selector by Tag + ID
        page.locator("input#profilePicture");

        // 7. Css Selector by Tag + Attributes
        page.locator("input[type='file']");

        // 8. Css Selector Multiple Attributes
        page.locator("input[type='radio'][id='gender-male']");

        // 9. Css Selector Starts with (^)
        page.locator("input[name^='full']");

        // 10. Css Selector Ends with ($)
        page.locator("input[name$='Name']");

        // 11. Css Selector Contains (*)
        page.locator("input[id*='Num']");

        // 12. Css Selector Direct Child (>)
        page.locator("div > h1");

        // 13. Css Selector Descendant (space)
        page.locator("div p");

        // 14. Css Selector Immediate sibling (+)
        page.locator("label + label");

        // 15. Css Selector General sibling (~)
        page.locator("button ~ div");

        // 16. Css Selector Not selector
        page.locator("button:not([type='submit'])");

        // 17. Css Selector nth-child
        page.locator("ul li:nth-child(2)");

        // 18. Css Selector first-child
        page.locator("ul li:first-child");

        // 19. Css Selector last-child
        page.locator("ul li:last-child");
    }

}
