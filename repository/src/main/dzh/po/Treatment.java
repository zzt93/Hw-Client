package po;

import java.util.ArrayList;

import blservice.Strategy.Goods;

enum catOfTreatment{GIVE,DISCOUNT,COUPON}
public class Treatment {
	catOfTreatment type;
	ArrayList<Goods> give;
	int discount;
	int coupon;
	public catOfTreatment getType() {
		return type;
	}
	public void setType(catOfTreatment type) {
		this.type = type;
	}
	public ArrayList<Goods> getGive() {
		return give;
	}
	public void setGive(ArrayList<Goods> give) {
		this.give = give;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getCoupon() {
		return coupon;
	}
	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}
}
