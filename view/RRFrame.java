package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class RRFrame extends JFrame{
	
	//should probably make the pane with all the buttons as a class so the frame can have 
	// multiple of the same panes 
	
	GridLayout rangeGrid = new GridLayout(13,13);
	
	JButton[][] buttons = new JButton[13][13];
	
	
	
	public RRFrame(String name) {
		super(name);
		setResizable(false);
	}
	
	static void createAndShowGUI() {
        //Create and set up the window.
        RRFrame frame = new RRFrame("GridLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        frame.addComponentsToPane(frame.getContentPane());
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
	
	public void addComponentsToPane(final Container pane) {
		JPanel rangePanel = new JPanel();
		rangePanel.setLayout(rangeGrid);
        
		addButtonsToRangePanel(rangePanel);

		pane.add(rangePanel, BorderLayout.NORTH);
        
	}
	
	private void addButtonsToRangePanel(JPanel rangePanel) {
		
		// init buttons of all hands, set size, add all to rangePanel
		buttons[0][0] = new JButton("22");
		
		//aww fuck cant use gridlayout if we want to specify size, gotta use gridbaglayout
		buttons[0][0].setPreferredSize(new Dimension(10, 40));
		
		rangePanel.add(buttons[0][0]);
		rangePanel.add(new JButton("AKo"));
		rangePanel.add(new JButton("AQo"));
		rangePanel.add(new JButton("AJo"));
		rangePanel.add(new JButton("ATo"));
		rangePanel.add(new JButton("Ao9"));
		rangePanel.add(new JButton("A8o"));
		rangePanel.add(new JButton("A7o"));
		rangePanel.add(new JButton("A6o"));
		rangePanel.add(new JButton("A5o"));
		rangePanel.add(new JButton("A4o"));
		rangePanel.add(new JButton("A3o"));
		rangePanel.add(new JButton("A2o"));
		
		rangePanel.add(new JButton("A2o"));
	}
	
}
