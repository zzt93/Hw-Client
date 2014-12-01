package po;

import java.util.ArrayList;
import java.util.HashMap;

public class GoodsListPO {
	HashMap<String, GoodsModelPO> goodsModels = new HashMap<String, GoodsModelPO>();
	
	/* Every GoodsPO in the list is a batch of goods
	 * a sum of every batch is the stock of the repository
	 */
	HashMap<String, ArrayList<GoodsPO>> goods = new HashMap<String, ArrayList<GoodsPO>>();

	public HashMap<String, ArrayList<GoodsPO>> getGoods() {
		return goods;
	}

	public void setGoods(HashMap<String, ArrayList<GoodsPO>> goods) {
		this.goods = goods;
	}

	public HashMap<String, GoodsModelPO> getGoodsModels() {
		return goodsModels;
	}

	public void setGoodsModels(HashMap<String, GoodsModelPO> goodsModels) {
		this.goodsModels = goodsModels;
	}

}
