package com.testing.Cliniops;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cliniops_AutomationScriptsTest extends Cliniops_ReusableMethodsTest{

	private WebDriver dr;  

	//@BeforeMethod    
	//@Parameters({"browser"})
	public void selectBrowser(String browser) throws IOException{
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
	public void auto_Clini_Login_001() throws Exception{
		String expectedTooltipText;
		dr.get("https://bridgetherapeutics.cliniops.com");
		Actions tooltip = new Actions(dr);

		WebElement usrname=dr.findElement(By.id("username"));
		tooltip.moveToElement(usrname).build().perform();			 		
		expectedTooltipText="Enter Username";
		validateTextAttribute(usrname, expectedTooltipText, "Username tooltip", "title","UsernameTooltip");

		WebElement password=dr.findElement(By.id("password"));
		tooltip.moveToElement(password).build().perform();
		expectedTooltipText="Enter Password";
		validateTextAttribute(password, expectedTooltipText, "Password tooltip", "title","PasswordTooltip");

		WebElement authenticate=dr.findElement(By.id("Authenticate"));
		tooltip.moveToElement(authenticate).build().perform();
		expectedTooltipText="Authenticate";
		validateTextAttribute(authenticate, expectedTooltipText, "Authenticate tooltip", "title","AuthenticateTooltip");

		WebElement selectStudy=dr.findElement(By.id("investigator_study"));
		tooltip.moveToElement(selectStudy).build().perform();
		//actualTooltipText=selectStudy.getAttribute("title");
		expectedTooltipText="Select Study";
		validateTextAttribute(selectStudy, expectedTooltipText, "Select Study tooltip", "title","SelectStudyTooltip");
		//TooltipValidation(selectStudy, expectedTooltipText, actualTooltipText);

		WebElement selectLang=dr.findElement(By.id("lang_type"));
		tooltip.moveToElement(authenticate).build().perform();
		expectedTooltipText="Select Language";
		validateTextAttribute(selectLang, expectedTooltipText, "Select Lang tooltip", "title","SelectLanguageTooltip");

		WebElement loginBtn=dr.findElement(By.xpath(".//*[@id='login']/div[7]/input"));
		tooltip.moveToElement(loginBtn).build().perform();
		expectedTooltipText="Login";
		validateTextAttribute(loginBtn, expectedTooltipText, "login tooltip", "title","LoginTooltip");
	}

	//@Test
	public void auto_Clini_Login_004() throws IOException, InterruptedException{
		
		String errorMsg;
		String expectedErrorMsg;
		dr.get("https://bridgetherapeutics.cliniops.com/login");
		
		WebElement forgotPwd=dr.findElement(By.linkText("Forgot password..? Click here..."));
		clickElement(forgotPwd, "Click Forgot Password", "Forgot Password");
		//Thread.sleep(3000);
		
		WebElement email=dr.findElement(By.id("forgotemail"));
		enterText(email, "abc@gmail.com", "Email id", "Enter Email");
		//Thread.sleep(3000);
		
		WebElement requestNewPwd=dr.findElement(By.id("req_new_pass"));
		clickElement(requestNewPwd, "Click Request Password", "Request new password");
		//Thread.sleep(3000);
		
		//WebElement emailIdError=dr.findElement(By.xpath("//*[text()='Email-id does not exist in database.']"));
		WebElement emailIdError = (new WebDriverWait(dr, 5))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Email-id does not exist in database.']")));
		errorMsg=emailIdError.getText();
		expectedErrorMsg="Email-id does not exist in database.";
		validateText(emailIdError, expectedErrorMsg, errorMsg,"Email error");
		//Thread.sleep(3000);
		
		WebElement email2=dr.findElement(By.id("forgotemail"));
		enterText(email2, "abhishekmj11@gmail.com", "Email id", "Enter Email");
		//Thread.sleep(3000);
		
		WebElement requestNewPwd2=dr.findElement(By.id("req_new_pass"));
		clickElement(requestNewPwd2, "Click Request Password", "Request new password");
		//Thread.sleep(3000);
		
		WebElement emailIdError2=dr.findElement(By.xpath(".//*[@id='content-body']/div[1]/span"));
		errorMsg=emailIdError2.getText();
		expectedErrorMsg="Email has been sent to your email address. Please check to create your new password.";
		validateText(emailIdError2, expectedErrorMsg, errorMsg,"Email error");
	}

	//@Test
	public void auto_Clini_Login_005() throws Exception{

		dr.get("https://bridgetherapeutics.cliniops.com");

		WebElement rightFooter=dr.findElement(By.id("footer-right"));

		validateText(rightFooter, "Version : 2.0.27", "Right Footer:Version 2.0.27 ","Right Footer");

		WebElement logo=dr.findElement(By.xpath(".//*[@id='logo']/h1/a/img"));

		if(logo.isDisplayed()){
			updateReport("Pass", "Presence of Logo", "Logo appears");
		}
		else{
			updateReport("Fail", "Presence of Logo", "Logo not displayed");
		}
	}


	//@AfterMethod
	public void closeBrowser(){
		dr.close();
		dr.quit();

	}

}




