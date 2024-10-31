package Task27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question1 {

	public static void main(String[] args) {
		// Initialize the WebDriver
		WebDriver driver = new ChromeDriver();
		// Maximize the browser window
		driver.manage().window().maximize();
		try {
			// Step 1: Open the specified URL
			driver.get("https://the-internet.herokuapp.com/windows");

			Thread.sleep(3000);
			
			// Step 2: Click the button to open a new window
			driver.findElement(By.linkText("Click Here")).click();

			// Step 3: Switch to the newly opened window
			String originalWindow = driver.getWindowHandle();
			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}
			Thread.sleep(3000);
			// Step 4: Verify that the text "New Window" is present on the page
			String pageSource = driver.getPageSource();
			if (pageSource.contains("New Window")) {
				System.out.println("Text 'New Window' is present on the page.");
			} else {
				System.out.println("Text 'New Window' is NOT present on the page.");
			}

			// Step 5: Close the new window
			driver.close();

			// Step 6: Switch back to the original window
			driver.switchTo().window(originalWindow);
			Thread.sleep(3000);
			// Verify the original window is active
			String currentWindow = driver.getWindowHandle();
			if (currentWindow.equals(originalWindow)) {
				System.out.println("The original window is active.");
			} else {
				System.out.println("The original window is NOT active.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser instance
			driver.quit();
		}
	}
}
