package com.scp.demo;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scp.db.CaptureTestResults;

@Listeners(value=CaptureTestResults.class)
public class BTest {
	  @Test(groups={"B","smoke"})
	  public void b1() {
		  System.out.println("inside b1");
	  }
	  
	  @Test(groups={"B"})
	  public void b2() {
		  System.out.println("inside b2");
	  }
	  
	  
	  @Test(groups={"B","smoke","sanity"})
	  public void b3() {
		  System.out.println("inside b3");
	  }
	  
	  @Test(groups={"B","sanity"})
	  public void b4() {
		  System.out.println("inside b4");
	  }
	 
	  @Test(groups={"B","sanity"})
	  public void b5() {
		  System.out.println("inside b5");
	  }
	
	  @Test(groups={"B"})
	  public void b6() {
		  System.out.println("inside b6");
	  }
	  
	  
	  @Test(groups={"B"})
	  public void b7() {
		  System.out.println("inside b7");
	  }
	  
	  
	  @Test(groups={"B","sanity"})
	  public void b8() {
		  System.out.println("inside B8");
	  }
	  
	  

	
}
