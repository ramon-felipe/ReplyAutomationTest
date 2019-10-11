package steps;

import cucumber.api.java.en.And;
import pages.ShippingPage;

public class ShippingStepDefs {

	@And("^I agree with terms and proceed to checkout$")
	public void AgreeWithTerms() {
		new ShippingPage().AgreeWithTerms().ProceedToCheckout();
	}
}
