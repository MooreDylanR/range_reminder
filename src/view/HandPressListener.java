package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Controller;

public class HandPressListener implements ActionListener
{
	int x;
	int y;
	Controller controller;
	
	public HandPressListener(Controller controller, int x, int y) {
		this.x = x;
		this.y = y;
		this.controller = controller;
	}
	
	@Override
    public void actionPerformed(ActionEvent e)
    {
        controller.changeHandStatus(x,y);
    }
    

	
}