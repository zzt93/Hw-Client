package businesslogicservice.GoodsListblservice;

import java.util.ArrayList;

import po.GoodsListPO;
import vo.GoodsModelVO;

public interface GL_account_BLservice {
	GoodsListPO initialize(String account) throws Exception;
	boolean add(GoodsModelVO goodsVO) throws Exception;
	boolean add(ArrayList<GoodsModelVO> goodsVOs) throws Exception;
	
	String getDatabase(String account) throws Exception;
}
