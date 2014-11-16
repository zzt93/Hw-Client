package vo;

import po.GoodsPO;

/**
 * An object of Goods is a batch of goods
 * @author zzt
 *
 */
public class GoodsVO {
	public GoodsVO(GoodsPO goodsPO) {
		// TODO Auto-generated constructor stub
	}
	public GoodsVO() {
		// TODO Auto-generated constructor stub
	}
	public int amount;
	public String name;
	public String id;
	public String model;
	public double inPrice;
	public double outPrice;
}
