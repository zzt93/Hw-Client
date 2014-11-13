package businesslogic.GoodsListbl;

import java.util.ArrayList;

import vo.GoodsVO;
import vo.TreeNodeVO;
import businesslogicservice.GoodsTypeblservice.GT_GL_BLservice;

public class Mock_GT_controller implements GT_GL_BLservice{

	ArrayList<TreeNodeVO> treeNodeVOs = new ArrayList<TreeNodeVO>(null);
	
	public boolean typeCheck(GoodsVO goods) throws Exception {
		String id = goods.id;
		for (TreeNodeVO treeNodeVO : treeNodeVOs) {
			if(treeNodeVO.getInfo().contains(id)){
				return (treeNodeVO.getSons() == null);
			}
		}
		return false;
	}

	public void update(ArrayList<TreeNodeVO> treeNodes) {
		for (TreeNodeVO treeNodeVO : treeNodeVOs) {
			for (TreeNodeVO treeNodeVO1 : treeNodes) {
				if (treeNodeVO.equals(treeNodeVO1)) {
					treeNodeVO.getGoodsModelVOs().add(null);
				}
			}
		}
	}

}
