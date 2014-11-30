package po;

import vo.BankVO;

import java.io.Serializable;

public class BankPO implements Serializable{
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
