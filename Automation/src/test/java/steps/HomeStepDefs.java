package steps;

import cucumber.api.java.en.Given;
import pages.HomePage;

public class HomeStepDefs {
	@Given("^I access the page (.*)$")
	public void GotoCreateAccountPage(String page) {
		new HomePage().GoTo(page);
	}
}
