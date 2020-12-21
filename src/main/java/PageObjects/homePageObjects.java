package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePageObjects {
public WebDriver driver;
	
	By pn=By.cssSelector("#root > div > div.products-wrapper > div > div>h4");
	By add=By.cssSelector("#root > div > div.products-wrapper > div > div> div.product-action > button");
	By crt=By.cssSelector("#root > div > header > div > div.cart > a.cart-icon > img");
	
	public homePageObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public List<WebElement> PdtName()
	{
		return driver.findElements(pn);
	}
	public List<WebElement> AddtoCart()
	{
		return driver.findElements(add);
}
	public WebElement Cartclick()
	{
		return driver.findElement(crt);
	}
	}
