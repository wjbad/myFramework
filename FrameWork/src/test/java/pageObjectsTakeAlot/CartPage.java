package pageObjectsTakeAlot;

import org.openqa.selenium.By;
import org.testng.Reporter;

import frameWorkClasses.BasePage;

public class CartPage extends BasePage {
	
	//cart.checkCartStatus();
	//cart.selectItem(""PhillipsAirFryer");
	//cart.checkURL("Takealot/deals");
	
	public boolean checkCartPageNavigation() {
		return false;
	}
	
	public boolean checkCartStatus() {
		return false;
	}
	
	public boolean checkCartCount(String checkCount) throws InterruptedException {
		Thread.sleep(2000);
		String itemElement = ".cart-summary-module_cart-summary-item-count_3jkNC > span";
		System.out.println(getElementText(By.cssSelector(itemElement)));		
		System.out.println(checkCount);
		
		if (getElementText(By.cssSelector(itemElement)).contains(checkCount))
			
		{
			Reporter.log("Amount Correct " + checkCount);
			Reporter.log("Text is " + getElementText(By.cssSelector(itemElement)));
			return true;
		}
		
			Reporter.log("Amount inCorrect " + checkCount);
			Reporter.log("Text is " + getElementText(By.cssSelector(itemElement)));
			return false;
		}
	
	
	public boolean checkEmptyCartMessage(String emptyCartMessage) {
		return false;
	}
	
	public void selectQuantity(String qunt) throws InterruptedException {
		selectDropDown(By.id("cart-item_undefined"), qunt);
		
	}

	public void removeFromCart() {
		clickElement(By.cssSelector(".button.clear.remove-item"));

	}

		
		
}
