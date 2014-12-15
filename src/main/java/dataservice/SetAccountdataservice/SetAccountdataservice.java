package dataservice.SetAccountdataservice;

import po.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SetAccountdataservice extends Remote {
	public ResultMessage setup(String name) throws RemoteException;
	public ResultMessage getGoods() throws RemoteException;
	public ResultMessage getBank() throws RemoteException;
	public ResultMessage getClient() throws RemoteException;
	public ResultMessage setDefaultAccount(String name) throws RemoteException;
	public ResultMessage getDefaultAccount() throws RemoteException;
	public ResultMessage getAllAccount() throws RemoteException;
	public ResultMessage inherit(String name)throws RemoteException;
	public ResultMessage creatCopy()throws RemoteException;
}
