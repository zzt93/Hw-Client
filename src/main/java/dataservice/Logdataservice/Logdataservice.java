package dataservice.Logdataservice;

import po.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Logdataservice extends Remote {
	public ResultMessage finds() throws RemoteException;
	public ResultMessage insert(String operation) throws RemoteException;
}
