package automation.testComponentes;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot extends BaseTest {
	
	
	public static String getScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourcePath = ts.getScreenshotAs(OutputType.FILE);
		File destPath = new File(System.getProperty("user.dir")+"\\report\\"+ testCaseName +".png");
		FileUtils.copyFile(sourcePath, destPath);
		return System.getProperty("user.dir")+"\\report\\"+ testCaseName +".png";
		
	}


}
