package testsTakeAlot;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import frameWorkClasses.ReadExcel;
import pageObjectsTakeAlot.BasePageTakeALot;
import pageObjectsTakeAlot.CartPage;
import pageObjectsTakeAlot.CheckOutPage;
import pageObjectsTakeAlot.DealsPage;
import pageObjectsTakeAlot.EmptyCartPage;
import pageObjectsTakeAlot.ItemPage;
import pageObjectsTakeAlot.LandingPage;
import pageObjectsTakeAlot.LoginPage;
import pageObjectsTakeAlot.ResultsPage;

public class Tests {
	
	@BeforeTest
	public void setUp() {
	basePageTakeALot.ClickCookiesButton();
	//basePageTakeALot.quizPopUp();
	}
	
	//@AfterTest
	//public void cleanUp() {
		//closeBrowser();
	//}
	
	
	//@BeforeTest
	//public void setUp2() {
	//basePageTakeALot.ClickCookiesButton2();
	//}
	
	//Instantiate the landing page class
	LandingPage landingPage = new LandingPage();
	CartPage cartPage = new CartPage();
	LoginPage loginPage = new LoginPage();
	ResultsPage resultPage = new ResultsPage();
	DealsPage dealPage = new DealsPage();
	CheckOutPage checkOutPage = new CheckOutPage();
	BasePageTakeALot basePageTakeALot = new BasePageTakeALot();
	ItemPage itemPage = new ItemPage();
	SoftAssert softAssertion = new SoftAssert();
	EmptyCartPage emptyCartPage = new EmptyCartPage();
	ReadDataFromExcel readDataFromExcel = new ReadDataFromExcel();
	ReadExcel rExcel = new ReadExcel();
	
	/*1
	 * GIVEN the shopper is on the landing page
	 * WHEN the shopper clicks on the cart button
	 * THEN check that the shopper is on the cart page
	 * AND check that cart is empty is displayed
	 */

	/*2
	* GIVEN the shopper is on the landing page
	* WHEN he enters "DKNY" as the search string
	* WHEN clicks the search button
	* THEN "DKNY" is displayed as the first item in the grid
	*/
	

	
	/*3
	 * GIVEN the shopper selected an item
	 * WHEN the shopper adds the item to the cart
	 * THEN item is added to the cart
	 */
	
	/*4
	 * demo - antoinette
	 * LandingPage.checkLandingPageNavigation();
	 * LandingPage.selectItem("DailyDeals");
	 * DealsPage.checkURL("Takealot/deals");
	 * DealsPage.checkFirstItem("PhillipsAirFryer");
	 */
	//GIVEN_shopperIsOnTheLandingPage_WHEN_shopperClicksOnTheDailyDeals_THEN_checkURL_AND_checkFirstItem
	
	//1
	//@Test
	//public void GIVEN_shopperInOnTheLandingPage_WEHN_shopperClicksCartButton_THEN_ChecksThatShopperIsONCartPAge_THEN_CheckThatCartIsEmpty() {
		
	//}
	
	//2
	@Test
	public void GIVEN_shopperOnLandingPage_WHEN_shopperEntersDKNYasTheSearchString_AND_shopperClicksTheSearchButton_THEN_DKNYBeDeliciousIsDisplayed() throws InterruptedException {
		//Variables
		String searchInput = "DKNY";
		String expectedText = searchInput;
		String actualText;
		//Process
		basePageTakeALot.navigateToHomePage();
		landingPage.clickSearchBar();
		landingPage.enterTextInSearchBar(searchInput);
		landingPage.clickSearchButton();
		Thread.sleep(4000);
		//landingPage.checkElementOfFirstItem();
		resultPage.clickElementTextOfFirstItem();
		resultPage.SwitchToNewTab();
		actualText = itemPage.checkElementOfFirstItem();
		System.out.println("Print the text " + " " + actualText );
		//itemPage.checkElementOfFirstItem();
		Reporter.log("Expected Value  " + " " + expectedText + " and Actual Value " + actualText);
		
		softAssertion.assertEquals("sdfsdf", "sdfsdfkkkk", "Soft assertion");
		//Assert.assertEquals(resultPage.checkFirstItemBrand("DKNY"), true);
		//Assert.assertEquals(resultPage.checkFirstItemDescription("DKNY"), true);
		Assert.assertEquals(resultPage.checkReview(), true);
		softAssertion.assertEquals("Charlotte", "Louise", "2ndSoft assertion");
		resultPage.closeChildBrowserTab();
		softAssertion.assertAll("All soft assertions:");
		//Assert.assertEquals(expectedText, actualText);
		//resultPage.closeChildBrowserTab();
	}
	
