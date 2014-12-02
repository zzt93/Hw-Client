package po;

import java.io.Serializable;

/**
 * Created by MethyleneBlue on 2014/10/??.
 */

public class BkTransPO implements Serializable {
	public String name;
	public double amount;
	public String remark;
	public BkTransPO(){
		this("测试账目",3000);
	}
	public BkTransPO(String name,double amount){
		this(name,amount,null);
	}
	public BkTransPO(String name,double amount,String remark){
		this.name=name;
		this.amount=amount;
		this.remark=remark;
	}
	public double getAmount(){
		return amount;
	}
	public String getName(){
		return name;
	}
	public String getRemark(){
		return remark;
	}
	public boolean equals(BkTransPO po){
		return name.equals(po.getName());
	}
}
