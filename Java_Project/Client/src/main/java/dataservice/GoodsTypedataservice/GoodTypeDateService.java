package dataservice.GoodsTypedataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.RepoFilterPO;
import po.TreeNodePO;

public interface GoodTypeDateService {
	ArrayList<TreeNodePO> getGoodsTypde() throws RemoteException;
	boolean initialize(ArrayList<TreeNodePO> treeNodePOs) throws RemoteException;
	
	boolean insert(TreeNodePO treeNodePO) throws RemoteException;
	boolean delete(TreeNodePO treeNodePO) throws RemoteException;
	boolean update(TreeNodePO treeNodePO) throws RemoteException;
	
	TreeNodePO efind(String idN) throws RemoteException;
	ArrayList<TreeNodePO> ifind(RepoFilterPO filterPO) throws RemoteException;
}
