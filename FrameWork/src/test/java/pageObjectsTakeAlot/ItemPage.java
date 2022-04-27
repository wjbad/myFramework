package pageObjectsTakeAlot;

import org.openqa.selenium.By;

import frameWorkClasses.BasePage;

public class ItemPage extends BasePage {

	public String checkElementOfFirstItem() {
		String text1 = getElementText(By.cssSelector(".title-content-list a"));
		return text1;
	}
	
	public String checkElementOfFirstItem2() {
		String text2 = getElementText(By.cssSelector("h1"));
		return text2;
	}
	
	
}
