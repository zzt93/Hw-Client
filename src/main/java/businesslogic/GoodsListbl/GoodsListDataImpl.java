package businesslogic.GoodsListbl;

import dataservice.GoodsListdataservice.GoodsListDataService;
import po.GoodsListPO;
import po.GoodsModelPO;
import po.RepoFilterPO;
import po.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

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

	public ResultMessage<Boolean> insert(GoodsModelPO goodsPO) throws RemoteException {
		// TODO Auto-generated method stub
		
		return new ResultMessage<Boolean>("", true);
	}

	public ResultMessage<Boolean> delete(GoodsModelPO goodsPO) throws RemoteException {
		// TODO Auto-generated method stub
		return new ResultMessage<Boolean>("", true);
	}

	public ResultMessage<Boolean> update(GoodsModelPO goodsPO) throws RemoteException {
		// TODO Auto-generated method stub
		return new ResultMessage<Boolean>("", true);
	}

	public ResultMessage<GoodsModelPO> efind(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage<ArrayList<GoodsModelPO>> ifind(RepoFilterPO filter) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	public ResultMessage<Boolean> saveGoodsList(GoodsListPO goodsListPO) {
		// TODO Auto-generated method stub
		return null;
	}

}
