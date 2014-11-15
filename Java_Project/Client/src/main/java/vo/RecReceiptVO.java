package vo;

public class RecReceiptVO extends ReceiptVO{
	public String client,operator;
	public double total=0;
	public RecReceiptVO(String num,String client,String operator,double total){
		this.number=num;
		this.client=client;
		this.operator=operator;
		this.total=total;
	}
	public RecReceiptVO(){}
}
