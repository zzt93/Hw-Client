package businesslogicservice.GoodsTypeblservice;

import po.GoodsListPO;
import vo.TreeNodeVO;

import java.util.ArrayList;

public interface GT_GL_BLservice {
	
	/* used to check whether it is a leaf node
	 * invoked by GL_controller
	 */
	ArrayList<String> addable_type() throws Exception;

	/*
	 * if some goods is added under a type, invoke it to update the tree node
	 * invoked by GL_BL
	 */
	void update_nodelist(ArrayList<TreeNodeVO> treeNodes, GoodsListPO goodsListPO) throws Exception;
}
