package vo;

import java.io.Serializable;

public class SaleConditionVO extends TimeConditionVO implements Serializable {
    public String startTime, endTime, goods, client, storage, buisnessman;
    private static final long serialVersionUID = 1L;
    public SaleConditionVO(String startTime,String endTime,String goods,String client,
    		String storage,String buisnessman){
    	if(startTime.equals(""))startTime=null;
    	if(endTime.equals(""))endTime=null;
    	if(storage.equals(""))storage=null;
    	this.startTime = startTime;
        this.endTime = endTime;
        this.goods = goods;
        this.client = client;
        this.buisnessman = buisnessman;
        this.storage = storage;
    }
}
