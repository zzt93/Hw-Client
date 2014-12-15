package po;

/**
 * Created by Nifury on 2014/10/20.
 */
public enum  ClientType {
    STOCKER, SELLER;
    public static String getName(ClientType type){
    	switch(type){
    	case STOCKER:
    		return "供应商";
    	case SELLER:
    		return "销售商";
    	}
    	return null;
    }
}
