package businesslogic.GoodsListbl;

import java.util.HashMap;

import po.GoodsListPO;
import vo.GoodsModelVO;
import businesslogicservice.GoodsListblservice.GL_GT_BLservice;

public class GL_GT_Impl implements GL_GT_BLservice{

	GoodsListPO goodsListPO ;
	public GL_GT_Impl(GoodsListPO goodsListPO) {
		this.goodsListPO = goodsListPO;
	}

	public boolean checkAdd(String info) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean checkEverHas(String info) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public HashMap<String, GoodsModelVO> getGoodsModels() {
		// TODO Auto-generated method stub
		return null;
	}

	public void notifyBT() {
		// TODO Auto-generated method stub
		
	}

}
