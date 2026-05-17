package org.luv2code.o8_advance_features;

import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class DebuggingToolsTest extends BaseTest {

    @Test
    void debuggingToolsTest() {


        // click on "Registration Form" link
        page.click("text=Registration Form");

        //page.pause();

        // check presence of "User Registration Form" heading
        highlightElement(page.locator("//h1[text()='User Registration Form']"));

        // enter full name
        page.locator("#fullName").fill("BhaJha");

        // enter password
        page.locator("#password").fill("BhaJha");

        // enter email
        page.locator("input[name='email']").fill("BhaJha@gmail.com");

        // enter phone number
        page.locator("input[type='number']").fill("9876543210");

        // enter date of birth
        page.locator("#birthDate").pressSequentially("12/05/2026");

        // enter address
        page.locator("#address").fill("123 My Street, Himachal Pradesh, India");

        // select country from dropdown
        page.selectOption("#country", "India");

        // choose gender
        page.locator("#gender-male").click();

        // click on accepts terms
        page.locator("#terms").click();
        // click on submit button
        page.click("//button[@type='submit']");
        //page.locator("//button[@type='submit']").click();

        // verify details on registration success page
        highlightElement(page.locator("//td[text()='Full Name']/../td[text()='BhaJha']"));

    }

}
