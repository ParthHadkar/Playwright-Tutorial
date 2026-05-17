package org.luv2code.o9_junit;

import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertionsRegistrationFormTest extends BaseTest {

    @Test
    void assertionsRegistrationFormTest(){

        String lExpectedName = "Val";
        String lExpectedEmail = "Val@gmail.com";
        String lExpectedPhone = "9876543211";

        // click on "Registration Form" link
        page.click("text=Registration Form");

        // check presence of "User Registration Form" heading
        highlightElement(page.locator("//h1[text()='User Registration Form']"));

        // enter full name
        page.locator("#fullName").fill(lExpectedName);

        // enter password
        page.locator("#password").fill("BhaJha");

        // enter email
        page.locator("input[name='email']").fill(lExpectedEmail);

        // enter phone number
        page.locator("input[type='number']").fill(lExpectedPhone);

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

        // verify details on registration success page
        highlightElement(page.locator("//td[text()='Full Name']/../td[text()='Val']"));

        // validate registration success page using Assertions

        String lActualName = page.locator("//td[text()='Full Name']/../td[2]").innerText();
        assertEquals(lExpectedName, lActualName);
        String lActualEmail = page.locator("//td[text()='Email']/../td[2]").innerText();
        assertEquals(lExpectedEmail, lActualEmail);
        String lActualPhone = page.locator("//td[text()='Phone']/../td[2]").innerText();
        assertEquals(lExpectedPhone, lActualPhone);

        waitInSeconds(3);

    }

}
