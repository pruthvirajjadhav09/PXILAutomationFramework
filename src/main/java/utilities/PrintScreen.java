package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class PrintScreen {
	public PrintScreen(WebDriver chrome_webDriver, String filename, String extension) throws IOException {
		File  srcFile = ((TakesScreenshot)chrome_webDriver).getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss").format(new Date());
		LocalDate date = LocalDate.now();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String  formattedString = date.format(formatter);
		
		File dir = new File("D:/PXIL/Automation Testing/PXILAutomationFramework"+formattedString);
		
		dir.mkdir();
		
		FileHandler.copy(srcFile, new File(dir+"/"+ filename+" "+timestamp+extension));
	}
}
