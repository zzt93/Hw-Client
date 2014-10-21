package PO;

import java.util.ArrayList;
import java.util.HashMap;

public class GoodsListPO {
	HashMap<String, GoodsModelPO> signalMap;
	
	/* Every GoodsPO in the list is a batch of goods
	 * a sum of every batch is the stock of the repository
	 */
	HashMap<String, ArrayList<GoodsPO>> goodsMap;
}
