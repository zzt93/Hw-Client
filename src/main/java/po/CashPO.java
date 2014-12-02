package po;

import vo.CashVO;
/**
 * Created by MethyleneBlue on 2014/10/??.
 */
public class CashPO extends ReceiptPO{
	public String operator;
	public double total=0;
	public ItemPO[] itemList;
	public CashPO(CashVO vo,ItemPO[] list){
		operator=vo.operator;
		itemList=list;
		total=vo.total;
		type=ReceiptType.CASH;
	}
	public CashPO(CashVO vo){
		operator=vo.operator;
		itemList=vo.itemList;
		total=vo.total;
		type=ReceiptType.CASH;
	}
	public CashPO(){
		
		number="测试单据";
		type=ReceiptType.CASH;
	}
}
