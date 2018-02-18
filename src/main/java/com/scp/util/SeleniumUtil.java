package com.scp.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.scp.login.LoginPageObject;
import com.scp.util.AppConstants.BrowserTypes;

/**
 * 
 * @author Yogesh
 *
 */
public class SeleniumUtil {
	public static WebDriver driver = null;
	
	/**
	 * @author Yogesh
	 * @param browserName
	 * @param url
	 * @throws InterruptedException 
	 */
	public static LoginPageObject getAppLandingPage(BrowserTypes browserName) throws InterruptedException {
		System.out.println("User values -- " + browserName.toString());
		
		switch (browserName) {
			case FIREFOX:
				System.setProperty("webdriver.gecko.driver","E:\\MySofts\\geckodriver-v0.19.0-win64\\geckodriver.exe");
				driver = new FirefoxDriver();
				break;
			case CHROME:
				System.setProperty("webdriver.chrome.driver","E:\\MySofts\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case SAFARI:
				System.out.println("add safari driver system path ");
				driver = new SafariDriver();
				break;
			case IE:
				System.out.println("add IE driver system path ");
				driver = new InternetExplorerDriver();
				break;
			case EDGE:
				System.out.println("add EDge driver system path ");
				driver = new EdgeDriver();
				break;
			default :
					System.out.println("");
					Assert.fail("Invalid browser types..");
		}
		Thread.sleep(2000);
		driver.get(AppConstants.APPLICATION_URL);
		return PageFactory.initElements(driver, LoginPageObject.class);
	}

	public static void captureScreenshot(String imgName) {
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File("E:\\OrangeHRMExecution_Screenshots\\"+imgName+".png");
        try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void closeBrowser() {
		if(null!=driver)
			driver.quit();
	}

}
