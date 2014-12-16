package businesslogic.GoodsTypebl;


import businesslogicservice.GoodsTypeblservice.GTBLservice;
import po.TreeNodePO;

import java.util.ArrayList;
import java.util.Iterator;

public class GTBLImpl implements GTBLservice{
	
	ArrayList<TreeNodePO> treeNodePOs ;
	
	

	public GTBLImpl(ArrayList<TreeNodePO> treeNodePOs) {
		this.treeNodePOs = treeNodePOs;
	}

	public boolean add(TreeNodePO node) throws Exception {
		treeNodePOs.add(node);
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
				treeNodePO.getFa().getSons().remove(treeNodePO);
				return true;
			}
		}
		return false;
	}

	public TreeNodePO eSearch(String id) throws Exception{
		for (Iterator<TreeNodePO> iterator = treeNodePOs.iterator(); iterator.hasNext();) {
			TreeNodePO treeNodePO = iterator.next();
			if (treeNodePO.getType_so_far().equals(id)) {
				return treeNodePO;
			}
		}
		return null;
	}

	public ArrayList<TreeNodePO> show() throws Exception {
		return treeNodePOs;
	}

	
	

}
