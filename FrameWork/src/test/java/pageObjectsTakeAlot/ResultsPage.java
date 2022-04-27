package pageObjectsTakeAlot;

import org.openqa.selenium.By;

import frameWorkClasses.BasePage;

public class ResultsPage extends BasePage{
	
	/* 2
	 * GIVEN the shopper is on the landing page == LandingPage.checkLandingPageNavigation()
	 * WHEN he enters "DKNY" as the search string == LandingPage.searchForItem("DKNY")
	 * AND clicks the search button == LandingPage.clickSearchButton()
	 * THEN "DKNY" is displayed as the first item in the grid == ResultsPage.checkItemName
	 */
	
	public boolean checkItemName(String checkItemName) {
		return false;
	}
	
	/*3
	 * GIVEN the shopper selected an item == ResultsPage.checkItemName
	 * WHEN the shopper adds the item to the cart == ResultsPAge.clickAddToCartButton
	 * WHEN the shopper goes to the cart == ResultsPage.clickCartButton
	 * THEN item is added to the cart == CartPage.itemDisplayedInCart
	 */
	
	
	
	public void clickElementTextOfFirstItem() {
	//clickElement(By.cssSelector("div:nth-of-type(2) > .grid.search-product  .product-anchor.product-card-module_product-anchor_TUCBV.sponsered"));
	clickElement(By.cssSelector("div:nth-of-type(2) > .grid.search-product  .product-anchor.product-card-module_product-anchor_TUCBV"));
	}
	
	public void clickElementTextOfFirstItem2() {
		//clickElement(By.cssSelector("div:nth-of-type(2) > .grid.search-product  .product-anchor.product-card-module_product-anchor_TUCBV.sponsered"));
		clickElement(By.cssSelector("div:nth-of-type(4) > .grid.search-product  .product-anchor.product-card-module_product-anchor_TUCBV"));
		}

	public String checkFirstItemBrand() {
		String textFirstItem = getElementText(By.cssSelector(".title-content-list a"));
		return textFirstItem;
	}

	public void checkFirstItemDescription() {
		clickElement(By.cssSelector("div:nth-of-type(2) > .grid.search-product  .product-anchor.product-card-module_product-anchor_TUCBV"));
	}

	public Object checkReview() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void clickAddtoCart() {
		clickElement(By.linkText("Add to Cart"));
	}
	
	public void clickGoToCart() {
		clickElement(By.cssSelector(".content-wrapper .checkout-now"));
	}
	
	public int getUnitPrice( ) {
		String unitPriceString = getElementText(By.cssSelector("[data-ref='buybox-price-main']"));
		//String unitPriceRstripped = unitPriceString.substring(2);
		//String unitPrice = unitPriceRstripped.replaceAll(",", "");
		//String unitPrice = unitPriceString.replaceAll("[^0-9]", "");
		String unitPrice = unitPriceString.replaceAll("\\D",  "");
		int unitPriceInt = Integer.parseInt(unitPrice);
		return unitPriceInt;
	}
}
