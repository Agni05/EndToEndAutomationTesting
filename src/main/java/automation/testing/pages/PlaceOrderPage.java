package automation.testing.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class PlaceOrderPage extends AbstractComponent{
	
	public PlaceOrderPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	WebDriver driver;
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement countryName;
	
	@FindBy(css=".ta-item span")
	List<WebElement> countries;
	
	@FindBy(css=".btnn.action__submit.ng-star-inserted")
	WebElement placeOrder;
	
	By searchResults = By.cssSelector(".ta-results");
	
	public void getCountry(String country)
	{
		//type India in the search box of select country
		countryName.sendKeys(country);
		//wait until we find the values
		waitForElementAppear(searchResults);
		//click on India from the suggestion
		WebElement click = countries.stream().filter(c-> c.getText().equalsIgnoreCase(country)).findFirst().orElse(null);
		click.click();
	}
	
	//click on place order button
	public ConfirmationPage placeOrder()
	{
		placeOrder.click();
		ConfirmationPage confirmPage = new ConfirmationPage(driver);
		return confirmPage;
	}

}
