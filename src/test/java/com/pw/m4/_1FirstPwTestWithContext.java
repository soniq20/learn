package com.pw.m4;

import com.microsoft.playwright.*;
import com.pw.ScriptBase;
import org.junit.jupiter.api.*;

import static java.lang.System.getProperty;

public class _1FirstPwTestWithContext extends ScriptBase {

    @Test
    public void firstPlaywrightTestWithContext(){

            page.navigate(home);
            Assertions.assertEquals(page.title(), "Home Page");

    }
    @Test
    public void secondPlaywrightTestWithContext(){

            page.navigate(home);
            String content = page.content();
            Assertions.assertTrue(content.contains("Cat In The Bag"));


    }

}
