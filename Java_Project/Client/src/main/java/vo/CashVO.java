package vo;

public class CashVO extends ReceiptVO {
	public String operator;
	public double total=0;
	public ItemVO[] itemList;
	public CashVO(String n,String o,ItemVO[] vo){
		itemList=vo;
		number=n;
		operator=o;
		for(int i=0;i<itemList.length;i++){
			total+=itemList[i].account;
		}
	}
}
