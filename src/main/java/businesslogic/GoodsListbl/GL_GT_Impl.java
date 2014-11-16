package businesslogic.GoodsListbl;

import java.util.HashMap;

import po.GoodsListPO;
import po.GoodsModelPO;
import businesslogicservice.GoodsListblservice.GL_GT_BLservice;

public class GL_GT_Impl implements GL_GT_BLservice{

	GoodsListPO goodsListPO ;
	HashMap<String, GoodsModelPO> goodsModels;
	public GL_GT_Impl(GoodsListPO goodsListPO) {
		this.goodsListPO = goodsListPO;
		goodsModels = goodsListPO.getGoodsModels();
	}

	public boolean checkEverHas(String info) throws Exception {
		return goodsModels.get(info).isEverHas();
	}



}