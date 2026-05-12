package org.luv2code.o4_actions;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

import java.nio.file.Paths;

public class FileHandlingTest extends BaseTest {

    @Test
    void fileHandlingTest() {

        // navigate to file upload page
        page.navigate("https://www.luv2test.com/#/file-upload");
        page.waitForTimeout(2000);

        // file upload with absolute path
        Locator lFileField = page.locator("#file-upload");
        lFileField.setInputFiles(Paths.get("D:\\Parth\\New Coding\\Playwright Tutorial\\java-playwright-junit\\src\\main\\resources\\files\\1.webp"));

        waitInSeconds(3);
        page.reload();
        waitInSeconds(2);

        // upload file using relative path
        String lPath = System.getProperty("user.dir");
        String lFilePath = lPath + "\\src\\main\\resources\\files\\2.jpg";
        page.locator("#file-upload").setInputFiles(Paths.get(lFilePath));

        waitInSeconds(3);

    }
}
