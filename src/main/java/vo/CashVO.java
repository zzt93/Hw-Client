package vo;

import po.CashPO;
import po.ItemPO;
import po.ReceiptPO;
import po.ReceiptType;

import java.io.Serializable;
import java.util.List;

public class CashVO extends ReceiptPO implements Serializable {
	public String operator;
	public double total=0;
	public String bank;
	public List<ItemPO> itemList;
	private static final long serialVersionUID = 1L;
	public CashVO(String bank,String operator,double total){
		this.bank=bank;
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
