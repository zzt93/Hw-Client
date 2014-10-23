package GoosTypeDataService;

import java.util.ArrayList;

import PO.RepoFilterPO;
import PO.TreeNodePO;

public interface GoodTypeDateService {
	ArrayList<TreeNodePO> getGoodsTypde();
	boolean initialize(ArrayList<TreeNodePO> treeNodePOs);
	
	boolean insert(TreeNodePO treeNodePO);
	boolean delete(TreeNodePO treeNodePO);
	boolean update(TreeNodePO treeNodePO);
	
	TreeNodePO efind(String idN);
	ArrayList<TreeNodePO> ifind(RepoFilterPO filterPO);
}
