package vo;

import po.GoodsListPO;

import java.io.Serializable;
import java.util.HashMap;

public class GoodsListVO implements Serializable {

	private static final long serialVersionUID = 1L;
	HashMap<String, GoodsModelVO> goodsModels;
	HashMap<String, GoodsVO> goods;
	public GoodsListVO(GoodsListPO goodsListPO) {
	}
	public HashMap<String, GoodsModelVO> getGoodsModels() {
		return goodsModels;
	}
	public void setGoodsModels(HashMap<String, GoodsModelVO> goodsModels) {
		this.goodsModels = goodsModels;
	}
	public HashMap<String, GoodsVO> getGoods() {
		return goods;
	}
	public void setGoods(HashMap<String, GoodsVO> goods) {
		this.goods = goods;
	}
	
}
