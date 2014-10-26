package vo;

public class BankVO {
	String name;
	public double account;
	String remark;
	public BankVO(String n,double a){
		this(n,a,null);
	}
	public BankVO(String n,double a,String r){
		name=n;
		account=a;
		remark=r;
	}
	
}
