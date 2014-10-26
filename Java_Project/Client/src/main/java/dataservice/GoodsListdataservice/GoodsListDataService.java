package dataservice.GoodsListdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.RepoFilterPO;
import po.GoodsListPO;
import po.GoodsPO;
import po.ResultMessage;

public interface GoodsListDataService {
	ResultMessage<GoodsListPO> getGoodsList() throws RemoteException;
	ResultMessage<Boolean> initialize(GoodsListPO goodsListPO) throws RemoteException;
	ResultMessage<Boolean> insert(GoodsPO goodsPO) throws RemoteException;
	ResultMessage<Boolean> delete(GoodsPO goodsPO) throws RemoteException;
	ResultMessage<Boolean> update(GoodsPO goodsPO) throws RemoteException;
	ResultMessage<GoodsPO> efind(String id) throws RemoteException;
	ResultMessage<ArrayList<GoodsPO>> ifind(RepoFilterPO filter) throws RemoteException;
}
