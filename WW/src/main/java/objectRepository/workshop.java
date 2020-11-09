package objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testBase.basicSetup;

public class workshop extends basicSetup {
	
	private static By workshopHeading= By.className("locationName-1jro_");
	private static By announcement= By.className("title-kZzZL");
	private static By bussinessHoursDropdown= By.className("title-3o8Pv");
	
	private static By schedules= By.className("day-NhBOb");
	private static By bussinessHours= By.className("times-fms3v");
	
	public static WebElement elementFinder(String s) {
		By element = null;
		switch(s.toLowerCase()) {
		case "workshop name" :
			element = workshopHeading ;
			break;
		case "important announcements" :
			element = announcement ;
			break;
		case "bussiness hours dropdown" :
			element = bussinessHoursDropdown ;
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
		case "virtual schedule" :
			element = schedules;
			break;
		case "store bussiness hours" :
			element = bussinessHours;
			break;
		default:
			System.out.println("Enter Valid Value");
		}
		List<WebElement> locator = driver.findElements(element);
		return locator;
	} 
}
