package FirstProject;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import PageObjects.cartPageObjects;
import PageObjects.homePageObjects;

import resources.base;

public class CartItemsValidation extends base {
	public WebDriver driver;
	

	private static Logger Log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void before() throws IOException {
		
		driver = initialiseDriver();
		driver.get(prop.getProperty("url"));
		Log.info("Chrome is initiated again");
		
		 
		}

	@Test
	public void ValidateCart() throws IOException {
		
		//CartItemsValidation b=new CartItemsValidation();
			
		
		cartPageObjects cp = new cartPageObjects(driver);
		homePageObjects hp = new homePageObjects(driver);

		int j = 0;
		String[] itemsToAdd = { "Cucumber", "Brocolli", "Carrot", "Pumpkin", "Capsicum" };
		List<String> itemsToAddList = Arrays.asList(itemsToAdd);
		for (int i = 0; i < hp.PdtName().size(); i++) {
			String[] name = hp.PdtName().get(i).getText().split("-");
			String formattedname = name[0].trim();

			if (itemsToAddList.contains(formattedname)) {
				// System.out.println(formattedname);
				hp.AddtoCart().get(i).click();
				j++;
				if (j == itemsToAdd.length) {

					break;
				}
			}

		}
		
		Log.info("Items Added");
		hp.Cartclick().click();
		Log.info("Clicked on cart");
		int k = 0;

		for (int n = 0; n < cp.CartPdtNames().size(); n++)

		{
			// System.out.println(cp.CartPdtNames().get(n).getText());
			String[] cartname = cp.CartPdtNames().get(n).getText().split("-");
			String formattedcartname = cartname[0].trim();
			// System.out.println(formattedcartname);
			if (itemsToAddList.contains(formattedcartname)) {

				k++;

				if (k == itemsToAdd.length) {
					System.out.println("     ");
					System.out.println("VERIFIED");
					
					break;
				}
			}
		}
		Log.info("Test verified");
		
		
		
	}

	@AfterTest
	public void after() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.close();
		Log.info("Driver closed");
		
	}

}
