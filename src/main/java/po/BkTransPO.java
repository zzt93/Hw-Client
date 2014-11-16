package po;


public class BkTransPO {
	public String name;
	public double account;
	public String remark;
	public BkTransPO(){
		this("测试账目",3000);
	}
	public BkTransPO(String name,double account){
		this(name,account,null);
	}
	public BkTransPO(String name,double account,String remark){
		this.name=name;
		this.account=account;
		this.remark=remark;
	}
	public double getAccount(){
		return account;
	}
	public String getName(){
		return name;
	}
	public boolean equals(BkTransPO po){
		return name.equals(po.getName());
	}
}
