package po;

import java.util.ArrayList;
import java.util.HashMap;

public class GoodsListPO {
	HashMap<String, GoodsModelPO> goodsModels;
	
	/* Every GoodsPO in the list is a batch of goods
	 * a sum of every batch is the stock of the repository
	 */
	HashMap<String, ArrayList<GoodsPO>> goodsMap;

	public HashMap<String, GoodsModelPO> getGoodsModels() {
		return goodsModels;
	}

	public void setGoodsModels(HashMap<String, GoodsModelPO> goodsModels) {
		this.goodsModels = goodsModels;
	}

	public HashMap<String, ArrayList<GoodsPO>> getGoodsMap() {
		return goodsMap;
	}

	public void setGoodsMap(HashMap<String, ArrayList<GoodsPO>> goodsMap) {
		this.goodsMap = goodsMap;
	}
}
