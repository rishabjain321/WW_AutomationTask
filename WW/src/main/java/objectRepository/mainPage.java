package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testBase.basicSetup;

public class mainPage extends basicSetup{
	
	private static By locationPopUpCloseButton = By.className("IconButton_icon-button__1FbvG");//3 index
	private static By findWorkshop= By.className("Menu_list-item__1F0Km");//5th index

	public static WebElement elementFinder(String s) {
		WebElement element = null;
		switch(s.toLowerCase()) {
		case "close find location popup" :
			element = driver.findElements(locationPopUpCloseButton).get(3);
			break;
		case "find workshop" :
			element = driver.findElements(findWorkshop).get(4) ;
			break;
		default:
			System.out.println("Enter Valid Value");
		}
		return element;

	}
}
