package com.compugain.Utils;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import com.compugain.setup.Setup;


public class PieChartCreation implements Setup {
	//private static Logger logger  = Logger.getLogger(PieChartCreation.class);
	
	/**
	 * Creating a pie chart with an Execution Status from TestNG Report
	 * @param passed:No of Passed Test Cases
	 * @param failed:No of Failed Test Cases
	 * @param skipped:Number of Skipped Test Cases
	 */
	public static void pieChartReport(int passed,int failed,int skipped)
	{
		System.out.println("Passed Cases size is"+passed);
		System.out.println("failed Cases size is"+failed);
		System.out.println("Skipped Cases size is"+skipped);
		int totalnoofcases=passed+failed+skipped;
		System.out.println(passed+" "+totalnoofcases);
		double passedpercentage=Math.round(((double)passed/(double)totalnoofcases)*100);
		double failedpercentage=Math.round(((double)failed/(double)totalnoofcases)*100);
		double skippedpercentage=Math.round(((double)skipped/(double)totalnoofcases)*100);
		System.out.println("total no of cases"+totalnoofcases);
		System.out.println("pass cases"+passedpercentage);

		DefaultPieDataset pieDataset = new DefaultPieDataset();
		pieDataset.setValue("PASS:"+passedpercentage+"%", passed);
		pieDataset.setValue("FAIL:"+failedpercentage+"%",failed);
		if(skipped>0)
			pieDataset.setValue("SKIP:"+skippedpercentage+"%", skipped);

		JFreeChart piechart = ChartFactory.createPieChart("UI - Automation Report", pieDataset, true, true, false);
		PiePlot plot = (PiePlot) piechart.getPlot();
		plot.setSectionPaint("PASS:"+passedpercentage+"%", Color.green);
		plot.setSectionPaint("FAIL:"+failedpercentage+"%", Color.RED);
		plot.setSectionPaint("SKIP:"+skippedpercentage+"%", Color.ORANGE);
		try {
			ChartUtilities.saveChartAsJPEG(new File(getFilePath(sPIECHARTLOCATION)), piechart, 400, 400);
			System.out.println("pie chart generated");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getFilePath(String sFilepath) {
		char cforwardslash = (char) 47;
		char cbackslash = (char) 92;
		System.out.println("File path is "+sFilepath);
		String sPath = System.getProperty("user.dir").replace(cbackslash,
				cforwardslash)
				+ sFilepath;
		
		File file = new File(sPath);
		if (file.exists()) {
			sPath = file.getAbsolutePath();
			System.out.println("The File Path is " + sPath);
		} else {
		}
		return sPath;
	}
/*	public static void main(String[] args) {
		pieChartReport(10,10,10);
	}
*/
}