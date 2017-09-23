package com.testing.Cliniops;

import java.io.IOException;
import java.util.ArrayList;
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
			dr.manage().window().maximize();
			
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
    	enterText(username, "Abhishek", "Username", "Enter username", dr);
    	WebElement password=dr.findElement(By.id("password"));
    	enterText(password, "Welcome123#", "Password", "Enter password", dr);
    	WebElement authenticate=dr.findElement(By.id("Authenticate"));
    	clickElement(authenticate, "Authenticate Button", "Click on authenticate", dr);
    	WebElement selectStudy= dr.findElement(By.id("investigator_study"));
    	checkEnabled(selectStudy,"selectStudy",dr);
    	WebElement selectLang= dr.findElement(By.id("lang_type"));
    	checkEnabled(selectLang,"selectLang",dr);
    	WebElement login=dr.findElement(By.xpath("//*[@title='Login']"));
    	checkEnabled(login,"login",dr);  
    	Thread.sleep(2000);
    	clickElement(selectStudy, "selectStudy","selectStudy",dr);
    	WebElement selectStudyOption=dr.findElement(By.xpath("//*[text()='Cisplatin/Etoposide/Rad................-Small Cell Lung Cancer']"));
    	checkObjectDisplay(selectStudyOption,"selectStudyOption","selectStudyOption",dr);
    	//String expectedTextForStudy="Cisplatin/Etoposide/Rad................-Small Cell Lung Cancer123";
    	//validateText(selectStudyOption, expectedTextForStudy, "Study option", "Study option", dr);
    	clickElement(selectStudyOption, "selectStudyOption","selectStudyOption",dr);
    	Thread.sleep(3000);

    	clickElement(selectLang, "selectLang","selectLang",dr);
    	WebElement selectLanguageOption=dr.findElement(By.xpath(".//*[@id='lang_type']/option[2]"));
    	checkObjectDisplay(selectLanguageOption,"selectLanguageOption","selectLanguageOption",dr);
    	//String expectedLanguage="English";
    	//validateText(selectLanguageOption, expectedLanguage, "Language option", "Language option", dr);
    	clickElement(selectLanguageOption, "selectLanguageOption","selectLanguageOption",dr);

    	Thread.sleep(2000);
    	clickElement(login, "login","login",dr);
    	String ActualURL= dr.getCurrentUrl();
    	String ExpectedURL="https://bridgetherapeutics.cliniops.com/investigator";
    	validateURL(ExpectedURL,ActualURL,"homePageURL",dr);
    	if(ExpectedURL.equals(ActualURL)){
    		updateReport("Pass", "HomeURL", "Actual text is matching with expected text",dr);
    	}
    	else{
    		updateReport("Fail", "HomeURL", "Actual text is not matching with expected text",dr);
    	}
    	WebElement homePage=dr.findElement(By.className("current"));
    	String expectedHome="Home";
    	validateText(homePage,expectedHome, "HomePage", "HomePage Highlighted", dr);
    	  
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

    @Test
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
    			.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='content-body']/div[1]/span")));
    	//errorMsg=emailIdError.getText();
    	expectedErrorMsg="Email-id or username does not exist in database.";
    	validateText(emailIdError, expectedErrorMsg, "Email error","Email error",dr);

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

        public void auto_Clini_Home_003() throws Exception {
    	login(dr);
    	//Thread.sleep(2000);
		
    	//Configure Tab
    	WebElement configure= dr.findElement(By.xpath("//*[contains(text(),'Configure')]"));
    	clickElement(configure, "Configure", "Configure Tab details", dr);
    	String expectedConfigUrl="https://bridgetherapeutics.cliniops.com/investigator/configurestudy/general";
    	String actualConfigUrl=dr.getCurrentUrl();
    	validateURL(expectedConfigUrl,actualConfigUrl,"Configure URL Check",dr);
    	Actions action=new Actions(dr);
    	action.moveToElement(dr.findElement(By.xpath("//*[contains(text(),'Configure')]"))).build().perform();
    	
        //Thread.sleep(3000);
        String expectedTextColor11="rgba(255, 255, 255, 1)";
    	String actualTextColor11 = dr.findElement(By.xpath("//*[contains(text(),'Configure')]")).getCssValue("color");
    	checkHighlightText(expectedTextColor11,actualTextColor11,"Configure tab highlight",dr);
        WebElement studyDetails=dr.findElement(By.xpath(".//*[@id='content-body']/div[1]/div/div[2]/div[1]/ul/li[1]/a"));
        action.moveToElement(studyDetails).build().perform();
    	Thread.sleep(3000);
        String expectedTextColor12="rgba(255, 255, 255, 1)";
    	String actualTextColor12 = studyDetails.getCssValue("color");
    	checkHighlightText(expectedTextColor12,actualTextColor12,"Study Details highlight",dr);
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
    	checkHighlightText(expectedTextColor21,actualTextColor21,"Manage tab highlight",dr);
        WebElement roles=dr.findElement(By.xpath(".//*[@id='content-body']/div/div/div[2]/div[1]/ul/li[1]/a"));
        action.moveToElement(roles).build().perform();
    	Thread.sleep(3000);
        String expectedTextColor22="rgba(255, 255, 255, 1)";
    	String actualTextColor22 = roles.getCssValue("color");
    	checkHighlightText(expectedTextColor22,actualTextColor22,"Roles highlight",dr);
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
    	checkHighlightText(expectedTextColor31,actualTextColor31,"Manage tab highlight",dr);
    	WebElement export=dr.findElement(By.xpath(".//*[@id='content-body']/div/div[1]/div[2]/ul/li[1]/a"));
        action.moveToElement(export).build().perform();
    	Thread.sleep(3000);
        String expectedTextColor32="rgba(255, 255, 255, 1)";
    	String actualTextColor32 = export.getCssValue("color");
    	checkHighlightText(expectedTextColor32,actualTextColor32,"Export highlight",dr);    	
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
    	checkHighlightText(expectedTextColor41,actualTextColor41,"Subjects tab highlight",dr);      	  	
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
    	checkHighlightText(expectedTextColor51,actualTextColor51,"Audit tab highlight",dr);     
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
    	checkHighlightText(expectedTextColor61,actualTextColor61,"Profile tab highlight",dr);  
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
	checkHighlightText(expectedTextColor,ActualTextColor,"Configure tab highlight",dr);
	clickElement(config, "Configure tab", "Configure tab",dr);
	String ExpectedURL="https://bridgetherapeutics.cliniops.com/investigator/configurestudy/general";
	String ActualURL=dr.getCurrentUrl();
	validateURL(ExpectedURL,ActualURL,"Configure URL Check",dr);
	
       }
     @Test
     public void auto_Clini_Confg_004() throws InterruptedException, IOException
     {
	login(dr);
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
		 public void AUTO_CLINI_CONFG_005() throws InterruptedException, IOException {
			 Login(dr);
			// Thread.sleep(3000);
			 WebElement configure_tab = dr.findElement(By.xpath(".//*[@id='nav']//li[2]"));
			 clickElement(configure_tab, "configureTab", "click configureTab", dr);
			 Thread.sleep(4000);
			 
			 //Verify appearance of Download file link.
			 String expectedFileLink = "Download File";
			 WebElement FileLink = dr.findElement(By.xpath(" //*[@id='study_general_settings']/div[2]/div[1]/fieldset[2]/div/p/a"));
			 String actualFileLink = FileLink.getText();
			 System.out.println(actualFileLink);
			 checkContentsMatch(actualFileLink, expectedFileLink, "DownLoad File Link", "DownLoad File Link", dr);
			
			 // verify appearance of Download file
			 String expectedFile = "ICF - Interview...cians_v8.pdf";
			 WebElement File = dr.findElement(By.xpath(" //*[@id='study_general_settings']/div[2]/div[1]/fieldset[2]/div/span"));
			 String actualFile = File.getText();
			 System.out.println(actualFile);
			 checkContentsMatch(actualFile, expectedFile, "DownLoad File in pdf", "DownLoad File in pdf", dr); 

		 }

		 public void AUTO_CLINI_CONFG_006() throws InterruptedException, IOException {
			 Login(dr);
			// Thread.sleep(3000);
			 WebElement configure_tab = dr.findElement(By.xpath(".//*[@id='nav']//li[2]"));
			 clickElement(configure_tab, "configureTab", "click configureTab", dr);
			 //Thread.sleep(4000);

			 //Verify appearance of dropdown data in "Subject ID:*" dropdown.

			 WebElement selectSubId = dr.findElement(By.id("subjectId"));
			 List<WebElement> Options = selectSubId.findElements(By.tagName("option"));
			 for (WebElement option : Options) {
				 if("Select option".equals(option.getText())){
					 String expectedText = "Select option";
					 String actualText = option.getText();
					 System.out.println(actualText);
					 checkContentsMatch(actualText, expectedText, "Select option is visible", "Select option is visible", dr);

				 }
				 if("Automatic".equals(option.getText())){
					 String expectedText = "Automatic";
					 String actualText = option.getText();
					 System.out.println(actualText);
					 checkContentsMatch(actualText, expectedText, "Automatic is visible", "Automatic is visible", dr);

				 }

				 // System.out.println(option.getText());
				 if("Custom".equals(option.getText())) {
					 String expectedText = "Custom";
					 String actualText = option.getText();
					 System.out.println(actualText);
					 checkContentsMatch(actualText, expectedText, "Custom is visible", "Custom is visible", dr);
					 clickElement(option, "select custom", "select custom option ", dr);
					 break;
				 }
			 }
                @Test
		 public void auto_Clini_Manage_009() throws InterruptedException,IOException{
			 Login(dr);
			 Thread.sleep(3000);
			 dr.findElement(By.xpath("//a[contains(text(),'Manage')]")).click();
			 WebElement Queries = dr.findElement(By.xpath(".//*[text()='Queries']"));
			 clickElement(Queries,"Queries Tab", "Queries Tab", dr);
			 Thread.sleep(2000);
			 String actualText = dr.findElement(By.xpath("//*[@id='content-body']/div/div/h3")).getText();
			 String expectedText ="Queries";
			 checkContentsMatch(actualText,expectedText,"Queries","Queries",dr); 
		 }
		 @Test
		 public void auto_Clini_Manage_010() throws InterruptedException,IOException{
			 Login(dr);
			 Actions mouseover = new Actions(dr);
			 Thread.sleep(3000);
			 dr.findElement(By.xpath("//a[contains(text(),'Manage')]")).click();
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
			 Login(dr);
			 Actions mouseover = new Actions(dr);
			 Thread.sleep(1000);
			 dr.findElement(By.xpath("//a[contains(text(),'Manage')]")).click();
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
					 checkObjectDisplay(subjectID, "SubjectID is displayed", "SubjectID  ", dr); 
				 }

				 WebElement Entity = dr.findElement(By.xpath(".//*[text()='Entity:']"));
				 System.out.println(Entity.getText());
				 mouseover.moveToElement(Entity).build().perform();
				 if(Entity.getText().equalsIgnoreCase("Entity:"))
				 {
					 checkObjectDisplay(Entity, "Entity is displayed", "Entity ", dr); 
				 }
				 WebElement Type = dr.findElement(By.xpath(".//*[text()='Type:']"));
				 System.out.println(Type.getText());
				 mouseover.moveToElement(Type).build().perform();
				 if(Type.getText().equalsIgnoreCase("Type:"))
				 {
					 checkObjectDisplay(Type, "Type is displayed", "Type ", dr); 
				 }
				 WebElement typeQuery = dr.findElement(By.xpath("//*[@id='querytype'][@disabled = 'disabled']")); 
				
				 WebElement status = dr.findElement(By.xpath("//*[@id='statussection']/fieldset/span"));
				 System.out.println(status.getText());
				 //mouseover.moveToElement(status).build().perform();
				 if(status.getText().equalsIgnoreCase("Status* :"))
				 {
					 checkObjectDisplay(status, "Status is displayed", "Status ", dr); 
				 }
				 
				 WebElement upDated = dr.findElement(By.xpath("//*[@id='querystatus']"));
				 upDated.click();
				 WebElement upDatedOption1 = dr.findElement(By.xpath("//*[@id='querystatus']/option[1]"));
				 upDatedOption1.click();
				
				 String actualTextupDated =  upDatedOption1.getText(); 
				 String expectedTextupDated ="Updated";
				 System.out.println(actualTextupDated);
				 checkContentsMatch(actualTextupDated,expectedTextupDated,"Updated is selected","Updated",dr);
				 
				 WebElement assigned = dr.findElement(By.xpath(".//*[text()='Assigned To']"));
				 System.out.println(assigned.getText());
				 mouseover.moveToElement(Type).build().perform();
				 if(assigned.getText().equalsIgnoreCase("Assigned To"))
				 {
					 checkObjectDisplay(assigned, "Assigned To is displayed", "Assigned To ", dr); 
				 }
				 
				 WebElement assignedTo = dr.findElement(By.xpath("//*[@id='assigned_to_user_id']"));
				 assignedTo.click();
				 WebElement assignedToName = dr.findElement(By.xpath("//*[@id='assigned_to_user_id']/option[5]"));
				
				
				 String actualTextassigedTo =  assignedToName.getText(); 
				 String expectedTextassigedTo ="Sarah Lee (sarah.lee)";
				 System.out.println(actualTextassigedTo);
				 checkContentsMatch(actualTextassigedTo,expectedTextassigedTo,"Sarah Lee (sarah.lee) is selected","Sarah Lee (sarah.lee)",dr);
	   
				 WebElement message = dr.findElement(By.xpath(".//*[text()='Message']"));
				 System.out.println(message.getText());
				
				 if(message.getText().equalsIgnoreCase("Message* :"))
				 {
					 checkObjectDisplay(Type, "Message is displayed", "Message ", dr); 
				 }
				 WebElement textArea = dr.findElement(By.xpath("//*[@id='message']"));
				 textArea.click();
				
				 String actualTexttextArea =  textArea.getText(); 
				 String expectedTexttextArea ="";
				 System.out.println(actualTexttextArea);
				 checkContentsMatch(actualTexttextArea,expectedTexttextArea,"Text area is selected","TextArea",dr);
				 
				 WebElement PrevMessage = dr.findElement(By.xpath("//*[@id='editQuery']/div/fieldset[5]/span"));
			
				 String actualTextPrevMessage =  PrevMessage.getText(); 
				 String expectedTextPrevMessage ="Previous Messages";
				 System.out.println(actualTextPrevMessage);
				 checkContentsMatch(actualTextPrevMessage,expectedTextPrevMessage," Previous message is displayed","Previous Message",dr);
				 
				 WebElement Date = dr.findElement(By.xpath("//*[@id='querytable']/thead/tr/th[1]"));
					
				 String actualTextDate =  Date.getText(); 
				 String expectedTextDate ="Date";
				 System.out.println(actualTextDate);
				 checkContentsMatch(actualTextDate,expectedTextDate," Date is displayed","Date",dr);
				
				 WebElement User = dr.findElement(By.xpath("//*[@id='querytable']/thead/tr/th[2]"));
					
				 String actualTextUser =  User.getText(); 
				 String expectedTextUser ="User";
				 System.out.println(actualTextUser);
				 checkContentsMatch(actualTextUser,expectedTextUser," User is displayed","User",dr);
				 
				 WebElement statusTable = dr.findElement(By.xpath("//*[@id='querytable']/thead/tr/th[3]"));
					
				 String actualTextStatus =  statusTable.getText(); 
				 String expectedTextStatus ="Status";
				 System.out.println(actualTextStatus);
				 checkContentsMatch(actualTextStatus,expectedTextStatus," Status is displayed","Status",dr);
		
				 WebElement msg = dr.findElement(By.xpath("//*[@id='querytable']/thead/tr/th[4]"));
					
				 String actualTextMsg =  msg.getText(); 
				 String expectedTextMsg ="Message";
				 System.out.println(actualTextMsg);
				 checkContentsMatch(actualTextMsg,expectedTextMsg," Message is displayed","Message",dr);
				 
				 WebElement assignTo = dr.findElement(By.xpath("//*[@id='querytable']/thead/tr/th[5]"));
					
				 String actualTextassignTo =  assignTo.getText(); 
				 String expectedTextassignTo ="Assigned To";
				 System.out.println(actualTextassignTo);
				 checkContentsMatch(actualTextassignTo,expectedTextassignTo," assigned To is displayed","assigned To",dr);
				 
				 WebElement UpdateQueryBtn = dr.findElement(By.xpath("//*[@id='editQuerySubmit']"));
				 mouseover.moveToElement(dr.findElement(By.xpath("//*[@id='editQuerySubmit']"))).build().perform();
				 checkObjectDisplay(UpdateQueryBtn, "Update Query Button", "Update Query Button", dr);
				 
				 WebElement cancelBtn = dr.findElement(By.xpath("//*[@id='editQuery']/div/fieldset[6]/div/div/input[2]"));
				 mouseover.moveToElement(dr.findElement(By.xpath("//*[@id='editQuery']/div/fieldset[6]/div/div/input[2]"))).build().perform();
				 checkObjectDisplay(cancelBtn, "cancel Button", "cancel Button", dr);
				 Thread.sleep(3000);
				 
				 WebElement closeBtn = dr.findElement(By.xpath("/html/body/div[4]/div[1]/button/span[1]"));
				 mouseover.moveToElement(dr.findElement(By.xpath("/html/body/div[4]/div[1]/button/span[1]"))).click().build().perform();
				 checkObjectDisplay(closeBtn, "close Button", "close Button", dr);
				 
				 Thread.sleep(3000);
				
           

			 }






		 }
			 
		 }
	 @Test
		 public void auto_Clini_Analyze_004() throws InterruptedException, IOException
		 {
			 Login(dr);
			 Actions action = new Actions(dr);
			 dr.findElement(By.xpath("//a[contains(text(),'Analyze')]")).click();

			 //it will verify the dropdown's are enabled
			 WebElement selectExcelExport= dr.findElement(By.id("exporttype"));
			 boolean selExcel=selectExcelExport.isEnabled();
			 Assert.assertEquals(selExcel,true,"Excel Export is enabled");
			 Thread.sleep(2000);
			 selectExcelExport.click();
			 selectExcelExport.click();

			 WebElement excelExport= dr.findElement(By.xpath("//*[@id='exporttype']/option[1]"));
			 action.moveToElement(excelExport).build().perform();
			 String expectedExcelExport="Excel Export";
			 validateText(excelExport, expectedExcelExport, "Excel Export","Select Export",dr);
			 dropDownByValue(selectExcelExport,"1",dr);
			 Thread.sleep(2000);


			 String expectedPopulation="Population";
			 String actualPopulation = dr.findElement(By.xpath("//*[@id='subjectdataform']/div/h2[1]")).getText();
			 checkContentsMatch(actualPopulation,expectedPopulation,"Population is Displayed","Population",dr);

			 String expectedData="Data";
			 String actualData = dr.findElement(By.xpath("//*[@id='subjectdataform']/div/h2[2]")).getText();
			 checkContentsMatch(actualData,expectedData,"Data is Displayed","Data",dr);



			 WebElement selectAllSites= dr.findElement(By.xpath("//*[@id='site']/option[2]"));
			 boolean selAllSites=selectAllSites.isEnabled();
			 Assert.assertEquals(selAllSites,true,"All Sites is enabled");
			 Thread.sleep(2000);
			 selectAllSites.click();




			 String expectedAllSites="All Sites";
			 String actualAllSites = dr.findElement(By.xpath("//*[@id='site']/option[2]")).getText();
			 System.out.println("Actual All Sites:"+actualAllSites);
			 checkContentsMatch1(actualAllSites,expectedAllSites,"All Sites is selected","All Sites",dr);
			 Thread.sleep(2000);

			 //Groups
			 WebElement selectAllGroups= dr.findElement(By.xpath("//*[@id='groups']/option[2]"));
			 boolean selAllGroups=selectAllGroups.isEnabled();
			 Assert.assertEquals(selAllGroups,true,"All Groups is enabled");
			 Thread.sleep(2000);
			 selectAllGroups.click();




			 String expectedAllGroups="All Groups";
			 String actualAllGroups = dr.findElement(By.xpath("//*[@id='groups']/option[2]")).getText();
			 System.out.println("Actual All Groups:"+actualAllGroups);
			 checkContentsMatch1(actualAllGroups,expectedAllGroups,"All Groups is selected","All Groups",dr);
			 Thread.sleep(2000);

			 //Form status
			 WebElement selectAllStatus= dr.findElement(By.xpath("//*[@id='sub_statuses']/option[2]"));
			 boolean selAllStatus=selectAllStatus.isEnabled();
			 Assert.assertEquals(selAllSites,true,"All Status is enabled");
			 Thread.sleep(2000);
			 selectAllStatus.click();




			 String expectedAllStatus="All Status";
			 String actualAllStatus = dr.findElement(By.xpath("//*[@id='sub_statuses']/option[2]")).getText();
			 System.out.println("Actual All Status:"+actualAllStatus);
			 checkContentsMatch1(actualAllStatus,expectedAllStatus,"All Status is selected","All Status",dr);
			 Thread.sleep(2000);

			 //Visits
			 WebElement selectAllVisits= dr.findElement(By.xpath("//*[@id='visit']/option[2]"));
			 boolean selAllVisits=selectAllVisits.isEnabled();
			 Assert.assertEquals(selAllVisits,true,"All Visits is enabled");
			 Thread.sleep(2000);
			 selectAllVisits.click();




			 String expectedAllVisits="All Visits";
			 String actualAllVisits = dr.findElement(By.xpath("//*[@id='visit']/option[2]")).getText();
			 System.out.println("Actual All Visits:"+actualAllVisits);
			 checkContentsMatch1(actualAllVisits,expectedAllVisits,"All Visits is selected","All Visits",dr);
			 Thread.sleep(2000);

			 //Data Forms
			 WebElement selectAllForms= dr.findElement(By.xpath("//*[@id='subform']/option[2]"));
			 boolean selAllForms=selectAllForms.isEnabled();
			 Assert.assertEquals(selAllForms,true,"All Forms is enabled");
			 Thread.sleep(2000);
			 selectAllForms.click();




			 String expectedAllForms="All Forms";
			 String actualAllForms = dr.findElement(By.xpath("//*[@id='subform']/option[2]")).getText();
			 System.out.println("Actual All Forms:"+actualAllForms);
			 checkContentsMatch1(actualAllSites,expectedAllSites,"All Forms is selected","All Forms",dr);
			 Thread.sleep(2000);

			 //Data ItemGroups
			 WebElement selectAllItemGroup= dr.findElement(By.xpath("//*[@id='form_variables']/option[2]"));
			 boolean selAllItemGroup=selectAllItemGroup.isEnabled();
			 Assert.assertEquals(selAllItemGroup,true,"All Item Group is enabled");
			 Thread.sleep(2000);
			 selectAllItemGroup.click();




			 String expectedAllItemGroup="All Item-Groups";
			 String actualAllItemGroup = dr.findElement(By.xpath("//*[@id='form_variables']/option[2]")).getText();
			 System.out.println("Actual All Item Group:"+actualAllItemGroup);
			 checkContentsMatch1(actualAllItemGroup,expectedAllItemGroup,"All Item Group is selected","All Item Group",dr);
			 Thread.sleep(2000);

		 }

	
    @AfterMethod

    public void closeBrowser(){
    	dr.close();
    	dr.quit();
    }


}




