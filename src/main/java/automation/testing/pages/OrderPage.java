package automation.testing.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class OrderPage extends AbstractComponent {
	
	public WebDriver driver;
	
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//tr //td[2]")
	List<WebElement> ordersName;
	
	public Boolean verifyOrderHistory(String pname)
	{
		Boolean match = ordersName.stream().anyMatch(order-> order.getText().equalsIgnoreCase(pname));
		return match;
	}


}
