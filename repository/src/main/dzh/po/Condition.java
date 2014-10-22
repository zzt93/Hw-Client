package po;

import java.util.ArrayList;

import blservice.Strategy.Goods;

enum catOfCondition{CUSTOMERLEVEL,COMPOSITION,TOTALPRICE}
public class Condition {
	catOfCondition type;
	
	public catOfCondition getType() {
		return type;
	}
	public void setType(catOfCondition type) {
		this.type = type;
	}
	public int getCustomerLevel() {
		return customerLevel;
	}
	public void setCustomerLevel(int customerLevel) {
		this.customerLevel = customerLevel;
	}
	public ArrayList<Goods> getComposition() {
		return composition;
	}
	public void setComposition(ArrayList<Goods> composition) {
		this.composition = composition;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	int customerLevel;
	ArrayList<Goods> composition;
	int totalPrice;
}
