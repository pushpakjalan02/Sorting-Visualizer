import javax.swing.JFrame;
import java.awt.Container;
import javax.swing.SwingUtilities;
  
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.data.category.DefaultCategoryDataset; 

class Plot extends JFrame{

	private DefaultCategoryDataset dataset;
	
	Plot(JFrame frame, int array[], String title){
		
		this.dataset = createDataset(array);

		JFreeChart barChart = ChartFactory.createBarChart(title, "", "", dataset, PlotOrientation.HORIZONTAL, false, true, false);
		
		ChartPanel cp = new ChartPanel(barChart);
		
		Container c = frame.getContentPane();
		c.add(cp);

	}

	public DefaultCategoryDataset getDataset(){
		return this.dataset;
	}

	public void delay(){
		try
		{
    		Thread.sleep(100);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}

		return;
	}

	private DefaultCategoryDataset createDataset(int array[]){

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		dataset.clear();

		for(int i = 0; i < array.length; i++){
			dataset.addValue(array[i], Integer.toString(i), "");
		}

		return dataset;
	}
}