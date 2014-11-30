package businesslogic.GoodsListbl;

import businesslogicservice.GoodsTypeblservice.GT_GL_BLservice;
import po.GoodsListPO;
import po.GoodsModelPO;
import po.TreeNodePO;
import vo.TreeNodeVO;

import java.util.ArrayList;

public class Mock_GT_controller implements GT_GL_BLservice{

	ArrayList<TreeNodePO> treeNodePOs = new ArrayList<TreeNodePO>(null);
	
	public ArrayList<String> addable_type() throws Exception {
		ArrayList<String> res = new ArrayList<String>();
		for (TreeNodePO node : treeNodePOs) {
			if(node.is_leaf()){
				res.add(node.getType_so_far());
			}
		}
		return res;
	}

	public void update_nodelist(ArrayList<TreeNodeVO> treeNodes, GoodsListPO goodsListPO) throws Exception {
		for (TreeNodeVO treeNodeVO : treeNodes) {
			for (TreeNodePO treeNodePO : treeNodePOs) {
				if(treeNodePO.getType_so_far().equals(treeNodeVO.getType_so_far())){
					GoodsModelPO temp = goodsListPO.getGoodsModels().get(treeNodePO.getType_so_far());
					treeNodePO.getGoodsModels().add(temp);
				} else {
					System.err.println("some treenode wrong");
				}
			}
		}
	}

}
