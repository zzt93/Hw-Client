package dataservice.GoodsTypedataservice;

import java.util.ArrayList;

import po.RepoFilterPO;
import po.TreeNodePO;

public interface GoodTypeDateService {
	ArrayList<TreeNodePO> getGoodsTypde() throws Exception;
	boolean initialize(ArrayList<TreeNodePO> treeNodePOs) throws Exception;
	
	boolean insert(TreeNodePO treeNodePO) throws Exception;
	boolean delete(TreeNodePO treeNodePO) throws Exception;
	boolean update(TreeNodePO treeNodePO) throws Exception;
	
	TreeNodePO efind(String idN) throws Exception;
	ArrayList<TreeNodePO> ifind(RepoFilterPO filterPO) throws Exception;
}
