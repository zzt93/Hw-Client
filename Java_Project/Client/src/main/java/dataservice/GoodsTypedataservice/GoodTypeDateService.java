package dataservice.GoodsTypedataservice;

import java.util.ArrayList;

import po.RepoFilterPO;
import po.TreeNodePO;

public interface GoodTypeDateService {
	ArrayList<TreeNodePO> getGoodsTypde();
	boolean initialize(ArrayList<TreeNodePO> treeNodePOs);
	
	boolean insert(TreeNodePO treeNodePO);
	boolean delete(TreeNodePO treeNodePO);
	boolean update(TreeNodePO treeNodePO);
	
	TreeNodePO efind(String idN);
	ArrayList<TreeNodePO> ifind(RepoFilterPO filterPO);
}
