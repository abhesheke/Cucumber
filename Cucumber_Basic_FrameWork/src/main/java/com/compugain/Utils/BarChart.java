package com.compugain.Utils;

import java.awt.Color;
import java.awt.GradientPaint;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import com.compugain.setup.Setup;


public class BarChart implements Setup
{
	private static Logger logger = Logger.getLogger(BarChart.class);


public static  Map<String, Integer> BarChartCreation(Map<String, Integer> passedgroupsmap,
		Map<String, Integer> failedgroupmap,
		Map<String, Integer> skippedgroupmap)throws Exception 
   {
	 Map<String, Integer> allmap= new HashMap<String, Integer>();

		 allmap.putAll(passedgroupsmap);
		 allmap.putAll(failedgroupmap); 
		 allmap.putAll(skippedgroupmap);
		 allmap.remove("Sanity");
		 allmap.remove("SanityDev");
		 allmap.remove("Acceptance");
		 allmap.remove("FileUplaod");
		 allmap.remove("p1");
		 allmap.remove("sanity");
		 allmap.remove("FileUpload");
		 allmap.remove("Functional");
		
       final String Skipped= "Passed";
       final String Passed = "Failed";
       final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
       // column keys...
       int i=1;
       for (Map.Entry<String, Integer> entry : allmap.entrySet()) {
			logger.info("Key : " + entry.getKey() + " Value : "
				+ entry.getValue());
		     	dataset.addValue(passedgroupsmap.get(entry.getKey()),"Passed",String.valueOf(i));
			    dataset.addValue(failedgroupmap.get(entry.getKey()),"Failed",String.valueOf(i));
			    dataset.addValue(skippedgroupmap.get(entry.getKey()),"Skipped",String.valueOf(i));
			    i++;
	   }
 
        JFreeChart chart = ChartFactory.createStackedBarChart(
         "Rev-Module Status", 
         "GroupNames", "Graph", 
         dataset,PlotOrientation.VERTICAL, 
         true, true, false);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        StackedBarRenderer renderer = (StackedBarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBaseItemLabelGenerator(
                new StandardCategoryItemLabelGenerator());
        
             chart.setBackgroundPaint(Color.white);     
      int width = 1200; /* Width of the image */
      int height =1200; /* Height of the image */ 
      File BarChart = new File(getFilePath(sBARCHARTLOCATION)); 
      ChartUtilities.saveChartAsJPEG( BarChart , chart , width , height );
      
      chart.setBackgroundPaint(Color.white);
     
      // get a reference to the plot for further customisation...
    //  final CategoryPlot plot = chart.getCategoryPlot();
   /*   CategoryPlot plot = (CategoryPlot) chart.getPlot();

      StackedBarRenderer renderer = (StackedBarRenderer) plot.getRenderer();
      renderer.setDrawBarOutline(false);
      renderer.setBaseItemLabelsVisible(true);
      renderer.setBaseItemLabelGenerator(
              new StandardCategoryItemLabelGenerator());

      plot.setBackgroundPaint(Color.lightGray);
      plot.setDomainGridlinePaint(Color.white);
      plot.setRangeGridlinePaint(Color.white);

      // set the range axis to display integers only...
      final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
      rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

      // disable bar outlines...
    //  final BarRenderer renderer = (BarRenderer) plot.getRenderer();
      StackedBarRenderer stackedbarrenderer = (StackedBarRenderer)plot.getRenderer();   
      stackedbarrenderer.setDrawBarOutline(false);   
      stackedbarrenderer.setItemLabelsVisible(true);   
      stackedbarrenderer.setSeriesItemLabelGenerator(0, new StandardCategoryItemLabelGenerator());   
         chart.getCategoryPlot().setRenderer(stackedbarrenderer);  // set up gradient paints for series...
*/      final GradientPaint gp0 = new GradientPaint(
          0.0f, 0.0f, Color.green, 
          0.0f, 0.0f, Color.lightGray
      );
      final GradientPaint gp1 = new GradientPaint(
          0.0f, 0.0f, Color.red, 
          0.0f, 0.0f, Color.lightGray
      );
      final GradientPaint gp2 = new GradientPaint(
          0.0f, 0.0f, Color.yellow, 
          0.0f, 0.0f, Color.lightGray
      );
      renderer.setSeriesPaint(0, gp0);
      renderer.setSeriesPaint(0, gp1);
      renderer.setSeriesPaint(0, gp2);
      
     /* stackedbarrenderer.setSeriesPaint(0, gp0);
      stackedbarrenderer.setSeriesPaint(1, gp1);
      stackedbarrenderer.setSeriesPaint(2, gp2);
*/
      /*final CategoryAxis domainAxis = plot.getDomainAxis();
      domainAxis.setCategoryLabelPositions(
          CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
      );*/
      // OPTIONAL CUSTOMISATION COMPLETED.
      return allmap;
   }

public static String getFilePath(String sFilepath) {
	char cforwardslash = (char) 47;
	char cbackslash = (char) 92;
	logger.info("File path is "+sFilepath);
	String sPath = System.getProperty("user.dir").replace(cbackslash,
			cforwardslash)
			+ sFilepath;
	
	File file = new File(sPath);
	if (file.exists()) {
		sPath = file.getAbsolutePath();
		logger.info("The File Path is " + sPath);
	} else {
	}
	return sPath;
}
public static void main(String[] args) throws Exception {
	    Map<String, Integer> passedgroupsmap= new HashMap<String, Integer>();
	 Map<String, Integer> failedgroupmap= new HashMap<String, Integer>();
	 Map<String, Integer> skippedgroupmap= new HashMap<String, Integer>();
	 Map<String, Integer> allmap= new HashMap<String, Integer>();

	 passedgroupsmap.put("Acceptance",10);
	 passedgroupsmap.put("Sanity",20);
	 passedgroupsmap.put("SanityDev",30);
	 
	 failedgroupmap.put("Acceptance",20);
	 failedgroupmap.put("Sanity",40);
	 failedgroupmap.put("newsanity",50);
	 
	 skippedgroupmap.put("Acceptance",15);
	 skippedgroupmap.put("skippedsanity",25);
	 skippedgroupmap.put("Sanity",35);
	 

	//new BarChartCreation(passedgroupsmap, failedgroupmap, skippedgroupmap);
}




}