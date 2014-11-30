package po;

import vo.TreeNodeVO;

import java.util.ArrayList;

public class TreeNodePO {
	String type;
	
	/*
	 * this member is to record the type info up to now
	 */
	String type_so_far;
	
	TreeNodePO fa;
	ArrayList<TreeNodePO> sons = new ArrayList<TreeNodePO>();
	
	ArrayList<GoodsModelPO> goodsModels = new ArrayList<GoodsModelPO>();

	public TreeNodePO(TreeNodeVO fa) {
		type = "" + fa.getSons().size();
		type_so_far += type;
	}
	
	
	public TreeNodePO(TreeNodeVO fa2, String son_type) {
		type = son_type;
		type_so_far += type;
	}


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
	
	public boolean is_leaf() {
		return sons.isEmpty();
	}
	public boolean type_editable() {
		return is_leaf()&&(goodsModels.isEmpty());
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

	public ArrayList<TreeNodePO> getSons() {
		return sons;
	}

	public void setSons(ArrayList<TreeNodePO> so) {
		this.sons = so;
	}

	
	public String getType_so_far() {
		return type_so_far;
	}


	public void setType_so_far(String type_so_far) {
		this.type_so_far = type_so_far;
	}


	public ArrayList<GoodsModelPO> getGoodsModels() {
		return goodsModels;
	}


	public void setGoodsModels(ArrayList<GoodsModelPO> goodsModels) {
		this.goodsModels = goodsModels;
	}
}
