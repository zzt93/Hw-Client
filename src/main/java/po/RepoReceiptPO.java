package po;

import java.util.Date;

/**
 * Created by zzt
 * 
 * Edited by dzh,add extension,11.12
 *
 */
public class RepoReceiptPO extends ReceiptPO{
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public RepoReceiptPO(String id, int a, int c) {
		this.id = id;
		actualNum = a;
		statisticNum = c;
		date = new Date().toString();
	}
	
	int actualNum;
	int statisticNum;
	String type;
	String date;
	String id;
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
