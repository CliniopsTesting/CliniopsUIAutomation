package com.testing.Cliniops;

import java.io.IOException;
import java.util.List;

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
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Cliniops_AutomationScriptsTest extends Cliniops_ReusableMethodsTest{
    WebDriver dr;  
    
	
    @BeforeMethod    
	@Parameters({"browser"})
	public void selectBrowser(String browser)throws IOException{
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
	
    @Test
    public void auto_Clini_Login_001() throws Exception{
    	dr.get("https://bridgetherapeutics.cliniops.com");
    	Actions tooltip = new Actions(dr);

    	WebElement usrname=dr.findElement(By.id("username"));
    	Thread.sleep(3000);			 		
    	tooltip.moveToElement(usrname).build().perform();	

    	validateTextAttribute(usrname, "Enter Username", "Username tooltip", "title","Username Tooltip",dr);
    	Thread.sleep(3000);			 		

    	WebElement password=dr.findElement(By.id("password"));
    	Thread.sleep(3000);
    	tooltip.moveToElement(password).build().perform();
    	Thread.sleep(3000);			 		
    	validateTextAttribute(password, "Enter Password", "password tooltip", "title","Password Tooltip",dr);

    	WebElement authenticate=dr.findElement(By.id("Authenticate"));
    	Thread.sleep(3000);
    	tooltip.moveToElement(authenticate).build().perform();
    	Thread.sleep(3000);			 		
    	validateTextAttribute(authenticate, "Authenticate", "Authenticate tooltip", "title","Authenticate Tooltip",dr);

    	Thread.sleep(2000);		
    	WebElement selectStudy=dr.findElement(By.id("investigator_study"));
    	Thread.sleep(2000);		
    	tooltip.moveToElement(selectStudy).build().perform();
    	Thread.sleep(2000);
    	validateTextAttribute(selectStudy, "Select Study", "select Study tooltip", "title","SelectStudy Tooltip",dr);

    	WebElement selectLang=dr.findElement(By.id("lang_type"));
    	Thread.sleep(3000);
    	tooltip = new Actions(dr);
    	tooltip.moveToElement(authenticate).build().perform();
    	Thread.sleep(3000); 				 		
    	validateTextAttribute(selectLang, "Select Language", "select Lang tooltip", "title","SelectLanguage Tooltip",dr);

    	WebElement loginBtn=dr.findElement(By.xpath(".//*[@id='login']/div[7]/input"));
    	Thread.sleep(5000);
    	tooltip = new Actions(dr);
    	tooltip.moveToElement(loginBtn).build().perform();
    	Thread.sleep(3000);			 		
    	validateTextAttribute(loginBtn, "Login", "login tooltip ", "title","Login Tooltip",dr);


    }


    @Test
    public void auto_Clini_Login_002() throws IOException, InterruptedException{
    	dr.get("https://bridgetherapeutics.cliniops.com/login");

    	WebElement username=dr.findElement(By.id("username"));
    	enterText(username, "Abhishek", "Username","Enter Username",dr);

    	WebElement password=dr.findElement(By.id("password"));
    	enterText(password, "Welcome123#", "Password","Enter Password",dr);

    	WebElement authenticate=dr.findElement(By.id("Authenticate"));
    	clickElement(authenticate, "Authenticate Button","Click Authenticate button",dr);
    	Thread.sleep(7000);

    	//it will verify the dropdown's are enabled
    	WebElement selectStudy= dr.findElement(By.id("investigator_study"));
    	boolean selStudy=selectStudy.isEnabled();
    	Assert.assertEquals(selStudy,true,"Study is enabled");

    	WebElement selectLang= dr.findElement(By.id("lang_type"));
    	boolean lang=selectLang.isEnabled();
    	Assert.assertEquals(lang, true,"Lang is enabled");	 

    	WebElement login=dr.findElement(By.xpath("//*[@title='Login']"));
    	boolean loginBtn=login.isEnabled();
    	Assert.assertEquals(loginBtn, true,"Login is enabled");

    	Thread.sleep(2000);
    	selectStudy.click();
    	Actions ac= new Actions(dr);
    	WebElement study= dr.findElement(By.xpath("//*[contains(text(),'Cisplatin/Etoposide/Rad')]"));
    	ac.moveToElement(selectStudy).build().perform();
    	String expectedTextForStudy="Cisplatin/Etoposide/Rad................-Small Cell Lung Cancer";
    	validateText(study, expectedTextForStudy, "Study Details","Study name",dr);
    	dropDownByValue(selectStudy,"5",dr);
    	Thread.sleep(2000);
    	Thread.sleep(7000);
    	selectLang.click();
    	WebElement lang1= dr.findElement(By.xpath("//*[contains(text(),'English')]"));
    	ac.moveToElement(lang1).build().perform();
    	String expectedLanguage="English";
    	validateText(lang1, expectedLanguage, "Language", "Language option",dr);
    	Thread.sleep(3000);


    	dropDownByValue(selectLang, "1",dr);
    	Thread.sleep(2000);

    	clickElement(login, "Login","Click Login button",dr);

    	String ActualURL= dr.getCurrentUrl();
    	String ExpectedURL="https://bridgetherapeutics.cliniops.com/investigator";

    	Assert.assertEquals(ActualURL, ExpectedURL);
    	WebElement homePage=dr.findElement(By.className("current"));
    	validateText(homePage, "Home", "HomePage","HomePage Display",dr);


    }	


    @Test
    public void auto_Clini_Login_003() throws IOException, InterruptedException{
    	//validating Authentication error message
    	String expected = "Authenitcation failed !";
    	dr.get("https://bridgetherapeutics.cliniops.com");
    	WebElement userNameObj = dr.findElement(By.xpath(".//*[@id='username']"));
    	enterText(userNameObj, "Abhi", "userName object","Enter Username",dr);

    	WebElement passwordObj = dr.findElement(By.id("password"));
    	enterText(passwordObj, "xxx", "password object","Enter Password",dr);

    	WebElement authenticateObj = dr.findElement(By.xpath(".//*[@id='Authenticate']"));
    	clickElement(authenticateObj, "Authentication button object","Click Authenticate",dr);

    	WebElement errMessageObj = dr.findElement(By.xpath(".//*[@id='showCustomErrMsg']"));

    	WebDriverWait wait = new WebDriverWait(dr, 30);
    	WebElement ele = wait.until(ExpectedConditions.visibilityOf(errMessageObj));
    	String actual = ele.getText();
    	System.out.println(actual);

    	if (actual.equals(expected))
    	{
    		System.out.println("authentication error message is passed");
    	}
    	else 
    	{
    		System.out.println("Nothing to check... ");
    	}

    	//Testing select study/ select language and login buttons are disabled
    	WebElement selStudyObj = dr.findElement(By.xpath(".//*[@id='investigator_study']"));
    	if (selStudyObj.isEnabled()){
    		System.out.println("selectstudy is enabled...");
    	}
    	else 
    	{
    		System.out.println("select study is disabled...");
    	}

    	WebElement selLangObj = dr.findElement(By.xpath(".//*[@id='lang_type']"));
    	if (selStudyObj.isEnabled()){
    		System.out.println("select language type is enabled...");
    	}
    	else 
    	{
    		System.out.println("select language type is disabled...");
    	}

    	WebElement loginObj = dr.findElement(By.xpath(".//*[@id='login']/div[7]/input"));
    	if (loginObj.isEnabled()){
    		System.out.println("login button is enabled ...");
    	}
    	else 
    	{
    		System.out.println("login button is disabled...");
    	}

    	//Testing for the error messages if we enter incorrect password and username
    	WebElement userNameObj1 = dr.findElement(By.xpath(".//*[@id='username']"));
    	userNameObj1.clear();
    	enterText(userNameObj1, "", "username object","Enter Username",dr);
    	WebElement passwordObj1 = dr.findElement(By.id("password"));
    	passwordObj1.clear();

    	WebElement authenticateObj1 = dr.findElement(By.id("Authenticate"));
    	clickElement(authenticateObj1, "Authentication button object","Click Authenticate",dr);

    	String expUserNameErrMsg = "Please enter the username";
    	String expPassWordErrMsg = "Please enter the password";

    	WebElement unErrObj = dr.findElement(By.xpath(".//*[@id='login']/div[1]/label"));
    	String unActual = unErrObj.getText();
    	if(expUserNameErrMsg.equals(unActual))
    	{
    		System.out.println("UserName error message is present...");
    	}
    	else 
    	{
    		System.out.println("UserName error message is not present...");
    	}

    	WebElement pwErrObj = dr.findElement(By.xpath(".//*[@id='login']/div[2]/label"));
    	String pwActual = pwErrObj.getText();

    	if(expPassWordErrMsg.equals(pwActual))
    	{
    		System.out.println("Password error message is present...");
    	}
    	else 
    	{
    		System.out.println("Password error message is not present...");
    	}

    }

    @Test(enabled=false)
    public void auto_Clini_Login_004() throws IOException{
    	String errorMsg;
    	String expectedErrorMsg;
    	dr.get("https://bridgetherapeutics.cliniops.com/login");

    	WebElement forgotPwd=dr.findElement(By.linkText("Forgot password..? Click here..."));
    	clickElement(forgotPwd, "Click Forgot Password", "Forgot Password",dr);

    	WebElement email=dr.findElement(By.id("forgotemail"));
    	enterText(email, "abc@gmail.com", "Email id", "Enter Email",dr);

    	WebElement requestNewPwd=dr.findElement(By.id("req_new_pass"));
    	clickElement(requestNewPwd, "Click Request Password", "Request new password",dr);

    	WebElement emailIdError = (new WebDriverWait(dr, 5))
    			.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Email-id does not exist in database.']")));
    	errorMsg=emailIdError.getText();
    	expectedErrorMsg="Email-id does not exist in database.";
    	validateText(emailIdError, expectedErrorMsg, errorMsg,"Email error",dr);

    	WebElement email2=dr.findElement(By.id("forgotemail"));
    	enterText(email2, "abhishekmj11@gmail.com", "Email id", "Enter Email",dr);

    	WebElement requestNewPwd2=dr.findElement(By.id("req_new_pass"));
    	clickElement(requestNewPwd2, "Click Request Password", "Request new password",dr);

    	WebElement emailIdError2=dr.findElement(By.xpath(".//*[@id='content-body']/div[1]/span"));
    	errorMsg=emailIdError2.getText();
    	expectedErrorMsg="Email has been sent to your email address. Please check to create your new password.";
    	validateText(emailIdError2, expectedErrorMsg, errorMsg,"Email error",dr);
    }
    @Test
    public void auto_Clini_Login_005() throws Exception{
    	dr.get("https://bridgetherapeutics.cliniops.com");
    	WebElement rightFooter=dr.findElement(By.id("footer-right"));
    	validateText(rightFooter, "Version : 2.0.27", "Right Footer:Version 2.0.27 ","Right Footer",dr);
    	WebElement logo=dr.findElement(By.xpath(".//*[@id='logo']/h1/a/img"));
    	if(logo.isDisplayed()){
    		updateReport("Pass", "Presence of Logo", "Logo appears",dr);
    	}
    	else{
    		updateReport("Fail", "Presence of Logo", "Logo not displayed",dr);
    	}
    }


    @Test
    public void auto_Clini_Home_001() throws InterruptedException, IOException{
    	Login(dr);
    	Thread.sleep(2000);
    	WebElement homeStudyLogo=dr.findElement(By.xpath(".//*[@id='logo']/h1/a/img"));
    	checkObjectDisplay(homeStudyLogo,"home Study  Logo","HomePage Study Logo",dr);
    	Thread.sleep(2000);
    	WebElement WelcomeUsername=dr.findElement(By.xpath(".//*[@id='header-right']/span[1]"));
    	checkObjectDisplay(WelcomeUsername,"WelcomeUsername","Welcome User_Full_Name",dr);
    	Thread.sleep(2000);
    	WebElement homePageStudyPortal=dr.findElement(By.xpath(".//*[@id='header-right']/span[2]/b"));
    	checkObjectDisplay(homePageStudyPortal,"homePageStudyPortal","homePageStudyPortal",dr);
    	Thread.sleep(2000);
    	WebElement logout=dr.findElement(By.xpath("//input[@value='Logout']"));		
    	checkEnabled(logout,"logout",dr);
    	Thread.sleep(2000);
    	if(logout.isEnabled()){
    		checkObjectDisplay(logout,"logout","logout",dr);
    	}
    	Thread.sleep(2000);
    	WebElement homePageStudyName=dr.findElement(By.xpath(".//*[@id='header-right']/div/span"));
    	checkObjectDisplay(homePageStudyName,"homePageStudyName","homePageStudyName",dr);
    	Thread.sleep(2000);
    	WebElement enrollmentCount=dr.findElement(By.xpath(".//*[@id='content-body']/div/div/div[2]/div[1]/span[2]"));
    	String expectedEnrollmentCount="300";
    	validateText(enrollmentCount, expectedEnrollmentCount, "Enrollment count","Enrollment",dr);
    	Thread.sleep(2000);
    	WebElement groupsCount=dr.findElement(By.xpath(".//*[@id='content-body']/div/div/div[2]/div[2]/span[2]"));
    	String expectedGroupsCount="2";
    	validateText(groupsCount, expectedGroupsCount, "Groups count","Groups",dr);
    	Thread.sleep(2000);
    	WebElement sitesCount=dr.findElement(By.xpath(".//*[@id='content-body']/div/div/div[2]/div[3]/span[2]"));
    	String expectedSitesCount="2";
    	validateText(sitesCount, expectedSitesCount, "Sites count","Sites",dr);
    	Thread.sleep(2000);
    	WebElement visitsCount=dr.findElement(By.xpath(".//*[@id='content-body']/div/div/div[2]/div[4]/span[2]"));
    	String expectedVisitsCount="5";
    	validateText(visitsCount, expectedVisitsCount, "Visits count","Visits",dr);
    }


    @AfterMethod

    public void closeBrowser(){
    	dr.close();
    	dr.quit();
    }


}




