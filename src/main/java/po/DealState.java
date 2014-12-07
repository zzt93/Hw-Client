package po;

public enum DealState {
	DEAL,UNDEAL;
	public static String getName(DealState state){
		switch(state){
		case DEAL:
			return "已处理";
		case UNDEAL:
			return "待处理";
		}
		return null;
	}
}
