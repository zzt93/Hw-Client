package businesslogicservice.GoodsListblservice;

import java.util.ArrayList;

import po.GoodsModelPO;
import vo.GoodsVO;

public interface GL_receipt_BLservice {
	//check whether some goods is exist
	boolean check(GoodsVO goods) throws Exception;
	//1. for check whether it can send as gift
	//2. check the amount
	ArrayList<GoodsModelPO> getGoodsModelPOs() throws Exception;
	int amount(GoodsVO goods) throws Exception;
}
