package po;

import java.io.Serializable;
import java.util.ArrayList;


public class Treatment implements Serializable {
	public CatOfTreatment type;
	public ArrayList<GoodsModelPO> give;
	public double discount;
	double coupon;
	private static final long serialVersionUID = 1L;
	


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
			this.give = (ArrayList<GoodsModelPO>)E;
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
	public ArrayList<GoodsModelPO> getGive() {
		return give;
	}
	public void setGive(ArrayList<GoodsModelPO> give) {
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
