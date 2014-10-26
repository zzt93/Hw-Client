package po;

import java.util.ArrayList;

public class TreeNodePO {
	String type;
	TreeNodePO fa;
	ArrayList<TreeNodePO> so;
	
	ArrayList<GoodsModelPO> goodsList;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public TreeNodePO getFa() {
		return fa;
	}

	public void setFa(TreeNodePO fa) {
		this.fa = fa;
	}

	public ArrayList<TreeNodePO> getSo() {
		return so;
	}

	public void setSo(ArrayList<TreeNodePO> so) {
		this.so = so;
	}

	public ArrayList<GoodsModelPO> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(ArrayList<GoodsModelPO> goodsList) {
		this.goodsList = goodsList;
	}
}
