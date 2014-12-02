package vo;

import po.BankPO;

import java.io.Serializable;

public class BankVO implements Serializable {
	public String name;
	public double balance;
	public String remark;
	public BankVO(){
		this("测试账目",3000);
	}
	public BankVO(String name,double balance){
		this(name,balance,null);
	}
	public BankVO(String name,double balance,String remark){
		this.name=name;
		this.balance=balance;
		this.remark=remark;
	}
	public BankVO(BankPO po){
		name=po.getName();
		balance=po.getBalance();
		remark=po.getRemark();
	}
	public boolean equals(BankVO vo){
		return vo.name.equals(name);
	}
	/*public static void main(String[] args){
		BankVO[] list1=new BankVO[1];
		BankVO[] list2=new BankVO[1];
		list1[0]=new BankVO();
		list2[0]=new BankVO();
		System.out.println(list1.equals(list1.clone()));
	}*/
	
}
