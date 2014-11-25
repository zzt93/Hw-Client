package po;

public class GoodsModelPO {
	
	public GoodsModelPO(String id) {
		this.id = id;
	}

	int amount;
	int signal;
	String id;//id = type + model
	boolean everHas;
	boolean gift;
	
	double lastInPrice;
	
	double lastOutPrice;
	
	double aver_in;
	
	@Override
	public String toString() {
		return id+amount+signal;
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
	
	public double getAver_in() {
		return aver_in;
	}

}
