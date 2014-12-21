package businesslogic.FinancialReceiptbl;

import po.ItemPO;

import java.util.ArrayList;

public class ItemList {
	ArrayList<ItemPO> list=new ArrayList<ItemPO>();
	double total=0;
	public void add(ItemPO po){
		total+=po.getAmount();
		list.add(po);
	}
	public void delete(ItemPO po){
		ItemPO temp;
		for(int i=0;i<list.size();i++){
			temp=list.get(i);
			if(temp.equals(po)){
				total-=temp.getAmount();
				list.remove(i);
				return;
			}
		}
	}
	public void delete(int i){
		total-=list.get(i).getAmount();
		list.remove(i);
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
