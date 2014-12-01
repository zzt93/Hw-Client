package po;

import vo.CashVO;
/**
 * Created by MethyleneBlue on 2014/10/??.
 */
public class CashPO extends ReceiptPO{
	public String number,operator;
	public double total=0;
	public ItemPO[] itemList;
	public CashPO(CashVO vo,ItemPO[] list){
		number=vo.number;
		operator=vo.operator;
		itemList=list;
		total=vo.total;
		type=ReceiptType.CASH;
	}
	public CashPO(CashVO vo){
		number=vo.number;
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
