package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Controller;

public class NewRangeListener implements ActionListener{
	Controller controller;
	
	public NewRangeListener(Controller controller) {
		this.controller = controller;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.makeNewRange();
	}

}
