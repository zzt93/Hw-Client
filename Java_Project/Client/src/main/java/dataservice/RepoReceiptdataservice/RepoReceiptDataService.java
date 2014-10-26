package dataservice.RepoReceiptdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.RepoFilterPO;
import po.RepoReceiptPO;

public interface RepoReceiptDataService {
	ArrayList<RepoReceiptPO> getRepoReceipts() throws RemoteException;
	boolean initialize(ArrayList<RepoReceiptPO> receipt) throws RemoteException;
	
	boolean insert(RepoReceiptPO receipt) throws RemoteException;
	boolean delete(RepoReceiptPO receipt) throws RemoteException;
	boolean update(RepoReceiptPO receipt) throws RemoteException;
	
	RepoReceiptPO efind(String info) throws RemoteException;
	ArrayList<RepoReceiptPO> ifind(RepoFilterPO filter) throws RemoteException;
	
}
