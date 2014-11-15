package businesslogic.FinancialReceiptbl;

import java.rmi.RemoteException;

import dataservice.FinancialReceiptdataservice.FinancialReceiptdataservice;
import po.CashReceiptPO;
import po.PayReceiptPO;
import po.RecReceiptPO;
import po.ReceiptPO;
import po.ResultMessage;

public class FinancialReceiptdata_stub implements FinancialReceiptdataservice {
	ResultMessage result=new ResultMessage(null,null);
	public ResultMessage addPay(PayReceiptPO po) throws RemoteException {
		System.out.println("添加付款单成功");
		return result;
	}

	public ResultMessage addRec(RecReceiptPO po) throws RemoteException {
		System.out.println("添加收款单成功");
		return result;
	}

	public ResultMessage addCash(CashReceiptPO po) throws RemoteException {
		System.out.println("添加现金费用单成功");
		return result;
	}

	public ResultMessage update(ReceiptPO[] receipt) throws RemoteException {
		return result;
	}

}
