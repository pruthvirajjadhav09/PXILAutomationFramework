package myRunTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:/PXIL/Automation Testing/chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("https://tradingdr.nseit.com/Public/LoginAdmin.aspx");
		WebElement username = wd.findElement(By.id("txtUserID"));
		username.click();
		username.sendKeys("Pruthviraj");
		
		WebElement password = wd.findElement(By.id("txtPwd"));
		password.sendKeys("Nseit@px4");
		Thread.sleep(12000);
		WebElement loginButton = wd.findElement(By.id("loginButtonLink"));
		loginButton.click();
	}

}