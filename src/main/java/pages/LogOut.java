package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.ExcelUtility;
import utilities.LoadProperties;

public class LogOut {
	public static WebElement element = null;
	static Properties dataPropertyObject = new LoadProperties().load();
	ExcelUtility excel = new ExcelUtility(dataPropertyObject.getProperty("XPATH_FILE"), "LoginPage");

	//Logout Expansion Button
	public WebElement logoutExpansion(WebDriver chrome_webDriver) {
		String logoutExpansion = excel.getData(4, 1).toString();
		element = chrome_webDriver.findElement(By.xpath("//a[contains(@id,'"+logoutExpansion+"')]"));
		return element;
	}

	//Logout Button
	public WebElement logoutButton(WebDriver chrome_webDriver) {
		element = chrome_webDriver.findElement(By.xpath("//a[@href ='/index.php/auth/logout']"));
		return element;
	}
}