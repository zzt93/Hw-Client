package dataservice.SetAccountdataservice;

import java.rmi.RemoteException;

import po.ResultMessage;

public interface SetAccountdataservice {
	public ResultMessage setup(String[] name) throws RemoteException;
	public ResultMessage goods() throws RemoteException;
	public ResultMessage bank() throws RemoteException;
	public ResultMessage client() throws RemoteException;
}
