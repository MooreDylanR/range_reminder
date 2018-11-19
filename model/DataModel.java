package model;

public class DataModel {
	// a collection of ranges
	public Range[] ranges = new Range[20];
	
	public DataModel() {
		for (int i =0;i<20;i++) {
			ranges[i] = new Range();
		}
	}
	
	

}
