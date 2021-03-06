package dataservice.BankManagedataservice;

import po.BankPO;
import po.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BankManagedataservice extends Remote {
	public ResultMessage find(String field) throws RemoteException;
	public ResultMessage insert(BankPO po) throws RemoteException;
	public ResultMessage delete(BankPO po) throws RemoteException;
	public ResultMessage update(BankPO po) throws RemoteException;
	public ResultMessage finds() throws RemoteException;
	

}
