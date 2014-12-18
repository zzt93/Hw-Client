package businesslogic.GoodsListbl;

import dataservice.GoodsListdataservice.GoodsListDataService;
import po.GoodsListPO;
import po.GoodsModelPO;
import po.RepoFilterPO;
import po.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class GoodsListData_stub implements GoodsListDataService {

	String account ;

	public ResultMessage<GoodsListPO> getGoodsList() throws RemoteException {
		System.out.println("in get goodslist");
		return new ResultMessage<GoodsListPO>(null, new GoodsListPO());
	}



	public ResultMessage<Boolean> insert(GoodsModelPO goodsPO) throws RemoteException {
		System.out.println("in insert of goodslist data stub");
		
		return new ResultMessage<Boolean>(null, true);
	}

	public ResultMessage<Boolean> delete(GoodsModelPO goodsPO) throws RemoteException {
		System.out.println("in delete of goodslist data stub");
		return new ResultMessage<Boolean>(null, true);
	}

	public ResultMessage<Boolean> update(GoodsModelPO goodsPO) throws RemoteException {
		System.out.println("in update of goodslist data stub");
		return new ResultMessage<Boolean>(null, true);
	}

	public ResultMessage<GoodsModelPO> efind(String id) throws RemoteException {
		System.out.println("in efind of goodslist data stub");
		return new ResultMessage<GoodsModelPO>(null, new GoodsModelPO("light a1", "bull light", "small"));
	}



}
