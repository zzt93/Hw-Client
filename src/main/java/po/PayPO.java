package po;

import vo.PayVO;

import java.io.Serializable;

/**
 * Created by MethyleneBlue on 2014/10/??.
 */
public class PayPO extends RecPO implements Serializable {
	public PayPO(PayVO vo,BkTransPO[] list){
		client=vo.client;
		operator=vo.operator;
		bankList=list;
		total=vo.total;
		type=ReceiptType.PAYMENT;
	}
	public PayPO(PayVO vo){
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
