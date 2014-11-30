package po;


import org.omg.PortableServer.POA;

/**
 * Created by MethyleneBlue on 2014/10/??.
 */

public class ItemPO {
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
	public double getAccount(){
		return amount;
	}
	public boolean equals(ItemPO po){
		return item.equals(po.getName());
	}
	public String getName(){
		return item;
	}
}
