package businesslogic.FinancialReceiptbl;

import java.util.ArrayList;

import po.ItemPO;
import po.ItemPO;

public class ItemList {
	ArrayList<ItemPO> list=new ArrayList<ItemPO>();
	double total=0;
	public void add(ItemPO po){
		total+=po.getAccount();
		list.add(po);
	}
	public void delete(ItemPO po){
		ItemPO temp;
		for(int i=0;i<list.size();i++){
			temp=list.get(i);
			if(temp.equals(po)){
				total-=temp.getAccount();
				list.remove(i);
				return;
			}
		}
	}
	public double getTotal(){
		return total;
	}
	public void clear(){
		list.clear();
		total=0;
	}
	public ItemPO[] getData(){
		ItemPO[] data=new ItemPO[list.size()];
		for(int i=0;i<list.size();i++){
			data[i]=list.get(i);
		}
		return data;
	}
}
