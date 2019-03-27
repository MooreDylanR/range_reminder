package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.Controller;

public class rangeListSelectionListener implements ListSelectionListener {
	JList<String> rangeList;
	Controller controller;
	
	public rangeListSelectionListener(JList<String> rangeSelectionBox, Controller controller) {
		this.rangeList = rangeSelectionBox;
		this.controller = controller;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		System.out.println(rangeList.getSelectedIndex());
		controller.setRange(rangeList.getSelectedIndex());
		controller.loadRange();
		
	}

}
