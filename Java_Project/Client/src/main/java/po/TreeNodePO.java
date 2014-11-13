package po;

import java.util.ArrayList;

import vo.TreeNodeVO;

public class TreeNodePO {
	String type;
	
	/*
	 * this member is to record the type info up to now
	 */
	String info;
	
	TreeNodePO fa;
	ArrayList<TreeNodePO> so;
	
	ArrayList<GoodsModelPO> goodsModels;

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	public TreeNodePO(TreeNodeVO treeNodeVO) {
		// TODO Auto-generated constructor stub
		
	}
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
		return goodsModels;
	}

	public void setGoodsList(ArrayList<GoodsModelPO> goodsList) {
		this.goodsModels = goodsList;
	}
}
