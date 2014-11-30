package dataservice.Logdataservice;

import po.ResultMessage;

import java.rmi.RemoteException;

public interface Logdataservice {
	public ResultMessage finds() throws RemoteException;
	public ResultMessage insert(String operation) throws RemoteException;
}
