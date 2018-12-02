package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.DataModel;
import model.Hand;
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
	
	public void changeHandStatus(int x, int y) {
		Hand.status newStatus = model.ranges[activeRange].hands[x][y].cycleAndReturnStatus();
		RRFrame.updateButton(x,y, newStatus);
	}
	
	public void saveRange() throws IOException {
		this.updatePath();
		Range theActiveRange = model.ranges[activeRange];
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));
		Hand.status cur;
		writer.write("[" + model.ranges[activeRange].id + "]");
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
			writer.write("[" + model.ranges[r].id + "]");
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
		int tempActiveRange = activeRange;
		
		for(int i=0;i<35;i++) {
			activeRange = i;
			loadRange();
		}
		activeRange = tempActiveRange;
		refreshAllButtons();
		
	}
	
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
						System.out.println("could not load range " + model.ranges[activeRange].id);
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
	
	public void updatePath() {
		this.path = view.getPathBoxText();
		System.out.println("new path: " + this.path);
	}
	
	public void initGui() {
		RRFrame.createAndShowGUI(this);
	}
}
