package dataservice.FinancialReceiptdataservice;

import java.rmi.RemoteException;

import po.*;

public interface FinancialReceiptdataservice {
	public ResultMessage addPay(PayPO po) throws RemoteException;
	public ResultMessage addRec(RecPO po) throws RemoteException;
	public ResultMessage addCash(CashPO po) throws RemoteException;
	public ResultMessage update(ReceiptPO[] receipt) throws RemoteException;
}
