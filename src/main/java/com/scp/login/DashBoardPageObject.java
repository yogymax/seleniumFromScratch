package com.scp.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPageObject {
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div/ul/li[2]/a")
	WebElement logOut;
	
	@FindBy(id="welcome")
	WebElement welcomeMessage;
	
	public void userLogout(){
		if(null!=getWelcomeMessage()){
			welcomeMessage.click();
			logOut.click();
		}
	}
	
	
	public String getWelcomeMessage(){
		try{
			return welcomeMessage.getText();
		}catch(Exception e){
			return null;
		}
		
	}
	

}
