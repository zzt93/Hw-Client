package po;

import vo.CashReceiptVO;
import vo.ItemVO;

public class CashReceiptPO extends ReceiptPO{
	String number,operator;
	double total=0;
	public ItemPO[] itemList;
	public CashReceiptPO(CashReceiptVO vo,ItemPO[] list){
		number=vo.number;
		operator=vo.operator;
		itemList=list;
		total=vo.total;
	}
	public CashReceiptPO(){}
}
