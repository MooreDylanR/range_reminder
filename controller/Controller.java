package controller;

import model.DataModel;
import view.RRFrame;

public class Controller {
	RRFrame view;
	DataModel model;
	
	public Controller(RRFrame view, DataModel model) {
		this.view = view;
		this.model = model;
	}
	
	public void printRange() {
		for(int i =12;i>=0;i--) {
			for (int j=12;j>=0;j--){
				System.out.print(model.ranges[0].hands[j][i].getLabel() + "  ");
				if (i==j) {
					System.out.print(" ");
				}
			}
			System.out.println();
			
		}
	}
}
