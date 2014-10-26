package dataservice.GoodsListdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.RepoFilterPO;
import po.GoodsListPO;
import po.GoodsPO;

public interface GoodsListDataService {
	GoodsListPO getGoodsList() throws RemoteException;
	boolean initialize(GoodsListPO goodsListPO) throws RemoteException;
	boolean insert(GoodsPO goodsPO) throws RemoteException;
	boolean delete(GoodsPO goodsPO) throws RemoteException;
	boolean update(GoodsPO goodsPO) throws RemoteException;
	GoodsPO efind(String id) throws RemoteException;
	ArrayList<GoodsPO> ifind(RepoFilterPO filter) throws RemoteException;
}
