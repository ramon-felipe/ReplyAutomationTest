package pages;

import org.openqa.selenium.By;

import base.BaseCucumberTest;
import base.BasePage;

public class SignInPage extends BasePage {
	private final String randomTag = "<RANDOM>";
	
	public SignInPage FillEmail(String text) {
		if(text.equalsIgnoreCase(randomTag)) {
			String rdnEmail = "aaaa" + Integer.toString(new BaseCucumberTest().rnd.nextInt(5000)) + "@aaa" + Integer.toString(new BaseCucumberTest().rnd.nextInt(5000)) + ".com.br" + ".com";
			super.dsl.SendKeys("Email address", rdnEmail);
		}else {
			super.dsl.SendKeys("Email address", text);
		}
		
		return this;
	}
	
	public SignInPage FillFields(String email, 
			                     String firstName, 
			                     String lastName, 
			                     String password, 
			                     String dayOfBirth, 
			                     String monthOfBirth,
			                     String yearOfBirth,
			                     String company,
			                     String adress,
			                     String city,
			                     String state,
			                     String zipCode,
			                     String homePhone,
			                     String mobilePhone) {		
		this.FillEmail(email);
		dsl.Click(By.xpath("//button[@id='SubmitCreate']"));
		dsl.ClickOnRadioButton("Mr.");
		dsl.SendKeys("First name", firstName);
		dsl.SendKeys("Last name", lastName);
		dsl.SendKeys("Password", password);
		dsl.waitHelper.Sleep(1);
		
		dsl.SelectComboValue("Date of Birth", "days", dayOfBirth);
		dsl.SelectComboValue("Date of Birth", "months", monthOfBirth);
		dsl.SelectComboValue("Date of Birth", "years", yearOfBirth);
		dsl.SendKeys("Company", company);
		dsl.SendKeys("Address", adress);
		dsl.waitHelper.Sleep(1);
		
		dsl.SendKeys("City", city);
		dsl.SelectComboOption("State", state);
		dsl.SendKeys("Zip/Postal Code", zipCode);
		dsl.SendKeys("Home phone", homePhone);
		dsl.SendKeys("Mobile phone", mobilePhone);
		
		dsl.ClickOnButton("Register");
		
		return this;
	}
	
	public AddressPage ProceedToCheckout() {
		super.dsl.Click(By.xpath("//button/*[text()='Proceed to checkout']"));		
		
		return new AddressPage();
	}
	
}
