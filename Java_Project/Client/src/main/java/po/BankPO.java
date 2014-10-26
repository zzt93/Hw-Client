package po;

import java.io.Serializable;

import vo.BankVO;

public class BankPO implements Serializable{
	String name;
	double account;
	String remark;
	public BankPO(BankVO bank){
		name=bank.name;
		account=bank.account;
		remark=bank.remark;
	}
}
