package com.pw.m6;

import com.microsoft.playwright.Download;
import com.pw.ScriptBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DownloadDemo extends ScriptBase {

 /*   @BeforeEach
    @Override
    public void createContextAndPage(){
        context = browser.newContext();
        page = context.newPage();
        page.setViewportSize(880, 680);
    }*/

    @Test
    public void doawnloadTestWithHandler(){

        page.navigate(home);
        page.onDownload(download -> {
            System.out.println(download.path());
            download.saveAs(Paths.get(new File("C:\\Users\\shuma\\PlaywrightDownloads\\downloads.zip").toURI()));
        });


        page.click("text=Download ZIP");
    }

    @Test
    public void downloadTestWithWaitForEvent(){
        page.navigate(home);


        Download download = page.waitForDownload(()->{
            page.click("text=Download ZIP");
        });
        Path path = download.path();
        System.out.println(path);

    }

    @Test
    public void downloadPDF(){
        page.navigate(home);

        Download download = page.waitForDownload(
                () -> page.click("text=Download")
        );

        System.out.println(download.path());
        download.saveAs(Paths.get(new File("C:\\Users\\shuma\\PlaywrightDownloads\\downloaded-headless-pdf").toURI()));

    }
}
