package vo;

public class CashReceiptVO extends ReceiptVO {
	public String operator;
	public double total=0;
	public CashReceiptVO(String num,String operator,double total){
		number=num;
		this.operator=operator;
		this.total=total;
	}
	public CashReceiptVO(){
		
	}
}
