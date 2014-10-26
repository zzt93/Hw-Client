package businesslogicservice.GoodsTypeblservice;


import java.util.ArrayList;

import vo.TreeNode;

public interface GTBLservice {
	boolean add(TreeNode tNode) throws Exception;
	boolean update(TreeNode tNode) throws Exception;
	boolean delete(TreeNode tNode) throws Exception;
	ArrayList<TreeNode> show() throws Exception;//return the tree so to build the tree
}
