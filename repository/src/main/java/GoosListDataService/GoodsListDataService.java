package GoosListDataService;

import java.util.ArrayList;

import PO.RepoFilterPO;
import PO.GoodsListPO;
import PO.GoodsPO;

public interface GoodsListDataService {
	GoodsListPO getGoodsList();
	boolean initialize(GoodsListPO goodsListPO);
	boolean insert(GoodsPO goodsPO);
	boolean delete(GoodsPO goodsPO);
	boolean update(GoodsPO goodsPO);
	GoodsPO efind(String id);
	ArrayList<GoodsPO> ifind(RepoFilterPO filter);
}
