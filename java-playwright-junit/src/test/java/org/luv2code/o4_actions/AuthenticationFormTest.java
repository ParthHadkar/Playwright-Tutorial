package org.luv2code.o4_actions;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class AuthenticationFormTest extends BaseTest {

    @Test
    void authenticationFormTest() {

        // click on "Authentication" link
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions()
                .setName("Authentication").setExact(true)).click();

        // check the presence of "Authentication" heading
        page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions()
                .setName("Authentication")).isVisible();

        // check the presence of "Welcome!" heading
        page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions()
                .setName("Welcome!")).isVisible();

        // send username to "username" text field
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions()
                .setName("username")).fill("admin");

        // send password to "password" text field
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions()
                .setName("password")).fill("admin");

        // click on "Sign In" button
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions()
                .setName("Sign In")).click();

        // check the presence of "Login Successful" heading
        page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions()
                .setName("Login Successful")).isVisible();

        // click on "Logout" button
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions()
                .setName("Logout")).click();

        // check the presence of "Welcome!" heading
        page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions()
                .setName("Welcome!")).isVisible();

        System.out.println("Success");
    }
}
