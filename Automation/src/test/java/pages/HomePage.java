package pages;

import org.openqa.selenium.By;

import base.BasePage;

public class HomePage extends BasePage {

	public HomePage GoTo(String url) {
		super.GoTo(url);
		
		return this;
	}
	
	public HomePage AddProductToCart(String productName) {
		super.AddProductToCart(productName);		
		
		return this;
	}
	
	public SummaryPage ProceedToCheckOut() {
		dsl.Click(By.xpath("//div[@id='layer_cart']//a[@title='Proceed to checkout']"));
		
		return new SummaryPage();
	}
}
