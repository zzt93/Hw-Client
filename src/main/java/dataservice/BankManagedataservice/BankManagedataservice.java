package dataservice.BankManagedataservice;

import po.BankPO;
import po.ResultMessage;

import java.rmi.RemoteException;

public interface BankManagedataservice {
	public ResultMessage find(String field) throws RemoteException;
	public ResultMessage insert(BankPO po) throws RemoteException;
	public ResultMessage delete(BankPO po) throws RemoteException;
	public ResultMessage update(BankPO po) throws RemoteException;
	public ResultMessage init() throws RemoteException;
	public ResultMessage finish() throws RemoteException;
	public ResultMessage finds() throws RemoteException;
	public ResultMessage setup(String account) throws RemoteException;
	public ResultMessage getID(String account) throws RemoteException;
}
