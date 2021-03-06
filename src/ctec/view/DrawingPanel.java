package ctec.view;


import javax.swing.*;

import ctec.controller.*;

import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawingPanel extends JPanel
{
	private DrawingController baseController;
	private ShapePanel shapePanel;
	private GraphPanel graphPanel;
	private JButton addRectangleButton;
	private JButton addCircleButton;
	private JButton addSquareButton;
	private JButton addTriangleButton;
	private JButton addEllipseButton;
	private JButton addPolygonButton;
	private JButton clearButton;
	private SpringLayout baseLayout;
	private ArrayList<Rectangle> rectangleList;
	
	public DrawingPanel(DrawingController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		shapePanel = new ShapePanel();
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 45, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, -8, SpringLayout.EAST, this);
		graphPanel = new GraphPanel();
		baseLayout.putConstraint(SpringLayout.NORTH, graphPanel, 220, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, -20, SpringLayout.NORTH, graphPanel);
		baseLayout.putConstraint(SpringLayout.SOUTH, graphPanel, -20, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 0, SpringLayout.WEST, graphPanel);
		baseLayout.putConstraint(SpringLayout.WEST, graphPanel, 20, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, graphPanel, -20, SpringLayout.EAST, this);
		
		addRectangleButton = new JButton("Add a rectangle");
		baseLayout.putConstraint(SpringLayout.SOUTH, addRectangleButton, -232, SpringLayout.SOUTH, this);
		addPolygonButton = new JButton("Add a polygon!");
		rectangleList = new ArrayList<Rectangle>();
		addCircleButton = new JButton("Add a circle");
		baseLayout.putConstraint(SpringLayout.NORTH, addCircleButton, 0, SpringLayout.NORTH, addRectangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, addCircleButton, 45, SpringLayout.EAST, addRectangleButton);
		
		clearButton = new JButton("Clear the lists");
		baseLayout.putConstraint(SpringLayout.SOUTH, clearButton, 0, SpringLayout.NORTH, addRectangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, addRectangleButton, 10, SpringLayout.WEST, clearButton);
		baseLayout.putConstraint(SpringLayout.WEST, clearButton, 32, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, addPolygonButton, 0, SpringLayout.NORTH, clearButton);
		baseLayout.putConstraint(SpringLayout.WEST, addPolygonButton, 41, SpringLayout.EAST, clearButton);
		
		setupPanel();
		setupLayout();
		setupListeners();
	}

	
	
	public void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.DARK_GRAY);
		this.add(addRectangleButton);
		this.add(addPolygonButton);
		this.add(shapePanel);
		this.add(clearButton);
		//this.add(graphPanel);
		this.add(addCircleButton);
		
	}
	
	
	
	public void setupLayout()
	{
	}
	
	
	
	public void setupListeners()
	{
		
		addCircleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addEllipse();
				repaint();
			}
		});
		
				
		
		
		
		
		addRectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addRectangle();
				repaint();
				
			}
		});
		
		addPolygonButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addPolygon();
				repaint();
			}
		});
		
		clearButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.clear();
				repaint();
			}
		});
		
		
	}
	
	
	
	
	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		
		Graphics2D mainGraphics = (Graphics2D) currentGraphics;
		mainGraphics.setStroke(new BasicStroke(20));
		mainGraphics.setColor(Color.ORANGE);
		mainGraphics.drawRect(50, 70, 200, 400);
		
		mainGraphics.drawRect(50,  70,  200,  20);
		
		for(Rectangle current : rectangleList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.fill(current);
			
		}
		
	
		
	}
	
	
	
}
