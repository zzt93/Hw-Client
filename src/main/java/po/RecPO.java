package po;

import vo.RecVO;

public class RecPO extends ReceiptPO {
	public String client,operator;
	public BkTransPO[] bankList;
	public double total=0;
	public RecPO(RecVO vo,BkTransPO[] list){
		number=vo.number;
		client=vo.client;
		operator=vo.operator;
		bankList=list;
		total=vo.total;
		type=ReceiptType.RECEIVE;
	}
	public RecPO(RecVO vo){
		number=vo.number;
		client=vo.client;
		operator=vo.operator;
		bankList=vo.bankList;
		total=vo.total;
		type=ReceiptType.RECEIVE;
	}
	public RecPO(){}
}
