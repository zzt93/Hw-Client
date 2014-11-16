package businesslogic.FinancialReceiptbl;

import java.util.ArrayList;

import po.BkTransPO;

public class BankList {
	ArrayList<BkTransPO> list=new ArrayList<BkTransPO>();
	double total=0;
	public void add(BkTransPO po){
		total+=po.getAccount();
		list.add(po);
	}
	public void delete(BkTransPO po){
		BkTransPO temp;
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
	public BkTransPO[] getData(){
		BkTransPO[] data=new BkTransPO[list.size()];
		for(int i=0;i<list.size();i++){
			data[i]=list.get(i);
		}
		return data;
	}
}