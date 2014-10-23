package dataservice.GoodsListdataservice;

import java.util.ArrayList;

import po.RepoFilterPO;
import po.GoodsListPO;
import po.GoodsPO;

public interface GoodsListDataService {
	GoodsListPO getGoodsList();
	boolean initialize(GoodsListPO goodsListPO);
	boolean insert(GoodsPO goodsPO);
	boolean delete(GoodsPO goodsPO);
	boolean update(GoodsPO goodsPO);
	GoodsPO efind(String id);
	ArrayList<GoodsPO> ifind(RepoFilterPO filter);
}
