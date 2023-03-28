package automation.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {
	
	public ConfirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	WebDriver driver;
	
	@FindBy(css="h1")
	WebElement confirm;
	
	//get the confirmation message
	public String getConfirm()
	{
		String confirmMessage = confirm.getText();
		return confirmMessage;
	}
	
}
