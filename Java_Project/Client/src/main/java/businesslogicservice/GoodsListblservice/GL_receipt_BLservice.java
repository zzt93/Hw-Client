package businesslogicservice.GoodsListblservice;

import java.util.ArrayList;

import po.GoodsModelPO;
import vo.Goods;

public interface GL_receipt_BLservice {
	//check whether some goods is exist
	boolean check(Goods goods);
	ArrayList<GoodsModelPO> getGoodsModelPOs();
	int amount(Goods goods);
}
