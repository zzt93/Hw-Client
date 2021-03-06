package vo;

import po.BkTransPO;
import po.RecPO;
import po.ReceiptPO;
import po.ReceiptType;

import java.io.Serializable;
import java.util.List;

public class RecVO extends ReceiptPO implements Serializable {
	public String client,operator;
	public List<BkTransPO> bankList;
	public double total=0;
	private static final long serialVersionUID = 1L;
	public RecVO(String client,String operator,double total){
		this.client=client;
		this.operator=operator;
		this.total=total;
		type=ReceiptType.RECEIVE;
	}
	public RecVO(RecPO po){
		number=po.number;
		client=po.client;
		operator=po.operator;
		total=po.total;
		bankList=po.bankList;
		type=po.type;
		statement=po.statement;
		time=po.time;
		
	}
	public RecVO(){
		type=ReceiptType.RECEIVE;
	}
}
