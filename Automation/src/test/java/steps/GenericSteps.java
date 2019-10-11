package steps;

import org.openqa.selenium.By;

import base.BasePage;
import base.DSL;
import cucumber.api.java.en.And;
import pages.SummaryPage;

public class GenericSteps {
	
	private BasePage basePage = new BasePage();
	private DSL dsl = new DSL();
	
	@And("I click on \"(.*)\" button")
	public void clickOnButton(String buttonText) {
		dsl.ClickOnButton(buttonText);
	}
	
	@And("I click on \"(.*)\" link")
	public void clickOnLink(String linkText) {
		dsl.Click(By.xpath("(//a[normalize-space(text())='" + linkText + "'] | //a//*[normalize-space(text())='" + linkText + "'])"));
	}
	
	@And("^I click on submenu \"(.*)\" of menu \"(.*)\"$")
	public void SelectMenuOption(String submenu, String menu) {
		basePage.SelectMenuOption(submenu, menu);
	}
	
	@And("^I add the first product to the kart$")
	public void AddFirstProductToKart() {
		basePage.AddFirstProductToKart();
	}
	
	@And("^I proceed to checkout$")
	public void ProceedToCheckout() {
		new SummaryPage().ProceedToCheckout();
	}
	
	@And("^I proceed to shipping section$")
	public void ProceedToShippingSection() {
		new SummaryPage().ProceedToCheckout().ProceedToCheckout();
	}
}
