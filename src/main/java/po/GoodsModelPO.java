package po;

import vo.GoodsModelVO;

import java.io.Serializable;

public class GoodsModelPO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GoodsModelPO(String id, String name, String model) {
		this.id = id;
		this.name = name;
		this.model = model;
	}

	public GoodsModelPO(GoodsModelVO goodsVO) {
		this.signal = goodsVO.getSignal();
		this.amount = goodsVO.getAmount();
		this.id = goodsVO.getId();
		this.name = goodsVO.getName();
		this.model = goodsVO.getModel();
		this.everHas = goodsVO.isEverHas();
		this.gift = goodsVO.isGift();
	}

	int amount;
	int signal;
	String id;//id = type + model
	String name;
	String model;
	public String getModel() {
		return model;
	}

	boolean everHas;
	boolean gift;
	
	double lastInPrice;
	
	double lastOutPrice;
	
	@Override
	public String toString() {
		return id+" "+amount+" "+signal;
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
	
	public boolean isEverHas() {
		return everHas;
	}
	public void setEverHas(boolean everHas) {
		this.everHas = everHas;
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

	public int getAver_in() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
