package po;

import vo.GoodsVO;

import java.io.Serializable;

public class GoodsPO implements Serializable {
	private static final long serialVersionUID = 1L;
	int amount;
	String name;
	String id;
	String model;
	double inPrice;
	double outPrice;
	
	/*
	 * This constructor is only for repo receipt
	 */
	public GoodsPO(GoodsVO goods){
		amount = goods.amount;
		
		id = goods.id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getInPrice() {
		return inPrice;
	}
	public void setInPrice(double inPrice) {
		this.inPrice = inPrice;
	}
	public double getOutPrice() {
		return outPrice;
	}
	public void setOutPrice(double outPrice) {
		this.outPrice = outPrice;
	}
}
