package com.pw.m6;

import com.microsoft.playwright.Page;
import com.pw.ScriptBase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class ScreenshotDemo extends ScriptBase {

    @Test
    public void screenshotTest(){
        page.navigate(home);
        page.selectOption("select#contactReason", "Bored");
        assertTrue(page.isVisible("#boredOption"));
        page.selectOption("select#contactReason","Question");


        assertTrue(page.isVisible("#boredOption"), "The blue box should've disappeared after selecting another option");

    }
    @AfterEach
    public void cleanup(){
        page.screenshot((new Page.ScreenshotOptions().setPath(Paths.get("box.png"))));
    }




    @Test
    public void evalOnSelector(){
        page.navigate(home);
        page.evalOnSelector("#hero-banner", "e => e.remove()");
        assertFalse(page.isVisible("#hero-banner"));
    }
    @Test
    public void evalOnSelectorAll(){
        page.navigate(advantages);
        Object obj = page.evalOnSelectorAll(".feature", "f => f.length");
        assertEquals(3, obj);

    }

}
