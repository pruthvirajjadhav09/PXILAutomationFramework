package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.ExcelUtility;
import utilities.LoadProperties;

public class Login {
	public static WebElement element =null;
	static Properties dataPropertyObject = new LoadProperties().load();
	ExcelUtility excel = new ExcelUtility(dataPropertyObject.getProperty("XPATH_FILE"), "LoginPage");
	//Username
	public WebElement username(WebDriver chrome_webDriver) {
		ExcelUtility excel = new ExcelUtility(dataPropertyObject.getProperty("XPATH_FILE"), "LoginPage");
		String username = excel.getData(1, 1).toString();
		element = chrome_webDriver.findElement(By.xpath("//input[contains(@id,'"+username+"')]"));
		return element;
	}
	//Password
	public WebElement password(WebDriver chrome_webDriver) {
		String password = excel.getData(2, 1).toString();
		element = chrome_webDriver.findElement(By.xpath("//input[contains(@id,'"+password+"')]"));
		return element;
	}
	//Login Button
	public WebElement loginButton(WebDriver chrome_webDriver) {
		String loginButton = excel.getData(3, 1).toString();
		element = chrome_webDriver.findElement(By.xpath("//a[contains(@id,'"+loginButton+"')]"));
		return element;
	}

}
