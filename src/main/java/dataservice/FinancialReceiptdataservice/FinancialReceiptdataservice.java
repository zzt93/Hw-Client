package dataservice.FinancialReceiptdataservice;

import po.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FinancialReceiptdataservice extends Remote {
	public ResultMessage addPay(PayPO po) throws RemoteException;
	public ResultMessage addRec(RecPO po) throws RemoteException;
	public ResultMessage addCash(CashPO po) throws RemoteException;
	public ResultMessage update(ReceiptPO[]receipt) throws RemoteException;
}
