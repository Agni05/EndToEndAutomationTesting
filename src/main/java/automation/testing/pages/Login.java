package automation.testing.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class Login extends AbstractComponent {
	
	public Login(WebDriver driver)
	{
		super(driver);
		//give life to this driver from the actual driver
		this.driver = driver;
		//this method can do all the function pass
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	//create annotation of find element
	//this is for userEmail
	@FindBy(id="userEmail")
	WebElement userMail;
	
	//this is for password
	@FindBy(id="userPassword")
	WebElement password;
	
	//this is for the submit button
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='toast-error']")
	WebElement errorMessage;
	
	public ProductPage perform(String email, String pass)
	{
		userMail.sendKeys(email);
		password.sendKeys(pass);
		submit.click();
		ProductPage prodPage = new ProductPage(driver);
		return prodPage;
	}
	
	public String getErrorMessage()
	{
		waitForElementAppear(errorMessage);
		String error = errorMessage.getText();
		return error;
		
	}
	

}
