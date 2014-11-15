package po;

import vo.BankVO;
import vo.PayReceiptVO;

public class PayReceiptPO extends ReceiptPO{
	String client,operator;
	BkTransPO[] bankList;
	double total=0;
	public PayReceiptPO(PayReceiptVO vo,BkTransPO[] list){
		number=vo.number;
		client=vo.client;
		operator=vo.operator;
		bankList=list;
		total=vo.total;
	}
	public PayReceiptPO(){}
}
