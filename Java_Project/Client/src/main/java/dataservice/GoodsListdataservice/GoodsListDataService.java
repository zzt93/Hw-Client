package dataservice.GoodsListdataservice;

import java.util.ArrayList;

import po.RepoFilterPO;
import po.GoodsListPO;
import po.GoodsPO;

public interface GoodsListDataService {
	GoodsListPO getGoodsList() throws Exception;
	boolean initialize(GoodsListPO goodsListPO) throws Exception;
	boolean insert(GoodsPO goodsPO) throws Exception;
	boolean delete(GoodsPO goodsPO) throws Exception;
	boolean update(GoodsPO goodsPO) throws Exception;
	GoodsPO efind(String id) throws Exception;
	ArrayList<GoodsPO> ifind(RepoFilterPO filter) throws Exception;
}
