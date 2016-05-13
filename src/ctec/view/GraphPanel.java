package ctec.view;
import java.awt.*;

import javax.swing.JPanel;


public class GraphPanel extends JPanel
{
	private int [] graphSource;
	
	public GraphPanel()
	{
		graphSource = new int[] {120,4,213,10, 407, 12, 705};
		setupPanel();
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.LIGHT_GRAY);
	}
	
	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		
		Graphics2D mainGraphics = (Graphics2D) currentGraphics;
		for(int index = 0; index < graphSource.length; index++)
		{
			int height = this.getHeight()/graphSource.length;
			int width = (int)((graphSource[index] / 200.00) * this.getWidth());
			int xPosition = 0;
			int yPosition = height * index;
			
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int alpha = (int)(Math.random() * 255);
			
			
			mainGraphics.setColor(new Color(red, green, blue, alpha));
			
			mainGraphics.fill(new Rectangle(xPosition, yPosition, width, height));
			
		}
	}
}
