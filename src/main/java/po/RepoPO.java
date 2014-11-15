package po;

import java.util.ArrayList;
import java.util.HashMap;

import po.GoodsPO;

public class RepoPO {
	long batch;
	String batchNum;
	
	HashMap<String, ArrayList<GoodsPO>> goodsListMap;
	public long getBatch() {
		return batch;
	}
	public void setBatch(long batch) {
		this.batch = batch;
	}
	public String getBatchNum() {
		return batchNum;
	}
	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
	}
	public HashMap<String, ArrayList<GoodsPO>> getGoodsListMap() {
		return goodsListMap;
	}
	public void setGoodsListMap(HashMap<String, ArrayList<GoodsPO>> goodsListMap) {
		this.goodsListMap = goodsListMap;
	}
}
