package vo;

public class ProfitVO {
	public double expense,earning,profit;
	public ProfitVO(double earning,double expense){
		this.expense=expense;
		this.earning=earning;
		this.profit=earning-expense;
	}
}
