package dataservice.FinancialReceiptdataservice;

import po.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FinancialReceiptdataservice extends Remote {
	public ResultMessage addPay(PayPO po);
	public ResultMessage addRec(RecPO po) ;
	public ResultMessage addCash(CashPO po) ;
	public ResultMessage update(ReceiptPO[]receipt); 
}
