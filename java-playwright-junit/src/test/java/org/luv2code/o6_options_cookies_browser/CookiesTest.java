package org.luv2code.o6_options_cookies_browser;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.Cookie;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CookiesTest {

    @Test
    void cookiesTest() {

        // open first browser and get cookies
        Playwright lPlaywright = Playwright.create();
        BrowserContext lBrowserContext1 = lPlaywright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newContext();
        Page lPage1 = lBrowserContext1.newPage();
        lPage1.navigate("https://www.luv2test.com/#/");

        // click on toggle theme button
        lPage1.waitForTimeout(2000);
        lPage1.click("button[data-test='theme-toggle']");
        lPage1.waitForTimeout(2000);

        // get all cookies from context
        List<Cookie> lCookies = lBrowserContext1.cookies();
        for (Cookie lCookie : lCookies) {
            System.out.println("Saved cookies: "+lCookie.name+" = "+lCookie.value);
        }
        for (Cookie lCookie : lCookies) {
            System.out.println("Domain: "+lCookie.domain);
            System.out.println("Path: "+lCookie.path);
            System.out.println("HttpOnly: "+lCookie.httpOnly);
            System.out.println("Secure: "+lCookie.secure);
        }

        // close the context
        lBrowserContext1.close();

        // open new browser and reuse cookies

        BrowserContext lBrowserContext2 = lPlaywright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newContext();
        Page lPage2 = lBrowserContext2.newPage();
        lPage2.navigate("https://www.luv2test.com/#/");

        // add cookies to new session
        lBrowserContext2.addCookies(lCookies);
        lPage2.waitForTimeout(2000);

        // refresh the page to apply cookies
        lPage2.reload();
        System.out.println("Cookies restore in new  session");
        lPage2.waitForTimeout(2000);

        // delete cookies
        lBrowserContext2.clearCookies(new BrowserContext.ClearCookiesOptions()
                .setName("theme")
                .setDomain("www.luv2test.com")
                .setPath("/")
        );

        lBrowserContext2.clearCookies(); // delete all cookies
        lPage2.waitForTimeout(2000);
        lPage2.reload();
        lPage2.waitForTimeout(2000);

        System.out.println("Cookies Deleted!!!");

        lBrowserContext2.close();
    }

}
