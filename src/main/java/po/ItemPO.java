package po;


import org.omg.PortableServer.POA;

import java.io.Serializable;

/**
 * Created by MethyleneBlue on 2014/10/??.
 */

public class ItemPO implements Serializable {
	private static final long serialVersionUID = 1L;
	String item,remark;
	double amount;
	public ItemPO(String item,double amount,String remark){
		this.item=item;
		this.amount=amount;
		this.remark=remark;
	}
	public ItemPO(String item,double amount){
		this(item,amount,null);
	}
	public double getAmount(){
		return amount;
	}
	public boolean equals(ItemPO po){
		return item.equals(po.getName());
	}
	public String getRemark(){
		return remark;
	}
	public String getName(){
		return item;
	}
	public void setAmount(double amount){
		this.amount=amount;
	}
}
