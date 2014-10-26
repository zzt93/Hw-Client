package businesslogicservice.GoodsListblservice;

import java.util.ArrayList;

import vo.GoodsVO;

public interface GL_account_BLservice {
	void initialize(String account) throws Exception;
	boolean add(GoodsVO goodsVO) throws Exception;
	boolean add(ArrayList<GoodsVO> goodsVOs) throws Exception;
	
	String getDatabase(String account) throws Exception;
}
