package org.luv2code.o4_actions;

import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class RegistrationFormTest extends BaseTest {

    @Test
    void registrationFormTest() {

        // click on "Registration Form" link
        page.click("text=Registration Form");

        // check presence of "User Registration Form" heading
        highlightElement(page.locator("//h1[text()='User Registration Form']"));

        // enter full name
        page.locator("#fullName").fill("BhaJha");
        waitInSeconds(1);

        // enter password
        page.locator("#password").fill("BhaJha");
        waitInSeconds(1);

        // enter email
        page.locator("input[name='email']").fill("BhaJha@gmail.com");
        waitInSeconds(1);

        // enter phone number
        page.locator("input[type='number']").fill("9876543210");
        waitInSeconds(1);

        // enter date of birth
        page.locator("#birthDate").pressSequentially("12/05/2026");
        waitInSeconds(1);

        // enter address
        page.locator("#address").fill("123 My Street, Himachal Pradesh, India");
        waitInSeconds(1);

        // select country from dropdown
        page.selectOption("#country", "India");
        waitInSeconds(1);

        // choose gender
        page.locator("#gender-male").click();
        waitInSeconds(1);

        // click on accepts terms
        page.locator("#terms").click();
        waitInSeconds(1);
        // click on submit button
        page.click("//button[@type='submit']");
        //page.locator("//button[@type='submit']").click();
        waitInSeconds(1);

        // verify details on registration success page
        highlightElement(page.locator("//td[text()='Full Name']/../td[text()='BhaJha']"));
        waitInSeconds(1);

    }

}
