package po;

import vo.BankVO;
import vo.RecVO;

public class RecPO extends ReceiptPO {
	String client,operator;
	BkTransPO[] bankList;
	double total=0;
	public RecPO(RecVO vo,BkTransPO[] list){
		number=vo.number;
		client=vo.client;
		operator=vo.operator;
		bankList=list;
		total=vo.total;
		type=ReceiptType.RECEIVE;
	}
	public RecPO(){}
}
