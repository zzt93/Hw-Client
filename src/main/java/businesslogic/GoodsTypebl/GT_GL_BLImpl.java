package businesslogic.GoodsTypebl;

import businesslogicservice.GoodsTypeblservice.GT_GL_BLservice;
import po.GoodsListPO;
import po.GoodsModelPO;
import po.TreeNodePO;
import vo.TreeNodeVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class GT_GL_BLImpl implements GT_GL_BLservice {

	
	ArrayList<TreeNodePO> treeNodePOs;
	public GT_GL_BLImpl(ArrayList<TreeNodePO> treeNodePOs) {
		this.treeNodePOs = treeNodePOs;
	}

	public ArrayList<String> addable_type() throws RemoteException {
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
				} 
			}
			System.err.println("some treenode wrong");
		}

	}

}
