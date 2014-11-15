package dataservice.Admindataservice;

import java.rmi.RemoteException;

import po.ResultMessage;
import po.UserPO;

public interface AdminDataService {
	public ResultMessage confirm(UserPO upo) throws RemoteException;
	public ResultMessage show() throws RemoteException;
	public ResultMessage delete(UserPO upo) throws RemoteException;
}
