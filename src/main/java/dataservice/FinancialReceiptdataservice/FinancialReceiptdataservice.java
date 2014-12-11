package dataservice.FinancialReceiptdataservice;

import po.*;
import vo.ReceiptConditionVO;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FinancialReceiptdataservice extends Remote {
	public ResultMessage addPay(PayPO po) throws RemoteException;
	public ResultMessage addRec(RecPO po) throws RemoteException;
	public ResultMessage addCash(CashPO po) throws RemoteException;
	public ResultMessage update(ReceiptPO[]receipt) throws RemoteException;
	public ResultMessage queryReceipt(ReceiptConditionVO vo)throws RemoteException;
}
