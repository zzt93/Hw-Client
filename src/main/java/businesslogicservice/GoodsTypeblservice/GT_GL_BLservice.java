package businesslogicservice.GoodsTypeblservice;

import java.util.ArrayList;

import po.GoodsListPO;
import vo.GoodsVO;
import vo.TreeNodeVO;

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
