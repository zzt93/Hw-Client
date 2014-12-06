package businesslogic.GoodsTypebl;


import businesslogicservice.GoodsTypeblservice.GTBLservice;
import po.TreeNodePO;
import vo.TreeNodeVO;

import java.util.ArrayList;
import java.util.Iterator;

public class GTBLImpl implements GTBLservice{
	
	ArrayList<TreeNodePO> treeNodePOs ;
	
	public GTBLImpl(String account) {
		// TODO Auto-generated constructor stub
	}

	public GTBLImpl(ArrayList<TreeNodePO> treeNodePOs) {
		this.treeNodePOs = treeNodePOs;
	}

	public boolean add(TreeNodePO fa, String son_type) throws Exception {
		if (son_type == null) {
			treeNodePOs.add(new TreeNodePO(fa));
		} 
		treeNodePOs.add(new TreeNodePO(fa, son_type));
		return true;
	}

	public boolean update(TreeNodePO tNode) throws Exception {
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

	public boolean delete(TreeNodePO tNode) throws Exception {
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

	public ArrayList<TreeNodePO> show() throws Exception {
		return treeNodePOs;
	}

	
	

}
