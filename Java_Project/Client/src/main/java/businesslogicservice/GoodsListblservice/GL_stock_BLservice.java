package businesslogicservice.GoodsListblservice;

import java.util.ArrayList;

import vo.Goods;

public interface GL_stock_BLservice {
	int amount(Goods goods) throws Exception;
	
	boolean addAmount(Goods goods) throws Exception;
	boolean addAmount(ArrayList<Goods> goodsArrayList) throws Exception;
	boolean reduAmount(Goods goods) throws Exception;
	boolean reduAmount(ArrayList<Goods> goodsArrayList) throws Exception;
	
}
