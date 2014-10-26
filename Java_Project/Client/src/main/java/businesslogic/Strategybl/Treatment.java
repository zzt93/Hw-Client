package businesslogic.Strategybl;

import java.util.ArrayList;

import po.GoodsPO;


public class Treatment {
	CatOfTreatment type;
	ArrayList<GoodsPO> give;
	double discount;
	double coupon;
	
	


	@SuppressWarnings("unchecked")
	public Treatment(CatOfTreatment type, Object E) {
		super();
		this.type = type;
		switch(type){
		case COUPON:
			this.coupon = (Double)E;
			break;
		case DISCOUNT:
			this.discount = (Double)E;
			break;
		case GIVE:
			this.give = (ArrayList<GoodsPO>)E;
			break;
		default:
			break;
		}

	}
	public CatOfTreatment getType() {
		return type;
	}
	public Treatment(){
		this(CatOfTreatment.COUPON,0);
	}
	
	
	public void setType(CatOfTreatment type) {
		this.type = type;
	}
	public ArrayList<GoodsPO> getGive() {
		return give;
	}
	public void setGive(ArrayList<GoodsPO> give) {
		this.give = give;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public double getCoupon() {
		return coupon;
	}
	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}
}