	//3
	@Test
	public void GIVEN_shopperOnLandingPage_WHEN_shopperEnterBOOTasTheSearchString_AND_shopperClicksTheSearchButton_THEN_BOOT() throws InterruptedException {
		//Variables
		String searchInput = "boot";
		String expectedBrand = "FitFlop";
		String actualBrand;
		String actualItemDescription;
		String expectedItemDescription = searchInput;
		//Process
		basePageTakeALot.navigateToHomePage();
		landingPage.clickSearchBar();
		landingPage.enterTextInSearchBar(searchInput);
		landingPage.clickSearchButton();
		Thread.sleep(4000);
		//landingPage.checkElementOfFirstItem();
		resultPage.clickElementTextOfFirstItem2();
		resultPage.SwitchToNewTab();
		actualBrand = itemPage.checkElementOfFirstItem2();
		System.out.println("Print the text " + " " + actualBrand );
		actualItemDescription = itemPage.checkElementOfFirstItem2();
		System.out.println("The heading of the first item is text " +  actualItemDescription);
		//itemPage.checkElementOfFirstItem();
		Reporter.log("Expected Brand  " + " " + expectedBrand + " and Actual Brand " + actualBrand);
		Reporter.log("Expected Description  " + " " + expectedItemDescription + " and Actual Description " + actualItemDescription);
		Assert.assertEquals(actualBrand, expectedBrand);
		Assert.assertTrue(actualItemDescription.contains("FitFlop"));
		resultPage.closeChildBrowserTab();
	}
	//4
	@Test
	public void GIVEN_shopperAddstoCart() throws InterruptedException {
	
	String searchInput = "DKNY";
	String expectedText = searchInput;
	String actualText;
	//String actualItemDescription = resultPage.clickElementTextOfFirstItem();
	basePageTakeALot.navigateToHomePage();
	landingPage.clickSearchBar();
	landingPage.enterTextInSearchBar(searchInput);
	landingPage.clickSearchButton();
	Thread.sleep(4000);
	//landingPage.checkElementOfFirstItem();
	resultPage.clickElementTextOfFirstItem();
	resultPage.SwitchToNewTab();
	
	//Assert.assertTrue(actualItemDescription.contains("DKNY"));
	
	resultPage.clickAddtoCart();
	Thread.sleep(2000);
	resultPage.clickGoToCart();
	
	Assert.assertEquals(cartPage.checkCartCount("(1 item)"), true);
	
	basePageTakeALot.closeChildBrowserTab();
	}
	
	//5
		@Test
		public void GIVEN_shopperDKNY_checkAmount() throws InterruptedException {
		
		String searchInput = "DKNY";
		String expectedText = searchInput;
		String actualText;
		//String actualItemDescription = resultPage.clickElementTextOfFirstItem();
		basePageTakeALot.navigateToHomePage();
		landingPage.clickSearchBar();
		landingPage.enterTextInSearchBar(searchInput);
		landingPage.clickSearchButton();
		Thread.sleep(4000);
		//landingPage.checkElementOfFirstItem();
		resultPage.clickElementTextOfFirstItem();
		resultPage.SwitchToNewTab();
		//resultPage.getUnitPrice();
		int unitPrice = resultPage.getUnitPrice();
		//System.out.println(unitPrice*3);
		resultPage.clickAddtoCart();
		resultPage.clickGoToCart();
		
		Assert.assertEquals(cartPage.checkCartCount("1 item"),true);
		cartPage.selectQuantity("2");
		
		Assert.assertEquals(cartPage.checkCartCount("2 item"),true);
		cartPage.selectQuantity("1");
		
		Assert.assertEquals(cartPage.checkCartCount("1 item"),true);
		cartPage.removeFromCart();
		
		Assert.assertEquals(emptyCartPage.checkEmptyCart(),true);
		Assert.assertEquals(emptyCartPage.checkEmptyCartWithIsDisplayed(),true);
		
		basePageTakeALot.closeChildBrowserTab();
		
		}
		
		//6
		@Test
		public void GIVEN_shopperDKNY_cartSummary() throws InterruptedException {
			basePageTakeALot.navigateToHomePage();
			Assert.assertEquals(landingPage.cartSummary("0"), true);
		}
		
		//7
				@Test
				public void GIVEN_shopperDKNY_checkWishList() throws InterruptedException {
				
				String searchInput = "DKNY";
				String expectedText = searchInput;
				String actualText;
				//String actualItemDescription = resultPage.clickElementTextOfFirstItem();
				basePageTakeALot.navigateToHomePage();
				landingPage.clickSearchBar();
				landingPage.enterTextInSearchBar(searchInput);
				landingPage.clickSearchButton();
				Thread.sleep(4000);
				//landingPage.checkElementOfFirstItem();
				resultPage.clickElementTextOfFirstItem();
				resultPage.SwitchToNewTab();
			
				resultPage.clickAddtoCart();
				resultPage.clickGoToCart();
				
				Assert.assertEquals(cartPage.checkCartCount("1 item"),true);
				
				//cartPage.moveToWishList();
				
				Assert.assertEquals(emptyCartPage.checkEmptyCart(),true);
				Assert.assertEquals(emptyCartPage.checkEmptyCartWithIsDisplayed(),true);
				Thread.sleep(8000);
				//landingPage.clickWishList();
				//landingPage.checkURL("wishlist");
				basePageTakeALot.closeChildBrowserTab();
				
				}
				
				//8
				
				@DataProvider(name = "Brand and Quantity")
				public Object[][] getDataFromExcel() throws IOException{
					String excelDIrectory = rExcel.getDataConfigProperties("excelDataDir");
					Object[][] errObj = rExcel.getExcelData(excelDIrectory +"BrandANDQuantity.xlsx", "Sheet1");
					return errObj;
				}
				
				@Test(dataProvider="Brand and Quantity")
				public void GIVEN_useExcelSheetForData(String brand, String quantity) throws InterruptedException {
				
				String searchInput = brand;
				String expectedText = searchInput;
				String actualText;
				//String actualItemDescription = resultPage.clickElementTextOfFirstItem();
				basePageTakeALot.navigateToHomePage();
				landingPage.clickSearchBar();
				landingPage.enterTextInSearchBar(searchInput);
				landingPage.clickSearchButton();
				}
}
