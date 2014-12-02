package vo;

import po.GoodsModelPO;

import java.io.Serializable;

public class GoodsModelVO implements Serializable {

	// all the field is for all batches goods
	int signal;
	int amount;
	String id;
	String name;
	String model;
	

	boolean everHas;
	boolean gift;
	
	double lastInPrice;
	double lastOutPrice;

	public GoodsModelVO(GoodsModelPO goodsModelPO) {
		// TODO Auto-generated constructor stub
	}
	public GoodsModelVO(String id, String name, String model) {
		// TODO Auto-generated constructor stub
	}
	
	public String getModel() {
		return model;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public boolean isGift() {
		return gift;
	}

	public void setGift(boolean gift) {
		this.gift = gift;
	}

	public double getLastInPrice() {
		return lastInPrice;
	}

	public void setLastInPrice(double lastInPrice) {
		this.lastInPrice = lastInPrice;
	}

	public double getLastOutPrice() {
		return lastOutPrice;
	}

	public void setLastOutPrice(double lastOutPrice) {
		this.lastOutPrice = lastOutPrice;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	public int getSignal() {
		return signal;
	}

	public void setSignal(int signal) {
		this.signal = signal;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isEverHas() {
		return everHas;
	}

	public void setEverHas(boolean everHas) {
		this.everHas = everHas;
	}

}
