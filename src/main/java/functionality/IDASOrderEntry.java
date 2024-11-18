package functionality;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
//import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;

import pages.Login;
import pages.UPCOrderEntryPage;
import utilities.ExcelUtility;
import utilities.LoadProperties;

public class IDASOrderEntry {

	Logger logger = LogManager.getLogger(Login.class); 
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	Properties dataPropertyObject = new LoadProperties().load();
	public void OrderEntry(WebDriver chrome_webDriver) {
		try {
			PropertyConfigurator.configure("log4j.properties");
			
			UPCOrderEntryPage upcoep = new UPCOrderEntryPage();
			
			Thread.sleep(2000);
			WebElement tradingTab = upcoep.tradingTab(chrome_webDriver);
			WebElement upcOrderEntryTab = upcoep.upcOrderEntryTab(chrome_webDriver);
//			WebElement product = upcoep.product(chrome_webDriver);
//			WebElement delToDate = upcoep.delToDate(chrome_webDriver);
			
			logger.info(dtf.format(now) + "--------------------------UPC Order Entry Screen-----------------------------");
			tradingTab.click();
			upcOrderEntryTab.click();
			Thread.sleep(2000);
			WebElement mw = chrome_webDriver.findElement(By.xpath("//div[contains(@class,'panel-heading')]"));
			
			mw.click();		
			WebElement productGroup = chrome_webDriver.findElement(By.xpath("//*[@id=\"s2id_ddlProductGroup\"]/a"));
			Thread.sleep(1000);
			productGroup.click();
			productGroup.sendKeys(Keys.ARROW_DOWN);
			productGroup.sendKeys(Keys.RETURN);
			ExcelUtility excel = new ExcelUtility(dataPropertyObject.getProperty("EXCEL_FILE"), "OrderEntry");
			for(int i=1;i<excel.getRowCount();i++) {
			WebElement product = chrome_webDriver.findElement(By.xpath("//*[@id=\"s2id_ddlproduct\"]/a"));
			Thread.sleep(1000);
			product.click();
			product.sendKeys(excel.getData(i, 0).toString());
			Thread.sleep(1000);
			product.sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			WebElement tmid = chrome_webDriver.findElement(By.xpath("//*[@id=\"s2id_ddlTMID\"]/a"));
			Thread.sleep(1000);
			tmid.click();
			tmid.sendKeys(excel.getData(i, 1).toString());
			tmid.sendKeys(Keys.ENTER);
			WebElement delToDate = chrome_webDriver.findElement(By.id("txtNrToDate"));
			delToDate.click();
//			delToDate.sendKeys(excel.getData(i, 2).toString());
//			delToDate.sendKeys(Keys.RETURN);
						
			}			
//			
//			for(int i=1;i<excel.getRowCount();i++) {
//				Thread.sleep(2000);
//				username.sendKeys(excel.getData(i, 0).toString());
//				password.sendKeys(excel.getData(i, 1).toString());
//				Thread.sleep(12000);
//				submit.click();
//			}
			logger.info(dtf.format(now) + "Login Successful");
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}