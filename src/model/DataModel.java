package model;

public class DataModel {
	// a collection of ranges
	public Range[] ranges = new Range[35];
	
	public DataModel() {
		//TODO need to find a way to create the ranges but not load them into the rangelist
		
		ranges[0] = new Range(".new range");
		ranges[1] = new Range(".range");
		ranges[2] = new Range(".range");
		ranges[3] = new Range(".range");
		ranges[4] = new Range(".range");
		ranges[5] = new Range(".range");
		ranges[6] = new Range(".range");
		ranges[7] = new Range(".range");
		ranges[8] = new Range(".range");
		ranges[9] = new Range(".range");
		ranges[10] = new Range(".range");
		ranges[11] = new Range(".range");
		ranges[12] = new Range(".range");
		ranges[13] = new Range(".range");
		ranges[14] = new Range(".range");
		ranges[15] = new Range(".range");
		ranges[16] = new Range(".range");
		ranges[17] = new Range(".range");
		ranges[18] = new Range(".range");
		ranges[19] = new Range(".range");
		ranges[20] = new Range(".range");
		ranges[21] = new Range(".range");
		ranges[22] = new Range(".range");
		ranges[23] = new Range(".range");
		ranges[24] = new Range(".range");
		ranges[25] = new Range(".range");
		ranges[26] = new Range(".range");
		ranges[27] = new Range(".range");
		ranges[28] = new Range(".range");
		ranges[29] = new Range(".range");
		ranges[30] = new Range(".range");
		ranges[31] = new Range(".range");
		ranges[32] = new Range(".range");
		ranges[33] = new Range(".range");
		ranges[34] = new Range(".range");
		
		/*old ranges
		ranges[0] = new Range("open_utg");
		ranges[1] = new Range("open_hj");
		ranges[2] = new Range("open_co");
		ranges[3] = new Range("open_btn");
		ranges[4] = new Range("open_sb");
		
		ranges[5] = new Range("call_hj_vs_open_utg");
		
		ranges[6] = new Range("call_co_vs_open_utg");
		ranges[7] = new Range("call_co_vs_open_hj");
		
		ranges[8] = new Range("call_btn_vs_open_utg");
		ranges[9] = new Range("call_btn_vs_open_hj");
		ranges[10] = new Range("call_btn_vs_open_co");
		
		ranges[11] = new Range("call_sb_vs_open_utg");
		ranges[12] = new Range("call_sb_vs_open_hj");
		ranges[13] = new Range("call_sb_vs_open_co");
		ranges[14] = new Range("call_sb_vs_open_btn");
		
		ranges[15] = new Range("call_bb_vs_open_utg");
		ranges[16] = new Range("call_bb_vs_open_hj");
		ranges[17] = new Range("call_bb_vs_open_co");
		ranges[18] = new Range("call_bb_vs_open_btn");
		ranges[19] = new Range("call_bb_vs_open_sb");
		
		ranges[20] = new Range("3b_hj_vs_open_utg");
		
		ranges[21] = new Range("3b_co_vs_open_utg");
		ranges[22] = new Range("3b_co_vs_open_hj");
		
		ranges[23] = new Range("3b_btn_vs_open_utg");
		ranges[24] = new Range("3b_btn_vs_open_hj");
		ranges[25] = new Range("3b_btn_vs_open_co");
		
		ranges[26] = new Range("3b_sb_vs_open_utg");
		ranges[27] = new Range("3b_sb_vs_open_hj");
		ranges[28] = new Range("3b_sb_vs_open_co");
		ranges[29] = new Range("3b_sb_vs_open_btn");
		
		ranges[30] = new Range("3b_bb_vs_open_utg");
		ranges[31] = new Range("3b_bb_vs_open_hj");
		ranges[32] = new Range("3b_bb_vs_open_co");
		ranges[33] = new Range("3b_bb_vs_open_btn");
		ranges[34] = new Range("3b_bb_vs_open_sb");*/
		
	}
	
	public String getId(int activeRange) {
		if(ranges[activeRange] == null) {
			return "youcantdothat";
		}else {
			return "[" + ranges[activeRange].name + "]";
		}
	}
	
	
	//TODO test that length is the right thing. does this work?
	public int getEmptyRangeID() {
		for(int i=0;i<ranges.length;i++)
		{
			if (ranges[i].name.startsWith(".")){
				return i;
			}
		}
		
		return -1;
	}
	

}
