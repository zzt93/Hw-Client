package GoodsListBLservice;

import java.util.ArrayList;

import PO.GoodsModelPO;
import VO.Goods;

public interface GL_receipt_BLservice {
	//check whether some goods is exist
	boolean check(Goods goods);
	ArrayList<GoodsModelPO> getGoodsModelPOs();
	int amount(Goods goods);
}
