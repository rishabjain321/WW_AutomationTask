package tests;

import java.io.IOException;
import java.text.Normalizer;

import junit.framework.Assert;
import objectRepository.findWorkshop;
import objectRepository.mainPage;
import objectRepository.workshop;
import testBase.basicSetup;
import testMethods.testingMethods;

public class mainPageTests extends testingMethods{
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		basicSetup.initializeDriver();
		basicSetup.openBrowser();
		Thread.sleep(2000);
		String Title = driver.getTitle().trim();
		Assert.assertEquals(Title, "WW (Weight Watchers): Weight Loss & Wellness Help | WW USA");
		clickElement(mainPage.elementFinder("Close Find location Popup"));
		clickElement(mainPage.elementFinder("find workshop"));
		Thread.sleep(2000);
		String Title2 = driver.getTitle().trim();
		Title2 = Normalizer.normalize(Title2, Normalizer.Form.NFKC);
		Assert.assertTrue(Title2.contains("Find WW Studios & Meetings Near You | WW USA"));
		sendValue(findWorkshop.elementFinder("location input field"), "10011");
		clickElement(findWorkshop.elementFinder("search location button"));
		Thread.sleep(2000);
		scrollToElement(findWorkshop.elementListFinder("workshops").get(0));
		String workshopName = findWorkshop.elementListFinder("workshops").get(0).getText();
		System.out.println("Nearest workshop found is: " + workshopName);
		String distance = findWorkshop.elementListFinder("distance of workshops").get(0).getText();
		System.out.println("Its distance is: "+distance);
		clickElement(findWorkshop.elementListFinder("distance of workshops").get(0));
		Thread.sleep(2000);
		scrollToElement(workshop.elementFinder("workshop name"));
		String workshopTitle = workshop.elementFinder("workshop name").getText();
		Assert.assertEquals(workshopTitle, workshopName);
		scrollToElement(workshop.elementFinder("bussiness hours dropdown"));
		Thread.sleep(5000);
		clickElement(workshop.elementFinder("bussiness hours dropdown"));
		bussinessHours();
		scrollToElement(workshop.elementFinder("important announcements"));
		printMeetings("tue");
		basicSetup.closeBrowser();
	}
	
	
	

}
