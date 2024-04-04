package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtilities {
	
	public static void takeScreenshot(WebDriver driver, String fileName) {
		
		
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		
		File destinationFile = new File("./ScreenShots/" + fileName + timestamp + ".png");
		try {
			FileHandler.copy(screenshotFile, destinationFile);
		} 
		catch (IOException e) {
			System.out.println("Can't Copy the Screenshot to a File");
		}
		
	}
	
	public static void takeScreenshot(WebElement element, String fileName) {
		
		File screenshotFile = element.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("./Utilities/Screenshots/" + fileName + ".png");
		try {
			FileHandler.copy(screenshotFile, destinationFile);
		} 
		catch (IOException e) {
			System.out.println("Can't Copy the Screenshot to a File");
		}
		
	}

}
