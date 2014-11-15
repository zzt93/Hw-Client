package po;

import vo.BankVO;
import vo.RecReceiptVO;

public class RecReceiptPO extends ReceiptPO {
	String client,operator;
	BkTransPO[] bankList;
	double total=0;
	public RecReceiptPO(RecReceiptVO vo,BkTransPO[] list){
		number=vo.number;
		client=vo.client;
		operator=vo.operator;
		bankList=list;
		total=vo.total;
	}
	public RecReceiptPO(){}
}
