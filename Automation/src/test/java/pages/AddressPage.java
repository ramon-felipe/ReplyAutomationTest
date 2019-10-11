package pages;

import org.openqa.selenium.By;

import base.BasePage;

public class AddressPage extends BasePage {

	public ShippingPage ProceedToCheckout() {
		super.dsl.ClickOnButton("Proceed to checkout");
		
		return new ShippingPage();		
	}
	
	public String GetFullName() {
		
		return dsl.GetElementText(By.xpath("//ul[@id='address_delivery']/li[@class='address_firstname address_lastname']"));
	}
	
	public String GetCompanyName() {
		return dsl.GetElementText(By.xpath("//ul[@id='address_delivery']/li[@class='address_company']"));
	}
	
	public String GetAddress() {
		return dsl.GetElementText(By.xpath("//ul[@id='address_delivery']/li[@class='address_address1 address_address2']"));
	}
	
	public String GetCityStatePostCode() {
		return dsl.GetElementText(By.xpath("//ul[@id='address_delivery']/li[@class='address_city address_state_name address_postcode']"));
	}
	
	public String GetHomePhone() {
		return dsl.GetElementText(By.xpath("//ul[@id='address_delivery']/li[@class='address_phone']"));
	}
	
	public String GetMobilePhone() {
		return dsl.GetElementText(By.xpath("//ul[@id='address_delivery']/li[@class='address_phone_mobile']"));
	}	
}
