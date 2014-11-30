package po;

import vo.PayVO;

public class PayPO extends ReceiptPO{
	String client,operator;
	BkTransPO[] bankList;
	public String getClient() {
		return client;
	}
	public String getOperator() {
		return operator;
	}
	public BkTransPO[] getBankList() {
		return bankList;
	}
	public double getTotal() {
		return total;
	}
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
	public PayPO(){
		type = ReceiptType.PAYMENT;
	}
}
