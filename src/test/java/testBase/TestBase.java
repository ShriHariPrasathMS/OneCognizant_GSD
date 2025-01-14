package testBase;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pageObjects.BeCognizantPage;
import pageObjects.LiveSupportGSDPage;
import pageObjects.OneCognizantHomePage;
import utilities.PropertyUtilities;

public class TestBase {

	public WebDriver driver;
	public BeCognizantPage beCognizantPage;
	public OneCognizantHomePage oneCogHomePage;
	public LiveSupportGSDPage gsdPage;
	public PropertyUtilities propertyUtility;
	public Logger logger;
	
	@Parameters({"browser"})
	@BeforeClass
	public void setup(String browser) throws InterruptedException {
		
		//Loading log4j2 file
		logger = LogManager.getLogger(this.getClass());
		//this.getClass() will return each class with has test-cases
		
		
		
		//Creating new Respective-Driver
		switch (browser) {
		case "Chrome":
			driver = new ChromeDriver();
			break;
		case "Edge":
			Thread.sleep(10000);
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Incorrect Browser-Name");
		}
		//Maximizing the browser
		driver.manage().window().maximize();
		//Implicit Wait for every elements about 10s
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Navigating to Be.Cognizant
		propertyUtility = new PropertyUtilities();
		driver.get(propertyUtility.getURL());
		//For Authentication, we apply sleep //and catching the exception it throws
		Thread.sleep(30000);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
