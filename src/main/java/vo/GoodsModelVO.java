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

	public String getType() {
		return type;
	}

	String type;
	private static final long serialVersionUID = 1L;

	boolean everHas;
	boolean gift;
	
	double lastInPrice;
	double lastOutPrice;

	public double getDefault_in() {
		return default_in;
	}
	public void setDefault_in(double in){
		default_in = in;
	}
	public void setDefault_out(double default_out){
		this.default_out = default_out;
	}
	public double getDefault_out(){
		return default_in;
	}
	double default_in;
	double default_out;

	public GoodsModelVO(GoodsModelPO goodsModelPO) {
		this.signal = goodsModelPO.getSignal();
		this.amount = goodsModelPO.getAmount();
		this.id = goodsModelPO.getId();
		this.name = goodsModelPO.getName();
		this.model = goodsModelPO.getModel();
		this.everHas = goodsModelPO.isEverHas();
		this.gift = goodsModelPO.isGift();

		this.default_in = goodsModelPO.getDefault_in();
		this.default_out = goodsModelPO.getDefault_out();
		this.lastInPrice = goodsModelPO.getLastInPrice();
		this.lastOutPrice = goodsModelPO.getLastOutPrice();
	}
	public GoodsModelVO(String type, String id, String name, String model) {
		this.type = type;
		this.id = id;
		this.name = name;
		this.model = model;
		
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
