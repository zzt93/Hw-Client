package vo;

import po.BkTransPO;
import po.RecPO;
import po.ReceiptPO;
import po.ReceiptType;

public class RecVO extends ReceiptPO{
	public String client,operator;
	public BkTransPO[] bankList;
	public double total=0;
	public RecVO(String num,String client,String operator,double total){
		number=num;
		this.client=client;
		this.operator=operator;
		this.total=total;
		type=ReceiptType.RECEIVE;
	}
	public RecVO(RecPO po){
		number=po.number;
		client=po.client;
		operator=po.operator;
		total=po.total;
		bankList=po.bankList;
		type=ReceiptType.RECEIVE;
	}
	public RecVO(){
		type=ReceiptType.RECEIVE;
	}
}
