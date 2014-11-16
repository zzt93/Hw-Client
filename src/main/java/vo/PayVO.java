package vo;

import po.ReceiptPO;
import po.ReceiptType;

public class PayVO extends ReceiptPO{
	public String client,operator;
	public double total=0;
	public PayVO(String num,String client,String operator,double total){
		number=num;
		this.client=client;
		this.operator=operator;
		this.total=total;
		type=ReceiptType.PAYMENT;
	}
	public PayVO(){
		type=ReceiptType.PAYMENT;
	}
}
