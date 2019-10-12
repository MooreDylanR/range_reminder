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
		int rangeIndex;
		System.out.println(rangeList.getSelectedIndex());
		rangeIndex = controller.getRangeByName(rangeList.getSelectedValue());//param of whatever the string for the range name is 
		System.out.println(rangeList.getSelectedValue());
		if(rangeIndex != -1) {
			controller.setRange(rangeIndex);// old way rangeList.getSelectedIndex()
			controller.loadRange();
		} else {
			System.out.println("cant find a range by that name");
		}
		
		
	}

}
