package dataservice.GoodsTypedataservice;

import po.RepoFilterPO;
import po.ResultMessage;
import po.TreeNodePO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface GoodsTypeDateService {
	ResultMessage<ArrayList<TreeNodePO>> getGoodsTypde() throws RemoteException;
	ResultMessage<Boolean> initialize(ArrayList<TreeNodePO> treeNodePOs) throws RemoteException;
	ResultMessage<String> getDatabse(String account) throws RemoteException;
	
	ResultMessage<Boolean> insert(TreeNodePO treeNodePO) throws RemoteException;
	ResultMessage<Boolean> delete(TreeNodePO treeNodePO) throws RemoteException;
	ResultMessage<Boolean> update(TreeNodePO treeNodePO) throws RemoteException;
	
	ResultMessage<TreeNodePO> efind(String idN) throws RemoteException;
	ResultMessage<ArrayList<TreeNodePO>> ifind(RepoFilterPO filterPO) throws RemoteException;
}
