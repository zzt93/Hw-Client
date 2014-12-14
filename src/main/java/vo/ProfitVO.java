package vo;

import java.io.Serializable;

public class ProfitVO implements Serializable {
	public double expense,income,profit,actualIncome;
	public double saleIncome,saleCost,goodsOverflow,goodsLost,
	costAdjust,stockDiffer,couponDiffer,discount,giftCost;
	private static final long serialVersionUID = 1L;
	public ProfitVO(double income,double expense){
		this.expense=expense;
		this.income=income;
		this.profit=income-expense;
	}
	public ProfitVO(){
		
	}
	public void calculate(){
		income=saleIncome+goodsOverflow+costAdjust+stockDiffer+couponDiffer;
		actualIncome=income-discount;
		expense=saleCost+goodsLost+giftCost;
		profit=actualIncome-expense;
	}
}
