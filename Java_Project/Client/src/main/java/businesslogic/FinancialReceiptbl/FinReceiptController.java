package businesslogic.FinancialReceiptbl;
import businesslogicservice.FinancialReceiptblservice.FinancialReceiptblservice;
import vo.*;
import po.*;
public class FinReceiptController implements FinancialReceiptblservice{
	BankList bankList=new BankList();
	ItemList itemList=new ItemList();
	FinReceipt finReceipt=new FinReceipt();
	public double addBank(BkTransVO vo){
		BkTransPO po=new BkTransPO(vo);
		bankList.add(po);
		return bankList.getTotal();
	}
	public double addItem(ItemVO vo){
		ItemPO po=new ItemPO(vo);
		itemList.add(po);
		return itemList.getTotal();
	}
	public double deleteBank(BkTransVO vo){
		BkTransPO po=new BkTransPO(vo);
		bankList.delete(po);
		return bankList.getTotal();
	}
	public double deleteItem(ItemVO vo){
		ItemPO po=new ItemPO(vo);
		itemList.delete(po);
		return itemList.getTotal();
	}
	public void makePayment(PayReceiptVO vo) throws Exception{
		PayReceiptPO po=new PayReceiptPO(vo,bankList.getData());
		bankList.clear();
		ResultMessage result=finReceipt.makePayMent(po);
		result.throwIfFailed();
	}
	public void makeReceive(RecReceiptVO vo) throws Exception{
		RecReceiptPO po=new RecReceiptPO(vo,bankList.getData());
		bankList.clear();
		ResultMessage result=finReceipt.makeReceive(po);
		result.throwIfFailed();
	}
	public void makeCash(CashReceiptVO vo) throws Exception{
		CashReceiptPO po=new CashReceiptPO(vo,itemList.getData());
		itemList.clear();
		ResultMessage result=finReceipt.makeCash(po);
		result.throwIfFailed();
	}		
	public String[] getBank(){
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
	}
}
