package po;

public class RepoReceiptPO {
	
	public RepoReceiptPO() {
		// TODO Auto-generated constructor stub
	}
	public RepoReceiptPO(int a, int c) {
		aNum = a;
		cNum = c;
	}
	
	int aNum;
	int cNum;
	String type;
	
	public int getaNum() {
		return aNum;
	}
	public void setaNum(int aNum) {
		this.aNum = aNum;
	}
	public int getcNum() {
		return cNum;
	}
	public void setcNum(int cNum) {
		this.cNum = cNum;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
