package dataservice.GoodsListdataservice;

import po.GoodsListPO;
import po.GoodsModelPO;
import po.RepoFilterPO;
import po.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface GoodsListDataService extends Remote {
	ResultMessage<GoodsListPO> getGoodsList() throws RemoteException;
	
	ResultMessage<Boolean> delete(GoodsModelPO goodsPO) throws RemoteException;
	ResultMessage<Boolean> update(GoodsModelPO goodsPO) throws RemoteException;
	ResultMessage<GoodsModelPO> efind(String id) throws RemoteException;
	ResultMessage<Boolean> insert(GoodsModelPO goodsModelPO) throws RemoteException;
}
