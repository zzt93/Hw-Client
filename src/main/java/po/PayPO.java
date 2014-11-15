package po;

import vo.BankVO;
import vo.PayVO;

public class PayPO extends ReceiptPO{
	String client,operator;
	BankVO[] bankList;
	double total=0;
	public PayPO(PayVO vo){
		number=vo.number;
		client=vo.client;
		operator=vo.operator;
		bankList=vo.bankList;
		total=vo.total;
	}
	public PayPO(){}
}
