package com.scp.demo;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scp.db.CaptureTestResults;

@Listeners(value=CaptureTestResults.class)
public class ATest {
  
	
  @Test(groups={"A","smoke"})
  public void f1() {
	  System.out.println("inside f1");
  }
  
  @Test(groups={"A"})
  public void f2() {
	  System.out.println("inside f2");
  }
  
  
  @Test(groups={"A","smoke"})
  public void f3() {
	  System.out.println("inside f3");
  }
  
  @Test(groups={"A","sanity"})
  public void f4() {
	  System.out.println("inside f4");
  }
 
  @Test(groups={"A"})
  public void f5() {
	  System.out.println("inside f5");
  }
  
 
  
  @Test(groups={"A","db"},dependsOnMethods="db")
  public void a5() {
	  System.out.println("inside f5");
  }
  
  @Test(groups={"A","db"},dependsOnMethods="db")
  public void a6() {
	  System.out.println("inside f5");
  }
  
  @Test(groups={"A"})
  public void db() {
	  System.out.println("inside f5");
	  Assert.fail("Database is not working....");
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
