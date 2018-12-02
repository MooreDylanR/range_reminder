package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Controller;

public class PathBoxListener implements ActionListener{
	
	private Controller controller;

	public PathBoxListener(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controller.updatePath();
		
	}

}
