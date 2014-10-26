package businesslogicservice.GoodsListblservice;

import java.util.ArrayList;

import po.GoodsModelPO;
import vo.GoodsVO;

public interface GL_receipt_BLservice {
	//check whether some goods is exist
	boolean check(GoodsVO goods);
	ArrayList<GoodsModelPO> getGoodsModelPOs();
	int amount(GoodsVO goods);
}
