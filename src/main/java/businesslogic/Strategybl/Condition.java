package businesslogic.Strategybl;

import java.util.ArrayList;

import po.GoodsPO;

public class Condition {
	public CatOfCondition type;
	int customerLevel;
	ArrayList<GoodsPO> composition;
	double totalPrice;
	
	
	public Condition(CatOfCondition type, int customerLevel) {
		super();
		this.type = type;
		this.customerLevel = customerLevel;
	}
	public Condition(CatOfCondition type, ArrayList<GoodsPO> composition) {
		super();
		this.type = type;
		this.composition = composition;
	}
	public Condition(CatOfCondition type, double totalPrice) {
		super();
		this.type = type;

		this.totalPrice = totalPrice;
	}
	public Condition(){
		this(CatOfCondition.CUSTOMERLEVEL,1);
	}
	public CatOfCondition getType() {
		return type;
	}
	public void setType(CatOfCondition type) {
		this.type = type;
	}
	public int getCustomerLevel() {
		return customerLevel;
	}
	public void setCustomerLevel(int customerLevel) {
		this.customerLevel = customerLevel;
	}
	public ArrayList<GoodsPO> getComposition() {
		return composition;
	}
	public void setComposition(ArrayList<GoodsPO> composition) {
		this.composition = composition;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

}
