package org;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.MouseButton;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DoubleWindow {
    @Test
    public void doubleWindow() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
            Page page = browser.newPage();
            page.navigate("https://the-internet.herokuapp.com/windows");
            page.click("a[href='/windows/new']");

            Page newPage = page.context().waitForPage(() -> {
                page.click("a[href='/windows/new']");
            });
            newPage.waitForLoadState();
            String expectedText = "New Window";
            String actualText = newPage.textContent("h3");
            if (expectedText.equals(actualText)) {
                System.out.println("succes");
            } else {
                System.out.println("insucces");
            }
            newPage.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("new_window.png")));
            newPage.close();


            // Wait a bit to observe the result (optional)
            page.waitForTimeout(2000);
            browser.close();


        } catch (Exception e) {
            System.out.println("something went wrong");
        }
    }

    private static boolean isModalDisplayed(Page page){
        return page.isVisible((".modal"));
    }

    private static void checkAndCloseModal(Page page){
        if(isModalDisplayed(page)){
            String modalText = page.textContent(".modal-title");
            System.out.println("Modal text: " + modalText);
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("modal")));
            page.click(".modal-footer");
            System.out.println("Modal closed");

        }else{
            System.out.println("No modal is displayed");
        }
    }
    private static void triggerExitIntent(Page page){
        page.mouse().move(0,0);
    }

    @Test
    public void entryAd() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
            Page page = browser.newPage();
            page.navigate("https://the-internet.herokuapp.com/entry_ad");
            checkAndCloseModal(page);
            page.click("a#restart-ad");
            page.reload();
            checkAndCloseModal(page);
            page.reload();
            if(!isModalDisplayed(page)){
                System.out.println("Correct");
            }else{System.out.println("Incorrect");}
        }
    }

    @Test
    public void exitAd(){
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
            Page page = browser.newPage();
            page.navigate("https://the-internet.herokuapp.com/exit_intent");
            triggerExitIntent(page);
                if (isModalDisplayed(page)) {
                System.out.println("Confirmation: The modal is displayed after triggering exit intent.");
            } else {
                System.out.println("Error: The modal is not displayed after triggering exit intent.");
            }
            checkAndCloseModal(page);
            browser.close();
        }
    }

    @Test
    public void downloadFile(){
        try(Playwright playwright = Playwright.create()){
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
            Page page = browser.newPage();
            page.navigate("https://the-internet.herokuapp.com/download");
            Locator fileLink = page.locator("a[href='download/Profile_YashBarfa.png']");
            if(fileLink.count()==1){
                System.out.println("File is present. proceed to download");

                Download download = page.waitForDownload(()->{ page.getByText("Profile_YashBarfa.png").click();});
                download.saveAs(Paths.get("Profile_YashBarfa.png"));

            }else{
                System.out.println("File is not present");
            }
browser.close();
        }
    }


        public static void main (String[]args){



    }
}