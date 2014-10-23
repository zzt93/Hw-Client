package businesslogicservice.GoodsListblservice;

import java.util.ArrayList;

import vo.Goods;

public interface GL_stock_BLservice {
	int amount(Goods goods);
	
	boolean addAmount(Goods goods);
	boolean addAmount(ArrayList<Goods> goodsArrayList);
	boolean reduAmount(Goods goods);
	boolean reduAmount(ArrayList<Goods> goodsArrayList);
	
}
