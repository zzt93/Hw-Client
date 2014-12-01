package businesslogicservice.GoodsListblservice;

import po.GoodsListPO;
import vo.GoodsModelVO;

import java.util.ArrayList;

public interface GL_account_BLservice {
	GoodsListPO initialize(String account) throws Exception;
	boolean add(GoodsModelVO goodsVO) throws Exception;
	boolean add(ArrayList<GoodsModelVO> goodsVOs) throws Exception;
	
	String getDatabase(String account) throws Exception;
}
