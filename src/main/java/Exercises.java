import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.options.MouseButton;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercises {
    @Test
    public void navigation() {
        try {
            Playwright playwright = Playwright.create();
            BrowserType chrome = playwright.chromium();
            Browser browser = chrome.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
            Page page = browser.newPage();
            page.navigate("https://the-internet.herokuapp.com/login");
            System.out.println(page.title());
//            page.click("id=username");
            page.fill("id=username", "tomsmith");
//            page.click("id=password");
            page.fill("id=password", "SuperSecretPassword!");
            page.click("button[type='submit']");
            String succesMessage = page.textContent((".flash.success"));
            if(succesMessage.contains("Welcome to the Secure Area. When you are done click logout below.")){
                System.out.println("Login successful");
            }else{
                System.out.println("Login failed");
            }
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("login_result.png")));

            browser.close();

        } catch (Exception e){
            System.out.println("something went wrong");
        }
    }

    @Test
    public void checkBox() {
        try{
            Playwright playwright = Playwright.create();
            BrowserType chrome = playwright.chromium();
            Browser browser = chrome.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
            Page page = browser.newPage();
            page.navigate("https://the-internet.herokuapp.com/checkboxes");
            System.out.println(page.title());
            Locator checkboxes = page.locator("input[type='checkbox']");
            for(int i=0; i<checkboxes.count(); i++){
                boolean isChecked = checkboxes.nth(i).isChecked();
                System.out.println("Checkbox " + (i+1) + " initially checked: " + isChecked);
                page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("initial_state.png")));
                checkboxes.nth(i).click();

                boolean isCheckedAfterClick = checkboxes.nth(i).isChecked();
                System.out.println("Checkbox " + (i+1) + " after click is checked: " + isCheckedAfterClick);
                page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("ifirst_click_state.png")));
                checkboxes.nth(i).click();
                System.out.println("Checkbox " + (i+1) + " after second click checked: " + checkboxes.nth(i).isChecked());
                page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("final_state.png")));
                browser.close();
            }
        } catch (Exception e){
            System.out.println("something went wrong");
        }
    }

    @Test
    public void checkPop() {
        try {
            Playwright playwright = Playwright.create();
            BrowserType chrome = playwright.chromium();
            Browser browser = chrome.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
            Page page = browser.newPage();
            page.navigate("https://the-internet.herokuapp.com/context_menu");
            System.out.println(page.title());
            Locator box = page.locator("#hot-spot");
            box.click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
            page.onDialog(dialog -> {
                String alertText = dialog.message();
                if(alertText.equals("You selected a context menu")){
                    System.out.println("Succes!");
                }else{System.out.println("Failure");
                }
                dialog.accept();
            });
            page.waitForTimeout(2000);
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("dialog_box.png")));
            browser.close();

        }catch (Exception e){
            System.out.println("something went wrong");
        }
    }




    public static void main(String[] args) {





    }

}
