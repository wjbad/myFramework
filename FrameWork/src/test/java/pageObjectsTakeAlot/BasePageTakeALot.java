package pageObjectsTakeAlot;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import frameWorkClasses.BasePage;

public class BasePageTakeALot extends BasePage {

	
	
	
	public void ClickCookiesButton() {
	//String cookiesButton = ".button.cookies-banner-module_dismiss-button_24Z98";
	//if(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cookiesButton)) != null)
	//clickElement(By.cssSelector(cookiesButton));
		try {
			clickElement(By.cssSelector(".button.cookies-banner-module_dismiss-button_24Z98")); }
		catch(Exception e) {
			System.out.println("cookie not there");
			//e.printStackTrace();
		}
	}
	
	public void quizPopUp() {
		String nextButton = "_hj-3HqTJ__styles__surveyActionButton";
		try { 
			clickElement(By.className("_hj-2fsWS__styles__closeEndedOptionText"));
			clickElement(By.className(nextButton));
			clickElement(By.className(nextButton));
			clickElement(By.className("_hj-3Y4y-__styles__closeButton")); }
		
		catch(Exception e) {
			System.out.println("survey not there");
			e.printStackTrace();
		}
	}

	//Method: Go to home page
	
	public void navigateToHomePage() {
		driver.get("https://www.takealot.com");
		waitForUrl(30, "takealot");
		}
}
