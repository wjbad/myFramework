package pageObjectsTakeAlot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import frameWorkClasses.BasePage;

public class LandingPage extends BasePage {
	
	//lp.checkLandingPageNavigation();
	//lp.selectItem("DailyDeals");
	//lp.checkURL("Takealot/deals");
	//lp.checkFirstItem("PhillipsAirFryer)
	
	public boolean checkLandingPageNavigation() {
		return false;
	}
	
	public void selectItem(String selectItem) {
		
	}
	
	/*
	 * GIVEN the shopper is on the landing page == LandingPage.checkLandingPageNavigation()
	 * WHEN the shopper clicks on the Cart button == LandingPage.clickCartButton()
	 * THEN check that the shopper is on the cart page == CartPage.checkCartPageNavigation()
	 * AND check that Cart is empty is displayed == CartPage.displayEmptyCart("Your shopping cart is empty")
	 */
	public void clickCartButton() {
		
	}
	
	/* 2
	 * GIVEN the shopper is on the landing page == LandingPage.checkLandingPageNavigation()
	 * WHEN he enters "DKNY" as the search string == LandingPage.searchForItem("DKNY")
	 * AND clicks the search button == LandingPage.clickSearchButton()
	 * THEN "DKNY" is displayed as the first item in the grid == ResultsPage.checkItemName
	 * WHEN going to the home page
	 */
	
	public void enterTextInSearchBar(String enterTextInSearchBar) {
		enterText(By.name("search"), enterTextInSearchBar);
	}
	
	public void clickSearchButton() {
		clickElement(By.cssSelector("button[type='submit']"));
	}
	
	public void clickSearchBar() {
		clickElement(By.name("search"));  
	}
	
	public String checkElementOfFirstItem() {
		//getElementText(By.cssSelector("div:nth-of-type(2) > .grid.search-product  .product-anchor.product-card-module_product-anchor_TUCBV.sponsered"));
		//String text1 = getElementText(By.cssSelector("div:nth-of-type(2) > .grid.search-product  .product-anchor.product-card-module_product-anchor_TUCBV.sponsered"));
		String text1 = getElementText(By.cssSelector("div:nth-of-type(2) > .grid.search-product  .product-anchor.product-card-module_product-anchor_TUCBV"));
		//System.out.println(text1);
		return text1;
	}
	
	public boolean cartSummary(String checkCount) throws InterruptedException {
		Thread.sleep(2000);
		String itemElement = ".badge-button-module_badge-button-outer_1gN1K";
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
	
}
