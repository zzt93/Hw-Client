package po;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * 
 * @author Mebleyev.G.Longinus
 *
 */
public class Condition implements Serializable {
	public CatOfCondition type;
	public int customerLevel;
	public ArrayList<GoodsPO> composition;
	public double totalPrice;
	
	
/*	public Condition(CatOfCondition type, int customerLevel) {
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
	*/

	@SuppressWarnings("unchecked")
	public Condition(CatOfCondition type,Object E){
		super();
		this.type = type;
		switch(type){
		case TOTALPRICE:
			this.totalPrice = (Double)E;
			break;
		case CUSTOMERLEVEL:
			this.customerLevel = (Integer)E;
			break;
		case COMPOSITION:
			this.composition = (ArrayList<GoodsPO>)E;
			break;
		default:
			break;
		}

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
