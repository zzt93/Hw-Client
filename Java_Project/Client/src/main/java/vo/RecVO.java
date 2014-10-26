package vo;

public class RecVO extends ReceiptVO{
	public String client,operator;
	public BankVO[] bankList;
	public double total=0;
	public RecVO(String n,String c,String o,String t,BankVO[] vo){
		number=n;
		client=c;
		operator=c;
		bankList=vo;
		for(int i=0;i<bankList.length;i++){
			total+=bankList[i].account;
		}
	}
}
