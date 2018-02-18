package com.scp.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scp.util.SeleniumUtil;

/**
 * 
 * @author Yogesh
 *
 */
public class LoginPageObject {
	
	@FindBy(id="txtUsername")
	WebElement username;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement signBtn;
	
	@FindBy(id="spanMessage")
	WebElement errorMessage;
	
	private void enterUserName(String uname){
		this.username.clear();
		this.username.sendKeys(uname);
	}
	
	private void enterPassword(String password){
		this.password.clear();
		this.password.sendKeys(password);
	}
	
	private DashBoardPageObject clickOnSignIn(){
		this.signBtn.click();
		DashBoardPageObject dashBoardPageObject = PageFactory.initElements(SeleniumUtil.driver,DashBoardPageObject.class);
		if(null!=dashBoardPageObject){
			if(null==dashBoardPageObject.getWelcomeMessage()){
				return null;
			}
		}
		return dashBoardPageObject;
	}
	
	
	public DashBoardPageObject enterCredetials(String uname,String pwd) throws InterruptedException{
		this.enterUserName(uname);
		this.enterPassword(pwd);
		Thread.sleep(2000);
		return this.clickOnSignIn();
	}
	
	public String getErrorMessage(){
		if(isErrorMessageDisplayed()){
			return errorMessage.getText();
		}
		return null;
	}

	public boolean isErrorMessageDisplayed() {
		try{
			return errorMessage.isDisplayed();
		}catch(Exception e){
			System.out.println("Error message is not displayed on a page");
			return false;
		}
		
	}
	
	

	
	
	
	
	
	
	
	
	
	

}
