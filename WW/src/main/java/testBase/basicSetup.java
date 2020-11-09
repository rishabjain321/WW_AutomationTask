package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class basicSetup {
	public static WebDriver driver;
	public static Properties prop  = new Properties();
	
	public static WebDriver initializeDriver() throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\data.properties");
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\browsers\\chromedriver.exe");
			driver = new ChromeDriver();

		}
		
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Browser_Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();			
		}
		
		else if(browserName.equals("ie"))
		{
			 System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\Browser_Drivers\\IEDriverServer.exe");  
			driver = new InternetExplorerDriver();			
		}
		return driver;

	}
	
	public static void openBrowser(){
		System.out.println("Open Browser started.");
		String baseURL = prop.getProperty("testSiteUrl");
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Browser Ready.");
	}
	
	public static void closeBrowser(){
		System.out.println("Closing Browser.");
		driver.close();
		System.out.println("Browser closed.");
	}

}
