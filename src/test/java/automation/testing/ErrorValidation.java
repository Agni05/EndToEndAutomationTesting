package automation.testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.testComponentes.BaseTest;
import automation.testComponentes.RetryListenrs;

public class ErrorValidation extends BaseTest {
	
	@Test(retryAnalyzer=RetryListenrs.class)
	public void ErrorTesting()
	{
		LoginFunc.perform("agnivo.test@yopmail.com", "Agnivo@2");
		Assert.assertEquals("Incorrect email or password.", LoginFunc.getErrorMessage());
	}
	
}
