package steps;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.PaymentPage;

public class PaymentStepDefs {

	PaymentPage paymentPage = new PaymentPage();
	
	@When("^I select the payment method \"(.*)\" and confirm the order$")
	public void SelectPaymentMethod(String paymentMethod) {
		paymentPage.SelectPaymentMethod(paymentMethod).ConfirmOrder();
	}
	
	@Then("^I validate the order confirmation$")
	public void ValidateOrderConfirmation() {
		assertEquals("Your order on My Store is complete.", paymentPage.GetOrderCompletePhrase());
	}
}
