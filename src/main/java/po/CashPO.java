package po;

import vo.CashVO;
import vo.ItemVO;

public class CashPO extends ReceiptPO{
	String number,operator;
	double total=0;
	public ItemVO[] itemList;
	public CashPO(CashVO vo){
		number=vo.number;
		operator=vo.operator;
		itemList=vo.itemList;
		total=vo.total;
	}
	public CashPO(){}
}
