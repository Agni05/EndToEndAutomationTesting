package automation.testComponentes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import automation.testing.pages.Login;

public class BaseTest {
	
	 WebDriver driver;
	
	FileInputStream fis;
	public Login LoginFunc;
	
	Properties prop = new Properties();
	String browserName;
	
	Iterator<Object[]> data;
	 
	public WebDriver initializeDriver() throws IOException
	{
		//for chrome driver
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\GlobalData.properties");
		prop.load(fis);
		if(System.getProperty("browser")!=null)
		{
			 browserName =  System.getProperty("browser");
		}
		else{
			browserName =  prop.getProperty("browser");
		}
		if(browserName.equalsIgnoreCase("chrome"))
		{
		 driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	//login
	public Login launchApplication() throws IOException
	{	
		driver = initializeDriver();
		LoginFunc = new Login(driver);
		LoginFunc.goTo();
		return LoginFunc;
	}
	
	@AfterMethod(alwaysRun=true)
	public void browserClose()
	{
		driver.close();
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException
	{
		//read json to string
		String jsonContent = FileUtils.readFileToString(new File(filepath),
				StandardCharsets.UTF_8);
		//String to hashmap through jackson databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
		return data;
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\testing\\data\\SubmitOrder.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
	}
	
	
	

}
