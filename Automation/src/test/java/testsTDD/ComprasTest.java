package testsTDD;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import base.BaseJunitTest;
import pages.AddressPage;
import pages.HomePage;
import pages.PaymentPage;
import pages.SummaryPage;

public class ComprasTest extends BaseJunitTest {

	private AddressPage addressPage = new AddressPage();
	private PaymentPage paymentPage = new PaymentPage();
	
	@Test
	public void RealizarCompra() {
		
		String productToBuy = "Blouse";
		String email = "aaaad" + Integer.toString(super.rnd.nextInt(5000)) + "@aaad.com.br"; //creates an random email
		String firstName = "Ramon";
		String lastName = "Silva";
		String fullName = firstName + " " + lastName;
		String companyName = "aaaaa";
		String address = "asdasdfasf";
		String city = "Sao Paulo";
		String state = "Alabama";
		String postCode = "12345";
		String cityStatePostCode = city + ", " + state + " " + postCode; 
		String homePhone = "99999999";
		String mobilePhone = "88888888";
		
		String productDescriptionOnCart = new HomePage().GoTo("http://www.automationpractice.com")
														.AddProductToCart(productToBuy)
														.ProceedToCheckOut()
														.GetProductDescription("//table[@id='cart_summary']/tbody/tr[1]/td[contains(@class, 'cart_description')]/p/a");
		
		//validates selected product
		assertEquals(productToBuy, productDescriptionOnCart);
		
		new SummaryPage().ProceedToCheckout()
						 .FillFields(email, firstName, lastName, "12345", "10", "12", "1989", companyName, address, city, state, postCode, homePhone, mobilePhone);
		
		//validates saved/selected address
		assertEquals(fullName, addressPage.GetFullName());
		assertEquals(companyName, addressPage.GetCompanyName());
		assertEquals(address, addressPage.GetAddress());
		assertEquals(cityStatePostCode, addressPage.GetCityStatePostCode());
		assertEquals(homePhone, addressPage.GetHomePhone());
		assertEquals(mobilePhone, addressPage.GetMobilePhone());
		
		String totalPrice = addressPage.ProceedToCheckout()
									    .AgreeWithTerms()
										.ProceedToCheckout()
										.GetTotalPriceCalculated();
		
		//validates the total price
		assertEquals(totalPrice, paymentPage.GetTotalPrice());
		
		String orderCompletePhrase = paymentPage.SelectPaymentMethod("Pay by bank wire")
												.ConfirmOrder()
												.GetOrderCompletePhrase();
		
		//validates the order complete phrase
		assertEquals("Your order on My Store is complete.", orderCompletePhrase);
	}	
}
