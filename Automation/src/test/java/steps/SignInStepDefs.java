package steps;

import cucumber.api.java.en.And;
import pages.SignInPage;

public class SignInStepDefs {
	
	private SignInPage signInPage = new SignInPage(); 
	
	@And("^I create an account \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\"$")
	public void CreateAnAccount(String email, String firstName, String lastName, String password, String dayOfBirth, String monthOfBirth, String yearOfBirth, String company, String adress, String city, String state, String zipCode, String homePhone, String mobilePhone) {
		signInPage.FillFields(email, firstName, lastName, password, dayOfBirth, monthOfBirth, yearOfBirth, company, adress, city, state, zipCode, homePhone, mobilePhone)
		;
	}
}
