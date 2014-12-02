package dataservice.GoodsListdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.GoodsModelPO;
import po.RepoFilterPO;
import po.GoodsListPO;
import po.GoodsPO;
import po.ResultMessage;

public interface GoodsListDataService extends Remote {
	ResultMessage<Boolean> saveGoodsList(GoodsListPO goodsListPO);
	ResultMessage<GoodsListPO> getGoodsList() throws RemoteException;
	ResultMessage<Boolean> initialize(GoodsListPO goodsListPO) throws RemoteException;
	
	ResultMessage<Boolean> delete(GoodsModelPO goodsPO) throws RemoteException;
	ResultMessage<Boolean> update(GoodsModelPO goodsPO) throws RemoteException;
	ResultMessage<GoodsModelPO> efind(String id) throws RemoteException;
	ResultMessage<ArrayList<GoodsModelPO>> ifind(RepoFilterPO filter) throws RemoteException;
	ResultMessage<Boolean> insert(GoodsModelPO goodsModelPO) throws RemoteException;
}
