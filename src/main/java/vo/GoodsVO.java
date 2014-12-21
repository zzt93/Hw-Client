package vo;

import po.GoodsPO;

import java.io.Serializable;

/**
 * An object of Goods is a batch of goods
 * @author zzt
 *
 */
public class GoodsVO implements Serializable {
	private static final long serialVersionUID = 1L;
	public GoodsVO(GoodsPO goodsPO) {
		this.amount = goodsPO.getAmount();
		this.id = goodsPO.getId();
		this.name = goodsPO.getName();
		this.model = goodsPO.getModel();
	}
	public GoodsVO(String id, String name, int amount) {
		this.id = id;
		this.name = name;
		this.amount = amount;
	}
	
	public GoodsVO(Object id, Object name, Object amount) {
		this.name = (String)name;
		this.id = (String)id;
		this.amount = (Integer)amount;
	}

	public int amount;
	public String name;
	public String id;
	public String model;
	public double inPrice;
	public double outPrice;


}
