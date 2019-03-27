package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Controller;

public class NextRangeListener implements ActionListener {

	Controller controller;
	
	NextRangeListener(Controller controller){
		this.controller = controller;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		controller.nextRange();
	}

}
