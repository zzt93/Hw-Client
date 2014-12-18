package po;

import vo.CashVO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MethyleneBlue on 2014/10/??.
 */
public class CashPO extends ReceiptPO implements Serializable {
	private static final long serialVersionUID = 1L;
	public String operator;
	public double total=0;
	public List<ItemPO> itemList;
	public String bank;
	public DealState dealState=DealState.UNDEAL;
	public CashPO(CashVO vo,List<ItemPO> list){
		operator=vo.operator;
		itemList=list;
		total=vo.total;
		type=ReceiptType.CASH;
		bank=vo.bank;
	}
	public CashPO(CashVO vo){
		operator=vo.operator;
		itemList=vo.itemList;
		total=vo.total;
		type=ReceiptType.CASH;
		bank=vo.bank;
	}
	public CashPO(){
		
		number="测试单据";
		type=ReceiptType.CASH;
	}
}
