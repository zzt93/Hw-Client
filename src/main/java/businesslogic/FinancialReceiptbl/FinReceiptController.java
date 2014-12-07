package businesslogic.FinancialReceiptbl;

import businesslogic.BankManagebl.BankController;
import businesslogic.Clientbl.ClientUtilityImpl;
import businesslogicservice.FinancialReceiptblservice.FinancialReceiptblservice;
import po.*;
import vo.BankVO;
import vo.CashVO;
import vo.PayVO;
import vo.RecVO;
import vo.ReceiptConditionVO;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
public class FinReceiptController implements FinancialReceiptblservice{
	BankList bankList=new BankList();
	ItemList itemList=new ItemList();
	FinReceipt finReceipt;
	ClientUtilityImpl clientController;
	BankController bankController;
	public FinReceiptController() throws RemoteException, NotBoundException{
		finReceipt=new FinReceipt();
		clientController=new ClientUtilityImpl();
	}
	public void clearBank(){
		bankList.clear();
	}
	public void clearItem(){
		bankList.clear();
	}
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
	public double deleteBank(int i){
		bankList.delete(i);
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
	public String[] getBank() throws Exception{
		BankController bankController;
		bankController=new BankController();
		BankVO[] vo=bankController.search(null);
		String result[];
		result=new String[vo.length];
		for(int i=0;i<result.length;i++){
			result[i]=vo[i].name;
			}
		return result;
	}
	public String[] getClient() throws Exception{
		List<ClientPO> clientList;
		clientList=clientController.queryClient(null);
		String[] result=new String[clientList.size()];
		for(int i=0;i<result.length;i++){
			result[i]=clientList.get(i).getName();
		}
		return result;
	}
	public String[] getOperator(){
		//TODO,通过Admin获得
		return null;
	}
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
	public void update(ReceiptPO[] po)throws Exception{
		ResultMessage result=finReceipt.update(po);
		result.throwIfFailed();
	}
	public void update(ReceiptPO po)throws Exception{
		ReceiptPO temp[]=new ReceiptPO[1];
		temp[0]=po;
		ResultMessage result=finReceipt.update(temp);
		result.throwIfFailed();
	}
}
