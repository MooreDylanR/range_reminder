package main;

import controller.Controller;
import model.DataModel;
import model.Range;
import view.RRFrame;

;

public class Run {
	
	public static void main(String [ ] args)
	{
		
		RRFrame view = new RRFrame("frame1");
		
		
		DataModel model = new DataModel();
		
		Controller controller = new Controller(view,model);
		
		controller.printRange();
		controller.initGui();
	}
}
