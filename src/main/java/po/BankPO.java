package po;

import vo.BankVO;
/**
 * Created by MethyleneBlue on 2014/10/??.
 */


import java.io.Serializable;

public class BankPO implements Serializable{
	private static final long serialVersionUID = 1L;
	String name;
	double balance;
	String remark;
	public BankPO(BankVO bank){
		name=bank.name;
		balance=bank.balance;
		remark=bank.remark;
	}
	public BankPO(){
		this(new BankVO());
	}
	public String getName(){
		return name;
	}
	public double getBalance(){
		return balance;
	}
	public String getRemark(){
		return remark;
	}
}
