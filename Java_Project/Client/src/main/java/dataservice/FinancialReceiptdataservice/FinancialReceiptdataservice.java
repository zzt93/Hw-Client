package dataservice.FinancialReceiptdataservice;

import java.rmi.RemoteException;

import po.*;

public interface FinancialReceiptdataservice {
	public ResultMessage addPay(PayReceiptPO po) throws RemoteException;
	public ResultMessage addRec(RecReceiptPO po) throws RemoteException;
	public ResultMessage addCash(CashReceiptPO po) throws RemoteException;
	public ResultMessage update(ReceiptPO[] receipt) throws RemoteException;
}
