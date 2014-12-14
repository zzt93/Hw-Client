package po;

import vo.RecVO;

import java.io.Serializable;

/**
 * Created by MethyleneBlue on 2014/10/??.
 */
public class RecPO extends ReceiptPO implements Serializable {
	private static final long serialVersionUID = 1L;
	public String client,operator;
	public BkTransPO[] bankList;
	public double total=0;
	public DealState dealState=DealState.UNDEAL;
	public RecPO(RecVO vo,BkTransPO[] list){
		client=vo.client;
		operator=vo.operator;
		bankList=list;
		total=vo.total;
		type=ReceiptType.RECEIVE;
	}
	public RecPO(RecVO vo){
		client=vo.client;
		operator=vo.operator;
		bankList=vo.bankList;
		total=vo.total;
		type=ReceiptType.RECEIVE;
	}
	public RecPO(){
		client="张三";
		operator="小李";
		total=2180;
		type=ReceiptType.RECEIVE;
		bankList=new BkTransPO[2];
		bankList[0]=new BkTransPO();
		bankList[1]=new BkTransPO();
		number="SKD-20140507-99653";
		time="2014-05-07";
	}
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
}
