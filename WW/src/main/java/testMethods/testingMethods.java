package testMethods;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import objectRepository.workshop;
import testBase.basicSetup;

public class testingMethods extends basicSetup{
			
	static JavascriptExecutor js = (JavascriptExecutor)driver;
	
	public static void clickElement(WebElement element) throws InterruptedException {
		System.out.println("clickElement started.");
		element.click();
		System.out.println("clickElement completed.");
	}
	
	public static void sendValue(WebElement element, String value) {
		System.out.println("sendValue started.");
		element.sendKeys(value);
		System.out.println("sendValue completed.");
	}

	public static void scroll(WebElement element, String direction) {
		System.out.println("scroll" + direction +" started.");
		while((element.isDisplayed()!= true)){
			if(direction.equalsIgnoreCase("down")) {
				js.executeScript("window.scrollBy(0,250)","");
			}else {
				js.executeScript("window.scrollBy(0,-250)", "");
			}
		}
		System.out.println("scroll" + direction +" completed.");
	}
	
	public static void scrollToElement(WebElement element) {
		System.out.println("scroll to element started.");
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		System.out.println("scroll completed.");
	}

	public static void bussinessHours() {
		System.out.println("Finding business hours started.");
		String day = LocalDate.now().getDayOfWeek().name();
		System.out.println(day);
		int i =0;
		switch(day) {
		case "SUNDAY" :
			i =0;
			break;
		case "MONDAY":
			i=1;
			break;
		case "TUESDAY" :
			i =2;
			break;
		case "WEDNESDAY":
			i=3;
			break;
		case "THURSDAY" :
			i =4;
			break;
		case "FRIDAY":
			i=5;
			break;
		case "SATURDAY" :
			i =6;
			break;
		}
		String times = workshop.elementListFinder("store bussiness hours").get(i).getText();
		System.out.println("Today's Bussiness Hours: "+ times);
		System.out.println("Finding business hours completed.");
	}

	public static void printMeetings(String value) {
		System.out.println("Printing Meetings for "+ value + "started.");
		int day =0;
		switch(value.toLowerCase().substring(0, 3)) {
		case "sun" :
			day =7;
			break;
		case "mon":
			day=8;
			break;
		case "tue" :
			day =9;
			break;
		case "wed":
			day=10;
			break;
		case "thu" :
			day =11;
			break;
		case "fri":
			day=12;
			break;
		case "sat" :
			day =13;
			break;
		default:
			System.out.println("Enter Valid Value");
		}
		String sundaySchedule =  workshop.elementListFinder("virtual schedule").get(day).getText();
		HashMap<String, Integer>details = new HashMap<String, Integer>();
		String[] scheduleBreakup = sundaySchedule.split("\\r?\\n");
		for(int i=2;i<scheduleBreakup.length;i=i+2) {
			if(details.containsKey(scheduleBreakup[i])) {
				details.put(scheduleBreakup[i], details.get(scheduleBreakup[i])+1);
			}else {
				details.put(scheduleBreakup[i], 1);
			}
		}

		for (Map.Entry<String, Integer> entry : details.entrySet()) { 
			System.out.println(entry.getKey() + " " + entry.getValue()); 
		} 
		System.out.println("Printing Meetings completed.");
	}

}