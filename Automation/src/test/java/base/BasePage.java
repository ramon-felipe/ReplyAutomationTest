package base;

import static driver.DriverFactory.GetDriver;

import org.openqa.selenium.By;

import helper.FileHelper;

public class BasePage{

	public DSL dsl;
	
	public BasePage() {
		this.dsl = new DSL();
	}
	
	public BasePage GoTo(String url) {
		GetDriver().get(url);
		
		return this;
	}
	
	protected BasePage MouveOverProduct(String productName) {
		String elementXpath = "(//a[normalize-space(text())='" + productName + "']/ancestor::div[contains(@class, 'product-container')])[1]";
		this.dsl.MouseOver(By.xpath(elementXpath));
		
		return this;
	}
	
	protected BasePage AddProductToCart(String productName) {
		this.MouveOverProduct(productName);		
		FileHelper.TakeScreenShot();		
		
		dsl.waitHelper.Sleep(1);
		
		this.dsl.Click(By.xpath("(//a[normalize-space(text())='" + productName + "']/ancestor::div[contains(@class, 'right-block')]/div[contains(@class, 'button-container')]/a[@title='Add to cart'])[1]"));
		FileHelper.TakeScreenShot();
		
		return this;
	}	
	
	public BasePage SelectMenuOption(String submenu, String menu) {
		String menuXpath = "//div[@id='block_top_menu']/ul/li[./a[translate(text(), 'abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ') = '" + menu.toUpperCase() + "']]";
		String subMenuXpath = menuXpath + "/ul/li/a[translate(text(), 'abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ') = '" + submenu.toUpperCase() + "']";
		
		dsl.MouseOver(By.xpath(menuXpath));
		dsl.waitHelper.Sleep(2);
		dsl.Click(By.xpath(subMenuXpath));
		
		return this;		
	}
	
	public BasePage AddFirstProductToKart() {
		dsl.MouseOver(By.xpath("(//a/ancestor::div[contains(@class, 'product-container')])[1]"));
		FileHelper.TakeScreenShot();		
		
		dsl.waitHelper.Sleep(1);
		
		this.dsl.Click(By.xpath("(//a/ancestor::div[contains(@class, 'right-block')]/div[contains(@class, 'button-container')]/a[@title='Add to cart'])[1]"));
		FileHelper.TakeScreenShot();
		
		return this;
	}
	
}
