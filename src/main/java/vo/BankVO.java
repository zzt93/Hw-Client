package vo;

public class BankVO {
	public String name;
	public double account;
	public String remark;
	public BankVO(String name,double account){
		this(name,account,null);
	}
	public BankVO(String name,double account,String remark){
		this.name=name;
		this.account=account;
		this.remark=remark;
	}
	
}
