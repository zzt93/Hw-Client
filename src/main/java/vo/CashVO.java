package vo;

public class CashVO extends ReceiptVO {
	public String operator;
	public double total=0;
	public ItemVO[] itemList;
	public CashVO(String num,String operator,ItemVO[] ItemList,double total){
		this.itemList=ItemList;
		number=num;
		this.operator=operator;
		this.total=total;
	}
	public CashVO(){
		
	}
}
