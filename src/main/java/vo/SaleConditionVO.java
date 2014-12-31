package vo;

import java.io.Serializable;

import po.ReceiptType;

public class SaleConditionVO extends TimeConditionVO implements Serializable {
    public String startTime, endTime, goods, client, storage, buisnessman;
    public ReceiptType type;
    private static final long serialVersionUID = 1L;
    public SaleConditionVO(String startTime,String endTime,String goods,String client,
    		String storage,String buisnessman){
    	if(startTime!=null){
    	  	if(startTime.equals(""))startTime=null;
    	}
    	if(endTime!=null){
        	if(endTime.equals(""))endTime=null;
    	}
    	if(storage!=null){
        	if(storage.equals(""))storage=null;	
    	}
    	if(buisnessman!=null){
    		if(buisnessman.equals(""))buisnessman=null;
    	}
    	this.startTime = startTime;
        this.endTime = endTime;
        this.goods = goods;
        this.client = client;
        this.buisnessman = buisnessman;
        this.storage = storage;
    }
}
