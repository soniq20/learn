package com.pw;

import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

public class PlaywrightTest {
    @Test
    public void firstTest(){
        Playwright pw = Playwright.create();
    }

}
