package vo;

public class GoodsRecordVO {
	public String time,client,goods,businessman,storage;
	public int number;
	public GoodsRecordVO(String goods,int number){
		this.number=number;
		time="2014/05/07";
		client="客户1";
		this.goods=goods;
		businessman="操作员1";
		storage="仓库1";
	}
}
