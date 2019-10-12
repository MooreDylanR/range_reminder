package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.DataModel;
import model.Hand;
import model.Hand.status;
import model.Range;
import view.RRFrame;

public class Controller {
	RRFrame view;
	DataModel model;
	int activeRange;
	String path;
	
	public Controller(RRFrame view, DataModel model) {
		this.view = view;
		this.model = model;
		activeRange=0;

		
	}
	
	public void printRange() {
		for(int i =12;i>=0;i--) {
			for (int j=12;j>=0;j--){
				System.out.print(model.ranges[activeRange].hands[j][i].getLabel() + "  ");
				if (i==j) {
					System.out.print(" ");
				}
			}
			System.out.println();
			
		}
	}
	
	public Range getActiveRange() {
		return model.ranges[activeRange];
	}
	
	public int getRangeByName(String rangeName) {
		for (int i=0; i<model.ranges.length;i++) {
			if (model.ranges[i].name.equalsIgnoreCase(rangeName)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public String[] getRangeNames() {
		String[] rangeNames = new String[model.ranges.length];
		System.out.println(model.ranges.length + " " + rangeNames.length);
		//This is kinda dumb, looping through each to write down the name, 
		//then looping through to read on other side?
		for(int i =0; i<model.ranges.length; i++) {
			rangeNames[i]=model.ranges[i].name;
		}	
		return rangeNames;
	}
	
	public void changeHandStatus(int x, int y) {
		Hand.status newStatus = model.ranges[activeRange].hands[x][y].cycleAndReturnStatus();
		RRFrame.updateButton(x,y, newStatus);
	}
	
	public void saveRangeToFile() throws IOException {
		this.updatePath();
		Range theActiveRange = model.ranges[activeRange];
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));
		Hand.status cur;
		writer.write("[" + model.ranges[activeRange].name + "]");
		writer.newLine();
	    
		for(int i =12;i>=0;i--) {
			for (int j=12;j>=0;j--){
				cur = theActiveRange.hands[j][i].getStatus();
				if(cur==Hand.status.IN) {
					writer.write("1");
				} else if (cur ==Hand.status.OUT ) {
					writer.write("0");
				} else if (cur == Hand.status.UNDECIDED) {
					writer.write("2");
				} else {
					System.out.println("error could not read character at " + i + " " +j);
				}		
			}
			writer.newLine();
		}
	    writer.close();
	}
	
	public void saveAllRanges() throws IOException {
		this.updatePath();
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));
		Hand.status cur;
		for(int r=0;r<35;r++) {
			Range curRange = model.ranges[r];
			writer.write("[" + model.ranges[r].name + "]");
			writer.newLine();
		    
			for(int i =12;i>=0;i--) {
				for (int j=12;j>=0;j--){
					cur = curRange.hands[j][i].getStatus();
					if(cur==Hand.status.IN) {
						writer.write("1");
					} else if (cur ==Hand.status.OUT ) {
						writer.write("0");
					} else if (cur == Hand.status.UNDECIDED) {
						writer.write("2");
					} else {
						System.out.println("error could not read character at " + i + " " +j);
					}		
				}
				writer.newLine();
			}
		}
		writer.close();
	}
	
	public void loadAllRange() {
		//TODO what does tempActiveRange do?
		int tempActiveRange = activeRange;
		
		//TODO
		//cant just do not null here
		
		//TODO completely change what this function does, 
		//it needs to READ names from the file and assign them to ranges
		// gotta get all strings that have [name] from the file
		
		//model.ranges[i]
		//activeRange = i;
		//loadRange();	
		String[] rangeNames = getRangeNamesFromFile();
		
		


		activeRange = tempActiveRange;
		refreshAllButtons();
		
	}
	
	
	//TODO use the same file reading code for this and loadRange?  
	private String[] getRangeNamesFromFile() {
		String[] rangeNames = new String[35];
		int curRange = 0;
		
		String line;
		char cur;
		this.updatePath();
		File f = new File(this.path);
		if(f.exists() && !f.isDirectory()) { 
			// and valid
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(path));
				line = reader.readLine();
				
				if(line.charAt(0) == '[') {
					rangeNames[curRange] = line; //TODO full line or just inside brackets
					curRange++;
				}
				
				//TODO do i do this? refreshAllButtons();		
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			if (!(f.exists())){
				System.out.println("file doesnt exist");
			}
			
			System.out.println("Cant load from file");
		}
		
		return null;
	}

	//summary: search file for a range that has the name of the current active range
	// 			if its found, load the following 12 line's statuses into the active range
	public void loadRange() {
		//this is going to be a big one
		// check that the file is there
		String line;
		char cur;
		this.updatePath();
		File f = new File(this.path);
		if(f.exists() && !f.isDirectory()) { 
			// and valid
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(path));
				line = reader.readLine();
				//String actual = model.getId(activeRange);
				while(!line.equals(model.getId(activeRange))) {
					line = reader.readLine();
					if (line == null){
						System.out.println("could not load range " + model.ranges[activeRange].name);
						reader.close();
						return;
					}
				}
				//need to find a way to do this in one transaction so if it errors out then it still displays the last range
				for(int i=0;i<13;i++) {
					line = reader.readLine();
					if(line.length()==13) {
						for(int j = 0; j<13; j++) {
							cur = line.charAt(j);
							if(cur=='1') {
								model.ranges[activeRange].hands[12-j][12-i].setStatus(Hand.status.IN);
							} else if (cur=='0') {
								model.ranges[activeRange].hands[12-j][12-i].setStatus(Hand.status.OUT);
							} else if (cur=='2') {
								model.ranges[activeRange].hands[12-j][12-i].setStatus(Hand.status.UNDECIDED);
							} else {
								System.out.println("got an unexpected character while loading range");
							}			
						}
					} else {
						System.out.println("warning: line read in did not have 13 statuses");
					}
				}
				refreshAllButtons();		
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			if (!(f.exists())){
				System.out.println("file doesnt exist");
			}
			
			System.out.println("Cant load from file");
		}
	}
	
	//TODO redo this so no array out of bounds exception
	public void updateRangeList() {
		RRFrame.removeAllRanges();
		int i = 0;
		while (model.ranges[i] != null) {
			RRFrame.addRangeToRanges(model.ranges[i].name);	
			i++;
		}
		
	}
	
	public void refreshAllButtons() {
		//update all buttons
		for(int i =12;i>=0;i--) {
			for (int j=12;j>=0;j--){
				RRFrame.updateButton(i, j, model.ranges[activeRange].hands[i][j].getStatus());
			}
		}
	}
	
	public void prevRange(){
		if(activeRange>0) {
			activeRange--;
			refreshAllButtons();
			System.out.println(model.getId(activeRange));
			RRFrame.setRangeLabel(model.getId(activeRange));
		} else {
			System.out.println("cant decrease range selection, already 0");
		}
	}
	
	public void nextRange(){
		if(activeRange<34) {//TODO take off magic number
			activeRange++;
			refreshAllButtons();
			System.out.println(model.getId(activeRange));
			RRFrame.setRangeLabel(model.getId(activeRange));
		} else {
			System.out.println("cant increase range selection, already at max (34)");
		}
	}
	
	public void setRange(int activeRange) {
		this.activeRange = activeRange;
	}
	
	public void makeNewRange() {
		//todo put this range in the list of ranges?
		//TODO find out how to turn the current button selection state into the range array
		//TODO this is the right direction, gotta save array state
		int rangeToWrite = model.getEmptyRangeID();
		model.ranges[rangeToWrite] = new Range(view.getRangeBoxText());
		
		
		RRFrame.addRangeToRanges(view.getRangeBoxText());
	}
	
	
	
	public void updatePath() {
		this.path = view.getPathBoxText();
		System.out.println("new path: " + this.path);
	}
	
	public void initGui() {
		RRFrame.createAndShowGUI(this);
	}




}
