package com.scp.db;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * 100
 * 
 * @author Yogesh
 *
 */

public class CaptureTestResults implements ITestListener {

	static int passCount=0;
	static int failCount=0;
	static int skipCount=0;
	
	public void onTestStart(ITestResult result) {
		System.out.println("Exeuction started --" +result.getTestName());
		
	}

	public void onTestSuccess(ITestResult result) {
		passCount++;
		System.out.println("Exeuction Passed --" +result.getTestName());
	}

	public void onTestFailure(ITestResult result) {
		failCount++;
		System.out.println("Exeuction Faild --" +result.getTestName());
	}

	public void onTestSkipped(ITestResult result) {
		skipCount++;
		System.out.println("Exeuction Skipped --" +result.getTestName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		System.out.println("Test Suite Exeuction started --");
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("Test Suite Exeuction Finished..Generating report --");
		try {
			GenerateTestReport.generateReport(passCount, failCount, skipCount,30);
			System.out.println("here is your test report....");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
