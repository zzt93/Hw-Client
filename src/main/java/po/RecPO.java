package po;

import vo.RecVO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MethyleneBlue on 2014/10/??.
 */
public class RecPO extends ReceiptPO implements Serializable {
	private static final long serialVersionUID = 1L;
	public String client,operator;
	public List<BkTransPO> bankList;
	public double total=0;
	public DealState dealState=DealState.UNDEAL;
	public RecPO(RecVO vo,List<BkTransPO> list){
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
		type=ReceiptType.RECEIVE;
	}
	public String getClient() {
		return client;
	}
	public String getOperator() {
		return operator;
	}
	public List<BkTransPO> getBankList() {
		return bankList;
	}
	public double getTotal() {
		return total;
	}
}
