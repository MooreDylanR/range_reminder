package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

import controller.Controller;
import model.Hand;
import model.Range;

public class RRFrame extends JFrame{
	
	//should probably make the pane with all the buttons as a class so the frame can have 
	// multiple of the same panes 
	
	GridBagLayout rangeGrid = new GridBagLayout();
	
	static JButton[][] buttons = new JButton[13][13];
	
	
	
	public RRFrame(String name) {
		super(name);
		setResizable(false);
	}
	
	public static void createAndShowGUI(Controller controller) {
        //Create and set up the window.
        RRFrame frame = new RRFrame("GridLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        frame.addComponentsToPane(frame.getContentPane(), controller);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
    }
	
	public void addComponentsToPane(final Container pane, Controller controller) {
		JPanel rangePanel = new JPanel();
		rangePanel.setLayout(rangeGrid);
        
		addButtonsToRangePanel(rangePanel, controller);

		pane.add(rangePanel, BorderLayout.NORTH);
        
	}
	
	public static void updateButton(int x, int y, Hand.status status) {
		System.out.println(x+" "+y);
		if(status==Hand.status.IN) {
			buttons[x][y].setBackground(new Color(107,181,255));
		} else if (status==Hand.status.OUT) {
			buttons[x][y].setBackground(new Color(231,239,247));
		} else if (status==Hand.status.UNDECIDED) {
			buttons[x][y].setBackground(new Color(211, 244, 210));
		} else {
			//wow big error here
		}
		
	}
	
	private void addButtonsToRangePanel(JPanel rangePanel, Controller controller) {
		GridBagConstraints c = new GridBagConstraints();
		Range range = controller.getActiveRange();
		
		//if (shouldFill) {
		//                //natural height, maximum width
		//                c.fill = GridBagConstraints.HORIZONTAL;
		//}
		// init buttons of all hands, set size, add all to rangePanel
		for(int i=0;i<13;i++) {
			for(int j=0;j<13;j++) {
				buttons[i][j] = new JButton(range.hands[i][j].getLabel());
				
				HandPressListener hpl = new HandPressListener(controller, i,j);
				buttons[i][j].addActionListener(hpl);
				
				buttons[i][j].setPreferredSize(new Dimension(40,40));
				buttons[i][j].setMargin(new Insets(0, 0, 0, 0));
				buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 12));
				updateButton(i,j,Hand.status.OUT);
				//c.insets = new Insets(25, 0, 0, 0);
				
				c.anchor = GridBagConstraints.CENTER;
				c.fill = GridBagConstraints.BOTH;
				c.gridx=(13-i);
				c.gridy=(13-j);
			
				rangePanel.add(buttons[i][j],c);
			}
		}
		System.out.println("addButtonsToRangePanel complete");
		
	}
	
}
