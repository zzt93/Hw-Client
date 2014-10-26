package businesslogicservice.GoodsListblservice;

import java.util.ArrayList;

import vo.GoodsVO;

public interface GL_stock_BLservice {
	int amount(GoodsVO goods);
	
	boolean addAmount(GoodsVO goods);
	boolean addAmount(ArrayList<GoodsVO> goodsArrayList);
	boolean reduAmount(GoodsVO goods);
	boolean reduAmount(ArrayList<GoodsVO> goodsArrayList);
	
}
