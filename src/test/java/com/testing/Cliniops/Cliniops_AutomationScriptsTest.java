package com.testing.Cliniops;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
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

		//WebElement usrname=dr.findElement(By.id("username"));
		WebElement usrname=Cliniops_ReusableMethodsTest.findTheElement("login_UsernameTextbox",Cliniops_DriverScriptTest.browserRunning,dr);
		Thread.sleep(1000);			 		
		tooltip.moveToElement(usrname).build().perform();	
		validateTextAttribute(usrname, "Enter Username", "Username tooltip", "title","Username Tooltip",dr);
		//Thread.sleep(1000);			 		

		//WebElement password=dr.findElement(By.id("password"));
		WebElement password=Cliniops_ReusableMethodsTest.findTheElement("login_PasswordTextbox",Cliniops_DriverScriptTest.browserRunning,dr);
		Thread.sleep(1000);
		tooltip.moveToElement(password).build().perform();
		//Thread.sleep(1000);			 		
		validateTextAttribute(password, "Enter Password", "password tooltip", "title","Password Tooltip",dr);

		//WebElement authenticate=dr.findElement(By.id("Authenticate"));
		WebElement authenticate=Cliniops_ReusableMethodsTest.findTheElement("login_AuthenticateButton",Cliniops_DriverScriptTest.browserRunning,dr);
		Thread.sleep(1000);
		tooltip.moveToElement(authenticate).build().perform();
		//Thread.sleep(3000);			 		
		validateTextAttribute(authenticate, "Authenticate", "Authenticate tooltip", "title","Authenticate Tooltip",dr);

		//Thread.sleep(2000);		
		//WebElement selectStudy=dr.findElement(By.id("investigator_study"));
		WebElement selectStudy=Cliniops_ReusableMethodsTest.findTheElement("login_SelectStudyDd",Cliniops_DriverScriptTest.browserRunning,dr);
		Thread.sleep(1000);		
		tooltip.moveToElement(selectStudy).build().perform();
		Thread.sleep(1000);
		validateTextAttribute(selectStudy, "Select Study", "select Study tooltip", "title","SelectStudy Tooltip",dr);

		//WebElement selectLang=dr.findElement(By.id("lang_type"));
		WebElement selectLang=Cliniops_ReusableMethodsTest.findTheElement("login_SelectLangDd",Cliniops_DriverScriptTest.browserRunning,dr);
		Thread.sleep(1000);
		tooltip = new Actions(dr);
		tooltip.moveToElement(authenticate).build().perform();
		Thread.sleep(1000); 				 		
		validateTextAttribute(selectLang, "Select Language", "select Lang tooltip", "title","SelectLanguage Tooltip",dr);

		//WebElement loginBtn=dr.findElement(By.xpath(".//*[@id='login']/div[7]/input"));
		WebElement loginBtn=Cliniops_ReusableMethodsTest.findTheElement("login_LoginBtn",Cliniops_DriverScriptTest.browserRunning,dr);
		Thread.sleep(1000);
		tooltip = new Actions(dr);
		tooltip.moveToElement(loginBtn).build().perform();
		Thread.sleep(1000);			 		
		validateTextAttribute(loginBtn, "Login", "login tooltip ", "title","Login Tooltip",dr);
	}


	@Test
	public void auto_Clini_Login_002() throws IOException, InterruptedException{
		dr.get("https://bridgetherapeutics.cliniops.com/login");

		//WebElement username=dr.findElement(By.id("username"));
		WebElement username=Cliniops_ReusableMethodsTest.findTheElement("login_UsernameTextbox",Cliniops_DriverScriptTest.browserRunning,dr);
		enterText(username, "Abhishek", "Username", "Enter username", dr);

		//WebElement password=dr.findElement(By.id("password"));
		WebElement password=Cliniops_ReusableMethodsTest.findTheElement("login_PasswordTextbox",Cliniops_DriverScriptTest.browserRunning,dr);
		enterText(password, "Welcome123#", "Password", "Enter password", dr);

		//WebElement authenticate=dr.findElement(By.id("Authenticate"));
		WebElement authenticate=Cliniops_ReusableMethodsTest.findTheElement("login_AuthenticateButton",Cliniops_DriverScriptTest.browserRunning,dr);
		clickElement(authenticate, "Authenticate Button", "Click on authenticate", dr);

		//WebElement selectStudy= dr.findElement(By.id("investigator_study"));
		WebElement selectStudy=Cliniops_ReusableMethodsTest.findTheElement("login_SelectStudyDd",Cliniops_DriverScriptTest.browserRunning,dr);
		checkEnabled(selectStudy,"selectStudy",dr);

		//WebElement selectLang= dr.findElement(By.id("lang_type"));
		WebElement selectLang=Cliniops_ReusableMethodsTest.findTheElement("login_SelectLangDd",Cliniops_DriverScriptTest.browserRunning,dr);
		checkEnabled(selectLang,"selectLang",dr);

		//WebElement login=dr.findElement(By.xpath("//*[@title='Login']"));
		WebElement login=Cliniops_ReusableMethodsTest.findTheElement("login_LoginBtn",Cliniops_DriverScriptTest.browserRunning,dr);
		checkEnabled(login,"login",dr);  
		Thread.sleep(2000);

		clickElement(selectStudy, "selectStudy","selectStudy",dr);
		//WebElement selectStudyOption=dr.findElement(By.xpath("//*[text()='Cisplatin/Etoposide/Rad................-Small Cell Lung Cancer']"));
		WebElement selectStudyOption=Cliniops_ReusableMethodsTest.findTheElement("login_SelectStudyOpt1",Cliniops_DriverScriptTest.browserRunning,dr);
		checkObjectDisplay(selectStudyOption,"selectStudyOption","selectStudyOption",dr);
		//String expectedTextForStudy="Cisplatin/Etoposide/Rad................-Small Cell Lung Cancer123";
		//validateText(selectStudyOption, expectedTextForStudy, "Study option", "Study option", dr);
		clickElement(selectStudyOption, "selectStudyOption","selectStudyOption",dr);
		Thread.sleep(2000);

		clickElement(selectLang, "selectLang","selectLang",dr);
		//WebElement selectLanguageOption=dr.findElement(By.xpath(".//*[@id='lang_type']/option[2]"));
		WebElement selectLanguageOption=Cliniops_ReusableMethodsTest.findTheElement("login_SelecctLangOpt1",Cliniops_DriverScriptTest.browserRunning,dr);
		checkObjectDisplay(selectLanguageOption,"selectLanguageOption","selectLanguageOption",dr);
		//String expectedLanguage="English";
		//validateText(selectLanguageOption, expectedLanguage, "Language option", "Language option", dr);
		clickElement(selectLanguageOption, "selectLanguageOption","selectLanguageOption",dr);

		Thread.sleep(2000);
		clickElement(login, "login","login",dr);
		Thread.sleep(2000);
		String ActualURL= dr.getCurrentUrl();
		String ExpectedURL="https://bridgetherapeutics.cliniops.com/investigator";
		validateURL(ExpectedURL,ActualURL,"homePageURL",dr);
		Thread.sleep(5000);
		String expectedTextColor="rgba(255, 255, 255, 1)";
		//String ActualTextColor = dr.findElement(By.xpath("//a[contains(text(),'Home')]")).getCssValue("color");
		String ActualTextColor=Cliniops_ReusableMethodsTest.findTheElement("login_homePageHighlight",Cliniops_DriverScriptTest.browserRunning,dr).getCssValue("color");
		checkHighlightText(expectedTextColor,ActualTextColor,"Home Page Tab Highlight",dr);

	}

	@Test
	public void auto_Clini_Login_003() throws IOException, InterruptedException{
		//validating Authentication error message
		String expected = "Authenitcation failed !";
		dr.get("https://bridgetherapeutics.cliniops.com");

		//WebElement userNameObj = dr.findElement(By.xpath(".//*[@id='username']"));
		WebElement userNameObj=Cliniops_ReusableMethodsTest.findTheElement("login_UsernameTextbox",Cliniops_DriverScriptTest.browserRunning,dr);
		enterText(userNameObj, "Abhi", "userName object","Enter Username",dr);

		//WebElement passwordObj = dr.findElement(By.id("password"));
		WebElement passwordObj=Cliniops_ReusableMethodsTest.findTheElement("login_PasswordTextbox",Cliniops_DriverScriptTest.browserRunning,dr);
		enterText(passwordObj, "xxx", "password object","Enter Password",dr);

		//WebElement authenticateObj = dr.findElement(By.xpath(".//*[@id='Authenticate']"));
		WebElement authenticateObj=Cliniops_ReusableMethodsTest.findTheElement("login_AuthenticateButton",Cliniops_DriverScriptTest.browserRunning,dr);
		clickElement(authenticateObj, "Authentication button object","Click Authenticate",dr);

		//WebElement errMessageObj = dr.findElement(By.xpath(".//*[@id='showCustomErrMsg']"));
		WebElement errMessageObj=Cliniops_ReusableMethodsTest.findTheElement("login_AuthenticationFailedMsg",Cliniops_DriverScriptTest.browserRunning,dr);
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
		//WebElement selStudyObj = dr.findElement(By.xpath(".//*[@id='investigator_study']"));
		WebElement selStudyObj=Cliniops_ReusableMethodsTest.findTheElement("login_SelectStudyDd",Cliniops_DriverScriptTest.browserRunning,dr);
		if (selStudyObj.isEnabled()){
			System.out.println("selectstudy is enabled...");
		}
		else 
		{
			System.out.println("select study is disabled...");
		}

		//WebElement selLangObj = dr.findElement(By.xpath(".//*[@id='lang_type']"));
		WebElement selLangObj = Cliniops_ReusableMethodsTest.findTheElement("login_SelectLangDd",Cliniops_DriverScriptTest.browserRunning,dr);
		if (selStudyObj.isEnabled()){
			System.out.println("select language type is enabled...");
		}
		else 
		{
			System.out.println("select language type is disabled...");
		}

		//WebElement loginObj = dr.findElement(By.xpath(".//*[@id='login']/div[7]/input"));
		WebElement loginObj = Cliniops_ReusableMethodsTest.findTheElement("login_LoginBtn",Cliniops_DriverScriptTest.browserRunning,dr);
		if (loginObj.isEnabled()){
			System.out.println("login button is enabled ...");
		}
		else 
		{
			System.out.println("login button is disabled...");
		}

		//Testing for the error messages if we enter incorrect password and username
		//WebElement userNameObj1 = dr.findElement(By.xpath(".//*[@id='username']"));
		WebElement userNameObj1=Cliniops_ReusableMethodsTest.findTheElement("login_UsernameTextbox",Cliniops_DriverScriptTest.browserRunning,dr);
		userNameObj1.clear();
		enterText(userNameObj1, "", "username object","Enter Username",dr);
		//WebElement passwordObj1 = dr.findElement(By.id("password"));
		WebElement passwordObj1=Cliniops_ReusableMethodsTest.findTheElement("login_PasswordTextbox",Cliniops_DriverScriptTest.browserRunning,dr);
		passwordObj1.clear();

		//WebElement authenticateObj1 = dr.findElement(By.id("Authenticate"));
		WebElement authenticateObj1=Cliniops_ReusableMethodsTest.findTheElement("login_AuthenticateButton",Cliniops_DriverScriptTest.browserRunning,dr);
		clickElement(authenticateObj1, "Authentication button object","Click Authenticate",dr);

		String expUserNameErrMsg = "Please enter the username";
		String expPassWordErrMsg = "Please enter the password";

		//WebElement unErrObj = dr.findElement(By.xpath(".//*[@id='login']/div[1]/label"));
		WebElement unErrObj = Cliniops_ReusableMethodsTest.findTheElement("login_UnErrorMsg",Cliniops_DriverScriptTest.browserRunning,dr);
		String unActual = unErrObj.getText();
		if(expUserNameErrMsg.equals(unActual))
		{
			System.out.println("UserName error message is present...");
		}
		else 
		{
			System.out.println("UserName error message is not present...");
		}

		//WebElement pwErrObj = dr.findElement(By.xpath(".//*[@id='login']/div[2]/label"));
		WebElement pwErrObj =Cliniops_ReusableMethodsTest.findTheElement("login_PwdErrorMsg",Cliniops_DriverScriptTest.browserRunning,dr);
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

	@Test
	public void auto_Clini_Login_004() throws IOException{
		String errorMsg;
		String expectedErrorMsg;
		dr.get("https://bridgetherapeutics.cliniops.com/login");

		//WebElement forgotPwd=dr.findElement(By.linkText("Forgot password..? Click here..."));
		WebElement forgotPwd=Cliniops_ReusableMethodsTest.findTheElement("login_ForgotPwdLink",Cliniops_DriverScriptTest.browserRunning,dr);
		clickElement(forgotPwd, "Click Forgot Password", "Forgot Password",dr);

		//WebElement email=dr.findElement(By.xpath("//input[@title='Enter Username']"));
		WebElement email=Cliniops_ReusableMethodsTest.findTheElement("login_EmailTextbox",Cliniops_DriverScriptTest.browserRunning,dr);
		enterText(email, "abc@gmail.com", "Email id", "Enter Email",dr);

		//WebElement requestNewPwd=dr.findElement(By.id("req_new_pass"));
		WebElement requestNewPwd=Cliniops_ReusableMethodsTest.findTheElement("login_RequestPwdButton",Cliniops_DriverScriptTest.browserRunning,dr);
		clickElement(requestNewPwd, "Click Request Password", "Request new password",dr);

		WebElement emailIdError = (new WebDriverWait(dr, 5))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='content-body']/div[1]/span")));
		//errorMsg=emailIdError.getText();
		expectedErrorMsg="Email-id or username does not exist in database.";
		validateText(emailIdError, expectedErrorMsg, "Email error","Email error",dr);

		//WebElement email2=dr.findElement(By.xpath("//input[@title='Enter Username']"));
		WebElement email2=Cliniops_ReusableMethodsTest.findTheElement("login_EmailTextbox",Cliniops_DriverScriptTest.browserRunning,dr);
		enterText(email2, "abhishekmj11@gmail.com", "Email id", "Enter Email",dr);

		//WebElement requestNewPwd2=dr.findElement(By.id("req_new_pass"));
		WebElement requestNewPwd2=Cliniops_ReusableMethodsTest.findTheElement("login_RequestPwdButton",Cliniops_DriverScriptTest.browserRunning,dr);
		clickElement(requestNewPwd2, "Click Request Password", "Request new password",dr);

		//WebElement emailIdError2=dr.findElement(By.xpath(".//*[@id='content-body']/div[1]/span"));
		WebElement emailIdError2=Cliniops_ReusableMethodsTest.findTheElement("login_EmailSendMsg",Cliniops_DriverScriptTest.browserRunning,dr);
		errorMsg=emailIdError2.getText();
		expectedErrorMsg="Email has been sent to your email address. Please check to create your new password.";
		validateText(emailIdError2, expectedErrorMsg, errorMsg,"Email error",dr);

	}
	@Test
	public void auto_Clini_Login_005() throws Exception{
		dr.get("https://bridgetherapeutics.cliniops.com");
		//WebElement rightFooter=dr.findElement(By.id("footer-right"));
		WebElement rightFooter=Cliniops_ReusableMethodsTest.findTheElement("login_RightFooter",Cliniops_DriverScriptTest.browserRunning,dr);
		validateText(rightFooter, "Version : 2.0.27", "Right Footer:Version 2.0.27","Right Footer",dr);
		//WebElement logo=dr.findElement(By.xpath(".//*[@id='logo']/h1/a/img"));
		WebElement logo=Cliniops_ReusableMethodsTest.findTheElement("login_Logo",Cliniops_DriverScriptTest.browserRunning,dr);
		if(logo.isDisplayed()){
			updateReport("Pass", "Presence of Logo", "Logo appears",dr);
		}
		else{
			updateReport("Fail", "Presence of Logo", "Logo not displayed",dr);
		}
	}



	@Test
	public void auto_Clini_Home_001() throws InterruptedException, IOException{
		login(dr);
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
	@Test
	public void auto_Clini_Home_002() throws InterruptedException, IOException {

		login(dr);

		Thread.sleep(2000);

		//Create action object
		Actions action = new Actions(dr);

		//Locate the 4 graphs
		List<WebElement> graphs = dr.findElements(By.cssSelector("div.graph-container>div[class*='graph']"));
		ArrayList<String> contId = new ArrayList<String>();

		//Locate the 4 containers to get their ids
		List<WebElement> containers = dr.findElements(By.cssSelector("div[id*='container']"));
		for(int i=0; i< containers.size(); i++){
			WebElement container = containers.get(i);
			String id = container.getAttribute("id");
			contId.add(id);
		}

		//Graph titles
		String[] expectedGraphText = {
				"Subjects Enrollment",
				"Visits",
				"Site Enrollment",
				"Group Enrollment"
		};
		//Expected result for chart menu options
		String[] expMenuOption = {
				"Print chart",
				"Download PNG image",
				"Download JPEG image",
				"Download PDF document",
				"Download SVG vector image"
		};

		String locator = "div[id=";
		//Navigate through the list elements 
		for(int i=0; i< graphs.size(); i++){
			WebElement chartObj = graphs.get(i);
			action.moveToElement(chartObj).build().perform();

			//Get Chart title and validate if it is as per expected??
			String title = chartObj.getText().split("\n")[0];
			checkContentsMatch(title, expectedGraphText[i], "Graph","Verify Graph Title",dr);
			System.out.println("Graph title = " + title);

			//Get the context menu rectangle "≡" and click on the button so pop up options are enabled
			String menuLocator = locator + contId.get(i) + "]>div>svg>g.highcharts-button>rect";
			WebElement chartMenu = dr.findElement(By.cssSelector(menuLocator));
			Thread.sleep(1000);
			action.moveToElement(chartMenu).build().perform();
			Thread.sleep(2000);

			//chartMenu.click();
			String ExpectedBrowser="org.openqa.selenium.firefox.FirefoxDriver";
			String ActualBrowser=dr.getClass().getName();
			System.out.println(ActualBrowser);
			if(ActualBrowser.equals(ExpectedBrowser)){chartMenu.click();}
			else{action.click().build().perform();}
			Thread.sleep(1000);

			String popUpLocator = locator + contId.get(i) + "]>div>div.highcharts-contextmenu>div>div";

			List<WebElement> popUpOptions = dr.findElements(By.cssSelector(popUpLocator));

			System.out.println("No. of Pop Up Window Options = " + popUpOptions.size()) ;
			//Find the pop up window and navigate to validate the 5 options
			for(int j=0; j< popUpOptions.size(); j++){
				WebElement opt = popUpOptions.get(j);
				Thread.sleep(1000);
				action.moveToElement(opt);
				String optText = opt.getText();
				System.out.println("Option text == " + optText);
				String stepName = "Verify Download Link";
				checkContentsMatch(optText, expMenuOption[j], "Chart Context Menu",stepName,dr);
			}
		}
	}

	@Test   
	public void auto_Clini_Home_003() throws Exception{
		login(dr);
		Thread.sleep(2000);
		//Configure Tab
		WebElement configure= dr.findElement(By.xpath("//*[contains(text(),'Configure')]"));
		clickElement(configure, "Configure", "Configure Tab details", dr);
		String expectedConfigUrl="https://bridgetherapeutics.cliniops.com/investigator/configurestudy/general";
		String actualConfigUrl=dr.getCurrentUrl();
		validateURL(expectedConfigUrl,actualConfigUrl,"Configure URL Check",dr);
		Actions action=new Actions(dr);
		action.moveToElement(dr.findElement(By.xpath("//*[contains(text(),'Configure')]"))).build().perform();
		Thread.sleep(3000);
		String expectedTextColor11="rgba(255, 255, 255, 1)";
		String actualTextColor11 = dr.findElement(By.xpath("//*[contains(text(),'Configure')]")).getCssValue("color");
		checkHighlightText(expectedTextColor11,actualTextColor11,"Configure tab Highlight",dr);
		WebElement studyDetails=dr.findElement(By.xpath(".//*[@id='content-body']/div[1]/div/div[2]/div[1]/ul/li[1]/a"));
		action.moveToElement(studyDetails).build().perform();
		Thread.sleep(3000);
		String expectedTextColor12="rgba(255, 255, 255, 1)";
		String actualTextColor12 = studyDetails.getCssValue("color");
		checkHighlightText(expectedTextColor12,actualTextColor12,"Study Details Highlight",dr);
		WebElement studyDetailsPage= dr.findElement(By.xpath("//div[@id='content-body']/div/div/h3"));
		String actualText=studyDetailsPage.getText().substring(0, 13);
		String expectedText="Study Details";
		checkContentsMatch(actualText,expectedText,"Study Details","Configure Study Details",dr); 
		Thread.sleep(3000);
		//Manage Tab
		WebElement manage= dr.findElement(By.xpath("//a[contains(text(),'Manage')]"));
		clickElement(manage, "Manage Tab", "Manage Tab details", dr);
		String expectedManageUrl="https://bridgetherapeutics.cliniops.com/investigator/managestudy/roles";
		String actualManageUrl=dr.getCurrentUrl();
		validateURL(expectedManageUrl,actualManageUrl,"Manage URL Check",dr);
		action.moveToElement(dr.findElement(By.xpath("//a[contains(text(),'Manage')]"))).build().perform();
		Thread.sleep(3000);
		String expectedTextColor21="rgba(255, 255, 255, 1)";
		String actualTextColor21 = dr.findElement(By.xpath("//a[contains(text(),'Manage')]")).getCssValue("color");
		checkHighlightText(expectedTextColor21,actualTextColor21,"Manage tab Highlight",dr);
		WebElement roles=dr.findElement(By.xpath(".//*[@id='content-body']/div/div/div[2]/div[1]/ul/li[1]/a"));
		action.moveToElement(roles).build().perform();
		Thread.sleep(3000);
		String expectedTextColor22="rgba(255, 255, 255, 1)";
		String actualTextColor22 = roles.getCssValue("color");
		checkHighlightText(expectedTextColor22,actualTextColor22,"Roles Highlight",dr);
		WebElement studyUserRoles= dr.findElement(By.xpath("//div[@id='content-body']/div/div/h3"));
		String actualText2=studyUserRoles.getText().substring(0, 16);
		String expectedText2="Study User Roles";
		checkContentsMatch(actualText2,expectedText2,"Study User Roles","Study User Roles",dr); 
		Thread.sleep(3000);

		//Analyze Tab
		WebElement analyze= dr.findElement(By.xpath("//*[contains(text(),'Analyze')]"));
		clickElement(analyze, "Analyze Tab", "Analyze Tab details", dr);
		String expectedAnalyzeUrl="https://bridgetherapeutics.cliniops.com/investigator/analyzestudy";
		String actualAnalyzeUrl=dr.getCurrentUrl();
		validateURL(expectedAnalyzeUrl,actualAnalyzeUrl,"Analyze URL Check",dr);
		action.moveToElement(dr.findElement(By.xpath("//*[contains(text(),'Analyze')]"))).build().perform();
		Thread.sleep(3000);
		String expectedTextColor31="rgba(255, 255, 255, 1)";
		String actualTextColor31 = dr.findElement(By.xpath("//*[contains(text(),'Analyze')]")).getCssValue("color");
		checkHighlightText(expectedTextColor31,actualTextColor31,"Manage tab Highlight",dr);
		WebElement export=dr.findElement(By.xpath(".//*[@id='content-body']/div/div[1]/div[2]/ul/li[1]/a"));
		action.moveToElement(export).build().perform();
		Thread.sleep(3000);
		String expectedTextColor32="rgba(255, 255, 255, 1)";
		String actualTextColor32 = export.getCssValue("color");
		checkHighlightText(expectedTextColor32,actualTextColor32,"Export Highlight",dr);    	
		WebElement studyAnalysis = dr.findElement(By.xpath("//div[@id='content-body']/div/div/h3"));
		String actualText3=studyAnalysis.getText().substring(0, 14);
		String expectedText3="Study Analysis";
		checkContentsMatch(actualText3,expectedText3,"Study Analysis","Study Analysis",dr); 
		Thread.sleep(3000);
		//Subjects Tab
		WebElement subjects= dr.findElement(By.xpath("//*[contains(text(),'Subjects')]"));
		clickElement(subjects, "Subjects Tab", "Subjects Tab details", dr);
		String expectedSubjectsUrl="https://bridgetherapeutics.cliniops.com/investigator/viewsubjects";
		String actualSubjectsUrl=dr.getCurrentUrl();
		validateURL(expectedSubjectsUrl,actualSubjectsUrl,"Subjects URL Check",dr);
		action.moveToElement(dr.findElement(By.xpath("//*[contains(text(),'Subjects')]"))).build().perform();
		Thread.sleep(3000);
		String expectedTextColor41="rgba(255, 255, 255, 1)";
		String actualTextColor41 = dr.findElement(By.xpath(".//*[@id='nav']/ul/li[5]/a")).getCssValue("color");
		checkHighlightText(expectedTextColor41,actualTextColor41,"Subjects tab Highlight",dr);      	  	
		WebElement subjectSummary = dr.findElement(By.xpath(".//*[@id='content-body']/div/div[2]/div[1]/h3"));
		String actualText41=subjectSummary.getText();
		String expectedText41="Subject Summary";
		checkContentsMatch(actualText41,expectedText41,"Subject Summary","Subject Summary",dr); 
		Thread.sleep(3000);
		WebElement subjectData = dr.findElement(By.xpath(".//*[@id='content-body']/div/div[2]/div[2]/h3"));
		String actualText42=subjectData.getText();
		String expectedText42="Subject Data";
		checkContentsMatch(actualText42,expectedText42,"Subject Data","Subject Data",dr); 
		//Audit
		WebElement audit= dr.findElement(By.xpath("//*[contains(text(),'Audit')]"));
		clickElement(audit, "Audit Tab", "Audit Tab details", dr);
		String expectedAuditUrl="https://bridgetherapeutics.cliniops.com/investigator/audittrial";
		String actualAuditUrl=dr.getCurrentUrl();
		validateURL(expectedAuditUrl,actualAuditUrl,"Audit URL Check",dr);
		action.moveToElement(dr.findElement(By.xpath("//*[contains(text(),'Audit')]"))).build().perform();
		Thread.sleep(3000);
		String expectedTextColor51="rgba(255, 255, 255, 1)";
		String actualTextColor51 = dr.findElement(By.xpath("//*[contains(text(),'Audit')]")).getCssValue("color");
		checkHighlightText(expectedTextColor51,actualTextColor51,"Audit tab Highlight",dr);     
		WebElement auditTrail = dr.findElement(By.xpath(".//*[text()='Audit Trail']"));
		String actualText5=auditTrail.getText();
		String expectedText5="Audit Trail";
		checkContentsMatch(actualText5,expectedText5,"Audit Trail","Audit Trail",dr); 
		//Profile Tab
		WebElement profile= dr.findElement(By.xpath("//*[contains(text(),'Profile')]"));
		clickElement(profile, "Profile Tab", "Profile Tab details", dr);    	
		String expectedProfileUrl="https://bridgetherapeutics.cliniops.com/investigator/profile";
		String actualProfileUrl=dr.getCurrentUrl();
		validateURL(expectedProfileUrl,actualProfileUrl,"Profile URL Check",dr);
		action.moveToElement(dr.findElement(By.xpath("//*[contains(text(),'Profile')]"))).build().perform();
		Thread.sleep(3000);
		String expectedTextColor61="rgba(255, 255, 255, 1)";
		String actualTextColor61 = dr.findElement(By.xpath(".//*[text()='Profile']")).getCssValue("color");
		checkHighlightText(expectedTextColor61,actualTextColor61,"Profile tab Highlight",dr);  
		WebElement profileInformation = dr.findElement(By.xpath(".//*[@id='content-body']/div[2]/div/h3"));
		String actualText6=profileInformation.getText();
		String expectedText6="Profile Information";
		checkContentsMatch(actualText6,expectedText6,"Profile Information","Profile Information",dr); 
	}
	@Test
	public void auto_Clini_Confg_001() throws InterruptedException, IOException{
		login(dr);
		Thread.sleep(2000);
		WebElement config=dr.findElement(By.xpath(".//*[text()='Configure']"));
		Actions action=new Actions(dr);
		action.moveToElement(config).build().perform();
		Thread.sleep(3000);
		String expectedTextColor="rgba(255, 255, 255, 1)";
		String ActualTextColor = dr.findElement(By.xpath(".//*[text()='Configure']")).getCssValue("color");
		Thread.sleep(2000);
		checkHighlightText(expectedTextColor,ActualTextColor,"Configure tab Highlight",dr);
		clickElement(config, "Configure tab", "Configure tab",dr);
		String ExpectedURL="https://bridgetherapeutics.cliniops.com/investigator/configurestudy/general";
		String ActualURL=dr.getCurrentUrl();
		validateURL(ExpectedURL,ActualURL,"Configure URL Check",dr);

	}
	@Test
	public void auto_Clini_Confg_002() throws Exception{
		login(dr);
		Thread.sleep(2000);
		WebElement configure= dr.findElement(By.xpath("//*[contains(text(),'Configure')]"));
		clickElement(configure, "Configure", "Configure Tab", dr);
		WebElement config=dr.findElement(By.xpath(".//*[text()='Configure']"));
		//Checking configure tab is highlighted
		Actions action=new Actions(dr);
		action.moveToElement(config).build().perform();
		Thread.sleep(3000);
		String expectedTextColor="rgba(255, 255, 255, 1)";
		String ActualTextColor = dr.findElement(By.xpath("//*[text()='Configure']")).getCssValue("color");
		Thread.sleep(2000);
		checkHighlightText(expectedTextColor,ActualTextColor,"Configure Tab",dr);
		//checking study details tab is highlighted
		String actualTextColorStudy= dr.findElement(By.xpath("//a[contains(text(),'Study Details')]")).getCssValue("color");
		checkHighlightText(expectedTextColor, actualTextColorStudy, "Study Details", dr); 
		//
		WebElement studyDetailsPage= dr.findElement(By.xpath("//div[@id='content-body']/div/div/h3"));
		String actualText=studyDetailsPage.getText().substring(0, 13);
		String expectedText="Study Details";
		checkContentsMatch(actualText,expectedText,"Study Details Page","Study Details Page",dr); 
		//import study button is located
		WebElement importStudy= dr.findElement(By.xpath("//a[contains(text(),'Import Study')]"));
		checkObjectDisplay(importStudy, "Import Study", "Import Study Button", dr);
		//Validating study Name
		WebElement studyName=dr.findElement(By.xpath("//td[contains(text(),'Advanced Stage III')]"));
		String expectedStudyName="Cisplatin/Etoposide/Radiotherapy +/- Consolidation...n Advanced Stage III Non-Small Cell Lung Cancer";
		validateText(studyName, expectedStudyName, "Study Name", "Validating Study Name", dr);
		//Validating Study Description
		WebElement studyDesc=dr.findElement(By.xpath("//tr[2]/td[2]"));
		String expectedStudyDesc="Cisplatin/Etoposide/Radiotherapy +/- Consolidation...n Advanced Stage III Non-Small Cell Lung Cancer";
		validateText(studyDesc, expectedStudyDesc, "Study Description", "Validating Study Description", dr);
		//Validating Protocol
		WebElement protocol=dr.findElement(By.xpath("//tr[3]/td[2]"));
		String expectedProtocol="Cisplatin/Etoposide/Radiotherapy +/- Consolidation...n Advanced Stage III Non-Small Cell Lung Cancer:";
		validateText(protocol, expectedProtocol, "Protocol", "Validating Protocol", dr);
	}

	@Test
	public void auto_Clini_Confg_003() throws IOException, InterruptedException {
		//Login to application
		login(dr);
		Thread.sleep(2000);

		//Navigate to configure tab
		dr.findElement(By.xpath("//*[contains(text(),'Configure')]")).click();

		Actions action = new Actions(dr);

		//Verify tool tip for target enrollment text box
		WebElement enrollTB = dr.findElement(By.cssSelector("#targetenrollment"));
		action.moveToElement(enrollTB).build().perform();
		Thread.sleep(1000);
		String actualText = enrollTB.getAttribute("title");
		checkContentsMatch(actualText, "Enter Target Enrollment","Enroll Button", "Validate ToolTip: Enroll Button ", dr );

		//Verify tool tip for browse button
		WebElement browseBtn = dr.findElement(By.cssSelector(".consentFile"));
		action.moveToElement(browseBtn).build().perform();
		Thread.sleep(1000);
		actualText = browseBtn.getAttribute("title");
		checkContentsMatch(actualText, "Browse consent form","Browse Button", "Validate ToolTip: Browse Button", dr );

		//Verify tool tip for data change button		
		WebElement dataChangeTB = dr.findElement(By.cssSelector("#reasonForDataChange"));
		action.moveToElement(dataChangeTB).build().perform();
		Thread.sleep(1000);
		actualText = dataChangeTB.getAttribute("title");
		checkContentsMatch(actualText, "Enter Reason for data change","Data Change TextBox", "Validate ToolTip: Reason for Data Change TextBox", dr );

		//Verify tool tip for save button
		WebElement saveBtn = dr.findElement(By.cssSelector("#save_general_settings"));
		action.moveToElement(saveBtn).build().perform();
		Thread.sleep(1000);
		actualText = saveBtn.getAttribute("title");
		checkContentsMatch(actualText, "Save","Save Button", "Validate ToolTip: Save Button", dr );

		//Verify tool tip for cancel button
		WebElement cancelBtn = dr.findElement(By.cssSelector(".disable-btn.btn-container-new"));
		action.moveToElement(cancelBtn).build().perform();
		Thread.sleep(1000);
		actualText = cancelBtn.getAttribute("title");
		checkContentsMatch(actualText, "Cancel","Cancel Button", "Validate ToolTip: Cancel Button", dr );

	}
	@Test
	public void auto_Clini_Confg_004() throws InterruptedException, IOException

	{	login(dr);
	Thread.sleep(3000);
	WebElement configure_tab = dr.findElement(By.xpath(".//*[@id='nav']//li[2]"));
	clickElement(configure_tab, "configureTab", "click configureTab", dr);
	Thread.sleep(4000);
	//validate text present in the target enrollment textbox
	String expected = "300";
	String actual = dr.findElement(By.xpath(".//*[@id='targetenrollment']")).getAttribute("value");
	System.out.println(actual);
	checkContentsMatch(actual, expected, "targetEnrollment", "Target Enrollment Value", dr);
	//verify value(custom) visibility in subjectID dropdown 
	String expSubjectId = "Custom";
	Thread.sleep(3000);
	String actual_subjectID_option=dr.findElement(By.xpath("//option[@value='Custom']")).getText();
	if(actual_subjectID_option.equals(expSubjectId))
	{checkContentsMatch(actual_subjectID_option, expSubjectId,"subjectID","SubjectID dropdown option", dr);
	System.out.println("Custom value is present in subjectID dropdown options");
	}
	//verify data change options present in textboxes
	String expReasonForDataChange1 = "Invalid entry";
	String expReasonForDataChange2 = "Updated Information";
	List<WebElement> reasonForDataChangeOptions = dr.findElements(By.xpath(".//*[@id='reasonForDataChange']"));
	String actual1 = reasonForDataChangeOptions.get(0).getAttribute("value");
	checkContentsMatch(actual1, expReasonForDataChange1, "reasonForDataChange", "Reason for Data Change:Value1", dr);
	String actual2 = reasonForDataChangeOptions.get(1).getAttribute("value");
	checkContentsMatch(actual2, expReasonForDataChange2, "reasonForDataChange", "Reason for Data Change:Value2", dr);	
	//verify file visibility of  informed consent form
	String expFileName = "ICF - Interview...cians_v8.pdf";
	String actualFileName = dr.findElement(By.xpath(".//*[@id='study_general_settings']/div[2]/div[1]/fieldset[2]/div/span")).getText();
	System.out.println(actualFileName);
	checkContentsMatch(actualFileName, expFileName, "dataChange", "Choose FileName Check", dr);
	}
	@Test
	public void auto_Clini_Confg_005() throws InterruptedException, IOException{
		login(dr);
		Thread.sleep(3000);
		WebElement configure_tab = dr.findElement(By.xpath(".//*[@id='nav']//li[2]"));
		clickElement(configure_tab, "configureTab", "ConfigureTab", dr);
		Thread.sleep(4000);
		//Verify appearance of Download file link.
		WebElement downloadFile = dr.findElement(By.xpath(".//*[@id='study_general_settings']/div[2]/div[1]/fieldset[2]/div/p/a"));
		checkObjectDisplay(downloadFile, "downloadFile", "Download File Link", dr);   

	}

	public void auto_Clini_Confg_006() throws InterruptedException, IOException{
		login(dr);
		Thread.sleep(3000);
		WebElement configure_tab = dr.findElement(By.xpath(".//*[@id='nav']//li[2]"));
		clickElement(configure_tab, "configureTab", "ConfigureTab", dr);
		Thread.sleep(5000);

		//Verify appearance of dropdown data in "Subject ID:*" dropdown.

		WebElement subjectId = dr.findElement(By.xpath(".//*[@id='subjectId']"));
		clickElement(subjectId, "SubjectId", "Subject Id Dropdown", dr);
		List<WebElement> Options = subjectId.findElements(By.tagName("option"));
		for (WebElement option : Options) {
			if("Select option".equals(option.getText())){
				String expectedText = "Select option";
				String actualText = option.getText();
				System.out.println(actualText);
				checkContentsMatch(actualText, expectedText, "Select option is visible", "Select Option Check", dr);

			}
			if("Automatic".equals(option.getText())){
				String expectedText = "Automatic";
				String actualText = option.getText();
				System.out.println(actualText);
				checkContentsMatch(actualText, expectedText, "Automatic is visible", "Automatic Option Check", dr);

			}

			// System.out.println(option.getText());
			if("Custom".equals(option.getText())) {
				String expectedText = "Custom";
				String actualText = option.getText();
				System.out.println(actualText);
				checkContentsMatch(actualText, expectedText, "Custom is visible", "Custom Option Check", dr);
				break;
			}}
	}





	@Test
	public void auto_Clini_Confg_007() throws InterruptedException,IOException{
		login(dr);
		Thread.sleep(3000);
		WebElement config=dr.findElement(By.xpath(".//*[@id='nav']/ul/li[2]/a"));
		config.click();
		Thread.sleep(3000);
		WebElement e2bSettings=dr.findElement(By.xpath(".//*[@id='study_general_settings']/div[2]/div[1]/fieldset[3]/a"));
		e2bSettings.click();
		String actualWindow=dr.findElement(By.xpath(".//*[@id='ui-id-2']")).getText();
		String expectedWindow="Settings";
		checkContentsMatch(actualWindow, expectedWindow, "Settings Window", "Safety Database Settings Window", dr);
		WebElement serverSettings=dr.findElement(By.xpath(".//*[@id='safetySettings']/div/fieldset[1]/span"));
		if(serverSettings.getText().trim().equalsIgnoreCase("Server Settings:*")){
			WebElement serverSettingsTextbox=dr.findElement(By.id("targetenrollment"));
			checkObjectDisplay(serverSettingsTextbox, "Server Settings TextBox", "Server Settings TextBox", dr);
		}
		else{
			updateReport("Fail", "Server Settings Textbox", "Server Settings textbox not displayed", dr);
		}
		WebElement username=dr.findElement(By.xpath(".//*[@id='safetySettings']/div/fieldset[2]/span"));
		if(username.getText().trim().equalsIgnoreCase("User Name:*")){
			WebElement usernameTextbox=dr.findElement(By.id("safetyuser"));
			checkObjectDisplay(usernameTextbox, "Username TextBox", "Username TextBox", dr);
		}
		else{
			updateReport("Fail", "Username Textbox", "Username textbox not displayed", dr);
		}
		WebElement password=dr.findElement(By.xpath(".//*[@id='safetySettings']/div/fieldset[3]/span"));
		if(password.getText().trim().equalsIgnoreCase("Password:*")){
			WebElement passwordTextbox=dr.findElement(By.id("safetypass"));
			checkObjectDisplay(passwordTextbox, "Password TextBox", "Password TextBox", dr);
		}
		else{
			updateReport("Fail", "Password Textbox", "Password textbox not displayed", dr);
		}
		WebElement sshKey=dr.findElement(By.xpath(".//*[@id='safetySettings']/div/fieldset[4]/span"));
		if(sshKey.getText().trim().equalsIgnoreCase("SSH Key:*")){
			WebElement sshKeyTextbox=dr.findElement(By.id("sshkey"));
			checkObjectDisplay(sshKeyTextbox, "SSH Key TextBox", "SSH Key TextBox", dr);
		}
		else{
			updateReport("Fail", "SSH Key Textbox", "SSH Key textbox not displayed", dr);
		}
		Thread.sleep(3000);
		WebElement submitBtn=dr.findElement(By.xpath("//fieldset[5]/div/input[1]"));
		checkObjectDisplay(submitBtn, "Submit Button", "Submit Button", dr);
		WebElement closeBtn=dr.findElement(By.xpath(".//*[@id='safetySettings']/div/fieldset[5]/div/input[2]"));
		checkObjectDisplay(closeBtn, "Close Button", "Close Button",dr);

	}

	@Test
	public void auto_Clini_Confg_008() throws InterruptedException,IOException{
		login(dr);
		Thread.sleep(3000);
		WebElement config=dr.findElement(By.xpath(".//*[@id='nav']/ul/li[2]/a"));
		config.click();
		Thread.sleep(3000);
		WebElement clinicalDbSettings=dr.findElement(By.xpath(".//*[@id='study_general_settings']/div[2]/div[1]/fieldset[4]/a"));
		clinicalDbSettings.click();
		String actualWindow=dr.findElement(By.xpath(".//*[@id='ui-id-2']")).getText();
		String expectedWindow="Settings";
		checkContentsMatch(actualWindow, expectedWindow, "Settings Window", "Clinical Database Settings Window", dr);
		WebElement serverSettings=dr.findElement(By.xpath(".//*[@id='safetySettings']/div/fieldset[1]/span"));
		//String serSetText=serverSettings.getText();
		//System.out.println(serSetText);
		//validateText(serverSettings, expectedText, objName, stepName, dr);
		//validateText(serverSettings, "Server Settings:*", Server Settings Label, stepName, dr);
		if(serverSettings.getText().trim().equalsIgnoreCase("Server Settings:*")){
			WebElement serverSettingsTextbox=dr.findElement(By.id("targetenrollment"));
			checkObjectDisplay(serverSettingsTextbox, "Server Settings TextBox", "Server Settings TextBox", dr);
		}
		else{
			updateReport("Fail", "Server Settings Textbox", "Server Settings textbox not displayed", dr);
		}
		WebElement username=dr.findElement(By.xpath(".//*[@id='safetySettings']/div/fieldset[2]/span"));
		if(username.getText().trim().equalsIgnoreCase("User Name:*")){
			WebElement usernameTextbox=dr.findElement(By.id("safetyuser"));
			checkObjectDisplay(usernameTextbox, "Username TextBox", "Username TextBox", dr);
		}
		else{
			updateReport("Fail", "Username Textbox", "Username textbox not displayed", dr);
		}
		WebElement password=dr.findElement(By.xpath(".//*[@id='safetySettings']/div/fieldset[3]/span"));
		if(password.getText().trim().equalsIgnoreCase("Password:*")){
			WebElement passwordTextbox=dr.findElement(By.id("safetypass"));
			checkObjectDisplay(passwordTextbox, "Password TextBox", "Password TextBox", dr);
		}
		else{
			updateReport("Fail", "Password Textbox", "Password textbox not displayed", dr);
		}
		WebElement sshKey=dr.findElement(By.xpath(".//*[@id='safetySettings']/div/fieldset[4]/span"));
		if(sshKey.getText().trim().equalsIgnoreCase("SSH Key:*")){
			WebElement sshKeyTextbox=dr.findElement(By.id("sshkey"));
			checkObjectDisplay(sshKeyTextbox, "SSH Key TextBox", "SSH Key TextBox", dr);
		}
		else{
			updateReport("Fail", "SSH Key Textbox", "SSH Key textbox not displayed", dr);
		}
		WebElement submitBtn=dr.findElement(By.xpath("//fieldset[5]/div/input[1]"));
		checkObjectDisplay(submitBtn, "Submit Button", "Submit Button", dr);
		WebElement closeBtn=dr.findElement(By.xpath(".//*[@id='safetySettings']/div/fieldset[5]/div/input[2]"));
		checkObjectDisplay(closeBtn, "Close Button", "Close Button", dr);
	}
	@Test
	public void auto_Clini_Manage_001() throws Exception{
		login(dr);
		Thread.sleep(5000);
		Actions action=new Actions(dr);
		//Manage Tab Highlighted
		WebElement manage= dr.findElement(By.xpath("//a[contains(text(),'Manage')]"));
		clickElement(manage, "Manage Tab", "Manage Tab details", dr);
		String expectedManageUrl="https://bridgetherapeutics.cliniops.com/investigator/managestudy/roles";
		String actualManageUrl=dr.getCurrentUrl();
		validateURL(expectedManageUrl,actualManageUrl,"Manage URL Check",dr);
		action.moveToElement(dr.findElement(By.xpath("//a[contains(text(),'Manage')]"))).build().perform();
		Thread.sleep(3000);
		String expectedTextColor21="rgba(255, 255, 255, 1)";
		String actualTextColor21 = dr.findElement(By.xpath("//a[contains(text(),'Manage')]")).getCssValue("color");
		checkHighlightText(expectedTextColor21,actualTextColor21,"Manage tab Highlight",dr);

	}
	@Test 

	public void auto_Clini_Manage_002() throws Exception{
		login(dr);
		Thread.sleep(4000);
		Actions actions=new Actions(dr);
		WebElement manage= dr.findElement(By.xpath("//a[contains(text(),'Manage')]"));
		clickElement(manage, "Manage Tab", "Manage Tab details", dr);
		//Checking Roles, Manage tab Highlighted
		actions.moveToElement(dr.findElement(By.xpath("//a[contains(text(),'Manage')]"))).build().perform();
		Thread.sleep(3000);
		String expectedTextColor21="rgba(255, 255, 255, 1)";
		String actualTextColorManage = dr.findElement(By.xpath("//a[contains(text(),'Manage')]")).getCssValue("color");
		checkHighlightText(expectedTextColor21,actualTextColorManage,"Manage tab Highlight",dr);
		String actualColorRoles=dr.findElement(By.xpath("//div[2]/div/ul/li/a")).getCssValue("color");
		checkHighlightText(actualColorRoles, actualTextColorManage, "Roles side tab", dr);
		String xpath="//*[@id='content-body']/div/div/div[2]/div[2]/div/table/tbody/tr/th";
		WebElement studyUserRoles= dr.findElement(By.xpath(xpath));
		String expectedText4Manage="Role";
		validateText(studyUserRoles, expectedText4Manage, "Manage-Study User roles", "Manage Tab", dr);
		Thread.sleep(3000);   
		//check appearance of add roles 
		WebElement addRoles=dr.findElement(By.xpath("//a[contains(text(),'Add Roles')]"));
		checkObjectDisplay(addRoles, "Add Roles", "Add Roles Button", dr);
		//check appearance of role and action
		WebElement role=dr.findElement(By.xpath(xpath));
		checkObjectDisplay(role, "Role", "Role", dr);
		String xpathAction="//div[@id='content-body']/div/div/div[2]/div[2]/div/table/tbody/tr/th[2]";
		WebElement action=dr.findElement(By.xpath(xpathAction));
		checkObjectDisplay(action, "Action", "Action", dr);
		//check appearance of elements under Role
		WebElement projectManager=dr.findElement(By.xpath("//table/tbody/tr[2]/td"));
		checkObjectDisplay(projectManager, "Project Manager", "Project Manager", dr);
		WebElement studyAdmin=dr.findElement(By.xpath("//table/tbody/tr[3]/td"));
		checkObjectDisplay(studyAdmin, "Study Administrator", "Study Administrator", dr);
		WebElement dataManager=dr.findElement(By.xpath("//table/tbody/tr[4]/td"));
		checkObjectDisplay(dataManager, "Data Manager", "Data Manager", dr);
		WebElement siteCoordinator=dr.findElement(By.xpath("//table/tbody/tr[5]/td"));
		checkObjectDisplay(siteCoordinator, "Site Coordinator", "Site Coordinator", dr);
		//check appearance of elements under Action
		WebElement viewRecord=dr.findElement(By.xpath("//a[@title='View Record']"));
		checkObjectDisplay(viewRecord, "View Record Project Manager", "View record for Project Manager", dr);
		WebElement viewRecord2=dr.findElement(By.xpath("//tr[3]/td[2]/div/a/img"));
		checkObjectDisplay(viewRecord2, "View Record Study Administrator", "View record for Study Administrator", dr);
		WebElement dataManagerEdit=dr.findElement(By.xpath("//tr[4]/td[2]/div/a/img"));
		checkObjectDisplay(dataManagerEdit, "Data Manager Edit button", "Data Manager Edit button", dr);
		WebElement dataManagerDelete=dr.findElement(By.xpath("//a[2]/img"));
		checkObjectDisplay(dataManagerDelete, "Data Manager Delete button", "Data Manager Delete button", dr);
		WebElement siteAdminView=dr.findElement(By.xpath("//tr[5]/td[2]/div/a/img"));
		checkObjectDisplay(siteAdminView, "Site Coordinator Edit button", "Site Coordinator Edit button", dr);
		WebElement siteAdminDelete=dr.findElement(By.xpath("//tr[5]/td[2]/div/a[2]/img"));
		checkObjectDisplay(siteAdminDelete, "Site Coordinator Delete button", "Site Coordinator Delete button", dr);
	}

	@Test
	public void auto_Clini_Manage_003() throws InterruptedException,IOException{
		Actions tooltip = new Actions(dr);
		login(dr);
		Thread.sleep(3000);
		dr.findElement(By.xpath("//a[contains(text(),'Manage')]")).click();
		Thread.sleep(3000);
		WebElement addRoles=dr.findElement(By.xpath(".//*[@id='content-body']/div/div/h3/span/a"));
		Thread.sleep(3000);
		tooltip.moveToElement(addRoles).build().perform();
		validateTextAttribute(addRoles, "Add Roles", "Add Roles tooltip", "title", "Add roles tooltip", dr);
		WebElement projectManagerViewRecord=dr.findElement(By.xpath(".//*[@id='content-body']/div/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[2]/div/a"));
		Thread.sleep(3000);
		tooltip.moveToElement(projectManagerViewRecord).build().perform();
		validateTextAttribute(projectManagerViewRecord, "View Record", "View Record tooltip", "title", "Project manager View record tooltip", dr);
		WebElement studyAdminViewRecord=dr.findElement(By.xpath(".//*[@id='content-body']/div/div/div[2]/div[2]/div[1]/table/tbody/tr[3]/td[2]/div/a"));
		Thread.sleep(3000);
		tooltip.moveToElement(studyAdminViewRecord).build().perform();
		validateTextAttribute(studyAdminViewRecord, "View Record", "View Record tooltip", "title", "Study Administrator View record tooltip", dr);
		WebElement dataMgrEditRecord=dr.findElement(By.xpath(".//*[@id='content-body']/div/div/div[2]/div[2]/div[1]/table/tbody/tr[4]/td[2]/div/a[1]"));
		Thread.sleep(3000);
		tooltip.moveToElement(dataMgrEditRecord).build().perform();
		validateTextAttribute(dataMgrEditRecord, "Edit Record", "Edit Record tooltip", "title", "Data Manager Edit record tooltip", dr);
		WebElement siteCoordEditRecord=dr.findElement(By.xpath(".//*[@id='content-body']/div/div/div[2]/div[2]/div[1]/table/tbody/tr[5]/td[2]/div/a[1]"));
		Thread.sleep(3000);
		tooltip.moveToElement(siteCoordEditRecord).build().perform();
		validateTextAttribute(siteCoordEditRecord, "Edit Record", "Edit Record tooltip", "title", "Site Coordinator Edit record tooltip", dr);
		WebElement dataMgrDeleteRecord=dr.findElement(By.xpath(".//*[@id='content-body']/div/div/div[2]/div[2]/div[1]/table/tbody/tr[4]/td[2]/div/a[2]"));
		Thread.sleep(3000);
		tooltip.moveToElement(dataMgrDeleteRecord).build().perform();
		validateTextAttribute(dataMgrDeleteRecord, "Delete Record", "Delete Record tooltip", "title", "Data Manager Delete record tooltip", dr);
		WebElement siteCoordDeleteRecord=dr.findElement(By.xpath(".//*[@id='content-body']/div/div/div[2]/div[2]/div[1]/table/tbody/tr[5]/td[2]/div/a[2]"));
		Thread.sleep(3000);
		tooltip.moveToElement(siteCoordDeleteRecord).build().perform();
		validateTextAttribute(siteCoordDeleteRecord, "Delete Record", "Delete Record tooltip", "title", "Site Coordinator Delete record tooltip", dr);
	}

	public void auto_Clini_Manage_004() throws InterruptedException, IOException

	{

		login(dr);
		Thread.sleep(4000);
		JavascriptExecutor jse = (JavascriptExecutor)dr;
		//clicking on manage tab in home screen
		WebElement manageTab = dr.findElement(By.xpath(".//*[@id='nav']/ul/li[3]/a"));
		clickElement(manageTab, "Manage tab", "clicked on manage tab", dr);
		System.out.println("clicked on manage tab.....");
		//clicking on action icon for project manager
		WebElement actionIcon_projManager = dr.findElement(By.xpath(".//*[@id='content-body']/div/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[2]/div/a/img"));
		clickElement(actionIcon_projManager, "projectmanager action icon", "clicked on action icon for projectManager", dr);
		System.out.println("clicked on action icon for project manager....");
		System.out.println("-----------------------------------------------");
		//#1
		Thread.sleep(3000);
		String actualRoleName = (String) jse.executeScript("return arguments[0].value;",dr.findElement(By.xpath("//*[@id='edit_inv_role_name']")));
		String expectedRoleName = "Project Manager";
		checkContentsMatch(actualRoleName,expectedRoleName,"RoleName","Role Name Text Validation",dr);
		System.out.println("text for Project Manager is validated....");
		//#2
		WebElement studydetails = dr.findElement(By.xpath(".//*[@id='edit_cs_studydetails']"));
		checkDropdownDEnableSelectedOpt(studydetails, "Write", "Disabled", "verify Write is present in the Study details textbox", dr);
		//#3
		WebElement sitesDD = dr.findElement(By.xpath(".//*[@id='edit_cs_sites']"));
		checkDropdownDEnableSelectedOpt(sitesDD, "Write", "Disabled", "verify Write is present in the sites textbox", dr);
		//#4
		WebElement trialArmsDD = dr.findElement(By.xpath(".//*[@id='edit_cs_trialarms']"));
		checkDropdownDEnableSelectedOpt(trialArmsDD, "Write", "Disabled","verify Write is present in the trailArms dropdown textbox", dr);
		//#5
		WebElement itemsDD = dr.findElement(By.xpath(".//*[@id='edit_cs_variable']"));
		checkDropdownDEnableSelectedOpt(itemsDD, "Write", "Disabled", "verify Write is present in the items dropdown textbox", dr);
		//#6
		WebElement items_group_Obj = dr.findElement(By.xpath(".//*[@id='edit_cs_itemgroup']"));
		checkDropdownDEnableSelectedOpt(items_group_Obj, "Write", "Disabled", "verify Write is present in the items_group dropdown textbox", dr);
		//#7
		WebElement formsDD = dr.findElement(By.xpath(".//*[@id='edit_cs_forms']"));
		checkDropdownDEnableSelectedOpt(formsDD, "Write", "Disabled", "verify Write is present in the forms dropdown textbox", dr);
		//#8
		WebElement visits = dr.findElement(By.xpath(".//*[@id='edit_cs_visits']"));
		checkDropdownDEnableSelectedOpt(visits, "Write", "Disabled", "verify Write is present in the visits dropdown textbox", dr);
		//#9
		WebElement fileRepository = dr.findElement(By.xpath(".//*[@id='edit_cs_filerepository']"));
		checkDropdownDEnableSelectedOpt(fileRepository, "Write", "Disabled", "verify Write is present in the fileRepsitory dropdown textbox", dr);
		//#10
		WebElement lock = dr.findElement(By.xpath(".//*[@id='edit_cs_lock']"));
		checkDropdownDEnableSelectedOpt(lock, "Write", "Disabled", "verify Write is present in the lock dropdown textbox", dr);
		//#11
		Thread.sleep(2000);


		//WebDriverWait wait = new WebDriverWait(dr, 30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='edit_ms_users']")));
		//jse.executeScript("window.scrollBy(0,500)");
		WebElement users = dr.findElement(By.xpath(".//*[@id='edit_ms_users']"));
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", users);
		checkDropdownDEnableSelectedOpt(users, "Write", "Disabled", "verify Write is present in the users dropdown textbox", dr);


		//#12
		WebElement export_reports = dr.findElement(By.xpath(".//*[@id='edit_ms_export-reports']"));
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", export_reports);
		checkDropdownDEnableSelectedOpt(export_reports, "Write", "Disabled", "verify Write is present in the export_reports dropdown textbox", dr);
		//#13//performing scrolldown operation
		WebElement analyse = dr.findElement(By.xpath(".//*[@id='edit_analyze_study']"));
		System.out.println("performing scrolldown operation until a particular element...");
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", analyse);
		//	    JavascriptExecutor jse =  (JavascriptExecutor)dr;
		//	    jse.executeScript(scroll(0,200));
		checkDropdownDEnableSelectedOpt(analyse, "Write", "Disabled", "verify Write is present in the analyse dropdown textbox", dr);
		//#14
		WebElement viewSubjects = dr.findElement(By.xpath(".//*[@id='edit_view_subjects']"));
		checkDropdownDEnableSelectedOpt(viewSubjects, "None", "Disabled", "verify Write is present in the viewSubjects dropdown textbox", dr);
		//#15
		WebElement audit = dr.findElement(By.xpath(".//*[@id='edit_investigator_audit']"));
		checkDropdownDEnableSelectedOpt(audit, "Write", "Disabled", "verify Write is present in the audit dropdown textbox", dr);
		//#16
		WebElement role = dr.findElement(By.xpath(".//*[@id='edit_ms_roles']"));
		checkDropdownDEnableSelectedOpt(role, "None", "Disabled", "verify Write is present in the role dropdown textbox", dr);
		//#17
		WebElement quries = dr.findElement(By.xpath(".//*[@id='edit_ms_queries']"));
		checkDropdownDEnableSelectedOpt(quries, "None", "Disabled", "verify Write is present in the queries dropdown textbox", dr);
		//#18
		WebElement formReview = dr.findElement(By.xpath(".//*[@id='edit_form_review']"));
		checkDropdownDEnableSelectedOpt(formReview, "None", "Disabled", "verify Write is present in the formReview dropdown textbox", dr);
		//#19
		Thread.sleep(6000);
		WebElement unlock_subject_site = dr.findElement(By.xpath(".//*[@id='edit_unlock_subject']"));
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", unlock_subject_site);
		checkDropdownDEnableSelectedOpt(unlock_subject_site, "None", "Disabled", "verify Write is present in the unlock_subject_site dropdown textbox", dr);
		//#20
		Thread.sleep(6000);
		WebElement siteLock = dr.findElement(By.xpath(".//*[@id='edit_site_lock']"));
		checkDropdownDEnableSelectedOpt(siteLock, "None", "Disabled", "verify Write is present in the site_lock dropdown textbox", dr);
		//#21
		WebElement registerSubjects = dr.findElement(By.xpath(".//*[@id='edit_ipad_registersubjects']"));
		checkDropdownDEnableSelectedOpt(registerSubjects, "None", "Disabled", "verify Write is present in the register subjects dropdown textbox", dr);
		//#22
		WebElement consent_visit = dr.findElement(By.xpath(".//*[@id='edit_ipad_consentvisit']"));
		checkDropdownDEnableSelectedOpt(consent_visit, "None", "Disabled", "verify Write is present in the unlock_subject_site dropdown textbox", dr);
		//#23
		WebElement syncData = dr.findElement(By.xpath(".//*[@id='edit_ipad_syncdata']"));
		checkDropdownDEnableSelectedOpt(syncData, "None", "Disabled", "verify Write is present in the sync_data dropdown textbox", dr);
		//#24
		Thread.sleep(4000);
		WebElement visitData = dr.findElement(By.xpath(".//*[@id='edit_ipad_visitdata']"));
		checkDropdownDEnableSelectedOpt(visitData, "None", "Disabled", "verify Write is present in the visitdata dropdown textbox", dr);
		//#25
		WebElement subjectIdentifier = dr.findElement(By.xpath(".//*[@id='edit_vs_identifier']"));
		checkDropdownDEnableSelectedOpt(subjectIdentifier, "None", "Disabled", "verify Write is present in the subject identifier dropdown textbox", dr);
		//#26
		WebElement formVerification = dr.findElement(By.xpath(".//*[@id='edit_form_verify']"));
		checkDropdownDEnableSelectedOpt(formVerification, "None", "Disabled", "verify Write is present in the formVerification dropdown textbox", dr);
		//#27
		WebElement cancel_button = dr.findElement(By.xpath(".//*[@id='editRole']/fieldset[27]/div/div/input[2]"));
		clickElement(cancel_button, "cancel button object", "click on cancel button", dr);
		System.out.println("clicked on cancel for project manager edit role......");
		Thread.sleep(4000);
		//clicking study administrator view record
		System.out.println("clicking on study administrator view record......");
		System.out.println("--------------------------------------------------");
		WebElement study_administrator_obj = dr.findElement(By.xpath(".//*[@id='content-body']/div/div/div[2]/div[2]/div[1]/table/tbody/tr[3]/td[2]/div/a/img"));
		//	   WebDriverWait wait = new WebDriverWait(dr, 30);
		//	   wait.until(ExpectedConditions.elementToBeClickable(study_administrator_obj)).click();
		clickElement(study_administrator_obj, "study_administrator object", "study admin edit role icon", dr);
		System.out.println("clicked on study admin edit role.....");
		//#1
		//verifying the fields for action icon for project manager textbox
		Thread.sleep(3000);
		String actualRoleName2 = (String) jse.executeScript("return arguments[0].value;",dr.findElement(By.xpath("//*[@id='edit_inv_role_name']")));
		String expectedRoleName2 = "Study Administrator";
		checkContentsMatch(actualRoleName2,expectedRoleName2,"RoleName","Role Name Text Validation",dr);
		System.out.println("text for Study Administrator is validated....");
		//#2
		WebElement studydetails1 = dr.findElement(By.xpath(".//*[@id='edit_cs_studydetails']"));
		Thread.sleep(3000);
		checkDropdownDEnableSelectedOpt(studydetails1, "Write", "Disabled", "verify Write is present in the Study details textbox", dr);
		//#3
		WebElement sites1DD = dr.findElement(By.xpath(".//*[@id='edit_cs_sites']"));
		checkDropdownDEnableSelectedOpt(sites1DD, "Write", "Disabled", "verify Write is present in the sites textbox", dr);
		//#4
		WebElement trialArms1DD = dr.findElement(By.xpath(".//*[@id='edit_cs_trialarms']"));
		checkDropdownDEnableSelectedOpt(trialArms1DD, "Write", "Disabled", "verify Write is present in the trailArms dropdown textbox", dr);
		//#5
		WebElement items1DD = dr.findElement(By.xpath(".//*[@id='edit_cs_variable']"));
		checkDropdownDEnableSelectedOpt(items1DD, "Write", "Disabled", "verify Write is present in the items dropdown textbox", dr);
		//#6
		WebElement items_group_Obj1 = dr.findElement(By.xpath(".//*[@id='edit_cs_itemgroup']"));
		checkDropdownDEnableSelectedOpt(items_group_Obj1, "Write", "Disabled", "verify Write is present in the items_group dropdown textbox", dr);
		//#7
		WebElement forms1DD = dr.findElement(By.xpath(".//*[@id='edit_cs_forms']"));
		checkDropdownDEnableSelectedOpt(forms1DD, "Write", "Disabled", "verify Write is present in the forms dropdown textbox", dr);
		//#8
		WebElement visits1 = dr.findElement(By.xpath(".//*[@id='edit_cs_visits']"));
		checkDropdownDEnableSelectedOpt(visits1, "Write", "Disabled", "verify Write is present in the visits dropdown textbox", dr);
		//#9
		WebElement fileRepository1 = dr.findElement(By.xpath(".//*[@id='edit_cs_filerepository']"));
		checkDropdownDEnableSelectedOpt(fileRepository1, "Write", "Disabled", "verify Write is present in the fileRepsitory dropdown textbox", dr);
		//#10
		WebElement lock1 = dr.findElement(By.xpath(".//*[@id='edit_cs_lock']"));
		checkDropdownDEnableSelectedOpt(lock1, "Write", "Disabled", "verify Write is present in the lock dropdown textbox", dr);
		//#11
		Thread.sleep(3000);
		WebElement user1 = dr.findElement(By.xpath(".//*[@id='edit_ms_users']"));
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", user1);
		checkDropdownDEnableSelectedOpt(user1, "Write", "Disabled", "verify Write is present in the users dropdown textbox", dr);
		//#12
		WebElement export_reports1 = dr.findElement(By.xpath(".//*[@id='edit_ms_export-reports']"));
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", export_reports1);
		checkDropdownDEnableSelectedOpt(export_reports1, "Write", "Disabled", "verify Write is present in the export_reports dropdown textbox", dr);
		//#13//performing scrolldown operation
		WebElement analyse1 = dr.findElement(By.xpath(".//*[@id='edit_analyze_study']"));
		System.out.println("performing scrolldown operation until a particular element...");
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", analyse1);
		//	    JavascriptExecutor jse =  (JavascriptExecutor)dr;
		//	    jse.executeScript(scroll(0,200));
		checkDropdownDEnableSelectedOpt(analyse1, "Write", "Disabled", "verify Write is present in the analyse dropdown textbox", dr);
		//#14
		WebElement viewSubjects1 = dr.findElement(By.xpath(".//*[@id='edit_view_subjects']"));
		checkDropdownDEnableSelectedOpt(viewSubjects1, "Write", "Disabled", "verify Write is present in the viewSubjects dropdown textbox", dr);
		//#15
		WebElement audit1 = dr.findElement(By.xpath(".//*[@id='edit_investigator_audit']"));
		checkDropdownDEnableSelectedOpt(audit1, "Write", "Disabled", "verify Write is present in the audit dropdown textbox", dr);
		//#16
		WebElement role1 = dr.findElement(By.xpath(".//*[@id='edit_ms_roles']"));
		checkDropdownDEnableSelectedOpt(role1, "Write", "Disabled", "verify Write is present in the role dropdown textbox", dr);
		//#17
		WebElement quries1 = dr.findElement(By.xpath(".//*[@id='edit_ms_queries']"));
		checkDropdownDEnableSelectedOpt(quries1, "Write", "Disabled", "verify Write is present in the queries dropdown textbox", dr);
		//#18
		WebElement formReview1 = dr.findElement(By.xpath(".//*[@id='edit_form_review']"));
		checkDropdownDEnableSelectedOpt(formReview1, "Write", "Disabled", "verify Write is present in the formReview dropdown textbox", dr);
		//#19
		Thread.sleep(6000);
		WebElement unlock_subject_site1 = dr.findElement(By.xpath(".//*[@id='edit_unlock_subject']"));
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", unlock_subject_site1);
		checkDropdownDEnableSelectedOpt(unlock_subject_site1, "Write", "Disabled", "verify Write is present in the unlock_subject_site dropdown textbox", dr);
		//#20
		Thread.sleep(6000);
		WebElement siteLock1 = dr.findElement(By.xpath(".//*[@id='edit_site_lock']"));
		checkDropdownDEnableSelectedOpt(siteLock1, "None", "Disabled", "verify Write is present in the site_lock dropdown textbox", dr);
		//#21
		WebElement registerSubjects1 = dr.findElement(By.xpath(".//*[@id='edit_ipad_registersubjects']"));
		checkDropdownDEnableSelectedOpt(registerSubjects1, "Write", "Disabled", "verify Write is present in the register subjects dropdown textbox", dr);
		//#22
		WebElement consent_visit1 = dr.findElement(By.xpath(".//*[@id='edit_ipad_consentvisit']"));
		checkDropdownDEnableSelectedOpt(consent_visit1, "Write", "Disabled", "verify Write is present in the unlock_subject_site dropdown textbox", dr);
		//#23
		WebElement syncData1 = dr.findElement(By.xpath(".//*[@id='edit_ipad_syncdata']"));
		checkDropdownDEnableSelectedOpt(syncData1, "Write", "Disabled", "verify Write is present in the sync_data dropdown textbox", dr);
		//#24
		Thread.sleep(4000);
		WebElement visitData1 = dr.findElement(By.xpath(".//*[@id='edit_ipad_visitdata']"));
		checkDropdownDEnableSelectedOpt(visitData1, "Write", "Disabled", "verify Write is present in the visitdata dropdown textbox", dr);
		//#25
		WebElement subjectIdentifier1 = dr.findElement(By.xpath(".//*[@id='edit_vs_identifier']"));
		checkDropdownDEnableSelectedOpt(subjectIdentifier1, "Write", "Disabled", "verify Write is present in the subject identifier dropdown textbox", dr);
		//#26
		WebElement formVerification1 = dr.findElement(By.xpath(".//*[@id='edit_form_verify']"));
		checkDropdownDEnableSelectedOpt(formVerification1, "Write", "Disabled", "verify Write is present in the formVerification dropdown textbox", dr);
		//#27
		WebElement cancel_button1 = dr.findElement(By.xpath(".//*[@id='editRole']/fieldset[27]/div/div/input[2]"));
		clickElement(cancel_button1, "cancel button object", "click on cancel button", dr);
		//clicking on DataManager edit record icon
		System.out.println("clicking on DataManager edit record icon");
		System.out.println("----------------------------------------");
		WebElement data_Manager_editrole_obj = dr.findElement(By.xpath(".//*[@id='content-body']/div/div/div[2]/div[2]/div[1]/table/tbody/tr[4]/td[2]/div/a[1]/img"));
		Thread.sleep(3000);
		clickElement(data_Manager_editrole_obj, "data_Manager_editrole_obj", "data manager edit role icon", dr);
		System.out.println("clicked on data_Manager_editrole_obj.....");
		Thread.sleep(3000);
		//#1
		//verifying the fields for action icon for project manager textbox
		Thread.sleep(3000);
		String actualRoleName3 = (String) jse.executeScript("return arguments[0].value;",dr.findElement(By.xpath("//*[@id='edit_inv_role_name']")));
		String expectedRoleName3 = "Data Manager";
		checkContentsMatch(actualRoleName3,expectedRoleName3,"RoleName","Role Name Text Validation",dr);
		System.out.println("text for Data Manager is validated....");
		//#2
		WebElement studydetails2 = dr.findElement(By.xpath(".//*[@id='edit_cs_studydetails']"));
		Thread.sleep(3000);
		checkDropdownDEnableSelectedOpt(studydetails2, "Write", "Enabled", "verify Write is present in the Study details textbox", dr);
		//#3
		WebElement sites2DD = dr.findElement(By.xpath(".//*[@id='edit_cs_sites']"));
		checkDropdownDEnableSelectedOpt(sites2DD, "Write", "Enabled", "verify Write is present in the sites textbox", dr);
		//#4
		WebElement trialArms2DD = dr.findElement(By.xpath(".//*[@id='edit_cs_trialarms']"));
		checkDropdownDEnableSelectedOpt(trialArms2DD, "Write", "Enabled", "verify Write is present in the trailArms dropdown textbox", dr);
		//#5
		WebElement items2DD = dr.findElement(By.xpath(".//*[@id='edit_cs_variable']"));
		checkDropdownDEnableSelectedOpt(items2DD, "Write", "Enabled", "verify Write is present in the items dropdown textbox", dr);
		//#6
		WebElement items_group_Obj2 = dr.findElement(By.xpath(".//*[@id='edit_cs_itemgroup']"));
		checkDropdownDEnableSelectedOpt(items_group_Obj2, "Write", "Enabled", "verify Write is present in the items_group dropdown textbox", dr);
		//#7
		WebElement forms2DD = dr.findElement(By.xpath(".//*[@id='edit_cs_forms']"));
		checkDropdownDEnableSelectedOpt(forms2DD, "Write", "Enabled", "verify Write is present in the forms dropdown textbox", dr);
		//#8
		WebElement visits2 = dr.findElement(By.xpath(".//*[@id='edit_cs_visits']"));
		checkDropdownDEnableSelectedOpt(visits2, "Write", "Enabled", "verify Write is present in the visits dropdown textbox", dr);
		//#9
		WebElement fileRepository2 = dr.findElement(By.xpath(".//*[@id='edit_cs_filerepository']"));
		checkDropdownDEnableSelectedOpt(fileRepository2, "Write", "Enabled", "verify Write is present in the fileRepsitory dropdown textbox", dr);
		//#10
		WebElement locks2 = dr.findElement(By.xpath(".//*[@id='edit_cs_lock']"));
		checkDropdownDEnableSelectedOpt(locks2, "Write", "Enabled", "verify Write is present in the lock dropdown textbox", dr);
		//#11
		//Thread.sleep(3000);
		WebElement user2 = dr.findElement(By.xpath(".//*[@id='edit_ms_users']"));
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", user2);
		checkDropdownDEnableSelectedOpt(user2, "Write", "Enabled", "verify Write is present in the users dropdown textbox", dr);
		//#12
		WebElement export_reports2 = dr.findElement(By.xpath(".//*[@id='edit_ms_export-reports']"));
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", export_reports1);
		checkDropdownDEnableSelectedOpt(export_reports2, "Write", "Enabled", "verify Write is present in the export_reports dropdown textbox", dr);
		//#13//performing scrolldown operation
		WebElement analyse2 = dr.findElement(By.xpath(".//*[@id='edit_analyze_study']"));
		System.out.println("performing scrolldown operation until a particular element...");
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", analyse2);
		//	    JavascriptExecutor jse =  (JavascriptExecutor)dr;
		//	    jse.executeScript(scroll(0,200));
		checkDropdownDEnableSelectedOpt(analyse2, "Write", "Enabled", "verify Write is present in the analyse dropdown textbox", dr);
		//#14
		WebElement viewSubjects2 = dr.findElement(By.xpath(".//*[@id='edit_view_subjects']"));
		checkDropdownDEnableSelectedOpt(viewSubjects2, "Write", "Enabled", "verify Write is present in the viewSubjects dropdown textbox", dr);
		//#15
		WebElement audit2 = dr.findElement(By.xpath(".//*[@id='edit_investigator_audit']"));
		checkDropdownDEnableSelectedOpt(audit2, "Write", "Enabled", "verify Write is present in the audit dropdown textbox", dr);
		//#16
		WebElement role2 = dr.findElement(By.xpath(".//*[@id='edit_ms_roles']"));
		checkDropdownDEnableSelectedOpt(role2, "Write", "Enabled", "verify Write is present in the role dropdown textbox", dr);
		//#17
		WebElement quries2 = dr.findElement(By.xpath(".//*[@id='edit_ms_queries']"));
		checkDropdownDEnableSelectedOpt(quries2, "Write", "Enabled", "verify Write is present in the queries dropdown textbox", dr);
		//#18
		WebElement formReview2 = dr.findElement(By.xpath(".//*[@id='edit_form_review']"));
		checkDropdownDEnableSelectedOpt(formReview2, "Write", "Enabled", "verify Write is present in the formReview dropdown textbox", dr);
		//#19
		Thread.sleep(6000);
		WebElement unlock_subject_site2 = dr.findElement(By.xpath(".//*[@id='edit_unlock_subject']"));
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", unlock_subject_site2);
		checkDropdownDEnableSelectedOpt(unlock_subject_site2, "None", "Enabled", "verify Write is present in the unlock_subject_site dropdown textbox", dr);
		//#20
		Thread.sleep(6000);
		WebElement siteLock2 = dr.findElement(By.xpath(".//*[@id='edit_site_lock']"));
		checkDropdownDEnableSelectedOpt(siteLock2, "None", "Enabled", "verify Write is present in the site_lock dropdown textbox", dr);
		//#21
		WebElement registerSubjects2 = dr.findElement(By.xpath(".//*[@id='edit_ipad_registersubjects']"));
		checkDropdownDEnableSelectedOpt(registerSubjects2, "None", "Enabled", "verify Write is present in the register subjects dropdown textbox", dr);
		//#22
		WebElement consent_visit2 = dr.findElement(By.xpath(".//*[@id='edit_ipad_consentvisit']"));
		checkDropdownDEnableSelectedOpt(consent_visit2, "None", "Enabled", "verify Write is present in the unlock_subject_site dropdown textbox", dr);
		//#23
		WebElement syncData2 = dr.findElement(By.xpath(".//*[@id='edit_ipad_syncdata']"));
		checkDropdownDEnableSelectedOpt(syncData2, "None", "Enabled", "verify Write is present in the sync_data dropdown textbox", dr);
		//#24
		Thread.sleep(4000);
		WebElement visitData2 = dr.findElement(By.xpath(".//*[@id='edit_ipad_visitdata']"));
		checkDropdownDEnableSelectedOpt(visitData2, "None", "Enabled", "verify Write is present in the visitdata dropdown textbox", dr);
		//#25
		WebElement subjectIdentifier2 = dr.findElement(By.xpath(".//*[@id='edit_vs_identifier']"));
		checkDropdownDEnableSelectedOpt(subjectIdentifier2, "Write", "Enabled", "verify Write is present in the subject identifier dropdown textbox", dr);
		//#26
		WebElement formVerification2 = dr.findElement(By.xpath(".//*[@id='edit_form_verify']"));
		checkDropdownDEnableSelectedOpt(formVerification2, "None", "Enabled", "verify Write is present in the formVerification dropdown textbox", dr);
		WebElement update_obj = dr.findElement(By.xpath(".//*[@id='edit_inv_role_submit']"));
		if(update_obj.isDisplayed())
		{
			System.out.println("update button is present in the DataManager edit role icon window......");
		}
		WebElement cancel_button2 = dr.findElement(By.xpath(".//*[@id='editRole']/fieldset[27]/div/div/input[2]"));
		if(cancel_button2.isDisplayed())
		{
			System.out.println("cancel button is present in the DataManager edit role icon window......");
		}
		//#27
		clickElement(cancel_button2, "cancel button object", "click on cancel button", dr);
		System.out.println("clicking on data manager delete icon.............");
		Thread.sleep(3000);
		System.out.println("------------------------------------------------");
		WebElement datamanager_deleteRecord_obj = dr.findElement(By.xpath(".//*[@id='content-body']/div/div/div[2]/div[2]/div[1]/table/tbody/tr[4]/td[2]/div/a[2]/img"));
		Thread.sleep(3000);
		clickElement(datamanager_deleteRecord_obj, "data manager delete record object", "clicked on delete record icon ", dr);
		Thread.sleep(7000);
		WebElement cancel3 = dr.findElement(By.xpath("html/body/div[4]/div[3]/div/button[2]"));

		if(cancel3.isDisplayed())
		{
			System.out.println("cancel button is present in the delete role icon window......");
		}
		WebElement ok_obj_deleteicon_dataManager = dr.findElement(By.xpath("html/body/div[4]/div[3]/div/button[1]"));
		if(ok_obj_deleteicon_dataManager.isDisplayed())
		{
			System.out.println("ok button is present in the delete role icon window......");
		}
		clickElement(cancel3, "cancel button object", "clicked on delete role canceel button", dr);
		System.out.println("clicked on cancel button on datamanager delete icon...........");
		System.out.println("clicking on select co-ordinator edit record icon........");
		System.out.println("--------------------------------------------------------");
		WebElement site_co_ordinator_editRole_icon = dr.findElement(By.xpath(".//*[@id='content-body']/div/div/div[2]/div[2]/div[1]/table/tbody/tr[5]/td[2]/div/a[1]/img"));
		clickElement(site_co_ordinator_editRole_icon, "siteCoordinator edit record object", "clicked on site co-ord edit record object", dr);
		Thread.sleep(3000);
		//#1
		//verifying the fields for action icon for site co_ordinator textbox
		Thread.sleep(3000);
		String actualRoleName4 = (String) jse.executeScript("return arguments[0].value;",dr.findElement(By.xpath("//*[@id='edit_inv_role_name']")));
		String expectedRoleName4 = "Site Coordinator";
		checkContentsMatch(actualRoleName4,expectedRoleName4,"RoleName","Role Name Text Validation",dr);
		System.out.println("text for site coordinator is validated....");
		//#2
		WebElement studydetails3 = dr.findElement(By.xpath(".//*[@id='edit_cs_studydetails']"));
		Thread.sleep(3000);
		checkDropdownDEnableSelectedOpt(studydetails3, "None", "Enabled", "verify Write is present in the Study details textbox", dr);
		//#3
		WebElement sites3DD = dr.findElement(By.xpath(".//*[@id='edit_cs_sites']"));
		checkDropdownDEnableSelectedOpt(sites3DD, "None", "Enabled", "verify Write is present in the sites textbox", dr);
		//#4
		WebElement trialArms3DD = dr.findElement(By.xpath(".//*[@id='edit_cs_trialarms']"));
		checkDropdownDEnableSelectedOpt(trialArms3DD, "None", "Enabled", "verify Write is present in the trailArms dropdown textbox", dr);
		//#5
		WebElement items3DD = dr.findElement(By.xpath(".//*[@id='edit_cs_variable']"));
		checkDropdownDEnableSelectedOpt(items3DD, "None", "Enabled", "verify Write is present in the items dropdown textbox", dr);
		//#6
		WebElement items_group_Obj3 = dr.findElement(By.xpath(".//*[@id='edit_cs_itemgroup']"));
		checkDropdownDEnableSelectedOpt(items_group_Obj3, "None", "Enabled", "verify Write is present in the items_group dropdown textbox", dr);
		//#7
		WebElement forms3DD = dr.findElement(By.xpath(".//*[@id='edit_cs_forms']"));
		checkDropdownDEnableSelectedOpt(forms3DD, "Write", "Enabled", "verify Write is present in the forms dropdown textbox", dr);
		//#8
		WebElement visits3 = dr.findElement(By.xpath(".//*[@id='edit_cs_visits']"));
		checkDropdownDEnableSelectedOpt(visits3, "None", "Enabled", "verify Write is present in the visits dropdown textbox", dr);
		//#9
		WebElement fileRepository3 = dr.findElement(By.xpath(".//*[@id='edit_cs_filerepository']"));
		checkDropdownDEnableSelectedOpt(fileRepository3, "None", "Enabled", "verify Write is present in the fileRepsitory dropdown textbox", dr);
		//#10
		WebElement locks3 = dr.findElement(By.xpath(".//*[@id='edit_cs_lock']"));
		checkDropdownDEnableSelectedOpt(locks3, "None", "Enabled", "verify Write is present in the lock dropdown textbox", dr);
		//#11
		Thread.sleep(3000);
		WebElement user3 = dr.findElement(By.xpath(".//*[@id='edit_ms_users']"));
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", user3);
		checkDropdownDEnableSelectedOpt(user3, "None", "Enabled", "verify Write is present in the users dropdown textbox", dr);
		//#12
		WebElement export_reports3 = dr.findElement(By.xpath(".//*[@id='edit_ms_export-reports']"));
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", export_reports1);
		checkDropdownDEnableSelectedOpt(export_reports3, "None", "Enabled", "verify Write is present in the export_reports dropdown textbox", dr);
		//#13//performing scrolldown operation
		WebElement analyse3 = dr.findElement(By.xpath(".//*[@id='edit_analyze_study']"));
		System.out.println("performing scrolldown operation until a particular element...");
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", analyse3);
		//	    JavascriptExecutor jse =  (JavascriptExecutor)dr;
		//	    jse.executeScript(scroll(0,200));
		checkDropdownDEnableSelectedOpt(analyse3, "Write", "Enabled", "verify Write is present in the analyse dropdown textbox", dr);
		//#14
		WebElement viewSubjects3 = dr.findElement(By.xpath(".//*[@id='edit_view_subjects']"));
		checkDropdownDEnableSelectedOpt(viewSubjects3, "Write", "Enabled", "verify Write is present in the viewSubjects dropdown textbox", dr);
		//#15
		WebElement audit3 = dr.findElement(By.xpath(".//*[@id='edit_investigator_audit']"));
		checkDropdownDEnableSelectedOpt(audit3, "None", "Enabled", "verify Write is present in the audit dropdown textbox", dr);
		//#16
		WebElement role3 = dr.findElement(By.xpath(".//*[@id='edit_ms_roles']"));
		checkDropdownDEnableSelectedOpt(role3, "None", "Enabled", "verify Write is present in the role dropdown textbox", dr);
		//#17
		WebElement quries3 = dr.findElement(By.xpath(".//*[@id='edit_ms_queries']"));
		checkDropdownDEnableSelectedOpt(quries3, "None", "Enabled", "verify Write is present in the queries dropdown textbox", dr);
		//#18
		WebElement formReview3 = dr.findElement(By.xpath(".//*[@id='edit_form_review']"));
		checkDropdownDEnableSelectedOpt(formReview3, "None", "Enabled", "verify Write is present in the formReview dropdown textbox", dr);
		//#19
		Thread.sleep(6000);
		WebElement unlock_subject_site3 = dr.findElement(By.xpath(".//*[@id='edit_unlock_subject']"));
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", unlock_subject_site3);
		checkDropdownDEnableSelectedOpt(unlock_subject_site3, "None", "Enabled", "verify Write is present in the unlock_subject_site dropdown textbox", dr);
		//#20
		Thread.sleep(6000);
		WebElement siteLock3 = dr.findElement(By.xpath(".//*[@id='edit_site_lock']"));
		checkDropdownDEnableSelectedOpt(siteLock3, "None", "Enabled", "verify Write is present in the site_lock dropdown textbox", dr);
		//#21
		WebElement registerSubjects3 = dr.findElement(By.xpath(".//*[@id='edit_ipad_registersubjects']"));
		checkDropdownDEnableSelectedOpt(registerSubjects3, "Write", "Enabled", "verify Write is present in the register subjects dropdown textbox", dr);
		//#22
		WebElement consent_visit3 = dr.findElement(By.xpath(".//*[@id='edit_ipad_consentvisit']"));
		checkDropdownDEnableSelectedOpt(consent_visit3, "write", "Enabled", "verify Write is present in the unlock_subject_site dropdown textbox", dr);
		//#23
		WebElement syncData3 = dr.findElement(By.xpath(".//*[@id='edit_ipad_syncdata']"));
		checkDropdownDEnableSelectedOpt(syncData3, "Write", "Enabled", "verify Write is present in the sync_data dropdown textbox", dr);
		//#24
		Thread.sleep(4000);
		WebElement visitData3 = dr.findElement(By.xpath(".//*[@id='edit_ipad_visitdata']"));
		checkDropdownDEnableSelectedOpt(visitData3, "Write", "Enabled", "verify Write is present in the visitdata dropdown textbox", dr);
		//#25
		WebElement subjectIdentifier3 = dr.findElement(By.xpath(".//*[@id='edit_vs_identifier']"));
		checkDropdownDEnableSelectedOpt(subjectIdentifier3, "Write", "Enabled", "verify Write is present in the subject identifier dropdown textbox", dr);
		//#26
		WebElement formVerification3 = dr.findElement(By.xpath(".//*[@id='edit_form_verify']"));
		checkDropdownDEnableSelectedOpt(formVerification3, "Write", "Enabled", "verify Write is present in the formVerification dropdown textbox", dr);
		WebElement update_obj3 = dr.findElement(By.xpath(".//*[@id='edit_inv_role_submit']"));
		if(update_obj3.isDisplayed())
		{
			System.out.println("update button is present in the site co-ordinator edit role icon window......");
		}
		WebElement cancel_button3 = dr.findElement(By.xpath(".//*[@id='editRole']/fieldset[27]/div/div/input[2]"));
		if(cancel_button3.isDisplayed())
		{
			System.out.println("cancel button is present in the site co-ordinator edit role icon window......");
		}
		//#27
		clickElement(cancel_button3, "cancel button object", "click on cancel button", dr);
		Thread.sleep(3000);
		System.out.println("clicking on site co-ordinator delete icon.............");
		System.out.println("-------------------------------------------------------");
		WebElement site_co_deleteIcon_obj = dr.findElement(By.xpath(".//*[@id='content-body']/div/div/div[2]/div[2]/div[1]/table/tbody/tr[5]/td[2]/div/a[2]/img"));
		Thread.sleep(3000);
		clickElement(site_co_deleteIcon_obj, "site_co_ord_delete icon object", "clicking on site coOrdinator  delete icon", dr);
		Thread.sleep(7000);
		WebElement cancel4 = dr.findElement(By.xpath("html/body/div[4]/div[3]/div/button[2]"));
		if(cancel4.isDisplayed())
		{
			System.out.println("cancel button is present in the delete role icon window for site co-ordinator......");
		}
		WebElement ok_obj_deleteicon_site_coOrdinator = dr.findElement(By.xpath("html/body/div[4]/div[3]/div/button[1]"));
		if(ok_obj_deleteicon_site_coOrdinator.isDisplayed())
		{
			System.out.println("ok button is present in the delete role icon window for site coOrdinator......");
		}
		clickElement(cancel4, "cancel button object", "clicked on delete role cancel button", dr);
		System.out.println("clicked on cancel button on site co_ordinator delete icon...........");
	}
	@Test

	public void auto_Clini_Manage_005() throws InterruptedException,IOException,InvocationTargetException{
		login(dr);
		Actions mouseover=new Actions(dr);
		Thread.sleep(3000);
		dr.findElement(By.xpath("//a[contains(text(),'Manage')]")).click();
		Thread.sleep(3000);
		WebElement addRoles=dr.findElement(By.xpath(".//*[@id='content-body']/div/div/h3/span/a"));
		clickElement(addRoles, "Add Roles button", "Click Add Roles button", dr);
		WebElement roleName=dr.findElement(By.id("inv_role_name"));
		if(roleName.getAttribute("value").equals("")){
			updateReport("Pass", "Role Name textbox", "Role name Textbox is empty", dr);
		}
		else{
			updateReport("Fail", "Role Name textbox", "Role name Textbox is not empty", dr);
		}
		//Thread.sleep(3000);
		WebElement studyDetails=dr.findElement(By.id("cs_studydetails"));
		checkDropdownDEnableSelectedOpt(studyDetails, "None", "Enabled","Study Details" ,dr);
		//Thread.sleep(3000);
		WebElement sites=dr.findElement(By.id("cs_sites"));
		checkDropdownDEnableSelectedOpt(sites, "None", "Enabled", "Sites", dr);
		//Thread.sleep(3000);
		WebElement trialArms=dr.findElement(By.id("cs_trialarms"));
		checkDropdownDEnableSelectedOpt(trialArms, "None", "Enabled", "Trial Arms", dr);
		//Thread.sleep(3000);
		WebElement items=dr.findElement(By.id("cs_variable"));
		checkDropdownDEnableSelectedOpt(items, "None", "Enabled", "Items", dr);
		//Thread.sleep(3000);
		WebElement itemGroup=dr.findElement(By.id("cs_itemgroup"));
		checkDropdownDEnableSelectedOpt(itemGroup, "None", "Enabled", "Item-Group", dr);
		//Thread.sleep(3000);
		WebElement forms=dr.findElement(By.id("cs_forms"));
		checkDropdownDEnableSelectedOpt(forms, "None", "Enabled", "Forms", dr);
		//Thread.sleep(3000);
		WebElement visits=dr.findElement(By.id("cs_visits"));
		checkDropdownDEnableSelectedOpt(visits, "None", "Enabled", "Visits", dr);
		//Thread.sleep(3000);
		WebElement fileRepo=dr.findElement(By.id("cs_filerepository"));
		checkDropdownDEnableSelectedOpt(fileRepo, "None", "Enabled", "Files Repository", dr);
		//Thread.sleep(3000);
		WebElement lock =dr.findElement(By.id("cs_lock"));
		checkDropdownDEnableSelectedOpt(lock, "None", "Enabled", "Lock", dr);
		//Thread.sleep(3000);
		WebElement user=dr.findElement(By.id("ms_users"));
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", user);
		checkDropdownDEnableSelectedOpt(user, "None", "Enabled", "User", dr);
		//Thread.sleep(3000);
		WebElement exportReports=dr.findElement(By.id("ms_export-reports"));
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", exportReports);
		//Thread.sleep(5000);
		checkDropdownDEnableSelectedOpt(exportReports, "None", "Enabled", "Export Reports", dr);
		//Thread.sleep(3000);
		WebElement analyze=dr.findElement(By.id("analyze_study"));
		checkDropdownDEnableSelectedOpt(analyze, "None", "Enabled", "Analyze", dr);
		//Thread.sleep(3000);
		WebElement viewSubjects=dr.findElement(By.id("view_subjects"));
		checkDropdownDEnableSelectedOpt(viewSubjects, "None", "Enabled", "View Subjects", dr);
		//Thread.sleep(3000);
		WebElement audit=dr.findElement(By.id("investigator_audit"));
		checkDropdownDEnableSelectedOpt(audit, "None", "Enabled", "Audit", dr);
		//Thread.sleep(3000);
		WebElement role=dr.findElement(By.id("ms_roles"));
		checkDropdownDEnableSelectedOpt(role, "None", "Enabled", "Role", dr);
		//Thread.sleep(3000);
		WebElement queries =dr.findElement(By.id("ms_queries"));
		checkDropdownDEnableSelectedOpt(queries, "None", "Enabled", "Queries", dr);
		//Thread.sleep(3000);
		WebElement formReview=dr.findElement(By.id("form_review"));
		checkDropdownDEnableSelectedOpt(formReview, "None", "Enabled", "Form Review", dr);
		//Thread.sleep(3000);
		WebElement unlockSub=dr.findElement(By.id("unlock_subject"));
		checkDropdownDEnableSelectedOpt(unlockSub, "None", "Enabled", "Unlock Subject/Sites", dr);
		//Thread.sleep(3000);
		WebElement siteLock=dr.findElement(By.id("site_lock"));
		checkDropdownDEnableSelectedOpt(siteLock, "None", "Enabled", "Site Lock", dr);
		//Thread.sleep(3000);
		WebElement registerSub=dr.findElement(By.id("ipad_registersubjects"));
		checkDropdownDEnableSelectedOpt(registerSub, "None", "Enabled", "Register Subjects", dr);
		//Thread.sleep(3000);
		WebElement consentVisit=dr.findElement(By.id("ipad_consentvisit"));
		checkDropdownDEnableSelectedOpt(consentVisit, "None", "Enabled", "Consent Visit", dr);
		//Thread.sleep(3000);
		WebElement syncData=dr.findElement(By.id("ipad_syncdata"));
		checkDropdownDEnableSelectedOpt(syncData, "None", "Enabled", "Sync Data", dr);
		//Thread.sleep(3000);
		WebElement visitData=dr.findElement(By.id("ipad_visitdata"));
		checkDropdownDEnableSelectedOpt(visitData, "None", "Enabled", "Visit Data", dr);
		//Thread.sleep(3000);
		WebElement subIdentifier=dr.findElement(By.id("vs_identifier"));
		checkDropdownDEnableSelectedOpt(subIdentifier, "None", "Enabled", "Subject Identifier", dr);
		//Thread.sleep(3000);
		WebElement formVerification=dr.findElement(By.id("form_verify"));
		checkDropdownDEnableSelectedOpt(formVerification, "None", "Enabled", "Form verification", dr);
		//Thread.sleep(3000);
		WebElement submit=dr.findElement(By.id("inv_role_submit"));
		checkObjectDisplay(submit, "Submit button", "Appearance of Submit button", dr);
		//Thread.sleep(3000);
		WebElement cancel=dr.findElement(By.className("main-btn"));
		checkObjectDisplay(cancel, "Cancel button", "Appearance of Cancel button", dr);
	}	

	@Test
	public void auto_Clini_Manage_006() throws InterruptedException,IOException{
		login(dr);
		Thread.sleep(3000);
		dr.findElement(By.xpath("//a[contains(text(),'Manage')]")).click();
		Thread.sleep(3000);
		WebElement Users=dr.findElement(By.xpath(".//*[text()='Users']"));
		clickElement(Users,"Users Tab", "Users Tab", dr);
		Thread.sleep(2000);
		String actualText=dr.findElement(By.xpath(".//*[@id='content-body']/div[1]/div/h3")).getText().substring(0, 19);
		String expectedText="User Administration";
		checkContentsMatch(actualText,expectedText,"User Adminisration Window","User Administration Window",dr); 
	}

	@Test
	public void auto_Clini_Manage_007() throws InterruptedException,IOException{
		login(dr);
		Actions mouseover=new Actions(dr);
		Thread.sleep(3000); 
		dr.findElement(By.xpath("//a[contains(text(),'Manage')]")).click();
		Thread.sleep(3000);
		dr.findElement(By.xpath(".//*[text()='Users']")).click();
		String expectedTextColor1="rgba(255, 255, 255, 1)";
		String actualTextColor1 = dr.findElement(By.xpath("//a[contains(text(),'Manage')]")).getCssValue("color");
		checkHighlightText(expectedTextColor1,actualTextColor1,"Manage tab Highlight",dr);
		String expectedTextColor2="rgba(255, 255, 255, 1)";
		String actualTextColor2= dr.findElement(By.xpath(".//*[text()='Users']")).getCssValue("color");
		checkHighlightText(expectedTextColor2,actualTextColor2,"Users bar Highlight",dr);

		WebElement addUser=dr.findElement(By.xpath(".//*[@id='content-body']/div[1]/div/h3/span/a"));
		mouseover.moveToElement(addUser).build().perform();
		checkObjectDisplay(addUser, "Add User button", "Add User button", dr); 
		WebElement search=dr.findElement(By.xpath(".//*[@id='user_table_filter']/label"));
		mouseover.moveToElement(search).build().perform();
		if(search.getText().equalsIgnoreCase("Search:")){checkObjectDisplay(search, "Search Option", "Search Option", dr); }

		WebElement count=dr.findElement(By.xpath(".//*[text()='Count']"));
		mouseover.moveToElement(count).build().perform();
		if(count.getText().equalsIgnoreCase("Count")){checkObjectDisplay(count, "Count Column", "Count Column", dr); }
		WebElement userName=dr.findElement(By.xpath(".//*[text()='Username']"));
		mouseover.moveToElement(userName).build().perform();
		if(userName.getText().equalsIgnoreCase("Username")){checkObjectDisplay(userName, "Username Column", "Username Column", dr); }
		WebElement emailId=dr.findElement(By.xpath(".//*[text()='E-mail ID']"));
		mouseover.moveToElement(emailId).build().perform();
		if(emailId.getText().equalsIgnoreCase("E-mail ID")){checkObjectDisplay(emailId, "E-mail ID Column", "E-mail ID Column", dr); }
		Thread.sleep(3000);
		WebElement firstName=dr.findElement(By.xpath(".//*[@id='user_table']/thead/tr/th[4]"));
		mouseover.moveToElement(firstName).build().perform();
		if(firstName.getText().equalsIgnoreCase("First Name")){checkObjectDisplay(firstName, "First Name Column", "First Name Column", dr); }
		WebElement lastName=dr.findElement(By.xpath(".//*[text()='Last Name']"));
		mouseover.moveToElement(lastName).build().perform();
		if(lastName.getText().equalsIgnoreCase("Last Name")){checkObjectDisplay(lastName, "Last Name Column", "Last Name Column", dr); }
		WebElement role=dr.findElement(By.xpath("//*[text()='Role']"));
		mouseover.moveToElement(role).build().perform();
		if(role.getText().equalsIgnoreCase("Role")){checkObjectDisplay(role, "Role Column", "Role Column", dr); }
		WebElement status=dr.findElement(By.xpath(".//*[text()='Status']"));
		mouseover.moveToElement(status).build().perform();
		if(status.getText().equalsIgnoreCase("Status")){checkObjectDisplay(status, "Status Column", "Status Column", dr); }
		WebElement sites=dr.findElement(By.xpath(".//*[text()='Sites']"));
		mouseover.moveToElement(sites).build().perform();
		if(sites.getText().equalsIgnoreCase("Sites")){checkObjectDisplay(sites, "Sites Column", "Sites Column", dr); }
		WebElement action=dr.findElement(By.xpath("//*[text()='Action']"));
		mouseover.moveToElement(action).build().perform();
		if(action.getText().equalsIgnoreCase("Action")){checkObjectDisplay(action, "Action Column", "Action Column", dr); }

		WebElement previous=dr.findElement(By.xpath(".//*[text()='Previous']"));
		mouseover.moveToElement(dr.findElement(By.xpath(".//*[text()='Previous']"))).build().perform();
		checkObjectDisplay(previous, "Previous Button", "Previous Button", dr);
		WebElement next=dr.findElement(By.xpath(".//*[text()='Next']"));
		mouseover.moveToElement(dr.findElement(By.xpath(".//*[text()='Next']"))).build().perform();
		checkObjectDisplay(next, "Next Button", "Next Button", dr);
		Thread.sleep(3000);
	}

	@Test
	public void auto_Clini_Manage_008() throws Exception{
		login(dr);
		Thread.sleep(4000);
		//click on manage tab
		WebElement manage= dr.findElement(By.xpath("//a[contains(text(),'Manage')]"));
		clickElement(manage, "Manage Tab", "Manage Tab details", dr);
		Thread.sleep(3000);
		//click on user
		WebElement users= dr.findElement(By.xpath("//a[contains(text(),'Users')]"));
		clickElement(users, "Users Tab", "Users Tab under manage", dr);
		//click on Edit user icon under Action
		WebElement editUser= dr.findElement(By.xpath("//a[@title='Edit User']"));
		clickElement(editUser, "Edit User Tab", "Edit User Icon under Action", dr);
		// checking elements in edit user pop up window
		Thread.sleep(3000);
		String fNamePath="//div[4]/div[2]/form/div/fieldset/div/input";
		WebElement fName=dr.findElement(By.xpath(fNamePath));
		checkObjectDisplay(fName, "First Name", "First Name", dr);
		String lNamePath="//form/div/fieldset[2]/div/input";
		WebElement lName=dr.findElement(By.xpath(lNamePath));
		checkObjectDisplay(lName, "Last Name", "Last Name", dr);
		WebElement selectRole=dr.findElement(By.xpath("//form/div/fieldset[3]/div/select"));
		checkObjectDisplay(selectRole, "Select Role DropDown", "Select Role DropDown", dr);
		String[] expectedDropDown={"Project Manager","Study Administrator","Data Manager","Site Coordinator"};
		Select select = new Select(selectRole);
		List<WebElement> options = select.getOptions();
		for(WebElement we:options)
		{
			for (int i=0; i<expectedDropDown.length; i++){
				if ((we.getText().trim()).equals((expectedDropDown[i]).trim())){
					updateReport("Pass", "Select Role DropDown value", "Select Role DropDown value:\""+expectedDropDown[i]+"\" appears", dr);
				} 
			}
		}
		WebElement emailId=dr.findElement(By.xpath("//form/div/fieldset[4]/div/input"));
		checkObjectDisplay(emailId, "Email ID", "Email ID", dr);
		WebElement phNo=dr.findElement(By.xpath("//fieldset[5]/div/input"));
		checkObjectDisplay(phNo, "PhoneNo", "Phone no field", dr);
		WebElement selStatus=dr.findElement(By.xpath("//form/div/fieldset[6]/div/select"));
		String[] selStatusValues={"Select status","Active","Inactive"};
		Select s = new Select(selStatus);
		List<WebElement> values = s.getOptions(); 
		for(WebElement we:values)
		{
			for (int i=0; i<selStatusValues.length; i++){
				if ((we.getText().trim()).equals((selStatusValues[i]).trim())){
					updateReport("Pass", "Select Status DropDown value", "Select Status DropDown value:\""+selStatusValues[i]+"\" appears", dr);
				} 
			}
		}
		WebElement siteOption1=dr.findElement(By.xpath(".//*[@id='editusersites']/option[1]"));
		String expectedSiteOption1="Maputo";
		if(siteOption1.getText().equals("Maputo"))
			checkObjectDisplay(siteOption1, "Site Option:"+siteOption1.getText(), "Site Option",dr); 

		WebElement siteOption2=dr.findElement(By.xpath(".//*[@id='editusersites']/option[2]"));
		String expectedSiteOption2="Los Angeles";
		if(siteOption2.getText().equals("Los Angeles"))
			checkObjectDisplay(siteOption2, "Site Option:"+siteOption2.getText(), "Site Option",dr); 
		WebElement update=dr.findElement(By.xpath("//div/input[@title='Update']"));
		checkObjectDisplay(update, "Update btn", "Update btn", dr);
		WebElement cancel=dr.findElement(By.xpath("//fieldset[8]/div/div/input[2]"));
		checkObjectDisplay(cancel, "Cancel btn", "Cancel btn", dr);
	}

	@Test
	public void auto_Clini_Manage_009() throws InterruptedException,IOException{
		login(dr);
		Thread.sleep(3000);
		dr.findElement(By.xpath("//a[contains(text(),'Manage')]")).click();
		Thread.sleep(3000);
		WebElement Queries = dr.findElement(By.xpath(".//*[text()='Queries']"));
		clickElement(Queries,"Queries Tab", "Queries Tab", dr);
		Thread.sleep(2000);
		String actualText = dr.findElement(By.xpath("//*[@id='content-body']/div/div/h3")).getText();
		String expectedText ="Queries";
		checkContentsMatch(actualText,expectedText,"Queries","Queries",dr); 
	}

	@Test
	public void auto_Clini_Manage_010() throws InterruptedException,IOException{
		login(dr);
		Actions mouseover = new Actions(dr);
		Thread.sleep(3000);
		dr.findElement(By.xpath("//a[contains(text(),'Manage')]")).click();
		Thread.sleep(3000);
		dr.findElement(By.xpath(".//*[text()='Queries']")).click();
		String expectedTextColor1="rgba(255, 255, 255, 1)";
		String actualTextColor1 = dr.findElement(By.xpath("//a[contains(text(),'Manage')]")).getCssValue("color");
		checkHighlightText(expectedTextColor1,actualTextColor1,"Manage tab Highlight",dr);
		String expectedTextColor2 = "rgba(255, 255, 255, 1)";
		String actualTextColor2 = dr.findElement(By.xpath(".//*[text()='Queries']")).getCssValue("color");
		checkHighlightText(expectedTextColor2,actualTextColor2,"Queries bar Highlight",dr);
		WebElement search = dr.findElement(By.xpath("//*[@id='dataTables-example_filter']/label"));
		mouseover.moveToElement(search).build().perform();
		if(search.getText().equalsIgnoreCase("Search:"))
		{
			checkObjectDisplay(search, "Search Option", "Search Option", dr); 
		}
		WebElement Subject = dr.findElement(By.xpath(".//*[text()='Subject']"));
		mouseover.moveToElement(Subject).build().perform();
		if(Subject.getText().equalsIgnoreCase("Subject"))
		{
			checkObjectDisplay(Subject, "Subject Column", "Subject Column", dr); 
		}
		WebElement Entity = dr.findElement(By.xpath(".//*[text()='Entity']"));
		mouseover.moveToElement(Entity).build().perform();
		if(Entity.getText().equalsIgnoreCase("Entity"))
		{
			checkObjectDisplay(Entity, "Entity Column", "Entity Column", dr);
		}
		WebElement Type = dr.findElement(By.xpath(".//*[text()='Type']"));
		mouseover.moveToElement(Type).build().perform();
		if(Type.getText().equalsIgnoreCase("Type"))
		{
			checkObjectDisplay(Type, "Type Column", "Type Column", dr);
		}
		Thread.sleep(3000);
		WebElement Status = dr.findElement(By.xpath("//*[@id='dataTables-example']/thead/tr/th[4]"));
		mouseover.moveToElement(Status).build().perform();
		if(Status.getText().equalsIgnoreCase("Status"))
		{
			checkObjectDisplay(Status, "Status Column", "Status Column", dr);
		}
		WebElement assignedTo = dr.findElement(By.xpath(".//*[text()='Assigned To']"));
		mouseover.moveToElement(assignedTo).build().perform();
		if(assignedTo.getText().equalsIgnoreCase("Assigned To"))
		{
			checkObjectDisplay(assignedTo, "Assigned To Column", "Assigned To Column", dr);
		}
		WebElement dateUpdated = dr.findElement(By.xpath("//*[text()='Date Updated']"));
		mouseover.moveToElement(dateUpdated).build().perform();
		if(dateUpdated.getText().equalsIgnoreCase("Date Updated"))
		{
			checkObjectDisplay(dateUpdated, "Date Updated Column", "Date Updated Column", dr);
		}
		WebElement Action = dr.findElement(By.xpath(".//*[text()='Action']"));
		mouseover.moveToElement(Action).build().perform();
		if(Action.getText().equalsIgnoreCase("Action"))
		{
			checkObjectDisplay(Action, "Action Column", "Action Column", dr);
		}
		JavascriptExecutor jse = (JavascriptExecutor)dr;
		jse.executeScript("window.scrollBy(0,500)");
		//Thread.sleep(3000);
		WebElement previous = dr.findElement(By.xpath(".//*[text()='Previous']"));
		mouseover.moveToElement(dr.findElement(By.xpath(".//*[text()='Previous']"))).build().perform();
		checkObjectDisplay(previous, "Previous Button", "Previous Button", dr);
		WebElement next =dr.findElement(By.xpath(".//*[text()='Next']"));
		mouseover.moveToElement(dr.findElement(By.xpath(".//*[text()='Next']"))).build().perform();
		checkObjectDisplay(next, "Next Button", "Next Button", dr);
	}

	@Test

	public void auto_Clini_Manage_011() throws InterruptedException,IOException{
		login(dr);
		Thread.sleep(5000);
		Actions mouseover = new Actions(dr);
		Thread.sleep(1000);
		dr.findElement(By.xpath("//a[contains(text(),'Manage')]")).click();
		Thread.sleep(3000);
		dr.findElement(By.xpath(".//*[text()='Queries']")).click();
		String parentWindowId = dr.getWindowHandle();
		System.out.println(parentWindowId);
		dr.findElement(By.xpath("//*[@id='dataTables-example']/tbody/tr[1]/td[7]/div/a")).click();
		for (String windowId: dr.getWindowHandles()) {
			System.out.println(windowId);
			dr.switchTo().window(windowId);
			Thread.sleep(2000);
			String actualText = dr.findElement(By.xpath("//*[@id='ui-id-1']")).getText();
			String expectedText="Edit Query";
			System.out.println(actualText);
			checkContentsMatch(actualText,expectedText,"Edit Query pop up","Edit Query Pop Up",dr); 
			WebElement subjectID= dr.findElement(By.xpath(".//*[text()='Subject ID:']"));
			System.out.println(subjectID.getText());
			mouseover.moveToElement(subjectID).build().perform();
			if(subjectID.getText().equalsIgnoreCase("Subject ID:"))
			{
				checkObjectDisplay(subjectID, "SubjectID ", "SubjectID  ", dr); 
			}
			WebElement Entity = dr.findElement(By.xpath(".//*[text()='Entity:']"));
			System.out.println(Entity.getText());
			mouseover.moveToElement(Entity).build().perform();
			if(Entity.getText().equalsIgnoreCase("Entity:"))
			{
				checkObjectDisplay(Entity, "Entity ", "Entity ", dr); 
			}
			WebElement Type = dr.findElement(By.xpath(".//*[text()='Type:']"));
			System.out.println(Type.getText());
			mouseover.moveToElement(Type).build().perform();
			if(Type.getText().equalsIgnoreCase("Type:"))
			{
				checkObjectDisplay(Type, "Type Dropdown field", "Type Dropdown field", dr); 
			}
			WebElement typeQuery = dr.findElement(By.xpath("//*[@id='querytype'][@disabled = 'disabled']")); 
			WebElement status = dr.findElement(By.xpath("//*[@id='statussection']/fieldset/span"));
			System.out.println(status.getText());
			//mouseover.moveToElement(status).build().perform();
			if(status.getText().equalsIgnoreCase("Status* :"))
			{
				checkObjectDisplay(status, "Status Dropdown", "Status Dropdown", dr); 
			}
			Thread.sleep(6000);
			WebElement opt1=dr.findElement(By.xpath(".//*[@id='querystatus']/option[1]"));	
			WebElement opt2=dr.findElement(By.xpath(".//*[@id='querystatus']/option[2]"));
			WebElement opt3=dr.findElement(By.xpath(".//*[@id='querystatus']/option[3]"));
			Select sel=new Select(dr.findElement(By.xpath(".//*[@id='querystatus']")));
			if(opt1.getText().equals("Updated")){checkObjectDisplay(opt1, "Status Dropdown field", "Status Dropdown field "+opt1.getText(), dr);}
			if(opt2.getText().equals("Resolved")){checkObjectDisplay(opt2, "Status Dropdown field", "Status Dropdown field "+opt2.getText(), dr);}
			if(opt3.getText().equals("Not Applicable")){checkObjectDisplay(opt3, "Status Dropdown field", "Status Dropdown field "+opt3.getText(), dr);}
			WebElement assigned = dr.findElement(By.xpath(".//*[text()='Assigned To']"));
			System.out.println(assigned.getText());
			mouseover.moveToElement(Type).build().perform();
			if(assigned.getText().equalsIgnoreCase("Assigned To"))
			{
				checkObjectDisplay(assigned, "Assigned To Dropdown filed ", "Assigned To Dropdown ", dr); 
			}
			WebElement message = dr.findElement(By.xpath(".//*[text()='Message']"));
			System.out.println(message.getText());
			if(message.getText().equalsIgnoreCase("Message* :"))
			{
				checkObjectDisplay(Type, "Message Textbox", "Message Textbox ", dr); 
			}
			WebElement PrevMessage = dr.findElement(By.xpath("//*[@id='editQuery']/div/fieldset[5]/span"));
			checkObjectDisplay(PrevMessage, "Previous Message Section", "Previous Message Section ", dr);
			WebElement Date = dr.findElement(By.xpath("//*[@id='querytable']/thead/tr/th[1]"));
			String actualTextDate =  Date.getText(); 
			String expectedTextDate ="Date";
			System.out.println(actualTextDate);
			checkContentsMatch(actualTextDate,expectedTextDate," Date ","Date",dr);
			WebElement User = dr.findElement(By.xpath("//*[@id='querytable']/thead/tr/th[2]"));
			String actualTextUser =  User.getText(); 
			String expectedTextUser ="User";
			System.out.println(actualTextUser);
			checkContentsMatch(actualTextUser,expectedTextUser," User ","User",dr);
			WebElement statusTable = dr.findElement(By.xpath("//*[@id='querytable']/thead/tr/th[3]"));
			String actualTextStatus =  statusTable.getText(); 
			String expectedTextStatus ="Status";
			System.out.println(actualTextStatus);
			checkContentsMatch(actualTextStatus,expectedTextStatus," Status ","Status",dr);
			WebElement msg = dr.findElement(By.xpath("//*[@id='querytable']/thead/tr/th[4]"));
			String actualTextMsg =  msg.getText(); 
			String expectedTextMsg ="Message";
			System.out.println(actualTextMsg);
			checkContentsMatch(actualTextMsg,expectedTextMsg," Message ","Message",dr);
			WebElement assignTo = dr.findElement(By.xpath("//*[@id='querytable']/thead/tr/th[5]"));
			String actualTextassignTo =  assignTo.getText(); 
			String expectedTextassignTo ="Assigned To";
			System.out.println(actualTextassignTo);
			checkContentsMatch(actualTextassignTo,expectedTextassignTo," assigned To ","assigned To",dr);
			Thread.sleep(3000);
		}

	}
	
	@Test

	 public void auto_Clini_Analyze_004() throws InterruptedException, IOException

	 { login(dr);
	 Actions action = new Actions(dr);
	 Thread.sleep(5000);
	 WebElement analyze=dr.findElement(By.xpath("//a[contains(text(),'Analyze')]"));
	 clickElement(analyze, "Analyze Tab", "Click on Analyze tab", dr);
	 //it will verify the dropdown's are enabled
		WebElement selectExport=dr.findElement(By.id("exporttype"));
		if(selectExport.isDisplayed()){
			Select select=new Select(selectExport);
			select.selectByIndex(0);
			updateReport("Pass", "Select Export","\"Excel Export\" is selected",dr);
		}
		else{
			updateReport("Fail", "Select Export", "\"Excel Export\" is not selected",dr);
		}
	 
	 String expectedPopulation="Population";
	 String actualPopulation = dr.findElement(By.xpath("//*[@id='subjectdataform']/div/h2[1]")).getText();
	 checkContentsMatch(actualPopulation,expectedPopulation,"Population is Displayed","Population panel",dr);
	 String expectedData="Data";
	 String actualData = dr.findElement(By.xpath("//*[@id='subjectdataform']/div/h2[2]")).getText();
	 checkContentsMatch(actualData,expectedData,"Data is Displayed","Data panel",dr);
	 WebElement selectAllSites= dr.findElement(By.xpath("//*[@id='site']/option[2]"));
	 boolean selAllSites=selectAllSites.isEnabled();
	 Assert.assertEquals(selAllSites,true,"All Sites is enabled");
	 Thread.sleep(2000);
	 clickElement(selectAllSites, "All Sites Option", "All Sites Option", dr);
	 String expectedAllSites="All Sites";
	 String actualAllSites = dr.findElement(By.xpath("//*[@id='site']/option[2]")).getText();
	 System.out.println("Actual All Sites:"+actualAllSites);
     checkContentsMatch(actualAllSites,expectedAllSites,"All Sites is selected","All Sites",dr);
	 Thread.sleep(2000);
	 //Groups
	 WebElement selectAllGroups= dr.findElement(By.xpath("//*[@id='groups']/option[2]"));
	 boolean selAllGroups=selectAllGroups.isEnabled();
	 Assert.assertEquals(selAllGroups,true,"All Groups is enabled");
	 Thread.sleep(2000);
	 clickElement(selectAllGroups, "All Groups Option", "All Groups Option", dr);
	 String expectedAllGroups="All Groups";
	 String actualAllGroups = dr.findElement(By.xpath("//*[@id='groups']/option[2]")).getText();
	 System.out.println("Actual All Groups:"+actualAllGroups);
	 checkContentsMatch(actualAllGroups,expectedAllGroups,"All Groups is selected","All Groups",dr);
	 Thread.sleep(2000);
	 //Form status
	 WebElement selectAllStatus= dr.findElement(By.xpath("//*[@id='sub_statuses']/option[2]"));
	 boolean selAllStatus=selectAllStatus.isEnabled();
	 Assert.assertEquals(selAllSites,true,"All Status is enabled");
	 Thread.sleep(2000);
	 clickElement(selectAllStatus, "All Status Option", "All Status Option", dr);
	 String expectedAllStatus="All Status";
	 String actualAllStatus = dr.findElement(By.xpath("//*[@id='sub_statuses']/option[2]")).getText();
	 System.out.println("Actual All Status:"+actualAllStatus);
	 checkContentsMatch(actualAllStatus,expectedAllStatus,"All Status is selected","All Status",dr);
	 Thread.sleep(2000);
	 //Visits
	 WebElement selectAllVisits= dr.findElement(By.xpath("//*[@id='visit']/option[2]"));
	 boolean selAllVisits=selectAllVisits.isEnabled();
	 Assert.assertEquals(selAllVisits,true,"All Visits is enabled");
	 Thread.sleep(2000);
	 clickElement(selectAllVisits, "All Visits Option", "All Visits Option", dr);
	 String expectedAllVisits="All Visits";
	 String actualAllVisits = dr.findElement(By.xpath("//*[@id='visit']/option[2]")).getText();
	 System.out.println("Actual All Visits:"+actualAllVisits);
	 checkContentsMatch(actualAllVisits,expectedAllVisits,"All Visits is selected","All Visits",dr);
	 Thread.sleep(2000);
	 //Data Forms
	 WebElement selectAllForms= dr.findElement(By.xpath("//*[@id='subform']/option[2]"));
	 boolean selAllForms=selectAllForms.isEnabled();
	 Assert.assertEquals(selAllForms,true,"All Forms is enabled");
     Thread.sleep(2000);
     clickElement(selectAllForms, "All Forms Option", "All Forms Option", dr);
	 String expectedAllForms="All Forms";
	 String actualAllForms = dr.findElement(By.xpath("//*[@id='subform']/option[2]")).getText();
	 System.out.println("Actual All Forms:"+actualAllForms);
	 checkContentsMatch(actualAllSites,expectedAllSites,"All Forms is selected","All Forms",dr);
	 Thread.sleep(2000);
	 //Data ItemGroups
	 WebElement selectAllItemGroup= dr.findElement(By.xpath("//*[@id='form_variables']/option[2]"));
	 boolean selAllItemGroup=selectAllItemGroup.isEnabled();
	 Assert.assertEquals(selAllItemGroup,true,"All Item Group is enabled");
	 Thread.sleep(2000);
	 clickElement(selectAllItemGroup, "All ItemGroup Option", "All ItemGroup Option", dr);
	 String expectedAllItemGroup="All Item-Groups";
	 String actualAllItemGroup = dr.findElement(By.xpath("//*[@id='form_variables']/option[2]")).getText();
	 System.out.println("Actual All Item Group:"+actualAllItemGroup);
	 checkContentsMatch(actualAllItemGroup,expectedAllItemGroup,"All Item Group is selected","All Item Group",dr);
	 Thread.sleep(2000);
 }



	/**
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test

	public void auto_Clini_Analyze_005() throws InterruptedException,IOException{
		login(dr);
		Thread.sleep(7000);
		WebElement analyze=dr.findElement(By.xpath(".//*[@id='nav']/ul/li[4]/a"));
		clickElement(analyze, "Analyze Tab", "Click on Analyze tab", dr);
		Thread.sleep(4000);
		WebElement selectExport=dr.findElement(By.id("exporttype"));
		if(selectExport.isDisplayed()){
			Select select=new Select(selectExport);
			select.selectByIndex(1);
			updateReport("Pass", "Select Export","\"CDISC ODM Export\" is selected",dr);
		}
		else{
			updateReport("Fail", "Select Export", "\"CDISC ODM Export\" is not selected",dr);
		}
		Thread.sleep(3000);
		WebElement fileType=dr.findElement(By.xpath(".//select[@id='file_type']"));
		checkObjectDisplay(fileType,"File Type Dropdown","File Type Dropdown",dr);
		WebElement exportFormat=dr.findElement(By.xpath(".//*[@id='export_format']"));
		checkObjectDisplay(exportFormat,"Export Format Dropdown","Export Format Dropdown",dr);
		WebElement granularityCheckBoxes=dr.findElement(By.xpath(".//*[@id='odmexportform']/div/fieldset[3]/div"));
		readingText(granularityCheckBoxes,"granularityCheckBoxes",dr);
		WebElement metaDataCheckbox=dr.findElement(By.xpath(".//*[@id='metadata']"));
		readingCheckbox(metaDataCheckbox,"Metadata Checkbox",dr);
		WebElement adminDataCheckbox=dr.findElement(By.xpath(".//*[@id='admindata']"));
		readingCheckbox(adminDataCheckbox,"Admin Data Checkbox",dr);
		WebElement clinicalData=dr.findElement(By.xpath(".//*[@id='clinicaldata']"));
		readingCheckbox(clinicalData,"Clinical Data Checkbox",dr);
		WebElement exportButton=dr.findElement(By.xpath(".//*[@id='exportodm'][@type='submit']"));
		checkObjectDisplay(exportButton,"Export Button","Export button",dr);
		//check for "Export Format" dropdown default option
		Thread.sleep(5000);
		WebElement exportFormatDefaultOption=dr.findElement(By.xpath(".//*[@id='export_format']"));
		Select sel1=new Select(exportFormatDefaultOption);
		WebElement actualExportFormatDefaultOption=sel1.getFirstSelectedOption();
		validateText(actualExportFormatDefaultOption, "CliniTrial ODM v1.3","ExportFormat Default Option","ExportFormat Default Option",dr);
		//check for filetype drop down default value
		WebElement fileTypeDefaultOption=dr.findElement(By.xpath(".//*[@id='file_type']"));
		Select sel2=new Select(fileTypeDefaultOption);
		WebElement actualFileTypeDefaultOption=sel2.getFirstSelectedOption();
		validateText(actualFileTypeDefaultOption, "Select File Type","FileType Default Option","FileType Default Option",dr);
		//check for all the drop down values for filetype dropdown field
		clickElement(fileType, "fileType dropdown", "Click on fileType", dr);
		if(fileType.getText().contains("Select File Type") & fileType.getText().contains("Snapshot") & fileType.getText().contains("Transactional"))
		{updateReport("Pass", "File Type Dropdown Options","Select File type,Snapshot and Transactional options are visible in the dropdown list",dr);}
		else{updateReport("Fail", "File Type Dropdown Options","Select File type,Snapshot and Transactional options are not visible in the dropdown list",dr);}
		//verify the selection of snapshot option for the filetype drop down
		WebElement fileTypeOption2=dr.findElement(By.xpath(".//*[@id='file_type']/option[2]"));
		clickElement(fileTypeOption2, "file Type Option : Snapshot", "Click on file Type Option", dr);
		WebElement snapShotOption=sel2.getFirstSelectedOption();
		validateText(snapShotOption, "Snapshot","SnapShot Option","SnapShot Option",dr);
		//check for the Exportformat" drop down values.
		clickElement(exportFormat, "exportFormat dropdown", "Click on exportFormat", dr);
		if(exportFormat.getText().contains("CliniTrial ODM v1.3") & exportFormat.getText().contains("Rave ODM v1.3"))
		{updateReport("Pass", "Export Format Dropdown Options","CliniTrial ODM v 1.3 & Rave ODM v 1.3 are options visible in the dropdown list",dr);}
		else{updateReport("Fail", "File Type Dropdown Options","CliniTrial ODM v 1.3 & Rave ODM v 1.3 are options not visible in the dropdown list",dr);}
		//uncheck the clinicaldata checkbox
		WebElement clinicalDataCheckbox=dr.findElement(By.xpath(".//*[@id='clinicaldata']"));
		clickElement(clinicalDataCheckbox, "Uncheck Clinical Data Checkbox", "Uncheck Clinical Data  Checkbox", dr);
		Thread.sleep(2000);
		//verify export button tooltip and enabled
		Actions tooltip = new Actions(dr);
		tooltip.moveToElement(exportButton).build().perform();
		validateTextAttribute(exportButton, "Export", "Export tooltip", "title","Export Tooltip",dr);
		checkEnabled(exportButton,"Export Button",dr); 


	}








	@AfterMethod
	public void closeBrowser(){
		updateResults();
		dr.close();
		dr.quit();
	}


}




