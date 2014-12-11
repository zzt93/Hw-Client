package businesslogic.FinancialReceiptbl;

import po.BkTransPO;

import java.util.ArrayList;

public class BankList {
	ArrayList<BkTransPO> list=new ArrayList<BkTransPO>();
	double total=0;
	public void add(BkTransPO po){
		total+=po.getAmount();
		list.add(po);
	}
	public void delete(BkTransPO po){
		BkTransPO temp;
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
		BkTransPO temp=list.remove(i);
		total-=temp.getAmount();
	}
	public double getTotal(){
		return total;
	}
	public void clear(){
		list.clear();
		total=0;
	}
	public BkTransPO[] getData(){
		BkTransPO[] data=new BkTransPO[list.size()];
		for(int i=0;i<list.size();i++){
			data[i]=list.get(i);
		}
		return data;
	}
}
