package stepDefination;

import java.io.IOException;
import org.testng.Assert;

import automation.testComponentes.BaseTest;
import automation.testing.pages.CartPage;
import automation.testing.pages.ConfirmationPage;
import automation.testing.pages.Login;
import automation.testing.pages.OrderPage;
import automation.testing.pages.PlaceOrderPage;
import automation.testing.pages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination extends BaseTest {
	
	public Login LoginFunc;
	public ProductPage prodPage;
	public CartPage cart;
	public PlaceOrderPage orderPlaceButton;
	public ConfirmationPage confirm;
	public OrderPage orderpage;
	
	
	@Given ("I landed on the Ecommerce Page")
	public void i_landed_on_the_Ecommerce_Page() throws IOException
	{
		LoginFunc = launchApplication();
	}
	
	@Given ("^I want to log in with (.+) and (.+)$")
	public void I_want_to_log_in_with_email_and_password(String email, String password)
	{
		prodPage = LoginFunc.perform(email, password);
	}
	
	@When ("^I add the product (.+) to the cart$")
	public void I_add_the_product_pname_to_the_cart(String pname)
	{
		prodPage.getProdutcList();
		prodPage.getProductName(pname);
		prodPage.addToCart(pname);
	}
	
	@And ("^I checkout the product (.+)$")
	public void I_checkout_the_product(String pname)
	{
		cart = prodPage.goToCart();
		
		//cart page
		Boolean test = cart.getMatch(pname);
		Assert.assertTrue(test);
		orderPlaceButton = cart.clickOnCheckout();
	}
	
	@And ("^I search for (.+) and click on it$")
	public void I_search_for_country_and_click_on_country(String country)
	{
		orderPlaceButton.getCountry(country);
	}
	
	@And ("I submit the order")
	public void I_submit_the_order()
	{
		confirm = orderPlaceButton.placeOrder();
	}
	
	@Then ("{string} message is displayed")
	public void confirmation_message_is_displayed(String string)
	{
		String confirmMessage = confirm.getConfirm();
		
		//verify the message right or wrong
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		browserClose();
	}
	
	@When ("I clicked on order button")
	public void I_clicked_on_order_button()
	{
		orderpage = LoginFunc.getOrder();
	}
	
	@Then ("^I verify (.+) is available in order section$")
	public void I_verify_product_is_available_in_order_section(String pname)
	{
		Assert.assertTrue(orderpage.verifyOrderHistory(pname));
		browserClose();
	}
	
    /*@Then ("I verify the {string} message is displayed")
    public void I_verify_the_error_message_is_displayed(String string)
    {
    	Assert.assertEquals(string, LoginFunc.getErrorMessage());
    	browserClose();
    }*/
    
    @Then("^I verify the \"([^\"]*)\" message is displayed$")
    public void i_verify_the_something_message_is_displayed(String strArg1)
    {
    	Assert.assertEquals(strArg1, LoginFunc.getErrorMessage());
    	browserClose();
    }
        


}
