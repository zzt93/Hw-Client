package po;

import vo.BankVO;
import vo.PayVO;

public class PayPO extends ReceiptPO{
	String client,operator;
	BkTransPO[] bankList;
	double total=0;
	public PayPO(PayVO vo,BkTransPO[] list){
		number=vo.number;
		client=vo.client;
		operator=vo.operator;
		bankList=list;
		total=vo.total;
		type=ReceiptType.PAYMENT;
	}
	public PayPO(PayVO vo){
		number=vo.number;
		client=vo.client;
		operator=vo.operator;
		bankList=vo.bankList;
		total=vo.total;
		type=ReceiptType.PAYMENT;
	}
	public PayPO(){}
}