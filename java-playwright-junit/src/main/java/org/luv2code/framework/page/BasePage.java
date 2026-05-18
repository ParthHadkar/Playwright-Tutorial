package org.luv2code.framework.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public abstract class BasePage {

    protected Page page;

    public BasePage(Page pPage) {
        this.page = pPage;
    }

    // common actions
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
