package vo;

import po.ReceiptPO;
import po.ReceiptType;

public class CashVO extends ReceiptPO {
	public String operator;
	public double total=0;
	public CashVO(String num,String operator,double total){
		number=num;
		this.operator=operator;
		this.total=total;
		type=ReceiptType.CASH;
	}
	public CashVO(){
		type=ReceiptType.CASH;
	}
}
