package vo;

import po.CashPO;
import po.ItemPO;
import po.ReceiptPO;
import po.ReceiptType;

import java.io.Serializable;

public class CashVO extends ReceiptPO implements Serializable {
	public String operator;
	public double total=0;
	public ItemPO[] itemList;
	public CashVO(String num,String operator,double total){
		number=num;
		this.operator=operator;
		this.total=total;
		type=ReceiptType.CASH;
	}
	public CashVO(CashPO po){
		number=po.number;
		operator=po.operator;
		total=po.total;
		itemList=po.itemList;
		type=ReceiptType.CASH;
		
	}
	public CashVO(){
		type=ReceiptType.CASH;
	}
}
