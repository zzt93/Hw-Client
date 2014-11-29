package businesslogicservice.GoodsListblservice;

import java.util.ArrayList;
import java.util.HashMap;

import po.GoodsModelPO;
import po.GoodsPO;
import vo.GoodsVO;

public interface GL_stock_BLservice {
	int amount(GoodsPO goods) throws Exception;
	
	boolean checkGoodsExists(GoodsVO goodsVO) throws Exception;
	ArrayList<String> sell_type();
	ArrayList<String> stock_type();
	
	boolean addAmount(GoodsVO goods) throws Exception;
	boolean addAmount(ArrayList<GoodsVO> goodsArrayList) throws Exception;
	boolean reduAmount(GoodsVO goods) throws Exception;
	boolean reduAmount(ArrayList<GoodsVO> goodsArrayList) throws Exception;
	
}
