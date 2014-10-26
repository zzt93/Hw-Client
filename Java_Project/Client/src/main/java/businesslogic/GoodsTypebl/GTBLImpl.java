package businesslogic.GoodsTypebl;


import java.util.ArrayList;

import po.TreeNodePO;
import dataservice.GoodsTypedataservice.GoodsTypeDataImpl;
import dataservice.GoodsTypedataservice.GoodsTypeDateService;
import vo.TreeNodeVO;
import businesslogicservice.GoodsTypeblservice.GTBLservice;

public class GTBLImpl implements GTBLservice{
	
	GoodsTypeDateService goodsTypeDateService = new GoodsTypeDataImpl();
	
	public GTBLImpl(String account) {
		// TODO Auto-generated constructor stub
		
	}

	public boolean add(TreeNodeVO tNode) throws Exception {
		// TODO Auto-generated method stub
		goodsTypeDateService.insert(new TreeNodePO(tNode));
		return true;
	}

	public boolean update(TreeNodeVO tNode) throws Exception {
		// TODO Auto-generated method stub
		goodsTypeDateService.update(new TreeNodePO(tNode));
		return true;
	}

	public boolean delete(TreeNodeVO tNode) throws Exception {
		// TODO Auto-generated method stub
		goodsTypeDateService.delete(new TreeNodePO(tNode));
		return true;
	}

	public TreeNodeVO eSearch(String id) throws Exception{
		// TODO Auto-generated method stub
		TreeNodePO temNodePO = goodsTypeDateService.efind(id).getObj();
		return new TreeNodeVO(temNodePO);
	}

	public ArrayList<TreeNodeVO> show() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void initialize(String account) throws Exception {
		// TODO Auto-generated method stub
		goodsTypeDateService.initialize(new ArrayList<TreeNodePO>(null));
	}

	public String getDatabase(String account) throws Exception{
		// TODO Auto-generated method stub
		return goodsTypeDateService.getDatabse(account).getObj();
	}

}
