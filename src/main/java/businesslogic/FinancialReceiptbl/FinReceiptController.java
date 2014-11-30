package businesslogic.FinancialReceiptbl;

import businesslogicservice.FinancialReceiptblservice.FinancialReceiptblservice;
import po.*;
import vo.CashVO;
import vo.PayVO;
import vo.RecVO;
import vo.ReceiptConditionVO;

import java.util.ArrayList;
public class FinReceiptController implements FinancialReceiptblservice{
	BankList bankList=new BankList();
	ItemList itemList=new ItemList();
	MockFinReceipt finReceipt=new MockFinReceipt();
	public double addBank(BkTransPO po){
		bankList.add(po);
		return bankList.getTotal();
	}
	public double addItem(ItemPO po){
		itemList.add(po);
		return itemList.getTotal();
	}
	public double deleteBank(BkTransPO po){
		bankList.delete(po);
		return bankList.getTotal();
	}
	public double deleteItem(ItemPO po){
		itemList.delete(po);
		return itemList.getTotal();
	}
	public void makePayment(PayVO vo) throws Exception{
		PayPO po=new PayPO(vo,bankList.getData());
		bankList.clear();
		ResultMessage result=finReceipt.makePayMent(po);
		result.throwIfFailed();
	}
	public void makeReceive(RecVO vo) throws Exception{
		RecPO po=new RecPO(vo,bankList.getData());
		bankList.clear();
		ResultMessage result=finReceipt.makeReceive(po);
		result.throwIfFailed();
	}
	public void makeCash(CashVO vo) throws Exception{
		CashPO po=new CashPO(vo,itemList.getData());
		itemList.clear();
		ResultMessage result=finReceipt.makeCash(po);
		result.throwIfFailed();
	}		
	/*public String[] getBank(){
		//通过BankManageBl获得
		return null;
	}
	public String[] getClient(){
		//通过ClientBL获得
		return null;
	}
	public String[] getOperator(){
		//通过Admin获得
		return null;
	}*/
	public ReceiptPO[] getReceipt()throws Exception{
		return new ReceiptPO[1];
	}
	public ArrayList<ReceiptPO> getReceipt(ReceiptConditionVO vo)throws Exception{
		return null;
	}
	public void creditCash(CashVO vo)throws Exception{
		CashPO po=new CashPO(vo);
		ResultMessage result=finReceipt.makeCash(po);
		result.throwIfFailed();
	}
	public void creditPay(PayVO vo)throws Exception{
		PayPO po=new PayPO(vo);
		ResultMessage result=finReceipt.makePayMent(po);
		result.throwIfFailed();
	}
	public void creditRec(RecVO vo)throws Exception{
		RecPO po=new RecPO(vo);
		ResultMessage result=finReceipt.makeReceive(po);
		result.throwIfFailed();
	}
}
