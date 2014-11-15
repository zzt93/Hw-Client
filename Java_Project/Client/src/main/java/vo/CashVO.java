package vo;

public class CashVO extends ReceiptVO {
	public String operator;
	public double total=0;
	public CashVO(String num,String operator,double total){
		number=num;
		this.operator=operator;
		this.total=total;
	}
	public CashVO(){
		
	}
}
