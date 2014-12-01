package dataservice.GoodsListdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.GoodsModelPO;
import po.RepoFilterPO;
import po.GoodsListPO;
import po.ResultMessage;

public interface GoodsListDataService {
	ResultMessage<Boolean> saveGoodsList(GoodsListPO goodsListPO);
	ResultMessage<GoodsListPO> getGoodsList() throws RemoteException;
	ResultMessage<Boolean> initialize(GoodsListPO goodsListPO) throws RemoteException;
	
	ResultMessage<Boolean> insert(GoodsModelPO goodsPO) throws RemoteException;
	ResultMessage<Boolean> delete(GoodsModelPO goodsPO) throws RemoteException;
	ResultMessage<Boolean> update(GoodsModelPO goodsPO) throws RemoteException;
	ResultMessage<GoodsModelPO> efind(String id) throws RemoteException;
	ResultMessage<ArrayList<GoodsModelPO>> ifind(RepoFilterPO filter) throws RemoteException;
}
