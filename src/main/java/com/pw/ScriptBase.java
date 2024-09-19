package com.pw;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static java.lang.System.getProperty;

public abstract class ScriptBase {
    protected final String webDir = "file:///" + getProperty("user.dir") + "\\src\\web\\";
    protected String home = webDir + "home.html";
    protected String advantages = webDir + "advantages.html";

    protected static Playwright playwright;
    protected static Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeAll
    static  void launchBrowser(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
    }

    @BeforeEach
    void createContextAndPage(){
        context = browser.newContext();
        page = context.newPage();
        page.setViewportSize(880, 680);
    }

    @AfterEach
    void closeContext(){
        context.close();
    }

    @AfterAll
    static void closeBrowser(){
        browser.close();;
        playwright.close();
    }





}
