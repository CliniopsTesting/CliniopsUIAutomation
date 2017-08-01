package com.testing.Cliniops;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Cliniops_AutomationScriptsTest extends Cliniops_ReusableMethodsTest{

	WebDriver dr;  


	//@BeforeMethod    
	//@Parameters({"browser"})
	public void selectBrowser(String browser) throws IOException{
		//startReport(testname, reportsPath);
		if(browser.equalsIgnoreCase("firefox")){
			dr=new FirefoxDriver();	
		}
		else if(browser.equalsIgnoreCase("chrome")){
			dr=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("IE")){
			dr=new InternetExplorerDriver();
		}
		dr.manage().window().maximize();
	}

	//@Test
	public void auto_clini_login_001() throws Exception{

		String expectedTooltipText;
		String actualTooltipText;
		Actions tooltip;
		dr.get("https://bridgetherapeutics.cliniops.com");
		tooltip = new Actions(dr);

		WebElement usrname=dr.findElement(By.id("username"));

		tooltip.moveToElement(usrname).build().perform();			 		
		expectedTooltipText="Enter Username";
		validateMsg_Attribute(usrname, expectedTooltipText, "username tooltip", "title");

		WebElement password=dr.findElement(By.id("password"));

		tooltip.moveToElement(password).build().perform();

		expectedTooltipText="Enter Password";
		validateMsg_Attribute(password, expectedTooltipText, "password tooltip", "title");

		WebElement authenticate=dr.findElement(By.id("Authenticate"));
		tooltip.moveToElement(authenticate).build().perform();

		expectedTooltipText="Authenticate";
		validateMsg_Attribute(authenticate, expectedTooltipText, "Authenticate tooltip", "title");


		usrname.sendKeys("Abhishek");
		password.sendKeys("Welcome123#");
		authenticate.click();


		WebElement selectStudy=dr.findElement(By.id("investigator_study"));

		tooltip.moveToElement(selectStudy).build().perform();

		//actualTooltipText=selectStudy.getAttribute("title");
		expectedTooltipText="Select Study";
		validateMsg_Attribute(selectStudy, expectedTooltipText, "select Study tooltip", "title");
		//TooltipValidation(selectStudy, expectedTooltipText, actualTooltipText);

		WebElement selectLang=dr.findElement(By.id("lang_type"));
		tooltip = new Actions(dr);
		tooltip.moveToElement(authenticate).build().perform();

		expectedTooltipText="Select Language";
		validateMsg_Attribute(selectLang, expectedTooltipText, "select Lang tooltip", "title");

		WebElement loginBtn=dr.findElement(By.xpath(".//*[@id='login']/div[7]/input"));
		tooltip = new Actions(dr);
		tooltip.moveToElement(loginBtn).build().perform();

		expectedTooltipText="Login";
		validateMsg_Attribute(loginBtn, expectedTooltipText, "login tooltip", "title");


	}
	//@Test
	public void auto_clini_login_002() throws IOException{

		String expected = "Abhishek";
		dr.get("https://bridgetherapeutics.cliniops.com");
		WebElement userNameObj = dr.findElement(By.xpath(".//*[@id='username']"));
		enterText(userNameObj, "Abhishek", "userName object");
		String actual = userNameObj.getAttribute("value");
		validateMsg_Attribute(userNameObj, expected, "usernameObject", "value");

	}

	//@Test
	public void auto_clini_login_004() throws IOException{
		dr.get("https://bridgetherapeutics.cliniops.com/login");
		WebElement selectstudy=dr.findElement(By.id("investigator_study"));
		checkDisabled(selectstudy,"Select Study");			
	}

	//@AfterMethod
	public void closeBrowser(){
		dr.close();
		dr.quit();
		
	}

}




