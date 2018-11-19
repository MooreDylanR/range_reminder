package controller;

import model.DataModel;
import model.Hand;
import model.Range;
import view.RRFrame;

public class Controller {
	RRFrame view;
	DataModel model;
	int activeRange;
	
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
		Hand.status newStatus = model.ranges[activeRange].hands[x][y].changeStatus();
		RRFrame.updateButton(x,y, newStatus);
	}
	
	public void initGui() {
		RRFrame.createAndShowGUI(this);
	}
}
