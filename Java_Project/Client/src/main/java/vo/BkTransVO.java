package vo;

import po.BankPO;

public class BkTransVO {
	public String name;
	public double account;
	public String remark;
	public BkTransVO(){
		this("测试账目",3000);
	}
	public BkTransVO(String name,double account){
		this(name,account,null);
	}
	public BkTransVO(String name,double account,String remark){
		this.name=name;
		this.account=account;
		this.remark=remark;
	}

}
