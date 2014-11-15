package po;

import java.util.ArrayList;
import java.util.HashMap;

public class GoodsTypePO {
	ArrayList<TreeNodePO> goodsType;
	//record the node that has goods -- show the goods at the ui of a node
	HashMap<TreeNodePO, GoodsModelPO> type_goodsMap;
	//record the name of node that can add goods -- GLBL.add
	String leafNode;

	public HashMap<TreeNodePO, GoodsModelPO> getType_goodsMap() {
		return type_goodsMap;
	}

	public void setType_goodsMap(HashMap<TreeNodePO, GoodsModelPO> type_goodsMap) {
		this.type_goodsMap = type_goodsMap;
	}

	public ArrayList<TreeNodePO> getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(ArrayList<TreeNodePO> goodsType) {
		this.goodsType = goodsType;
	}
}
