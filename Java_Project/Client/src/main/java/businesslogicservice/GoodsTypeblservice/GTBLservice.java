package businesslogicservice.GoodsTypeblservice;


import java.util.ArrayList;

import vo.TreeNodeVO;

public interface GTBLservice {
	boolean add(TreeNodeVO tNode) throws Exception;
	boolean update(TreeNodeVO tNode) throws Exception;
	boolean delete(TreeNodeVO tNode) throws Exception;
	
	TreeNodeVO eSearch(String id);
	
	ArrayList<TreeNodeVO> show() throws Exception;//return the tree so to build the tree
	
	void initialize(String account);
	String getDatabase(String account); 
}
