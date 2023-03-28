package abstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.testing.pages.CartPage;
import automation.testing.pages.OrderPage;

public class AbstractComponent {
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waitForElementAppear(By FindBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	}
	
	public void waitForElementAppear(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementDisappear(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//locator of loading symbol
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	private WebElement cartButton;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	private WebElement Orderbutton;
	
	//cart button
	public CartPage goToCart()
	{
		cartButton.click();
		CartPage cart = new CartPage(driver);
		return cart;
	}
	//order button
	public OrderPage getOrder()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Orderbutton.click();
		OrderPage orders = new OrderPage(driver);
		return orders;
	}

}
