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

	int actualNum;
	int statisticNum;
	String goods_id;
	String operator;
	public RepoReceiptPO(String goods_id, int a, int c, String user) {
		
		this.goods_id = goods_id;
		actualNum = a;
		statisticNum = c;
		operator = user;
		super.type = ReceiptType.REPORECEIPT;
		super.time=new DateGetter().toString();
		
	}	
	
	public String getOperator(){
		return operator;
	}
	public String getDate() {
		return time;
	}
	
	public String getGoods_id() {
		return goods_id;
	}
	
	public String getReceipt_id() {
		return number;
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
