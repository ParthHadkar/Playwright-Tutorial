package org.luv2code.o10_framework_tests;

import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;
import org.luv2code.framework.page.HomePage;
import org.luv2code.framework.page.RegistrationPage;

public class RegistrationTest extends BaseTest {

    @Test
    void registrationTest() {

        HomePage lHomePage = new HomePage(page);
        RegistrationPage lRegistrationPage = new RegistrationPage(page);

        // click on "Registration Form" link
        lHomePage.clickRegistrationLink();
        waitInSeconds(1);

        // check presence of "User Registration Form" heading
        lRegistrationPage.verifyRegistrationFormHeading();
        waitInSeconds(1);

        // enter full name
        lRegistrationPage.enterFullName("BhaJha");
        waitInSeconds(1);

        // enter password
        lRegistrationPage.enterPassword("BhaJha");
        waitInSeconds(1);

        // enter email
        lRegistrationPage.enterEmail("BhaJha@gmail.com");
        waitInSeconds(1);

        // enter phone number
        lRegistrationPage.enterPhone("9876543210");
        waitInSeconds(1);

        // enter date of birth
        lRegistrationPage.enterBirthDate("12/05/2026");
        waitInSeconds(1);

        // enter address
        lRegistrationPage.enterAddress("123 My Street, Himachal Pradesh, India");
        waitInSeconds(1);

        // select country from dropdown
        lRegistrationPage.enterCountry("India");
        waitInSeconds(1);

        // choose gender
        lRegistrationPage.clickMaleGender();
        waitInSeconds(1);

        // click on accepts terms
        lRegistrationPage.acceptTerms();
        waitInSeconds(1);

        // click on submit button
        lRegistrationPage.clickSubmitButton();
        waitInSeconds(1);

        // verify details on registration success page
        lRegistrationPage.verifyRegistrationSuccess();
        waitInSeconds(1);

    }

}
