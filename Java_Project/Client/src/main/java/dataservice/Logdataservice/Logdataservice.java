package dataservice.Logdataservice;

import java.rmi.RemoteException;

import po.ResultMessage;

public interface Logdataservice {
	public ResultMessage finds() throws RemoteException;
	public ResultMessage insert(String operation) throws RemoteException;
}
