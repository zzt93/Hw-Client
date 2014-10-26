package po;

import java.io.Serializable;

public class BankPO implements Serializable{
	String name;
	double account;
	String remark;
	public BankPO(String n,double a){
		this(n,a,null);
	}
	public BankPO(String n,double a,String r){
		name=n;
		account=a;
		remark=r;
	}
}
