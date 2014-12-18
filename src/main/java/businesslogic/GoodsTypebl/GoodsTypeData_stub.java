package businesslogic.GoodsTypebl;

import dataservice.GoodsTypedataservice.GoodsTypeDateService;
import po.RepoFilterPO;
import po.ResultMessage;
import po.TreeNodePO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class GoodsTypeData_stub implements GoodsTypeDateService{

	public ResultMessage<ArrayList<TreeNodePO>> getGoodsTypde()
			throws RemoteException {
		System.out.println("in get goods type of goodstype data stub");
		return new ResultMessage<ArrayList<TreeNodePO>>(null, new ArrayList<TreeNodePO>());
	}

	public ResultMessage<Boolean> initialize(ArrayList<TreeNodePO> treeNodePOs)
			throws RemoteException {
		System.out.println("in update of goodslist data stub");
		return new ResultMessage<Boolean>(null, true);
	}

	public ResultMessage<Boolean> insert(TreeNodePO treeNodePO)
			throws RemoteException {
		System.out.println("in insert of goodstype data stub");
		return new ResultMessage<Boolean>(null, true);
	}

	public ResultMessage<Boolean> delete(TreeNodePO treeNodePO)
			throws RemoteException {
		System.out.println("in delete of goodstype data stub");
		return new ResultMessage<Boolean>(null, true);
	}

	public ResultMessage<Boolean> update(TreeNodePO treeNodePO)
			throws RemoteException {
		System.out.println("in update of goodstype data stub");
		return new ResultMessage<Boolean>(null, true);
	}

	public ResultMessage<TreeNodePO> efind(String idN) throws RemoteException {
		System.out.println("in efind of goodstype data stub");
		return new ResultMessage<TreeNodePO>(null, new TreeNodePO(""));
	}

	public ResultMessage<ArrayList<TreeNodePO>> ifind(RepoFilterPO filterPO)
			throws RemoteException {
		System.out.println("in ifind of goodstype data stub");
		return new ResultMessage<ArrayList<TreeNodePO>>(null, new ArrayList<TreeNodePO>());
	}

	public ResultMessage<String> getDatabse(String account)
			throws RemoteException {
		System.out.println("in getDatabase of goodstype data stub");

		return null;
	}

}
