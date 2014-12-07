package po;
/**
 * Created by MethyleneBlue on 2014/10/??.
 */
public enum ReceiptState {
	approve,wait,disapprove;
	public static String getName(ReceiptState state){
		switch(state){
		case approve:
			return "通过审批";
		case disapprove:
			return "未通过审批";
		case wait:
			return "待审";
		}
		return null;
		
	}
}
