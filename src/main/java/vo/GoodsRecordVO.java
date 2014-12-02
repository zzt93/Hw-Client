package vo;

import po.ReceiptType;

import java.io.Serializable;

public class GoodsRecordVO implements Serializable {
	public String time,goods,goodsType;
	public int number;
	public double price,total;
	public ReceiptType type;
	public GoodsRecordVO(){
		goods="测试商品";
	}
}
