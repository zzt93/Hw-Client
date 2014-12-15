package dataservice.SetAccountdataservice;

import po.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SetAccountdataservice extends Remote {
	public ResultMessage setup(String name) throws RemoteException;
	public ResultMessage goods() throws RemoteException;
	public ResultMessage bank() throws RemoteException;
	public ResultMessage client() throws RemoteException;
	public ResultMessage setDefaultAccount(String name) throws RemoteException;
	public ResultMessage getDefaultAccount() throws RemoteException;
	public ResultMessage getAllAccount() throws RemoteException;
	public ResultMessage inherit(String name)throws RemoteException;
	public ResultMessage creatCopy()throws RemoteException;
}
