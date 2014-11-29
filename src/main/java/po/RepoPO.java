package po;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;


public class RepoPO {
	static Random random = new Random();
	static int count = 0;
	
	
	
	public RepoPO(GoodsListPO tem) {
		count ++;
		date = new Date().toString();
		batch = Math.abs(random.nextLong());
		batchNum = Integer.toHexString(count);
		
		HashMap<String, GoodsModelPO> goodsModel = tem.getGoodsModels();
		HashMap<String, ArrayList<GoodsPO>> goodsHashMap = tem.getGoods();
		for (String id : goodsModel.keySet()) {
			if (goodsModel.get(id).getAmount() > 0) {
				repoGoods.add(new RepoGoods(id, goodsModel.get(id), goodsHashMap.get(id)));
			}
		}
	}
	
	ArrayList<RepoGoods> repoGoods = new ArrayList<RepoGoods>();
	long batch;
	String batchNum;
	String date;
	
	public String getDate() {
		return date;
	}

	public long getBatch() {
		return batch;
	}

	public String getBatchNum() {
		return batchNum;
	}

	public ArrayList<RepoGoods> getRepoGoods() {
		return repoGoods;
	}

	
	
}
