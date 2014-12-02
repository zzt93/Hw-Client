package vo;

import po.BkTransPO;
import po.ReceiptPO;
import po.ReceiptType;

import java.io.Serializable;

public class PayVO extends ReceiptPO implements Serializable {
	public String client,operator;
	public BkTransPO[] bankList;
	public double total=0;
	public PayVO(String client,String operator,double total){
		this.client=client;
		this.operator=operator;
		this.total=total;
		type=ReceiptType.PAYMENT;
	}
	public PayVO(){
		type=ReceiptType.PAYMENT;
	}
}
