package pages;

import org.openqa.selenium.By;

import base.BasePage;

public class SummaryPage extends BasePage {

	public String GetProductDescription(String XPath) {						
		return super.dsl.GetElementText(By.xpath(XPath));
	}
	
	public SignInPage ProceedToCheckout() {
		super.dsl.Click(By.xpath("//div[@id='columns']//a[@title='Proceed to checkout']"));		
		
		return new SignInPage();
	}
	
}
