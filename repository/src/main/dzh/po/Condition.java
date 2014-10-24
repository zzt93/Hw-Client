package dzh.po;

import java.util.ArrayList;

import dzh.blservice.Strategy.Goods;

enum catOfCondition{CUSTOMERLEVEL,COMPOSITION,TOTALPRICE}
public class Condition {
	public catOfCondition type;
	int customerLevel;
	ArrayList<Goods> composition;
	double totalPrice;
	
	
	public Condition(catOfCondition type, int customerLevel) {
		super();
		this.type = type;
		this.customerLevel = customerLevel;
	}
	public Condition(catOfCondition type, ArrayList<Goods> composition) {
		super();
		this.type = type;
		this.composition = composition;
	}
	public Condition(catOfCondition type, double totalPrice) {
		super();
		this.type = type;

		this.totalPrice = totalPrice;
	}
	public Condition(){
		this(catOfCondition.CUSTOMERLEVEL,1);
	}
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
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

}
