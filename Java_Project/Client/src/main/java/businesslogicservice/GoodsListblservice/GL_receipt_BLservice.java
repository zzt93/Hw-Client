package businesslogicservice.GoodsListblservice;


import po.GoodsModelPO;
import po.GoodsPO;

public interface GL_receipt_BLservice {
	//check whether some goods is exist
	boolean check(GoodsPO goods) throws Exception;
	//1. for check whether it can send as gift
	//2. check the amount
	GoodsModelPO getGoodsModelPOs(String id) throws Exception;
	int amount(GoodsPO goods) throws Exception;
	//update the amount if repo_receipt is approved
}
