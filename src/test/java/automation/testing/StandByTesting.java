package automation.testing;
 
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.testComponentes.BaseTest;
import automation.testing.pages.CartPage;
import automation.testing.pages.ConfirmationPage;
import automation.testing.pages.OrderPage;
import automation.testing.pages.PlaceOrderPage;
import automation.testing.pages.ProductPage;

public class StandByTesting extends BaseTest {
	

	@Test(dataProvider = "getData")
	public void endToEndTest(HashMap<String, String> input) throws IOException {
		
		//report.createTest("End to end Test");
		
		//login functionality
		ProductPage prodPage = LoginFunc.perform(input.get("email"), input.get("password"));
		
		//Product page
		//get the product list
		prodPage.getProdutcList();
		prodPage.getProductName(input.get("pname"));
		prodPage.addToCart(input.get("pname"));
		CartPage cart = prodPage.goToCart();
		
		//cart page
		Boolean test = cart.getMatch(input.get("pname"));
		Assert.assertTrue(test);
		PlaceOrderPage orderPlaceButton = cart.clickOnCheckout();
		orderPlaceButton.getCountry(input.get("country"));
		ConfirmationPage confirm = orderPlaceButton.placeOrder();
		String confirmMessage = confirm.getConfirm();
			
		//verify the message right or wrong
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		//report.flush();
		
	}
	
	//dependsOnMethods= {"endToEndTest"}, 
	@Test(dataProvider= "getData")
	public void orderHistoryTest(HashMap<String, String> input)
	{
		//report.createTest("Order History Test");
		
		LoginFunc.perform(input.get("email"), input.get("password"));
		LoginFunc.perform(input.get("email"), input.get("password"));
		OrderPage orderpage = LoginFunc.getOrder();
		Assert.assertTrue(orderpage.verifyOrderHistory(input.get("pname")));
		//report.flush();
		//System.out.println(input.get("email"));
	}

}
