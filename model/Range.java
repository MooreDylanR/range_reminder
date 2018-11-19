package model;

public class Range {
	String id = "test";
	public Hand[][] hands;
	
	
	public Range() {
		this.hands = new Hand[13][13];
		
		hands[0][0] = new Hand("22");	hands[1][0] = new Hand("32o");	hands[2][0] = new Hand("42o");
		hands[0][1] = new Hand("32s");	hands[1][1] = new Hand("33");	hands[2][1] = new Hand("43o");
		hands[0][2] = new Hand("42s");	hands[1][2] = new Hand("43s");	hands[2][2] = new Hand("44");
		hands[0][3] = new Hand("52s");	hands[1][3] = new Hand("53s");	hands[2][3] = new Hand("54s");
		hands[0][4] = new Hand("62s");	hands[1][4] = new Hand("63s");	hands[2][4] = new Hand("64s");
		hands[0][5] = new Hand("72s");	hands[1][5] = new Hand("73s");	hands[2][5] = new Hand("74s");
		hands[0][6] = new Hand("82s");	hands[1][6] = new Hand("83s");	hands[2][6] = new Hand("84s");
		hands[0][7] = new Hand("92s");	hands[1][7] = new Hand("93s");	hands[2][7] = new Hand("94s");
		hands[0][8] = new Hand("T2s");	hands[1][8] = new Hand("T3s");	hands[2][8] = new Hand("T4s");
		hands[0][9] = new Hand("J2s");	hands[1][9] = new Hand("J3s");	hands[2][9] = new Hand("J4s");
		hands[0][10]= new Hand("Q2s");	hands[1][10]= new Hand("Q3s");	hands[2][10]= new Hand("Q4s");
		hands[0][11]= new Hand("K2s");	hands[1][11]= new Hand("K3s");	hands[2][11]= new Hand("K4s");
		hands[0][12]= new Hand("A2s");	hands[1][12]= new Hand("A3s");	hands[2][12]= new Hand("A4s");
		
		hands[3][0] = new Hand("52o");	hands[4][0] = new Hand("62o");	hands[5][0] = new Hand("72o");
		hands[3][1] = new Hand("53o");	hands[4][1] = new Hand("63o");	hands[5][1] = new Hand("73o");
		hands[3][2] = new Hand("54o");	hands[4][2] = new Hand("64o");	hands[5][2] = new Hand("74o");
		hands[3][3] = new Hand("55");	hands[4][3] = new Hand("65o");	hands[5][3] = new Hand("75o");
		hands[3][4] = new Hand("65s");	hands[4][4] = new Hand("66");	hands[5][4] = new Hand("76o");
		hands[3][5] = new Hand("75s");	hands[4][5] = new Hand("76s");	hands[5][5] = new Hand("77");
		hands[3][6] = new Hand("85s");	hands[4][6] = new Hand("86s");	hands[5][6] = new Hand("87s");
		hands[3][7] = new Hand("95s");	hands[4][7] = new Hand("96s");	hands[5][7] = new Hand("97s");
		hands[3][8] = new Hand("T5s");	hands[4][8] = new Hand("T6s");	hands[5][8] = new Hand("T7s");
		hands[3][9] = new Hand("J5s");	hands[4][9] = new Hand("J6s");	hands[5][9] = new Hand("J7s");
		hands[3][10]= new Hand("Q5s");	hands[4][10]= new Hand("Q6s");	hands[5][10]= new Hand("Q7s");
		hands[3][11]= new Hand("K5s");	hands[4][11]= new Hand("K6s");	hands[5][11]= new Hand("K7s");
		hands[3][12]= new Hand("A5s");	hands[4][12]= new Hand("A6s");	hands[5][12]= new Hand("A7s");
		
		hands[6][0] = new Hand("82o");	hands[7][0] = new Hand("92o");	hands[8][0] = new Hand("T2o");
		hands[6][1] = new Hand("83o");	hands[7][1] = new Hand("93o");	hands[8][1] = new Hand("T3o");
		hands[6][2] = new Hand("84o");	hands[7][2] = new Hand("94o");	hands[8][2] = new Hand("T4o");
		hands[6][3] = new Hand("85o");	hands[7][3] = new Hand("95o");	hands[8][3] = new Hand("T5o");
		hands[6][4] = new Hand("86o");	hands[7][4] = new Hand("96o");	hands[8][4] = new Hand("T6o");
		hands[6][5] = new Hand("87o");	hands[7][5] = new Hand("97o");	hands[8][5] = new Hand("T7o");
		hands[6][6] = new Hand("88");	hands[7][6] = new Hand("98o");	hands[8][6] = new Hand("T8o");
		hands[6][7] = new Hand("98s");	hands[7][7] = new Hand("99");	hands[8][7] = new Hand("T9o");
		hands[6][8] = new Hand("T8s");	hands[7][8] = new Hand("T9s");	hands[8][8] = new Hand("TT");
		hands[6][9] = new Hand("J8s");	hands[7][9] = new Hand("J9s");	hands[8][9] = new Hand("JTs");
		hands[6][10]= new Hand("Q8s");	hands[7][10]= new Hand("Q9s");	hands[8][10]= new Hand("QTs");
		hands[6][11]= new Hand("K8s");	hands[7][11]= new Hand("K9s");	hands[8][11]= new Hand("KTs");
		hands[6][12]= new Hand("A8s");	hands[7][12]= new Hand("A9s");	hands[8][12]= new Hand("ATs");
	
		hands[9][0] = new Hand("J2o");	hands[10][0] = new Hand("Q2o");	hands[11][0] = new Hand("K2o");
		hands[9][1] = new Hand("J3o");	hands[10][1] = new Hand("Q3o");	hands[11][1] = new Hand("K3o");
		hands[9][2] = new Hand("J4o");	hands[10][2] = new Hand("Q4o");	hands[11][2] = new Hand("K4o");
		hands[9][3] = new Hand("J5o");	hands[10][3] = new Hand("Q5o");	hands[11][3] = new Hand("K5o");
		hands[9][4] = new Hand("J6o");	hands[10][4] = new Hand("Q6o");	hands[11][4] = new Hand("K6o");
		hands[9][5] = new Hand("J7o");	hands[10][5] = new Hand("Q7o");	hands[11][5] = new Hand("K7o");
		hands[9][6] = new Hand("J8o");	hands[10][6] = new Hand("Q8o");	hands[11][6] = new Hand("K8o");
		hands[9][7] = new Hand("J9o");	hands[10][7] = new Hand("Q9o");	hands[11][7] = new Hand("K9o");
		hands[9][8] = new Hand("JTo");	hands[10][8] = new Hand("QTo");	hands[11][8] = new Hand("KTo");
		hands[9][9] = new Hand("JJ");	hands[10][9] = new Hand("QJo");	hands[11][9] = new Hand("KJo");
		hands[9][10]= new Hand("QJs");	hands[10][10]= new Hand("QQ");	hands[11][10]= new Hand("KQo");
		hands[9][11]= new Hand("KJs");	hands[10][11]= new Hand("KQs");	hands[11][11]= new Hand("KK");
		hands[9][12]= new Hand("AJs");	hands[10][12]= new Hand("AQs");	hands[11][12]= new Hand("AKs");
		
		hands[12][0] = new Hand("A2o");
		hands[12][1] = new Hand("A3o");
		hands[12][2] = new Hand("A4o");
		hands[12][3] = new Hand("A5o");
		hands[12][4] = new Hand("A6o");
		hands[12][5] = new Hand("A7o");
		hands[12][6] = new Hand("A8o");
		hands[12][7] = new Hand("A9o");
		hands[12][8] = new Hand("ATo");
		hands[12][9] = new Hand("AJo");
		hands[12][10]= new Hand("AQo");
		hands[12][11]= new Hand("AKo");
		hands[12][12]= new Hand("AA");
		
	}
}
