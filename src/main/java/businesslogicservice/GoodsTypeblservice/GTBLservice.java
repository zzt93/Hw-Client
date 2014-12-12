package businesslogicservice.GoodsTypeblservice;


import vo.TreeNodeVO;

import java.util.ArrayList;

import po.TreeNodePO;

public interface GTBLservice {
	boolean add(TreeNodePO node) throws Exception;
	boolean update(TreeNodePO tNode) throws Exception;
	boolean delete(TreeNodePO tNode) throws Exception;
	
	TreeNodePO eSearch(String id) throws Exception;
	
	ArrayList<TreeNodePO> show() throws Exception;//return the tree so to build the tree
	
	
}
