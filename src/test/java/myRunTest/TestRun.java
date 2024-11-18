package myRunTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import functionality.LoginFunctionality;
import functionality.UpcOrderEntry;
import utilities.DriverSetup;

public class TestRun {

	public static void main(String[] args) throws InterruptedException, IOException {
		DriverSetup ds = new DriverSetup();
		WebDriver chrome_webDriver = ds.setup();
		new LoginFunctionality().LoginToPratyay(chrome_webDriver);
//		new (chrome_webDriver);
		new UpcOrderEntry().OrderEntry(chrome_webDriver);
	}
}