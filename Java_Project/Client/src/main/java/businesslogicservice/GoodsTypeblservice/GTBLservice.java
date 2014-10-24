package businesslogicservice.GoodsTypeblservice;


import java.util.ArrayList;

import vo.TreeNode;

public interface GTBLservice {
	boolean add(TreeNode tNode);
	boolean update(TreeNode tNode);
	boolean delete(TreeNode tNode);
	ArrayList<TreeNode> show();//return the tree so to build the tree
}