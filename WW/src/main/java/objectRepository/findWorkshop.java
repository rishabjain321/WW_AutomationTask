package objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testBase.basicSetup;

public class findWorkshop extends basicSetup {

	private static By locationInput= By.id("location-search");
	private static By searchLocationArrow= By.className("rightArrow-daPRP");
	private static By workshops= By.className("linkContainer-1NkqM");
	private static By workshopDistances= By.className("distance-OhP63");
	
	public static WebElement elementFinder(String s) {
		By element = null;
		switch(s.toLowerCase()) {
		case "location input field" :
			element = locationInput;
			break;
		case "search location button" :
			element = searchLocationArrow ;
			break;
		default:
			System.out.println("Enter Valid Value");
		}
		WebElement locator = driver.findElement(element);
		return locator;
	} 
	
	public static List<WebElement> elementListFinder(String s) {
		By element = null;
		switch(s.toLowerCase()) {
		case "workshops" :
			element = workshops;
			break;
		case "distance of workshops" :
			element = workshopDistances;
			break;
		default:
			System.out.println("Enter Valid Value");
		}
		List<WebElement> locator = driver.findElements(element);
		return locator;
	} 

}
