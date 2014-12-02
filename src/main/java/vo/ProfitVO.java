package vo;

import java.io.Serializable;

public class ProfitVO implements Serializable {
	public double expense,earning,profit;
	public ProfitVO(double earning,double expense){
		this.expense=expense;
		this.earning=earning;
		this.profit=earning-expense;
	}
}
