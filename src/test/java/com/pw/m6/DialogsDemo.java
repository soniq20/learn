package com.pw.m6;

import com.pw.ScriptBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DialogsDemo extends ScriptBase {

    @Test
    public void alertTest(){
        page.navigate(home);
        page.fill("#donation", "50");

        page.onDialog(dialog -> {
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
                    dialog.accept();
        });

        page.click("#submit-donation");
        Assertions.assertTrue(page.isVisible("text=Thank you"));
    }

    @Test
    public void confirmTestAccept(){
        page.navigate(home);
        page.fill("#donation", "2000");

        page.onDialog(dialog -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Dialog type found:" + dialog.type());
        });

        page.click("#submit-donation");
        Assertions.assertTrue(page.isVisible("text=Thank you for your generosity"));
    }
}
