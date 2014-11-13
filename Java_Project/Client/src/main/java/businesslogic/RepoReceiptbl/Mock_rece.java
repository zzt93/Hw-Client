package businesslogic.RepoReceiptbl;

import java.util.HashMap;

import po.GoodsListPO;
import po.GoodsModelPO;
import po.GoodsPO;
import businesslogicservice.GoodsListblservice.GL_receipt_BLservice;

public class Mock_rece implements GL_receipt_BLservice{

	GoodsListPO goodsListPO = new GoodsListPO();
	public boolean check(GoodsPO goods) throws Exception {
		HashMap<String, GoodsModelPO> gHashMap = goodsListPO.getGoodsModels();
		return gHashMap.get(goods.getId()).getAmount() > 0;
	}

	public GoodsModelPO getGoodsModelPOs(String id) throws Exception {
		return goodsListPO.getGoodsModels().get(id);
	}

	public int amount(GoodsPO goods) throws Exception {
		GoodsModelPO temp = goodsListPO.getGoodsModels().get(goods.getId());
		return temp.getAmount();
	}

}
