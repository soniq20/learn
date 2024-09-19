package org;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.MouseButton;

public class Context {
    public static void main(String[] args) {
        // Initialize Playwright and launch a browser
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
            Page page = browser.newPage();

            // Navigate to the context menu page
            page.navigate("https://the-internet.herokuapp.com/context_menu");

            // Locate the box element
            Locator box = page.locator("#hot-spot");

            // Right-click on the box to trigger the context menu
            box.click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));


            // Handle the alert dialog
            page.onDialog(dialog -> {
                // Get the text from the alert dialog
                String alertText = dialog.message();

                // Check if the expected text is present
                if (alertText.equals("You selected a context menu")) {
                    System.out.println("Confirmation: The alert text is correct.");
                } else {
                    System.out.println("Alert text does not match the expected value.");
                }

                // Accept the dialog to close it
                dialog.accept();
            });

            // Wait a bit to observe the result (optional)
            page.waitForTimeout(2000);

            // Close the browser
            browser.close();
        }
    }
}