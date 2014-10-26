package businesslogicservice.GoodsListblservice;

import java.util.ArrayList;

import vo.GoodsVO;

public interface GL_stock_BLservice {
	int amount(GoodsVO goods) throws Exception;
	
	boolean checkExists(GoodsVO goodsVO) throws Exception;
	
	boolean addAmount(GoodsVO goods) throws Exception;
	boolean addAmount(ArrayList<GoodsVO> goodsArrayList) throws Exception;
	boolean reduAmount(GoodsVO goods) throws Exception;
	boolean reduAmount(ArrayList<GoodsVO> goodsArrayList) throws Exception;
	
}
