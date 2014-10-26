package businesslogic.GoodsListbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import dataservice.GoodsListdataservice.GoodsListDataImpl;
import po.GoodsListPO;
import po.GoodsModelPO;
import po.GoodsPO;
import vo.GoodsVO;
import businesslogic.GoodsTypebl.GT_GL_BLImpl;
import businesslogicservice.GoodsListblservice.GLBLservice;
import businesslogicservice.GoodsTypeblservice.GT_GL_BLservice;

public class GLBLImpl implements GLBLservice {
	
	public GLBLImpl(String account) {
		// TODO Auto-generated constructor stub
		try {
			goodsList = new GoodsListDataImpl("account name").getGoodsList().getObj();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	GoodsListPO goodsList ;
	
	public boolean save() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean add(GoodsVO goods) throws Exception {
		// TODO Auto-generated method stub
		//whether 
		GT_GL_BLservice  gl_BLservice = new GT_GL_BLImpl();
		if (!gl_BLservice.typeCheck(goods)){
			return false;
		}
		HashMap<String, GoodsModelPO> tempGoodsModelPOs = goodsList.getGoodsModels();
		HashMap<String, ArrayList<GoodsPO>> tempGoods = goodsList.getGoods();
		
		ArrayList<GoodsPO> batchGoods = new ArrayList<GoodsPO>();
		batchGoods.add(new GoodsPO(goods));
		tempGoods.put(goods.id, batchGoods);
		
		GoodsModelPO tempGoodsModelPO = tempGoodsModelPOs.get(goods.id);
		tempGoodsModelPO.setAmount(tempGoodsModelPO.getAmount()+goods.amount);
		return true;
	}

	public boolean add(ArrayList<GoodsVO> goodsA) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(GoodsVO goods) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<GoodsVO> iSearch(String info) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<GoodsVO> iSearch(int amount) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<GoodsVO> iSearch(String[] infos) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<GoodsVO> eSearch(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean update(GoodsVO goods) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public HashMap<String, ArrayList<GoodsVO>> show() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
