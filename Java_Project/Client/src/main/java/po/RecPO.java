package po;

import vo.BankVO;
import vo.RecVO;

public class RecPO extends ReceiptPO {
	String client,operator;
	BankVO[] bankList;
	double total=0;
	public RecPO(RecVO vo){
		number=vo.number;
		client=vo.client;
		operator=vo.operator;
		bankList=vo.bankList;
		total=vo.total;
	}
}
