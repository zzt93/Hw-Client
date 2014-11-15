package vo;

public class PayVO extends ReceiptVO{
	public String client,operator;
	public double total=0;
	public PayVO(String num,String client,String operator,double total){
		this.number=num;
		this.client=client;
		this.operator=operator;
		this.total=total;
	}
	public PayVO(){}
}
