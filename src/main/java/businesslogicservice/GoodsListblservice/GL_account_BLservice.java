package businesslogicservice.GoodsListblservice;

import vo.GoodsModelVO;

import java.util.ArrayList;

public interface GL_account_BLservice {
	boolean add(GoodsModelVO goodsVO) throws Exception;
	boolean add(ArrayList<GoodsModelVO> goodsVOs) throws Exception;
	
}
