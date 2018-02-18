package com.scp.demo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.scp.db.ExcelReadWriteDemo;
import com.scp.login.DashBoardPageObject;
import com.scp.login.LoginPageObject;
import com.scp.util.AppConstants;
import com.scp.util.SeleniumUtil;

public class LoginTest {

	
/**
 * Validate page
 * Invalid credentails (valide error messages too)
 * 		-- Username - blank
 * 		-- password -- blank
 * 		-- username & password blank
 * 		-- username -- incorrect
 * 		-- password - incorrect
 * 		-- username & password incorrect
 * Valid credetails
 * @throws InterruptedException 
 * 
 * 
 */
	
  @Test
  public void valid_cretentials() throws InterruptedException {
	  try{
		  LoginPageObject loginPage = SeleniumUtil.getAppLandingPage(AppConstants.BrowserTypes.FIREFOX);
		  DashBoardPageObject dashboard =  loginPage.enterCredetials("Admin","admin");
		  Thread.sleep(2000);
		  Assert.assertEquals(dashboard.getWelcomeMessage(), AppConstants.ADMIN_WELCOME_MESSAGE);  
	  }catch(Exception e){
		SeleniumUtil.captureScreenshot("valid_cretentials");
		Assert.fail("Test case is failed "+e.getMessage()); 
	  }catch(AssertionError e){
			SeleniumUtil.captureScreenshot("valid_cretentials");
			Assert.fail("Test case is failed "+e.getMessage());
	  }finally{
		  Thread.sleep(2000);
		  SeleniumUtil.closeBrowser();
	  }

	  
	  
	  
  }
  
  
  @Test(dataProvider="testData")
  public void invalid_cretentials(String uname,String pwd,String expectedMsg) throws InterruptedException {
	
	 try{
	  LoginPageObject loginPage = SeleniumUtil.getAppLandingPage(AppConstants.BrowserTypes.FIREFOX);
	  DashBoardPageObject dashboard =  loginPage.enterCredetials(uname,pwd);
	  Thread.sleep(2000);
	  Assert.assertEquals(loginPage.getErrorMessage(), expectedMsg);
	  
	  }catch(Exception e){
			SeleniumUtil.captureScreenshot("invalid_cretentials_" +uname+"_"+pwd);
			Assert.fail("Test case is failed..."+e.getMessage());
	  }catch(AssertionError e){
		  SeleniumUtil.captureScreenshot("invalid_cretentials_" +uname+"_"+pwd);
		  Assert.fail("Test case is failed..."+e.getMessage());
	  }finally{
		  Thread.sleep(2000);
		  SeleniumUtil.closeBrowser();
	  }
  }
  
  
  @DataProvider(name="testData")
  public Object[][] getUserData(){
   return ExcelReadWriteDemo.getTestData();
	  
/**
 *  * 		-- Username - blank
 * 		-- password -- blank
 * 		-- username & password blank
 * 		-- username -- incorrect
 * 		-- password - incorrect
 * 		-- username & password incorrect

 */
	  
	  
	 /* data[0][0]="";
	  data[0][1]="admin";
	  data[0][2]=AppConstants.USERNAME_CANNOT_BE_EMPTY;
	  
	  data[1][0]="Admin";
	  data[1][1]="";
	  data[1][2]=AppConstants.PASSWORD_CANNOT_BE_EMPTY;
	  
	  data[2][0]="";
	  data[2][1]="";
	  data[2][2]=AppConstants.USERNAME_CANNOT_BE_EMPTY;
	  
	  data[3][0]="abcd";
	  data[3][1]="admin";
	  data[3][2]=AppConstants.INVALID_CREDTIALS;
	  
	  data[4][0]="Admin";
	  data[4][1]="aasaaawa";
	  data[4][2]=AppConstants.INVALID_CREDTIALS;
	  
	  data[5][0]="aaaaaaa";
	  data[5][1]="bbbbb";
	  data[5][2]=AppConstants.INVALID_CREDTIALS;*/
	  //return data;
	 
  }
  
  
  
  
  
  
  
  
  
  
}
