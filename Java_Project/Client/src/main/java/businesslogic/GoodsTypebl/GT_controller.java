package businesslogic.GoodsTypebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.GoodsTypedataservice.GoodsTypeDateService;
import po.TreeNodePO;
import vo.GoodsVO;
import vo.TreeNodeVO;
import businesslogicservice.GoodsTypeblservice.GTBLservice;
import businesslogicservice.GoodsTypeblservice.GT_GL_BLservice;

public class GT_controller implements GT_GL_BLservice, GTBLservice {
	
	ArrayList<TreeNodePO> treeNodePOs;
	GoodsTypeDateService goodsTypeDateService = new GoodsTypeDataImpl();
	public GT_controller() throws RemoteException {
		treeNodePOs = goodsTypeDateService.getGoodsTypde().getObj();
		

		gtbLservice = new GTBLImpl(treeNodePOs);
		gl_BLservice = new GT_GL_BLImpl(treeNodePOs);
	}
	
	GTBLservice gtbLservice;
	GT_GL_BLservice gl_BLservice;

	public boolean add(TreeNodeVO tNode) throws Exception {
		return gtbLservice.add(tNode);
	}

	public boolean update(TreeNodeVO tNode) throws Exception {
		return gtbLservice.update(tNode);
	}

	public boolean delete(TreeNodeVO tNode) throws Exception {
		return gtbLservice.delete(tNode);
	}

	public TreeNodeVO eSearch(String id) throws Exception {
		return gtbLservice.eSearch(id);
	}

	public ArrayList<TreeNodeVO> show() throws Exception {
		return gtbLservice.show();
	}

	public void initialize(String account) throws Exception {
		gtbLservice.initialize(account);
	}

	public String getDatabase(String account) throws Exception {
		return gtbLservice.getDatabase(account);
	}

	public boolean typeCheck(GoodsVO goods) throws Exception {
		return gl_BLservice.typeCheck(goods);
	}

	public void update(ArrayList<TreeNodeVO> treeNodes) {
		gl_BLservice.update(treeNodes);
	}

}
