package businesslogic.GoodsTypebl;


import java.util.ArrayList;
import java.util.Iterator;

import po.TreeNodePO;
import dataservice.GoodsTypedataservice.GoodsTypeDateService;
import vo.TreeNodeVO;
import businesslogicservice.GoodsTypeblservice.GTBLservice;

public class GTBLImpl implements GTBLservice{
	
	ArrayList<TreeNodePO> treeNodePOs ;
	
	public GTBLImpl(String account) {
		// TODO Auto-generated constructor stub
		
	}

	public GTBLImpl(ArrayList<TreeNodePO> treeNodePOs) {
		this.treeNodePOs = treeNodePOs;
	}

	public boolean add(TreeNodeVO tNode) throws Exception {
		treeNodePOs.add(new TreeNodePO(tNode));
		return true;
	}

	public boolean update(TreeNodeVO tNode) throws Exception {
		for (Iterator<TreeNodePO> iterator = treeNodePOs.iterator(); iterator.hasNext();) {
			TreeNodePO treeNodePO = iterator.next();
			if (treeNodePO.getType_so_far().equals(tNode.getType_so_far())
					&& treeNodePO.type_editable()) {
				treeNodePO.setType(tNode.getType());
				return true;
			}
		}
		return false;
	}

	public boolean delete(TreeNodeVO tNode) throws Exception {
		for (Iterator<TreeNodePO> iterator = treeNodePOs.iterator(); iterator.hasNext();) {
			TreeNodePO treeNodePO = iterator.next();
			if (treeNodePO.getType_so_far().equals(tNode.getType_so_far())
					&& treeNodePO.type_editable()) {
				iterator.remove();
				return true;
			}
		}
		return false;
	}

	public TreeNodeVO eSearch(String id) throws Exception{
		for (Iterator<TreeNodePO> iterator = treeNodePOs.iterator(); iterator.hasNext();) {
			TreeNodePO treeNodePO = iterator.next();
			if (treeNodePO.getType_so_far().equals(id)) {
				return new TreeNodeVO(treeNodePO);
			}
		}
		return null;
	}

	public ArrayList<TreeNodeVO> show() throws Exception {
		ArrayList<TreeNodeVO> res = new ArrayList<TreeNodeVO>();
		for (TreeNodePO treeNodePO : treeNodePOs) {
			res.add(new TreeNodeVO(treeNodePO));
		}
		return res;
	}

	

}
