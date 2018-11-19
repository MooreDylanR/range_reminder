package model;

public class Hand {
	private enum status{IN, OUT, UNDECIDED}
	
	/*
	 * status options
	 * IN = hand is 100% in this range
	 * OUT = hand is 0% in this range
	 * UNDECIDED = unknown% in this range
	 */
	Hand.status active;
	
	// hand label
	private final String label;
	
	public Hand(String label) {
		this.label = label;
		this.active = Hand.status.OUT;
	}
	
	public String getLabel() {
		return this.label;
	}
}
