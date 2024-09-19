package com.pw.m3;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

import static java.lang.System.getProperty;

public class _3CssSelector {
    String home = "file:///" + getProperty("user.dir") + "\\src\\web\\home.html";

    @Test
    public void cssSelectorTest() {
        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.chromium();
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
            Page page = browser.newPage();
            page.navigate(home);

            page.fill("input", "first input box that PW finds");
            page.fill(".form-control", "First box with this class");
            page.fill("form #exampleFormControlInput1", "Combined");
            page.fill(":nth-match(.form-control, 1)", "Hello there stran ger");
        }
    }
}