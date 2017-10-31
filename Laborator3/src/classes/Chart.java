package classes;

import java.io.*;
import java.util.ArrayList;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Chart {
    private int[] interval = new int[10];
    ArrayList<Float> arrayList;
    public Chart(ArrayList<Float> arrayList){
        this.arrayList = arrayList;
    }
    public void initializeArrays(){
        for(int i=0;i<10;i++){
            interval[i] = 0;
        }
    }
    public void countFunction(){
        for(Float x  : arrayList){
            if(x <=0.1){
                interval[0]++;
            }
            if(x>=0.1 && x<=0.2){
                interval[1]++;
            }
            if(x>=0.2 && x<=0.3){
                interval[2]++;
            }
            if(x>=0.3 && x<=0.4){
                interval[3]++;
            }
            if(x>=0.4 && x<=0.5){
                interval[4]++;
            }
            if(x>=0.5 && x<=0.6){
                interval[5]++;
            }
            if(x>=0.6 && x<=0.7){
                interval[6]++;
            }
            if(x>=0.7 && x<=0.8){
                interval[7]++;
            }
            if(x>=0.8 && x<=0.9){
                interval[8]++;
            }
            if(x>=0.9 && x<=1){
                interval[9]++;
            }
        }
    }


    public void drawChart() throws Exception {
        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
        initializeArrays();
        countFunction();
        line_chart_dataset.addValue(interval[0],"0.1","0.1");
        line_chart_dataset.addValue(interval[1],"0.1","0.2");
        line_chart_dataset.addValue(interval[2],"0.1","0.3");
        line_chart_dataset.addValue(interval[3],"0.1","0.4");
        line_chart_dataset.addValue(interval[4],"0.1","0.5");
        line_chart_dataset.addValue(interval[5],"0.1","0.6");
        line_chart_dataset.addValue(interval[6],"0.1","0.7");
        line_chart_dataset.addValue(interval[7],"0.1","0.8");
        line_chart_dataset.addValue(interval[8],"0.1","0.9");
        line_chart_dataset.addValue(interval[9],"0.1","1");

        JFreeChart lineChartObject = ChartFactory.createLineChart(
                "Binomial Distribution","Interval",
                "Binomial Distribution",
                line_chart_dataset,PlotOrientation.VERTICAL,
                true,true,false);

        int width = 640;    /* Width of the image */
        int height = 480;   /* Height of the image */
        File lineChart = new File( "LineChartBinomialDistribution1.jpeg" );
        ChartUtilities.saveChartAsJPEG(lineChart ,lineChartObject, width ,height);
    }
}