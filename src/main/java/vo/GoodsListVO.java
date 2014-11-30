package vo;

import po.GoodsListPO;

import java.util.HashMap;

public class GoodsListVO {

	
	HashMap<String, GoodsModelVO> goodsModels;
	HashMap<String, GoodsVO> goods;
	public GoodsListVO(GoodsListPO goodsListPO) {
		// TODO Auto-generated constructor stub
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
