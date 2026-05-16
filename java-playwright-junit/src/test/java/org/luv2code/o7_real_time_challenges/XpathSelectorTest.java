package org.luv2code.o7_real_time_challenges;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class XpathSelectorTest extends BaseTest {

    @Test
    void xpathSelectorTest() {

        // navigate to our User Registration Form
        page.navigate("https://www.luv2test.com/#/registration-form");

        // 1. Xpath by Tag Name
        highlightElement(page.locator("//input").first());// resolved to 9 elements
        waitInSeconds(2);

        // 2. Xpath by ID
        Locator lNameField = page.locator("//input[@id='fullName']");
        lNameField.fill("Val");
        waitInSeconds(2);

        // 3. Xpath by Class Name
        page.locator("//label[contains(@class,'w-32')]");

        // 4. Xpath by Attributes
        page.locator("//input[@type='password']");// //*[@type='password'] not preferable

        // 5. Xpath by Tag + Class
        page.locator("//input[@class='accent-blue-500']");

        // 6. Xpath by Tag + ID
        page.locator("//input[@id='profilePicture']");

        // 7. Xpath by Tag + Attributes
        page.locator("//input[@type='file']");

        // 8. Xpath Multiple Attributes
        page.locator("//input[@type='radio'][@id='gender-male']");

        // 9. Xpath Starts with
        page.locator("//input[starts-with(@name,'full')]");

        // 10. Xpath Ends with
        page.locator("//input[substring(@name,string-length(@name) - string-length('Name')+1)='Name']");

        // 11. Xpath Contains
        page.locator("//input[contains(@id,'Num')]");

        // 12. Xpath Direct Child
        page.locator("//div/h1");

        // 13. Xpath Descendant
        page.locator("//div/p");

        // 14. Xpath Immediate sibling
        page.locator("//label/following-sibling::label[1]");

        // 15. Xpath General sibling
        page.locator("//button/following-sibling::div");

        // 16. Xpath Not selector
        page.locator("//button[not(@type='submit')]");

        // 17. Xpath nth-child
        page.locator("//ul/li[2]");

        // 18. Xpath first-child
        page.locator("//ul/li[1]");

        // 19. Xpath last-child
        page.locator("//ul/li[last()]");
    }

}
