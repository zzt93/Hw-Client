package po;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;


public class RepoPO {
	static Random random = new Random();
	static int count = 0;
	
	public class RepoGoods {
		public RepoGoods(GoodsModelPO goodsModelPO, ArrayList<GoodsPO> arrayList) {
			amount = goodsModelPO.getAmount();
			aver_price = goodsModelPO.getAver_in();
			//TODO whose name and model
			name = arrayList.get(0).name;
			model = arrayList.get(0).model;
		}
		String name;
		String model;
		int amount;
		double aver_price;
	}
	
	public RepoPO(GoodsListPO tem) {
		count ++;
		date = new Date().toString();
		batch = random.nextLong();
		batchNum = Integer.toHexString(count);
		
		HashMap<String, GoodsModelPO> goodsModel = tem.getGoodsModels();
		HashMap<String, ArrayList<GoodsPO>> goodsHashMap = tem.getGoods();
		for (String id : goodsModel.keySet()) {
			if (goodsModel.get(id).getAmount() > 0) {
				repoGoods.put(id, new RepoGoods(goodsModel.get(id), goodsHashMap.get(id)));
			}
		}
	}
	
	HashMap<String, RepoGoods> repoGoods;
	long batch;
	String batchNum;
	String date;
	
	public long getBatch() {
		return batch;
	}

	public String getBatchNum() {
		return batchNum;
	}

	public HashMap<String, RepoGoods> getRepoGoods() {
		return repoGoods;
	}

	
	
}
