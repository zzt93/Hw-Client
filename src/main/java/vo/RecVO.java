package vo;

import po.ReceiptPO;
import po.ReceiptType;

public class RecVO extends ReceiptPO{
	public String client,operator;
	public double total=0;
	public RecVO(String num,String client,String operator,double total){
		number=num;
		this.client=client;
		this.operator=operator;
		this.total=total;
		type=ReceiptType.RECEIVE;
	}
	public RecVO(){
		type=ReceiptType.RECEIVE;
	}
}
