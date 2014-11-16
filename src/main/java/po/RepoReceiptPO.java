package po;
/**
 * Edited by dzh,add extension,11.12
 *
 */
public class RepoReceiptPO extends ReceiptPO{
	
	public RepoReceiptPO(int a, int c) {
		actualNum = a;
		statisticNum = c;
	}
	
	int actualNum;
	int statisticNum;
	String type;
	
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
