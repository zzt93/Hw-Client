package GoodsTypeBLservice;


import java.util.ArrayList;

import VO.TreeNode;

public interface GTBLservice {
	boolean add(TreeNode tNode);
	boolean update(TreeNode tNode);
	boolean delete(TreeNode tNode);
	ArrayList<TreeNode> show();//return the tree so to build the tree
}
