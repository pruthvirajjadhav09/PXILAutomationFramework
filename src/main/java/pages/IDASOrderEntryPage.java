package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.ExcelUtility;
import utilities.LoadProperties;

public class IDASOrderEntryPage {
	public static WebElement element = null;
	static Properties dataPropertyObject = new LoadProperties().load();
	ExcelUtility excel = new ExcelUtility(dataPropertyObject.getProperty("XPATH_FILE"), "HomePage");
	//Trading Tab
	public WebElement tradingTab(WebDriver chrome_webDriver) {
//		excel = new ExcelUtility(dataPropertyObject.getProperty("XPATH_FILE"), "HomePage");
		element = chrome_webDriver.findElement(By.xpath("//*[@id='mnuMainMenu']/ul/li[2]/a"));
		return element;
	}
	//UPC Order Entry Tab
	public WebElement idasOrderEntryTab(WebDriver chrome_webDriver) {
//		String upcOrderEntryTab = excel.getData(2, 1).toString();
		element = chrome_webDriver.findElement(By.xpath("//*[@id='mnuMainMenu']/ul/li[2]/ul/li[1]/a"));		
		return element;
	}
	//Product
	public WebElement product(WebDriver chrome_webDriver) {
		element = chrome_webDriver.findElement(By.xpath("//*[@id=\"s2id_ddlproduct\"]/a"));
		return element;
	}
	//Delivery To Date
	public WebElement delToDate(WebDriver chrome_webDriver) {
		element = chrome_webDriver.findElement(By.id("txtNrToDate"));
		return element;
	}
	//Password
	public WebElement password(WebDriver chrome_webDriver) {
		String password = excel.getData(5, 1).toString();
		element = chrome_webDriver.findElement(By.xpath("//input[contains(@id,'"+password+"')]"));
		return element;
	}
	//Confirm Password
	public WebElement confirmPassword(WebDriver chrome_webDriver) {
		String confirmPassword = excel.getData(6, 1).toString();
		element = chrome_webDriver.findElement(By.xpath("//input[contains(@id,'"+confirmPassword+"')]"));
		return element;
	}
	//Save Button
	public WebElement saveButton(WebDriver chrome_webDriver) {
		String saveButton = excel.getData(7, 1).toString();
		element = chrome_webDriver.findElement(By.xpath("//input[contains(@id,'"+saveButton+"')]"));
		return element;
	}
	//Search User Name
	public WebElement search_UN(WebDriver chrome_webDriver) {
		String search_UN = excel.getData(8, 1).toString();
		element = chrome_webDriver.findElement(By.xpath("//input[contains(@id,'"+search_UN+"')]"));
		return element;
	}
	//Search Button
	public WebElement searchButton(WebDriver chrome_webDriver) {
		String searchButton = excel.getData(9, 1).toString();
		element = chrome_webDriver.findElement(By.xpath("//input[contains(@id,'"+searchButton+"')]"));
		return element;
	}
	//Verified Record
	public WebElement verifiedRecord(WebDriver chrome_webDriver) {
		String verifiedRecord = excel.getData(10, 1).toString();
		element = chrome_webDriver.findElement(By.xpath("//div[contains(@id,"+verifiedRecord+")]/table/tbody/tr[1]/td[2]/a"));
		return element;
	}
}
