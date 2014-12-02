package po;

import java.io.Serializable;

public class RepositoryPO implements Serializable {
	String batch;
	String batchNum;
	GoodsListPO now;
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getBatchNum() {
		return batchNum;
	}
	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
	}
	public GoodsListPO getNow() {
		return now;
	}
	public void setNow(GoodsListPO now) {
		this.now = now;
	}
}
