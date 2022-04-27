package pageObjectsTakeAlot;

import org.openqa.selenium.By;
import org.testng.Reporter;

import frameWorkClasses.BasePage;

public class EmptyCartPage extends BasePage {
	
	public boolean checkEmptyCart() {
		String itemElement = "img[alt='Empty shopping cart']";
		if (driver.findElements(By.cssSelector(itemElement)).size() != 0) {
			System.out.println("Element exists");
			Reporter.log("Element exists " + itemElement);
			Reporter.log("Text is " + getElementText(By.cssSelector(itemElement)));
			return true;	
		} else {
			System.out.println("Element doesn't exist");
			Reporter.log("Element does not exist " + itemElement);
			Reporter.log("Text is " + getElementText(By.cssSelector(itemElement)));
			return false;
		}
	}

	public boolean checkEmptyCartWithIsDisplayed() {
		String itemElement = "img[alt='Empty shopping cart']";
		Boolean Display = elementExists(By.cssSelector(itemElement));
		return Display;
	}


	
}
