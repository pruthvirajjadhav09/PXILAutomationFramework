package functionality;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.LogOut;
import pages.Login;
import utilities.ExcelUtility;
import utilities.LoadProperties;

public class LoginFunctionality {

	Logger logger = LogManager.getLogger(Login.class); 
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	Properties dataPropertyObject = new LoadProperties().load();
	public void LoginToPratyay(WebDriver chrome_webDriver) {
		try {
			PropertyConfigurator.configure("log4j.properties");
			
			Login login = new Login();
			
			WebElement username = login.username(chrome_webDriver);
			WebElement password = login.password(chrome_webDriver);
			WebElement submit = login.loginButton(chrome_webDriver);
			
			logger.info(dtf.format(now) + "--------------------------Login to Pratyay - Trading  Application-----------------------------");
			ExcelUtility excel = new ExcelUtility(dataPropertyObject.getProperty("EXCEL_FILE"), "LoginData");
			for(int i=1;i<excel.getRowCount();i++) {
				Thread.sleep(2000);
				username.sendKeys(excel.getData(i, 0).toString());
				password.sendKeys(excel.getData(i, 1).toString());
				Thread.sleep(12000);
				submit.click();
			}
			logger.info(dtf.format(now) + "Login Successful");
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void LogoutFunctionality(WebDriver chrome_webDriver) throws InterruptedException {
			LogOut logout= new LogOut();
			PropertyConfigurator.configure("log4j.properties");
			WebElement logoutExpansion = logout.logoutExpansion(chrome_webDriver);
			WebElement logoutButton = logout.logoutButton(chrome_webDriver);
			
			logger.info(dtf.format(now) + "--------------------------Logout from Pratyay - Trading  Application-----------------------------");
			logoutExpansion.click();
			Thread.sleep(2000);
			logoutButton.click();
			
			logger.info(dtf.format(now) + "Logout Successful");
	}
}