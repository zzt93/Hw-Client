package dataservice.GoodsListdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.GoodsListPO;
import po.GoodsPO;
import po.RepoFilterPO;

public class GoodsListDataImpl implements GoodsListDataService {

	String account ;
	
	public GoodsListDataImpl(String accountN) {
		// TODO Auto-generated constructor stub
		account = accountN;
	}
	public GoodsListPO getGoodsList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean initialize(GoodsListPO goodsListPO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean insert(GoodsPO goodsPO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(GoodsPO goodsPO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(GoodsPO goodsPO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public GoodsPO efind(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<GoodsPO> ifind(RepoFilterPO filter) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
