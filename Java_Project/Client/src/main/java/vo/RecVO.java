package vo;

public class RecVO extends ReceiptVO{
	public String client,operator;
	public BankVO[] bankList;
	public double total=0;
	public RecVO(String num,String client,String operator,BankVO[] bankList,double total){
		this.number=num;
		this.client=client;
		this.operator=operator;
		this.bankList=bankList;
		this.total=total;
	}
	public RecVO(){}
}
