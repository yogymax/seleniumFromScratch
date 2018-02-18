package com.scp.db;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class GenerateTestReport {
	
	public static void generateReport(int pass,int fail,int skip,int yettoautomte) throws IOException {
		  DefaultPieDataset dataset = new DefaultPieDataset( );
	      dataset.setValue("Pass", new Double( pass ) );
	      dataset.setValue("Fail", new Double( fail ) );
	      dataset.setValue("Skip", new Double( skip ) );
	      dataset.setValue("Yet To Automate", new Double( yettoautomte ) );

	      JFreeChart chart = ChartFactory.createPieChart(
	         "TestExecutionReport",   // chart title
	         dataset,          // data
	         true,             // include legend
	         true,
	         false);
	         
	      int width = 640;   /* Width of the image */
	      int height = 480;  /* Height of the image */ 
	      File pieChart = new File( "ScpTestReport.jpeg" ); 
	      ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
	   }
}
	
