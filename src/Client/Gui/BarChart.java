package Client.Gui;



	/* ===========================================================
	 * JFreeChart : a free chart library for the Java(tm) platform
	 * ===========================================================
	 *
	 * (C) Copyright 2000-2004, by Object Refinery Limited and Contributors.
	 *
	 * Project Info:  http://www.jfree.org/jfreechart/index.html
	 *
	 * This library is free software; you can redistribute it and/or modify it under the terms
	 * of the GNU Lesser General Public License as published by the Free Software Foundation;
	 * either version 2.1 of the License, or (at your option) any later version.
	 *
	 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
	 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
	 * See the GNU Lesser General Public License for more details.
	 *
	 * You should have received a copy of the GNU Lesser General Public License along with this
	 * library; if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330,
	 * Boston, MA 02111-1307, USA.
	 *
	 * [Java is a trademark or registered trademark of Sun Microsystems, Inc. 
	 * in the United States and other countries.]
	 *
	 * -----------------
	 * BarChartDemo.java
	 * -----------------
	 * (C) Copyright 2002-2004, by Object Refinery Limited and Contributors.
	 *
	 * Original Author:  David Gilbert (for Object Refinery Limited);
	 * Contributor(s):   -;
	 *
	 * $Id: BarChartDemo.java,v 1.16 2004/04/29 10:06:34 mungady Exp $
	 *
	 * Changes
	 * -------
	 * 11-Jun-2002 : Version 1 (DG);
	 * 25-Jun-2002 : Removed redundant imports (DG);
	 * 09-Oct-2002 : Added frame centering (DG);
	 * 18-Nov-2002 : Changed from DefaultCategoryDataset to DefaultTableDataset (DG);
	 * 28-Oct-2003 : Changed to display gradient paint (DG);
	 * 10-Nov-2003 : Renamed BarChartDemo.java (DG);
	 *
	 */

	//package guiManagerReports;

	import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.GradientPaint;
	import java.awt.event.WindowEvent;
	import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
	import org.jfree.chart.ChartPanel;
	import org.jfree.chart.JFreeChart;
	import org.jfree.chart.axis.CategoryAxis;
	import org.jfree.chart.axis.CategoryLabelPositions;
	import org.jfree.chart.axis.NumberAxis;
	import org.jfree.chart.plot.CategoryPlot;
	import org.jfree.chart.plot.PlotOrientation;
	import org.jfree.chart.renderer.category.BarRenderer;
	import org.jfree.data.category.CategoryDataset;
	import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import Server.DataBase.statistic;
import Server.DataBase.statisticQuery;
	/**
	 * A simple demonstration application showing how to create a bar chart.
	 *
	 */
	public class BarChart extends ApplicationFrame {

		/**
	     * Creates a new chart for histogram instance.
	     *
	     * @param title  the frame title.
	     */
		private static final long serialVersionUID = 2994939688431811892L;
		
		public statistic statisticQ;
		public ArrayList <String> thing;
		
	    public BarChart(final String title,statistic statisticQ) {
	    	
	        super(title);
	        this.statisticQ=statisticQ;
	   //     this.thing=thing;
	        final CategoryDataset dataset = createDataset();
	        final JFreeChart chart = createChart(dataset);
	        final ChartPanel chartPanel = new ChartPanel(chart);
	        chartPanel.setPreferredSize(new Dimension(700, 400));
	        setContentPane(chartPanel);

	    }
	    
	    public void windowClosing(final WindowEvent  event) 
		{
	    	if (event.getWindow() == this) 
	    	     dispose();
		}
	    
	    /**
	     * Returns a sample dataset.
	     * 
	     * @return The dataset.
	     */
	    private CategoryDataset createDataset() {
	        
	    	// create the dataset...
	    	final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	    	
	        // row keys...
	        final String series = this.getTitle();
	        
	        final String series1 = "planne by coach";
	        final String series2 = "all preformed teaining";
	        final String series3 = "planned out of preformed";
	        final String series4 = "unplanned preformed training";

	        final String category1 = "planned training";
	        final String category2 =  "preformed training  ";
	        final String category3 =  "preformed were planned";
	        final String category4 = "preformed unplanned training";
	        // column keys...
	       
	        	dataset.addValue(this.statisticQ.getHowmanyplanned(),series1,category1);
	        	dataset.addValue(this.statisticQ.getHowmanypreformed(),series2,category2);
	        	dataset.addValue(this.statisticQ.getHowmanyoutofplannedPreformed(),series3,category3);
	        	dataset.addValue(this.statisticQ.getUnplanned(),series4,category4);
	        return dataset;
	        
	    }
	    
	    /**
	     * Creates a sample chart.
	     * 
	     * @param dataset  the dataset.
	     * 
	     * @return The chart.
	     */
	    private JFreeChart createChart(final CategoryDataset dataset) {
	        
	        // create the chart...
	        final JFreeChart chart = ChartFactory.createBarChart(
	        	"Distribution of Trainging",         // chart title
	            "",               // domain axis label
	            "",                  // range axis label
	            dataset,                  // data
	            PlotOrientation.VERTICAL, // orientation
	            true,                     // include legend
	            true,                     // tooltips?
	            false                     // URLs?
	        );

	        // set the background color for the chart...
	        chart.setBackgroundPaint(Color.white);

	        // get a reference to the plot for further customisation...
	        final CategoryPlot plot = chart.getCategoryPlot();
	        plot.setBackgroundPaint(Color.lightGray);
	        plot.setDomainGridlinePaint(Color.white);
	        plot.setRangeGridlinePaint(Color.white);

	        // set the range axis to display integers only...
	        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
	        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

	        // disable bar outlines...
	        final BarRenderer renderer = (BarRenderer) plot.getRenderer();
	        renderer.setDrawBarOutline(false);
	        
	        // set up gradient paints for series...
	        final GradientPaint gp0 = new GradientPaint(
	            0.0f, 0.0f, Color.blue, 
	            0.0f, 0.0f, Color.lightGray
	        );
	        final GradientPaint gp1 = new GradientPaint(
	            0.0f, 0.0f, Color.green, 
	            0.0f, 0.0f, Color.lightGray
	        );
	        final GradientPaint gp2 = new GradientPaint(
	            0.0f, 0.0f, Color.red, 
	            0.0f, 0.0f, Color.lightGray
	        );
	        final GradientPaint gp3 = new GradientPaint(
		            0.0f, 0.0f, Color.magenta, 
		            0.0f, 0.0f, Color.lightGray
		        );
	        renderer.setSeriesPaint(0, gp0);
	        renderer.setSeriesPaint(1, gp1);
	        renderer.setSeriesPaint(2, gp2);
	        renderer.setSeriesPaint(3, gp3);
	        final CategoryAxis domainAxis = plot.getDomainAxis();
	        domainAxis.setCategoryLabelPositions(
	            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
	        );
	        
	        return chart;
	        
	    }

	}
	
