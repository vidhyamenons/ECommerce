package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;

public class base {
	
	public Properties prop;
	public WebDriver driver;
	
public WebDriver initialiseDriver() throws IOException
{
	prop=new Properties();
	FileInputStream fis=new FileInputStream("C:\\Users\\Rajeev\\eclipse-workspace\\FirstProject\\src\\main\\java\\resources\\data.properties");
	prop.load(fis);
	String browserName=prop.getProperty("browser");
	
	if(browserName.equalsIgnoreCase("chrome"))
	{
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Rajeev\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
	}
	
		return driver;
	}

public String getScreenshotpath(String testcaseName, WebDriver driver) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	String destnfile=System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
	FileUtils.copyFile(source, new File(destnfile));
	return destnfile;
}
}
	


