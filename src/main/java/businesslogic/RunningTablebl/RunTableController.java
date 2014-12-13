package businesslogic.RunningTablebl;

import businesslogic.Adminbl.AdminController;
import businesslogic.Clientbl.ClientUtilityImpl;
import businesslogic.GoodsListbl.GL_controller;
import businesslogicservice.RunningTableblservice.RunningTableblservice;
import po.ClientPO;
import po.ReceiptPO;
import po.UserPO;
import vo.*;

import java.util.List;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class RunTableController implements RunningTableblservice {
	CheckReceipt checkReceipt=new CheckReceipt();
	SaleRecord record=new SaleRecord();
	CheckProfit profit=new CheckProfit();
	ClientUtilityImpl clientController;
	AdminController adminController;
	GL_controller goodsController;
	
	public RunTableController() throws RemoteException, NotBoundException{
		clientController=new ClientUtilityImpl();
		adminController=new AdminController();
		goodsController=new GL_controller();
	}
	
	public GoodsRecordVO[] getSaleTable(SaleConditionVO vo) throws Exception {
		System.out.println("进入controller");
		return record.getSaleTable(vo);
	}

	public ArrayList<ReceiptPO> getReceipt(ReceiptConditionVO vo) throws Exception {
		ArrayList<ReceiptPO> list=checkReceipt.getReceipt(vo);
		
		return list;
	}

	public ProfitVO getProfit(ReceiptConditionVO vo) throws Exception {
		
		return profit.getProfit(vo);
	}

	public void CreditNote(ReceiptPO po) throws Exception {
		checkReceipt.CreditNote(po);
	}
	
	public String[] getClient() throws Exception{
		List<ClientPO> list=clientController.queryClient(null);
		String[] result=new String[list.size()];
		for(int i=0;i<list.size();i++){
			result[i]=list.get(i).getName();
		}
		return result;
	}
	public String[] getOperator() throws Exception{
		ArrayList<UserPO> list=adminController.show();
		String[] result=new String[list.size()];
		for(int i=0;i<list.size();i++){
			result[i]=list.get(i).getName();
		}
		return result;
	}
	public String[] getGoodsList() {
		String[] result;
		ArrayList tempList;
	
		tempList=goodsController.stock_type();
		result=new String[tempList.size()];
		for(int i=0;i<tempList.size();i++){//可能造成巨大的消耗
			result[i]=(String)tempList.get(i);
		}
		return result;
	}

}
