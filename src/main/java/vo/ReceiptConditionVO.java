package vo;

import po.DealState;
import po.ReceiptState;
import po.ReceiptType;

import java.io.Serializable;

public class ReceiptConditionVO extends TimeConditionVO implements Serializable {
    public String startTime, endTime, client, operator, storage;
    public ReceiptType type;
    public ReceiptState state;
    public DealState dealState;
    private static final long serialVersionUID = 1L;
    public ReceiptConditionVO(String startTime, String endTime, ReceiptType type, String client
            , String operator, String storage) {
    	if(startTime!=null){
    		if(startTime.equals(""))startTime=null;
    	}
    	if(endTime!=null){
    		if(endTime.equals(""))endTime=null;
    	}
    	if(storage!=null){
    		if(storage.equals(""))storage=null;
    	}
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
        this.client = client;
        this.operator = operator;
        this.storage = storage;
    }

    public ReceiptConditionVO(ReceiptType type) {
        this(null, null, type, null, null, null);
    }

    public ReceiptConditionVO() {
    	this(null);
    }
   
}
