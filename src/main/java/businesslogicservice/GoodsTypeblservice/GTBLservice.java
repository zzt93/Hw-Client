package businesslogicservice.GoodsTypeblservice;


import java.util.ArrayList;

import vo.TreeNodeVO;

public interface GTBLservice {
	boolean add(TreeNodeVO fa, String son_type) throws Exception;
	boolean update(TreeNodeVO tNode) throws Exception;
	boolean delete(TreeNodeVO tNode) throws Exception;
	
	TreeNodeVO eSearch(String id) throws Exception;
	
	ArrayList<TreeNodeVO> show() throws Exception;//return the tree so to build the tree
	
	
}
