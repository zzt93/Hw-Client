package businesslogic.RunningTablebl;

import java.util.ArrayList;

public class ReceiptList<T>{
	ArrayList<T> list=new ArrayList<T>();
	public void add(T receipt){
		list.add(receipt);
	}
	public void adds(T[] receiptList){
		for(int i=0;i<receiptList.length;i++){
			list.add(receiptList[i]);
		}
	}
	public T get(int i){
		return list.get(i);
	}
}
