package po;

import vo.TreeNodeVO;

import java.io.Serializable;
import java.util.ArrayList;

public class TreeNodePO implements Serializable {
	@Override
	public String toString() {
		return "TreeNodePO [type=" + type + "\n type_so_far=" + type_so_far
				+ "\n fa=" + fatherNode.type + "\n sons=" + sons + "]\n";
	}
	private static final long serialVersionUID = 1L;

	String type;
	
	/*
	 * this member is to record the type info up to now
	 */
	String type_so_far = "";
	
	TreeNodePO fatherNode;
	ArrayList<TreeNodePO> sons = new ArrayList<TreeNodePO>();
	
	ArrayList<GoodsModelPO> goodsModels = new ArrayList<GoodsModelPO>();

	public TreeNodePO(TreeNodePO fa) {
		this(fa, "");
		type = ""+(char)('A' + fa.getSons().size()-1);
		
	}
	
	
	public TreeNodePO(TreeNodePO fa2, String son_type) {
		type = son_type;
		type_so_far = fa2.getType_so_far() + type;
		fa2.getSons().add(this);
		this.fatherNode = fa2;
	}


	public TreeNodePO(String type) {
		this.type = type;
		this.type_so_far = type;
		fatherNode = null;
	}


	@Override
	public int hashCode() {
		return type_so_far.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		TreeNodePO temp = (TreeNodePO)obj;
		return type_so_far.equals(temp.getType_so_far());
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
		return fatherNode;
	}

	public void setFa(TreeNodePO fa) {
		this.fatherNode = fa;
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
