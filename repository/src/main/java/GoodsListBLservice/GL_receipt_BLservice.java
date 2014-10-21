package GoodsListBLservice;

import VO.Goods;

public interface GL_receipt_BLservice {
	//check whether some goods is exist
	boolean check(Goods goods);
	int amount(Goods goods);
}
