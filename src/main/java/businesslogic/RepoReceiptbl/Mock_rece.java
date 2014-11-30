package businesslogic.RepoReceiptbl;

import businesslogicservice.GoodsListblservice.GL_receipt_BLservice;
import po.GoodsListPO;
import po.GoodsModelPO;
import po.GoodsPO;
import po.RepoReceiptPO;

import java.util.HashMap;

public class Mock_rece implements GL_receipt_BLservice{

	GoodsListPO goodsListPO = new GoodsListPO();
	public boolean check_rece(GoodsPO goods) throws Exception {
		HashMap<String, GoodsModelPO> gHashMap = goodsListPO.getGoodsModels();
		return gHashMap.get(goods.getId()).getAmount() > 0;
	}

	public GoodsModelPO getGoodsModelPO(String id) throws Exception {
		return goodsListPO.getGoodsModels().get(id);
	}

	public int amount(GoodsPO goods) throws Exception {
		GoodsModelPO temp = goodsListPO.getGoodsModels().get(goods.getId());
		return temp.getAmount();
	}

	public void receiveRece(RepoReceiptPO receiptPO) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
