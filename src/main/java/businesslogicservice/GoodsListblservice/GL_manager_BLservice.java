package businesslogicservice.GoodsListblservice;


import po.GoodsListPO;
import vo.GoodsVO;

public interface GL_manager_BLservice {
	int amount(GoodsVO goods) throws Exception;
	GoodsListPO getGoodsList() throws Exception;
}
