package dataservice.Admindataservice;

import po.ResultMessage;
import po.UserPO;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AdminDataService extends Remote {
	public ResultMessage confirm(UserPO upo) throws RemoteException;
	public ResultMessage show() throws RemoteException;
	public ResultMessage delete(UserPO upo) throws RemoteException;
}
