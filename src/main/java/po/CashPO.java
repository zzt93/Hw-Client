package po;

import vo.CashVO;
import vo.ItemVO;

public class CashPO extends ReceiptPO{
	String number,operator;
	double total=0;
	public ItemPO[] itemList;
	String time;
	public CashPO(CashVO vo,ItemPO[] list){
		number=vo.number;
		operator=vo.operator;
		itemList=list;
		total=vo.total;
		type=ReceiptType.CASH;
	}
	public CashPO(){}
}
