package po;

import java.io.Serializable;
import java.util.ArrayList;

public class RepoGoods implements Serializable {
	public RepoGoods(String id, GoodsModelPO goodsModelPO, ArrayList<GoodsPO> arrayList) {
		this.id = id;
		amount = goodsModelPO.getAmount();
		aver_price = goodsModelPO.getAver_in();
		//TODO whose name and model
		name = goodsModelPO.getName();
		model = arrayList.get(0).model;
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