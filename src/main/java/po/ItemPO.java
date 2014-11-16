package po;

import org.omg.PortableServer.POA;

import vo.ItemVO;

public class ItemPO {
	String item,remark;
	double account;
	public ItemPO(String i,double a,String r){
		item=i;
		account=a;
		remark=r;
	}
	public ItemPO(ItemVO vo){
		item=vo.item;
		account=vo.account;
		remark=vo.remark;
	}
	public double getAccount(){
		return account;
	}
	public boolean equals(ItemPO po){
		return item.equals(po.getName());
	}
	public String getName(){
		return item;
	}
}
