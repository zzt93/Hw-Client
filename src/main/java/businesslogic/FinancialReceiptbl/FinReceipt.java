package businesslogic.FinancialReceiptbl;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.Clientdataservice.ClientDataService;
import dataservice.FinancialReceiptdataservice.FinancialReceiptdataservice;
import po.CashPO;
import po.PayPO;
import po.RecPO;
import po.ReceiptPO;
import po.ResultMessage;
import util.RMIUtility;
import vo.ReceiptConditionVO;

public class FinReceipt {
	  private static FinancialReceiptdataservice dataService;

	    public FinReceipt() throws RemoteException, NotBoundException {
	        if (dataService == null)
	            dataService = (FinancialReceiptdataservice) RMIUtility.getImpl("FinancialReceipt");
	    }

	public ResultMessage makePayMent(PayPO po) throws RemoteException {
		ResultMessage result;
		result=dataService.addPay(po);
		return result;
	}
	public ResultMessage makeReceive(RecPO po)throws RemoteException {
		ResultMessage result;
		result=dataService.addRec(po);
		return result;
	}
	public ResultMessage makeCash(CashPO po)throws RemoteException {
		ResultMessage result;
		result=dataService.addCash(po);
		return result;
	}
	public ResultMessage update(ReceiptPO [] receipt) throws RemoteException{
		ResultMessage result;
		result=dataService.update(receipt);
		return result;
	}
	public ResultMessage queryReceipt(ReceiptConditionVO condition)throws RemoteException{
		ResultMessage result;
		result=dataService.queryReceipt(condition);
		return result;
	}
}
