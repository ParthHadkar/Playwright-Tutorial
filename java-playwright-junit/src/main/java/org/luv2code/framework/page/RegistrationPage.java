package org.luv2code.framework.page;

import com.microsoft.playwright.Page;

public class RegistrationPage extends BasePage {

    public RegistrationPage(Page pPage) {
        super(pPage);
    }

    // locators
    private final String registrationFormHeading = "//h1[text()='User Registration Form']";
    private final String fullNameField = "#fullName";
    private final String passwordField = "#password";
    private final String emailField = "input[name='email']";
    private final String phoneField = "input[type='number']";
    private final String birthDateField = "#birthDate";
    private final String addressTextArea = "#address";
    private final String countryDropdown = "#country";
    private final String maleGender = "#gender-male";
    private final String acceptTerms = "#terms";
    private final String submitButton = "//button[@type='submit']";
    private final String successNameCell = "//td[text()='Full Name']/../td[text()='BhaJha']";

    // actions
    public void verifyRegistrationFormHeading() {
        page.locator(registrationFormHeading).isVisible();
    }

    public void enterFullName(String pText) {
        type(fullNameField, pText);
    }

    public void enterPassword(String pText) {
        type(passwordField, pText);
    }

    public void enterEmail(String pText) {
        type(emailField, pText);
    }

    public void enterPhone(String pText) {
        type(phoneField, pText);
    }

    public void enterBirthDate(String pText) {
        page.locator(birthDateField).pressSequentially(pText);
    }

    public void enterAddress(String pText) {
        type(addressTextArea, pText);
    }

    public void enterCountry(String pText) {
        page.selectOption(countryDropdown, pText);
    }

    public void clickMaleGender() {
        click(maleGender);
    }

    public void acceptTerms() {
        click(acceptTerms);
    }

    public void clickSubmitButton() {
        click(submitButton);
    }

    public void verifyRegistrationSuccess() {
        page.locator(successNameCell).isVisible();
    }

}
