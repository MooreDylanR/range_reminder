package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Controller;

public class loadRangeListener implements ActionListener{
	Controller controller;
	public loadRangeListener(Controller controller) {
		this.controller = controller;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		controller.loadAllRange();
		//controller.loadRange();
	}

}
