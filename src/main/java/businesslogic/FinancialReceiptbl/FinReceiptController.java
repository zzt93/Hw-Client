package businesslogic.FinancialReceiptbl;

import businesslogic.Adminbl.AdminController;
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
	AdminController adminController;
	public FinReceiptController() throws RemoteException, NotBoundException{
		finReceipt=new FinReceipt();
		clientController=new ClientUtilityImpl();
		adminController=new AdminController();
		bankController=new BankController();
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
//	public double deleteBank(BkTransPO po){
//		bankList.delete(po);
//		return bankList.getTotal();
//	}
	public double deleteBank(int i){
		bankList.delete(i);
		return bankList.getTotal();
	}
//	public double deleteItem(ItemPO po){
//		itemList.delete(po);
//		return itemList.getTotal();
//	}
	public double deleteItem(int i){
		itemList.delete(i);
		return itemList.getTotal();
	}
	public void makePayment(PayVO vo) throws Exception{
		PayPO po=new PayPO(vo,bankList.list);
		ResultMessage result=finReceipt.makePayMent(po);
		result.throwIfFailed();
		bankList.clear();
	}
	public void makeReceive(RecVO vo) throws Exception{
		RecPO po=new RecPO(vo,bankList.list);
		ResultMessage result=finReceipt.makeReceive(po);
		result.throwIfFailed();
		bankList.clear();
	}
	public void makeCash(CashVO vo) throws Exception{
		CashPO po=new CashPO(vo,itemList.list);
		ResultMessage result=finReceipt.makeCash(po);
		result.throwIfFailed();
		itemList.clear();
	}		
	public String[] getBank() throws Exception{
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
	public String getOperator() throws Exception{
		return adminController.getUser();
	
	}
	public ArrayList<ReceiptPO> getReceipt()throws Exception{
		ReceiptConditionVO condition=new ReceiptConditionVO(ReceiptType.CASH);
		ArrayList<ReceiptPO> list=new ArrayList<ReceiptPO>();
		ArrayList<ReceiptPO> temp=getReceipt(condition);
		list.addAll(temp);
		condition.type=ReceiptType.PAYMENT;
		temp=getReceipt(condition);
		list.addAll(temp);
		condition.type=ReceiptType.RECEIVE;
		temp=getReceipt(condition);
		list.addAll(temp);
		
		return list;
	}
	public ArrayList<ReceiptPO> getReceipt(ReceiptConditionVO vo)throws Exception{
		ResultMessage result;
		result=finReceipt.queryReceipt(vo);
		result.throwIfFailed();

		ArrayList<ReceiptPO> list=(ArrayList<ReceiptPO>)result.getObj();
		
		return list;
	}
	public void creditCash(CashPO po)throws Exception{
		
		ResultMessage result=finReceipt.makeCash(po);
		result.throwIfFailed();
	}
	public void creditPay(PayPO po)throws Exception{
		
		ResultMessage result=finReceipt.makePayMent(po);
		result.throwIfFailed();
	}
	public void creditRec(RecPO po)throws Exception{
		
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
