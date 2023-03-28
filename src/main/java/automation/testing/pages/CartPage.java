package automation.testing.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent {
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	WebDriver driver;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> productName;
	
	public boolean getMatch(String pname)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//scan the names in my cart to check we add what is there or not
		boolean test = productName.stream().anyMatch(cartp-> cartp.getText().equalsIgnoreCase(pname));
		return test;
		
	}
	
	@FindBy(xpath="//div[@class='subtotal cf ng-star-inserted'] //button")
	private WebElement checkoutButton;
	
	public PlaceOrderPage clickOnCheckout()
	{
		//click on checkout button
		checkoutButton.click();
		PlaceOrderPage orderPlaceButton = new PlaceOrderPage(driver);
		return orderPlaceButton;
		
	}
	
	
	


}
