package businesslogicservice.GoodsTypeblservice;

import java.util.ArrayList;

import vo.GoodsVO;
import vo.TreeNodeVO;

public interface GT_GL_BLservice {
	boolean typeCheck(GoodsVO goods) throws Exception;// used to check whether
														// it is a leaf node

	// if some goods is added under a type, invoke it to update the tree node
	void update(ArrayList<TreeNodeVO> treeNodes);
}
