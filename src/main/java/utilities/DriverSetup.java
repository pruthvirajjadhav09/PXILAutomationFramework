package utilities;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetup {
	public WebDriver chrome_webDriver=null;
	public WebDriver setup() {
		//Initializing the Driver using the Properties
		Properties dataPropertyObject = new LoadProperties().load();
		System.setProperty("webdriver.chrome.driver", "D:/PXIL/Automation Testing/ChromeDriver/chromedriver(2).exe");
		chrome_webDriver=new ChromeDriver();
		//Login to Pratyay
		chrome_webDriver.get(dataPropertyObject.getProperty("URL"));
		chrome_webDriver.manage().window().maximize();
		return chrome_webDriver;	
	}

}
