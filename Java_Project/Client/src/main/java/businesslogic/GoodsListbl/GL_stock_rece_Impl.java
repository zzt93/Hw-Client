package businesslogic.GoodsListbl;

import java.util.ArrayList;
import java.util.HashMap;

import po.GoodsListPO;
import po.GoodsModelPO;
import po.GoodsPO;
import vo.GoodsModelVO;
import vo.GoodsVO;
import businesslogicservice.GoodsListblservice.GL_receipt_BLservice;
import businesslogicservice.GoodsListblservice.GL_stock_BLservice;

public class GL_stock_rece_Impl implements GL_stock_BLservice, GL_receipt_BLservice{

	GoodsListPO goodsListPO;
	public GL_stock_rece_Impl(GoodsListPO goodsListPO) {
		this.goodsListPO = goodsListPO;
	}

	public boolean check(GoodsPO goods) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public GoodsModelPO getGoodsModelPOs(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int amount(GoodsPO goods) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean checkGoodsExists(GoodsVO goodsVO) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAmount(GoodsVO goods) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAmount(ArrayList<GoodsVO> goodsArrayList)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean reduAmount(GoodsVO goods) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean reduAmount(ArrayList<GoodsVO> goodsArrayList)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public HashMap<String, GoodsModelVO> getGoodsModels() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
