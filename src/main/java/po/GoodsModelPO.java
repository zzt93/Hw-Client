package po;

public class GoodsModelPO {
	int signal;
	int amount;
	String id;
	boolean everHas;
	boolean gift;
	
	double lastInPrice;
	double lastOutPrice;
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
	
	
}
