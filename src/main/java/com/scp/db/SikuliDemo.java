/*package com.scp.db;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliDemo {
	
	public static void main(String[] args) throws FindFailed, InterruptedException, AWTException {
		
		Screen screen = new Screen();
		Pattern pattern1  = new Pattern("C:\\Users\\Yogesh\\Desktop\\sikilipatterns\\1.PNG");
		Pattern pattern2  = new Pattern("C:\\Users\\Yogesh\\Desktop\\sikilipatterns\\2.PNG");
		Pattern pattern3  = new Pattern("C:\\Users\\Yogesh\\Desktop\\sikilipatterns\\3.PNG");
		Pattern pattern4  = new Pattern("C:\\Users\\Yogesh\\Desktop\\sikilipatterns\\4.PNG");
		Pattern pattern5  = new Pattern("C:\\Users\\Yogesh\\Desktop\\sikilipatterns\\5.PNG");
		Pattern pattern6  = new Pattern("C:\\Users\\Yogesh\\Desktop\\sikilipatterns\\6.PNG");
		Pattern pattern7  = new Pattern("C:\\Users\\Yogesh\\Desktop\\sikilipatterns\\7.PNG");
		Pattern pattern8  = new Pattern("C:\\Users\\Yogesh\\Desktop\\sikilipatterns\\8.PNG");
		
		
		Thread.sleep(3000);
		screen.click(pattern1);
		Thread.sleep(3000);
		screen.type(pattern2,"download sikuli jar");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(5000);
		screen.click(pattern3);
		Thread.sleep(5000);
		screen.click(pattern4);
		Thread.sleep(5000);
		screen.click(pattern5);
		Thread.sleep(3000);
		
		for(int i=0;i<4;i++){
			screen.click(pattern6);
			Thread.sleep(3000);
		}
		
		screen.click(pattern7);
		Thread.sleep(3000);
		screen.click(pattern8);
		
	}

}
*/