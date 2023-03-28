package automation.testing.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class ProductPage extends AbstractComponent {
	
	public ProductPage(WebDriver driver)
	{
		//Create super method for sending variable to parent class from child class
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this );
	}
	
	WebDriver driver;
	
	//find the all elements as products
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(id="toast-container")
	private WebElement toastPopUp;
	
	@FindBy(css = ".ng-animating")
	private WebElement spinner;
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".btn.w-10.rounded");

	public List<WebElement> getProdutcList()
	{
		waitForElementAppear(productsBy);
		return products;
	}
	
	public WebElement getProductName(String pname)
	{
		//now the find that one which we want to add in the cart with java stream
		WebElement prod = products.stream().filter(product-> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(pname))
				.findFirst().orElse(null);
		return prod;
				
	}
	
	public void addToCart(String pname)
	{
		//add to cart the product
		WebElement prod = getProductName(pname);
		prod.findElement(addToCart).click();
		
		//wait for product added to cart message
		waitForElementAppear(toastPopUp);
		//wait locator of loading symbol
		waitForElementDisappear(spinner);
		
	}
	

}
