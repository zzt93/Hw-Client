package po;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zzt
 * 
 * Edited by dzh,add extension,11.12
 *
 */
public class RepoReceiptPO extends ReceiptPO implements Serializable {
	private static final long serialVersionUID = 1L;
	static long count = 0;

	public RepoReceiptPO(String id, int a, int c) {
		receipt_id = " "+ count++;
		this.goods_id = id;
		actualNum = a;
		statisticNum = c;
		
		super.type = ReceiptType.REPORECEIPT;
		super.time=new DateGetter().toString();
		
	}	
	int actualNum;
	int statisticNum;
	public String getDate() {
		return time;
	}
	String goods_id;
	public String getGoods_id() {
		return goods_id;
	}
	String receipt_id;
	
	public String getReceipt_id() {
		return receipt_id;
	}
	public int getaNum() {
		return actualNum;
	}
	public void setaNum(int aNum) {
		this.actualNum = aNum;
	}
	public int getcNum() {
		return statisticNum;
	}
	public void setcNum(int cNum) {
		this.statisticNum = cNum;
	}
	public ReceiptType getType() {
		return type;
	}
	public void setType(String type) {
		this.type = ReceiptType.valueOf(type);
	}
	
}
