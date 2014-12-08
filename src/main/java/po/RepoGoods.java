package po;

import java.io.Serializable;

public class RepoGoods implements Serializable {
	private static final long serialVersionUID = 1L;
	public RepoGoods(String id, GoodsModelPO goodsModelPO) {
		this.id = id;
		amount = goodsModelPO.getAmount();
		aver_price = goodsModelPO.getAver_in();
		
		name = goodsModelPO.getName();
		model = goodsModelPO.getModel();
	}
	String id;
	
	String name;
	String model;
	int amount;
	double aver_price;
	
	public String getName() {
		return name;
	}
	public String getModel() {
		return model;
	}
	public int getAmount() {
		return amount;
	}
	public double getAver_price() {
		return aver_price;
	}
	public String getId() {
		return id;
	}
}