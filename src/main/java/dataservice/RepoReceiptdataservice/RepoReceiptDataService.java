package dataservice.RepoReceiptdataservice;

import po.GoodsReceiptPO;
import po.RepoFilterPO;
import po.RepoReceiptPO;
import po.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RepoReceiptDataService {
	ResultMessage<ArrayList<RepoReceiptPO>> getRepoReceipts() throws RemoteException;
	ResultMessage<ArrayList<GoodsReceiptPO>> getGoodsReceipts() throws RemoteException;
	ResultMessage<Boolean> initialize(ArrayList<RepoReceiptPO> receipt) throws RemoteException;
	
	ResultMessage<Boolean> insert(RepoReceiptPO receipt) throws RemoteException;
	ResultMessage<Boolean> insert(GoodsReceiptPO receipt) throws RemoteException;
	ResultMessage<Boolean> delete(RepoReceiptPO receipt) throws RemoteException;
	ResultMessage<Boolean> update(RepoReceiptPO receipt) throws RemoteException;
	
	ResultMessage<RepoReceiptPO> efind(String info) throws RemoteException;
	ResultMessage<ArrayList<RepoReceiptPO>> ifind(RepoFilterPO filter) throws RemoteException;
	
}
