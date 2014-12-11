package businesslogic.GoodsListbl;

import businesslogicservice.GoodsListblservice.GL_GT_BLservice;
import po.GoodsListPO;
import po.GoodsModelPO;

import java.util.HashMap;

public class GL_GT_Impl implements GL_GT_BLservice{

	GoodsListPO goodsListPO ;
	HashMap<String, GoodsModelPO> goodsModels;
	public GL_GT_Impl(GoodsListPO goodsListPO) throws NullPointerException{
		this.goodsListPO = goodsListPO;
		
		goodsModels = goodsListPO.getGoodsModels();
		
	}

	public boolean checkEverHas(String info) throws Exception {
		if (goodsModels.size() == 0){
			return false;
		}
		return goodsModels.get(info).isEverHas();
	}



}
