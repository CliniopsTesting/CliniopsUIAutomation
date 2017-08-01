package com.testing.Cliniops;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cliniops_ReusableMethodsTest {   

	//static WebDriver driver ;  
	static String htmlname = null;
	static BufferedWriter bw = null;
	//static BufferedWriter bw1 = null;
	static String exeStatus = "True";
	static int report;
	static int rowCount = 1;
	private static String browserName = null;
	private static int reportFlag = 0;

	
	/**
	 * Name of the Method: enterText
	 * Brief description : Enter text into text box field
	 * Arguments: obj --> Webelement Object, textval --> Text to be entered, objName --> name of hte object
	 * Created by: Automation team
	 * Creation date : July 17 2017
	 * last modified:  July 17 2017
	 **/
	public static void enterText(WebElement obj, String textVal, String objName) throws IOException{
		if(obj.isDisplayed()){
			obj.sendKeys(textVal);
			updateReport("Pass","entertext",textVal+" is entered in "+objName);

		}else{
			updateReport("Fail","entertext",objName+" field is not displayed,please check application");

		}

	}
	
	/** 
	 * Name of the Method: dropDown
	 * Brief description : Selecting the DropDown
	 * Arguments: obj --> Webelement Object, textval --> Text to be entered 
	 * Created by: Automation team
	 * Creation date : July 17 2017
	 * last modified:  July 17 2017
	 **/
	public static void dropDown(WebElement dd, int index) throws IOException{

		Select select = new Select(dd);
		if(dd.isDisplayed()){
			select.selectByIndex(index);
			updateReport("Pass", "DropDown", "selected dd object by using index");
		}
		else{
			updateReport("Fail", "DropDown", "Not selected dd object by using index");
		}

	}

	/* 
	 * Name of the Method: clickObj
	 * Brief description : click object
	 * Arguments: obj --> Webelement Object,  objName --> name of the object
	 * Created by: Automation team
	 * Creation date : July 17 2017
	 * last modified: July 17 2017
	 * 
	 * */	
	public static void clickObj(WebElement obj, String objName) throws IOException{
		if(obj.isDisplayed()){
			obj.click();
			updateReport("Pass", "click Action", "clicked on selected object");
			System.out.println("Pass: "+ objName + " is clicked.");
		}else{
			updateReport("Fail", "click Action", "Not clicked on selected object");
		}
	}

	//Name of the method:ButtonClick
	//Brief description:used to click the button
	//arguments:obj->WebElement,objname->name of the object
	//created by:Automation team
	//creation date:12/15/2016
	//modified date:12/15/2016
	public static void ButtonClick(WebElement obj,String objname) throws IOException{
		if(obj.isDisplayed())
		{
			obj.click();
			updateReport("Pass","ButtonClick",objname+" is clicked");
		}
		else{
			updateReport("Fail","ButtonClick",objname+" is not displayed");
		}	

	}


	/* Name of the method:ErrorMessage
		    Brief description:used to display message on matching actual text with expected text
			arguments:obj->WebElement,Expectedtext->text used to compare with actual text,objname->name of the object
			created by:Automation team
			creation date:12/15/2016
			modified date:12/15/2016 
	 */
	public static void ErrorMessage(WebElement obj,String Expectedtext,String objname) throws IOException{
		if(obj.isDisplayed())
		{
			String Actualtext=obj.getText().trim();
			if(Expectedtext.trim().contains(Actualtext.trim())){
				updateReport("Pass","ErrorMessage","Actual message matching with expected message:"+Actualtext);
			}
			else{
				updateReport("Fail","ErrorMessage","Actual message not matching with expected message:"+Actualtext);
			}
		}
		else{
			updateReport("Fail","ErrorMessage",objname+" is not displayed,please check your application");
		}
	}
	/* 
	 * Name of the Method: validateMsg
	 * Brief description : validate message displayed on the web page
	 * Arguments: obj --> Webelement Object,  expectedText --> expected text to be displayed, objName --> name of hte object
	 * Created by: Automation team
	 * Creation date : July 17 2017
	 * last modified: July 17 2017
	 * 
	 * */	

	public static void validateMsg(WebElement obj, String expectedText, String objName) throws IOException{
		if(obj.isDisplayed()){
			String actualText = obj.getText().trim();
			if(expectedText.equals(actualText)){
				updateReport("Pass", "validate message", "Actual message is matching with expected message");
			}else{
				updateReport("Fail", "validate message", "Actual message is matching with expected message");
			}
		}else{
			updateReport("Fail",objName," is not displayed, please check your application");
		}
	}
	/* 
	 * Name of the Method: validateMsg_Attribute
	 * Brief description : validate message displayed on the web page
	 * Arguments: obj --> Webelement Object,  expectedText --> expected text to be displayed, objName --> name of the object
	 * Created by: Automation team
	 * Creation date : July 20 2017
	 * last modified: July 20 2017
	 * 
	 */	

	public static void validateMsg_Attribute(WebElement obj, String expectedText, String objName,String attributeName) throws IOException{
		if(obj.isDisplayed()){
			String actualText = obj.getAttribute(attributeName);
			if(expectedText.equals(actualText)){
				updateReport("Pass","validateMsg_Attribute","Actual message matching with expected message:"+ actualText);
			}else{
				updateReport("Fail","validateMsg_Attribute","Actual message not matching with expected message:"+actualText);
			}
		}else{
			updateReport("Fail","validateMsg_Attribute",objName +"is not displayed, please check your application");
		}
	}
	//Name of the method:checkDisabled 
	//Brief description:check disabled object
	//arguments:obj->WebElement,objname->name of the object
	//created by:Automation team
	//creation date:07/24/2017
	//modified date:07/24/2017

	public static void checkDisabled(WebElement obj,String objname) throws IOException{
		if(obj.getAttribute("disabled").trim().contains("true")){updateReport("Pass","Checkdisabled",objname+" is disabled");}
		else{updateReport("Fail","Checkdisabled",objname+" is not disabled");}
	}

	//Name of the method:Readingtext
	//Brief description:Reading text box value
	//arguments:obj->WebElement,objname->name of the object
	//created by:Automation team
	//creation date:07/24/2017
	//modified date:07/24/2017
	public static void ReadingText(WebElement obj,String objname) throws IOException{
		if(obj.isDisplayed())
		{
			String Actualtext=obj.getText().trim();
			if(Actualtext.isEmpty())
			{
				updateReport("Fail","ReadingText",objname+" has No data");
			}
			else{
				updateReport("Pass","ReadingText",objname+" contains "+Actualtext);
			}
		}
	}	

	//Name of the method:readingCheckbox
	//Brief description:Reading check box value
	//arguments:obj->WebElement,objname->name of the object
	//created by:Automation team
	//creation date:07/24/2017
	//modified date:07/24/2017
	public static void readingCheckbox(WebElement obj,String Expectedtext,String objname) throws IOException{
		if(obj.isDisplayed())
		{
			String Actualtext=obj.getAttribute("checked").trim();
			if(Expectedtext.equals(Actualtext)){
				updateReport("Pass","readingCheckbox",objname+" is checked");
			}
			else{
				updateReport("Fail","readingCheckbox",objname+" is not checked");
			}
		}
		else{
			updateReport("Fail","readingCheckbox",objname+" is not displayed,please check your application");
		}
	}
	/*
	 * Name of the Method: readSheet
	 * Brief description : read excel sheet data
	 * Arguments: datatable --> report path,sheetname:sheet name to access in the excel file
	 * Created by: Automation team
	 * Creation date : July 17 2017
	 * last modified:  July 17 2017
	 */

	public static String[][] readSheet(String dataTable, String sheetName) throws IOException{


		/*Step 1: Get the XL Path*/
		File xlFile = new File(dataTable);

		/*Step2: Access the Xl File*/
		FileInputStream xlDoc = new FileInputStream(xlFile);

		/*Step3: Access the work book */
		HSSFWorkbook wb = new HSSFWorkbook(xlDoc);


		/*Step4: Access the Sheet */
		HSSFSheet sheet = wb.getSheet(sheetName);

		int iRowCount =  sheet.getLastRowNum()+1;
		int iColCount = sheet.getRow(0).getLastCellNum();//Row count starts from '0' in excel

		System.out.println("Total row = " + iRowCount + " total col = " + iColCount);

		String[][] xlData = new String[iRowCount][iColCount];

		for(int i =0; i<iRowCount;i++){
			for(int j = 0; j <iColCount;j++){
				xlData[i][j] = sheet.getRow(i).getCell(j).getStringCellValue().trim();
			}

		}

		return xlData;
	}
	/*
	 * Name of the Method: startReport
	 * Brief description : Creates HTML report template
	 * Arguments: scriptname:test script name to run,ReportsPath:HTML report path to create,browserName:browser the script is running
	 * Created by: Automation team
	 * Creation date : July 17 2017
	 * last modified:  July 17 2017
	 */
	public static void startReport(String scriptName, String reportsPath, String browser) throws IOException{

		browserName = browser;
		if(reportFlag == 0){
			reportFlag = 1;
			String strResultPath = null;
			String testScriptName =scriptName;

			Date cur_dt = new Date(); 
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String strTimeStamp = dateFormat.format(cur_dt);

			if (reportsPath == "") { 
				reportsPath = "C:\\";
			}

			if (!reportsPath.endsWith("\\")) { 
				reportsPath = reportsPath + "\\";
			}

			strResultPath = reportsPath + "Log" + "/" +testScriptName +"/"; 
			File f = new File(strResultPath);
			f.mkdirs();
			htmlname = strResultPath  + testScriptName + "_" + strTimeStamp 
					+ ".html";

			bw = new BufferedWriter(new FileWriter(htmlname));

			bw.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
			bw.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
			bw.write("<TR><TD BGCOLOR=#66699 WIDTH=15%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Browser Name</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>"
					+ browserName + "</B></FONT></TD></TR>");
			bw.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
			bw.write("<TR COLS=7><TD BGCOLOR=#BDBDBD WIDTH=5%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>SL No</B></FONT></TD>"
					+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Step Name</B></FONT></TD>"
					+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Execution Time</B></FONT></TD> "
					+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Status</B></FONT></TD>"
					+ "<TD BGCOLOR=#BDBDBD WIDTH=40%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Detail Report</B></FONT></TD></TR>");
		}
		else{
			bw.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
			bw.write("<TR><TD BGCOLOR=#66699 WIDTH=15%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Browser Name</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>"
					+ browserName + "</B></FONT></TD></TR>");
			bw.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		}
	}
	/*
	 * Name of the Method: updateReport
	 * Brief description : Updates HTML report with test results
	 * Arguments: Res_type:holds the response of test script,Action:Action performed,result:contains test results
	 * Created by: Automation team
	 * Creation date : July 17 2017
	 * last modified:  July 17 2017
	 */

	public static void updateReport(String Res_type,String Action, String result) throws IOException {
		String str_time;
		Date exec_time = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		str_time = dateFormat.format(exec_time);
		if (Res_type.startsWith("Pass")) {
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE=VERDANA SIZE=2>"
					+ (rowCount++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ "Passed"
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=40%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ result + "</FONT></TD></TR>");

		} else if (Res_type.startsWith("Fail")) {
			exeStatus = "Failed";
			report = 1;
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=5%><FONT FACE=VERDANA SIZE=2>"
					+ (rowCount++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
					+ "<a href= "
					+ htmlname
					+ "  style=\"color: #FF0000\"> Failed </a>"

					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=40%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
					+ result + "</FONT></TD></TR>");

		} 
	}
	
	public static void closeReport() throws IOException{
		rowCount = 1;
		browserName = null;
		reportFlag = 0;
		htmlname = null;
		bw.close();
	}
}
