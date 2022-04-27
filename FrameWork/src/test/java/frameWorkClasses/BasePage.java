package frameWorkClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	//Declare the web driver
	public static WebDriver driver;
	
	//Constructor of the base class - Check if the driver started
	//Set the Browser and URL
	public BasePage() {
	if (driver == null) {
		//Set Parameter values
		String browser = getDataConfigProperties("browser");
		String URL = getDataConfigProperties("URL");
		String pdriverDir = getDataConfigProperties("pdriverDir");
//		String chromebrowser = "chrome";
//		String firefoxbrowser = "firefox";
//		String edgebrowser = "edge";
//		String URL = "https://www.takealot.com/";
//		String pdriverDir = "C:\\Selenium\\";
		// String pdriverDirFireFox = getDataConfirgPropeties("driverdirFirefox");
		// String pdriverDirEdge = getDataConfirgPropeties("driverdirEdge");

		//check if parameter passed as "chrome"
		if (browser.equalsIgnoreCase("chrome")) {
		//Set path to chromedriver.exe
		System.setProperty("webdriver.chrome.driver", pdriverDir + "chromedriver.exe");
		//create an instance of chrome
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
//		else if (firefoxbrowser.equalsIgnoreCase("firefox")) {
//			//Set path to firefoxdriver.exe
//			System.setProperty("webdriver.firefox.driver", pdriverDir + "geckodriver.exe");
//			//create an instance of firefox
//			driver = new FirefoxDriver();
//			driver.get(URL);
//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			}
//		else if (edgebrowser.equalsIgnoreCase("edge")) {
//			//Set path to edgedriver.exe
//			System.setProperty("webdriver.edge.driver", pdriverDir + "msedgedriver.exe");
//			//create an instance of edge
//			driver = new EdgeDriver();
//			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
		
	}
	
	
	//Create a method to read the config
	public String getDataConfigProperties(String propertyName) {
		//Properties set
		Properties p = new Properties();
		InputStream is = null;
		try {
			is = new FileInputStream("config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			p.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p.getProperty(propertyName);
		
	}
	
	
	//Method to wait for element
	public void waitForElement(int elementWait, By pLocator) {
		WebDriverWait wait = new WebDriverWait(driver, elementWait);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(pLocator));
		}
	
	//Method: Wait for click
	public void waitforClick(int elementWait, By pLocator) {
		WebDriverWait wait = new WebDriverWait(driver, elementWait);
		wait.until(ExpectedConditions.elementToBeClickable(pLocator));
		}
	
	//...Wait to disappear
	public void waitToDisappear(int elementWait, By pLocator) {
		WebDriverWait wait = new WebDriverWait(driver, elementWait);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(pLocator));
	}
	
	//Method: Get element text
	public String getElementText(By pLocator) {
		String elementText = getElement(pLocator).getText();
		return elementText;
	}
	
	//Wait for URL
	public void waitForUrl(int elementWait, String urlContains) {
		WebDriverWait wait = new WebDriverWait(driver, elementWait);
		wait.until(ExpectedConditions.urlContains(urlContains));
		}
	
	//Method: Get current URL
	public String getURL() {
		String getCurrentURL = driver.getCurrentUrl();
		return getCurrentURL;
	}
	
	//Method: Click element
	public void clickElement(By pLocator) {
		waitforClick(30, pLocator);
		getElement(pLocator).click();
		}
		
	//Method: Check if element exists
	public boolean elementExists(By pLocator) {
		boolean display = getElement(pLocator).isDisplayed();
		return display;
	}
	
	//Method: Get element
	public WebElement getElement(By pLococator) {
		waitforClick(30, pLococator);
		return driver.findElement(pLococator);
		}
	
	//Method: Clean up driver
	public void cleanUp() {
		driver.close();
	}
	
	//Method: Enter text
	public void enterText(By pLocator, String enterText) {
		waitforClick(30, pLocator);
		driver.findElement(pLocator).sendKeys(enterText);
	}
	
	//Method: Clear text
	public void clearText(By pLocator) {
		waitforClick(30, pLocator);
		driver.findElement(pLocator).clear();
	}
	
	//Method: Select from drop down
	public void selectDropDown(By pLocator, String pValue) {
		//Create an instance of the dropdown object
		waitForElement(200,pLocator);
		Select sDrpDown = new Select(getElement(pLocator));
		// Populates the DropDwon
		sDrpDown.selectByVisibleText(pValue);
	}
	
	
	//Switch Window
	public void SwitchToNewTab() {
		Set<String> handles = driver.getWindowHandles(); //selenium will check how many windows are currently open
															// this will store the ID for both parent and child window
		Iterator<String> it = handles.iterator();		// using the it object you can access the ID
		String parentWindowID = it.next();
		String childWindowID = it.next();
		driver.switchTo().window(childWindowID); // switch to the new window by passing the ID of the child window
		}
	
	public void SwitchToParent() {
		Set<String> handles = driver.getWindowHandles(); //selenium will check how many windows are currently open
															// this will store the ID for both parent and child window
		Iterator<String> it = handles.iterator();		// using the it object you can access the ID
		String parentWindowID = it.next();
		String childWindowID = it.next();
		driver.switchTo().window(parentWindowID); // switch to the new window by passing the ID of the parent window
		}
	
	public void closeChildBrowserTab() {
		Set<String> handles = driver.getWindowHandles(); //selenium will check how many windows are currently open
														//this will store the ID for both parent and child window
		Iterator<String> it = handles.iterator();		// using the it object you can access the ID
		String parentWindowID = it.next();
		String childWindowID = it.next();
		driver.switchTo().window(childWindowID);
		driver.close();
		driver.switchTo().window(parentWindowID);
		}
	
	//Method: Get title
	public String getTitle() {
		String getTitle = driver.getTitle();
		return getTitle;
	}
	
}
