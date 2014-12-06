package dataservice.RepoReceiptdataservice;

import po.GoodsReceiptPO;
import po.RepoFilterPO;
import po.RepoReceiptPO;
import po.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RepoReceiptDataService extends Remote {
	ResultMessage<ArrayList<RepoReceiptPO>> getRepoReceipts() throws RemoteException;
	ResultMessage<ArrayList<GoodsReceiptPO>> getGoodsReceipts() throws RemoteException;
	
	ResultMessage<Boolean> insert(RepoReceiptPO receipt) throws RemoteException;
	ResultMessage<Boolean> insert(GoodsReceiptPO receipt) throws RemoteException;
	ResultMessage<Boolean> update(RepoReceiptPO receipt) throws RemoteException;

	ResultMessage<RepoReceiptPO> efind(String id) throws RemoteException;
	ResultMessage<GoodsReceiptPO> efindGoods(String id) throws RemoteException;
}
