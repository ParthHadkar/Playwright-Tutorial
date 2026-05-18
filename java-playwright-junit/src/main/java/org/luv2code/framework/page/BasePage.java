package org.luv2code.framework.page;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.luv2code.framework.utils.ConfigUtil;

public abstract class BasePage {

    protected Page page;

    public BasePage(Page pPage) {
        this.page = pPage;
    }

    // common actions

    // check presence of element
    public void shouldBeDisplayed(String pSelector) {
        long lStartTime = System.currentTimeMillis();
        System.out.println("Finding element: " + pSelector);
        Locator pLocator = page.locator(pSelector);
        pLocator.waitFor(); // ensure locator is attached & visible

        long lEndTime = System.currentTimeMillis();
        long lDuration = lEndTime - lStartTime;
        System.out.println("Element found: " + pSelector + " in " + lDuration + " ms");

        if (ConfigUtil.getProperty("debug").equalsIgnoreCase("true")) {
            highlightElement(pLocator);
        }
    }

    public static void highlightElement(Locator pLocator) {
        ElementHandle lElementHandle = pLocator.elementHandle();
        if (lElementHandle != null) {
            pLocator.page().evaluate("e => { e.style.border='3px solid red'; " +
                    "e.style.backgroundColor='yellow';}", lElementHandle);
        }
    }

    public void click(String pSelector) {
        page.locator(pSelector).first().click();
    }

    public void click(Locator pLocator) {
        pLocator.click();
    }

    // type / fill
    public void type(String pSelector, String pText) {
        page.locator(pSelector).fill(pText);
    }

    // get text
    public String getText(String pSelector) {
        return page.locator(pSelector).innerText();
    }

    // get title
    public String getTitle() {
        return page.title();
    }

    // more as per need ....

}
