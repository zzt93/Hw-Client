package businesslogicservice.GoodsListblservice;

import java.util.ArrayList;
import java.util.HashMap;

import vo.GoodsModelVO;
import vo.GoodsVO;

public interface GL_stock_BLservice {
	int amount(GoodsVO goods) throws Exception;
	
	boolean checkGoodsExists(GoodsVO goodsVO) throws Exception;
	
	boolean addAmount(GoodsVO goods) throws Exception;
	boolean addAmount(ArrayList<GoodsVO> goodsArrayList) throws Exception;
	boolean reduAmount(GoodsVO goods) throws Exception;
	boolean reduAmount(ArrayList<GoodsVO> goodsArrayList) throws Exception;
	
	HashMap<String, ArrayList<GoodsModelVO>> getGoodsModels();
}
