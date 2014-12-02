package vo;

import java.io.Serializable;

public class ProfitVO implements Serializable {
	public double expense,earning,profit;
	private static final long serialVersionUID = 1L;
	public ProfitVO(double earning,double expense){
		this.expense=expense;
		this.earning=earning;
		this.profit=earning-expense;
	}
}
