package Task27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question2 {
	public static void main(String[] args) {

		// Initialize the WebDriver
		WebDriver driver = new ChromeDriver();
		// Maximize the browser window
		driver.manage().window().maximize();

		try {
			// Step 1: Open the specified URL
			driver.get("http://the-internet.herokuapp.com/nested_frames");

			// Step 2: Verify that the page title is "Frames"
			String pageTitle = driver.getCurrentUrl();
			if (pageTitle.contains("frames")) {
				System.out.println("Verified: The page title is 'Frames'.");
			} else {
				System.out.println("Verification failed: The page title is not 'Frames'. Actual title: " + pageTitle);
			}

			// Step 3: Switch to the top frame
			driver.switchTo().frame("frame-top");

			// Step 4: Verify that there are three frames on the page
			int frameCount = driver.findElements(By.tagName("frame")).size();
			if (frameCount == 3) {
				System.out.println("Verified: There are three frames on the page.");
			} else {
				System.out.println("Verification failed: There are not three frames.");
			}

			// Step 5: Switch to the left frame
			driver.switchTo().frame("frame-left");
			String leftFrameText = driver.findElement(By.cssSelector("body")).getText();
			if (leftFrameText.equals("LEFT")) {
				System.out.println("Verified: The left frame has the text 'LEFT'.");
			} else {
				System.out.println("Verification failed: The left frame does not have the correct text.");
			}

			// Step 6: Switch back to the top frame
			driver.switchTo().parentFrame();

			// Step 7: Switch to the middle frame
			driver.switchTo().frame("frame-middle");
			String middleFrameText = driver.findElement(By.cssSelector("body")).getText();
			if (middleFrameText.equals("MIDDLE")) {
				System.out.println("Verified: The middle frame has the text 'MIDDLE'.");
			} else {
				System.out.println("Verification failed: The middle frame does not have the correct text.");
			}

			// Step 8: Switch back to the top frame
			driver.switchTo().parentFrame();

			// Step 9: Switch to the right frame
			driver.switchTo().frame("frame-right");
			String rightFrameText = driver.findElement(By.cssSelector("body")).getText();
			if (rightFrameText.equals("RIGHT")) {
				System.out.println("Verified: The right frame has the text 'RIGHT'.");
			} else {
				System.out.println("Verification failed: The right frame does not have the correct text.");
			}

			// Step 10: Switch back to the top frame
			driver.switchTo().parentFrame();

			// Step 11: Switch to the bottom frame
			driver.switchTo().frame("frame-bottom");
			String bottomFrameText = driver.findElement(By.cssSelector("body")).getText();
			if (bottomFrameText.equals("BOTTOM")) {
				System.out.println("Verified: The bottom frame has the text 'BOTTOM'.");
			} else {
				System.out.println("Verification failed: The bottom frame does not have the correct text.");
			}

			// Step 12: Switch back to the top frame
			driver.switchTo().parentFrame();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser instance
			driver.quit();
		}
	}
}
