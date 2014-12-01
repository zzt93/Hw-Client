package businesslogic.GoodsTypebl;

import businesslogic.GoodsListbl.GL_controller;
import businesslogicservice.GoodsTypeblservice.GTBLservice;
import businesslogicservice.GoodsTypeblservice.GT_GL_BLservice;
import businesslogicservice.GoodsTypeblservice.GT_account_service;
import dataservice.GoodsTypedataservice.GoodsTypeDateService;
import po.GoodsListPO;
import po.TreeNodePO;
import vo.TreeNodeVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class GT_controller implements GT_GL_BLservice, GTBLservice,
		GT_account_service {

	ArrayList<TreeNodePO> treeNodePOs;

	public ArrayList<TreeNodePO> getTreeNodePOs() {
		return treeNodePOs;
	}

	GoodsTypeDateService goodsTypeDateService = new GoodsTypeDataImpl();

	public GT_controller() throws RemoteException {
		treeNodePOs = goodsTypeDateService.getGoodsTypde().getObj();

		if (treeNodePOs == null) {
			treeNodePOs.add(new TreeNodePO(new TreeNodeVO("Light/灯")));
		}
		gtbLservice = new GTBLImpl(treeNodePOs);
		gt_gl_BLservice = new GT_GL_BLImpl(treeNodePOs);

		gl_controller = new GL_controller();
	}

	GTBLservice gtbLservice;
	GT_GL_BLservice gt_gl_BLservice;

	/*
	 * for cross modules
	 */
	GL_controller gl_controller;

	public boolean add(TreeNodeVO fa, String son_type) throws Exception {
		if (gl_controller.checkEverHas(fa.getType_so_far())) {
			return false;
		}
		boolean res = gtbLservice.add(fa, null);
		if (res) {
			goodsTypeDateService.insert(new TreeNodePO(fa));
		}
		return res;
	}

	public boolean update(TreeNodeVO tNode) throws Exception {
		boolean res = gtbLservice.update(tNode);
		if (res) {
			goodsTypeDateService.update(new TreeNodePO(tNode));
		}
		return res;
	}

	public boolean delete(TreeNodeVO tNode) throws Exception {
		boolean res = gtbLservice.delete(tNode);
		if (res) {
			goodsTypeDateService.delete(new TreeNodePO(tNode));
		}
		return res;
	}

	public TreeNodeVO eSearch(String id) throws Exception {
		return gtbLservice.eSearch(id);
	}

	public ArrayList<TreeNodeVO> show() throws Exception {
		return gtbLservice.show();
	}

	public void initialize(String account) throws Exception {
		ArrayList<TreeNodePO> res = new ArrayList<TreeNodePO>();
		goodsTypeDateService.initialize(res).getObj();
	}

	public String getDatabase(String account) throws Exception {
		return goodsTypeDateService.getDatabse(account).getObj();
	}

	public ArrayList<String> addable_type() throws Exception {
		return gt_gl_BLservice.addable_type();
	}

	public void update_nodelist(ArrayList<TreeNodeVO> treeNodes,
			GoodsListPO goodsListPO) throws Exception {
		gt_gl_BLservice.update_nodelist(treeNodes, goodsListPO);
		goodsTypeDateService.update(null);
	}

	public int height() {
		int height = 0;
		TreeNodePO fa = treeNodePOs.get(0);
		while (fa != null) {
			for (TreeNodePO treeNodePO : fa.getSons()) {
				int temp = travel(treeNodePO, height);
				if (height > temp) {
					System.err.println("some thing wrong");
					assert(false);
				} else {
					height = temp;
				}
			}
		}
		return height;
	}

	private int travel(TreeNodePO po, int i) {
		if (po == null) {
			return i;
		} else {
			return travel(po, i + 1);
		}
	}
}
