package model;

public class Hand {
	public enum status{IN, OUT, UNDECIDED}
	
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
	
	public Hand.status cycleAndReturnStatus() {
		if(active==Hand.status.IN) {
			active = Hand.status.UNDECIDED;
		} else if (active==Hand.status.OUT) {
			active = Hand.status.IN;
		} else if (active==Hand.status.UNDECIDED) {
			active = Hand.status.OUT;
		} else {
			//wow big error here
		}
		return active;
	}
	
	public Hand.status getStatus() {
		return active;
	}
	
	public void setStatus(Hand.status status) {
		this.active = status;
	}
	
	public String getLabel() {
		return this.label;
	}
}
