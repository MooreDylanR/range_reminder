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
import model.Hand.status;
import model.Range;

public class RRFrame extends JFrame{
	
	//should probably make the pane with all the buttons as a class so the frame can have 
	// multiple of the same panes 
	
	GridBagLayout rangeGrid = new GridBagLayout();
	
	static JButton[][] buttons = new JButton[13][13];
	static JTextField loadSavePath = new JTextField(50);
	static JTextField rangeNameField = new JTextField();
	static DefaultListModel<String> rangeSelectionModel = new DefaultListModel<String>();
	
	static JLabel rangeLabel;
	
	
	
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
	
	public static void updateButton(int x, int y, status active) {
		//System.out.println(x+" "+y);
		if(active==Hand.status.IN) {
			buttons[x][y].setBackground(new Color(107,181,255));
		} else if (active==Hand.status.OUT) {
			buttons[x][y].setBackground(new Color(231,239,247));
		} else if (active==Hand.status.UNDECIDED) {
			buttons[x][y].setBackground(new Color(122, 214, 135));
		} else {
			//wow big error here
		}
		
	}
	
	public static void setRangeLabel(String string) {
		rangeLabel.setText(string);
	}
	
	public String getPathBoxText() {
		return loadSavePath.getText();
	}
	
	public String getRangeBoxText() {
		return rangeNameField.getText();
	}
	
	public static void addRangeToRanges(String rangeName) {
		rangeSelectionModel.addElement(rangeName);
	}
	
	public static void removeAllRanges() {
		rangeSelectionModel.removeAllElements();
	}
	
	private void addButtonsToRangePanel(JPanel rangePanel, Controller controller) {
		GridBagConstraints c = new GridBagConstraints();
		Range range = controller.getActiveRange();
		JPanel handsPanel = new JPanel();
		handsPanel.setLayout(rangeGrid);
		
		// init buttons of all hands, set size, add all to rangePanel
		// each hand button added to the handsPanel
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
				c.gridy=(13-j+1);
			
				handsPanel.add(buttons[i][j],c);
			}			
		}
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.BOTH;
		c.gridx=2;
		c.gridy=1;
		c.gridheight =13;
		c.gridwidth = 13;
		rangePanel.add(handsPanel, c);
				
		
		JList<String> rangeSelectionBox = new JList<String>(rangeSelectionModel);
		rangeListSelectionListener rlsl = new rangeListSelectionListener(rangeSelectionBox, controller);
		rangeSelectionBox.addListSelectionListener(rlsl);
		rangeSelectionBox.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		rangeSelectionBox.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		//can call the below statement anywhere
		
		String[] rangeNames = controller.getRangeNames();
		populateRangeList(rangeNames);
		
		
		rangeSelectionBox.setPreferredSize(new Dimension(100,250));
		c.gridx=0;
		c.gridy=1;
		c.gridheight =1;
		c.gridwidth = 1;
		rangePanel.add(rangeSelectionBox, c);
				
		c.gridx=0;
		c.gridy=2;
		c.gridheight =1;
		c.gridwidth = 1;
		rangePanel.add(rangeNameField, c);
		
		NewRangeListener newrl = new NewRangeListener(controller);
		JButton addRangeButton = new JButton("create new range");
		addRangeButton.addActionListener(newrl);
		c.gridx=0;
		c.gridy=3;
		c.gridheight =1;
		c.gridwidth = 1;
		rangePanel.add(addRangeButton, c);		
		
		saveRangeListener srl = new saveRangeListener(controller);
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(srl);
		c.gridx=0;
		c.gridy=15;
		c.gridheight =2;
		c.gridwidth = 5;
		rangePanel.add(saveButton, c);
		
		loadRangeListener lrl = new loadRangeListener(controller);
		JButton loadButton = new JButton("Load");
		loadButton.addActionListener(lrl);
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.BOTH;
		c.gridx=5;
		c.gridy=15;
		c.gridheight =2;
		c.gridwidth = 4;
		rangePanel.add(loadButton, c);
		
		PathBoxListener pbl = new PathBoxListener(controller);
		loadSavePath.addActionListener(pbl);
		loadSavePath.setText("C:/temp/tempfile1.txt");
		c.gridx=9;
		c.gridy=15;
		c.gridheight =2;
		c.gridwidth = 10;
		rangePanel.add(loadSavePath, c);
		
		PrevRangeListener prl = new PrevRangeListener(controller);
		JButton prevRangeButton = new JButton("prev");
		prevRangeButton.addActionListener(prl);
		prevRangeButton.setPreferredSize(new Dimension(40,40));
		prevRangeButton.setMargin(new Insets(0, 0, 0, 0));
		prevRangeButton.setFont(new Font("Arial", Font.PLAIN, 12));
		c.gridx=(0);
		c.gridy=(12);
		c.gridheight =1;
		c.gridwidth = 1;
		rangePanel.add(prevRangeButton, c);
		
		NextRangeListener nrl = new NextRangeListener(controller);
		JButton nextRangeButton = new JButton("next");
		nextRangeButton.addActionListener(nrl);
		nextRangeButton.setPreferredSize(new Dimension(40,40));
		nextRangeButton.setMargin(new Insets(0, 0, 0, 0));
		nextRangeButton.setFont(new Font("Arial", Font.PLAIN, 12));
		c.gridx=(0);
		c.gridy=(13);
		c.gridheight =1;
		c.gridwidth = 1;
		rangePanel.add(nextRangeButton, c);
		
		rangeLabel = new JLabel("helloworld");
		c.gridx=(1);
		c.gridy=(0);
		c.gridheight =1;
		c.gridwidth = 5;
		rangePanel.add(rangeLabel, c);
		
		

		System.out.println("addButtonsToRangePanel complete");
	}

	private void populateRangeList(String[] rangeNames) {
		//clear old ranges from rangelist
		rangeSelectionModel.clear();
		//add new ranges to rangelist
		//only add ranges to the rangelist if the name does not start with .
		//TODO do not add if name is blank?
		for(int i=0;i<rangeNames.length;i++) {
			if (rangeNames[i].charAt(0) != '.') {
				rangeSelectionModel.addElement(rangeNames[i]);	
			}	
		}
	}
	
}
