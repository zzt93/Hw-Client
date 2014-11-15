package businesslogic.GoodsListbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.GoodsListdataservice.GoodsListDataService;
import po.GoodsListPO;
import po.GoodsPO;
import po.RepoFilterPO;
import po.ResultMessage;

public class GoodsListDataImpl implements GoodsListDataService {

	String account ;
	
	public GoodsListDataImpl(String accountN) {
		// TODO Auto-generated constructor stub
		account = accountN;
	}
	public ResultMessage<GoodsListPO> getGoodsList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage<Boolean> initialize(GoodsListPO goodsListPO) throws RemoteException {
		// TODO Auto-generated method stub
		return new ResultMessage<Boolean>("", true);
	}

	public ResultMessage<Boolean> insert(GoodsPO goodsPO) throws RemoteException {
		// TODO Auto-generated method stub
		return new ResultMessage<Boolean>("", true);
	}

	public ResultMessage<Boolean> delete(GoodsPO goodsPO) throws RemoteException {
		// TODO Auto-generated method stub
		return new ResultMessage<Boolean>("", true);
	}

	public ResultMessage<Boolean> update(GoodsPO goodsPO) throws RemoteException {
		// TODO Auto-generated method stub
		return new ResultMessage<Boolean>("", true);
	}

	public ResultMessage<GoodsPO> efind(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage<ArrayList<GoodsPO>> ifind(RepoFilterPO filter) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	public ResultMessage<Boolean> saveGoodsList(GoodsListPO goodsListPO) {
		// TODO Auto-generated method stub
		return null;
	}

}
