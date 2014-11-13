package businesslogic.GoodsListbl;

import java.util.ArrayList;

import po.GoodsListPO;
import vo.GoodsVO;
import businesslogicservice.GoodsListblservice.GL_account_BLservice;

public class GL_account_Impl implements GL_account_BLservice {

	GoodsListPO goodsListPO;
	public GL_account_Impl(GoodsListPO goodsListPO) {
		this.goodsListPO = goodsListPO;
	}

	public void initialize(String account) throws Exception {
		// TODO Auto-generated method stub

	}

	public boolean add(GoodsVO goodsVO) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean add(ArrayList<GoodsVO> goodsVOs) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public String getDatabase(String account) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
