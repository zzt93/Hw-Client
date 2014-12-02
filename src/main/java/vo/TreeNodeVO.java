package vo;

import po.TreeNodePO;

import java.io.Serializable;
import java.util.ArrayList;

public class TreeNodeVO implements Serializable {
	
	public TreeNodeVO(TreeNodePO temNodePO) {
		// TODO Auto-generated constructor stub
	}
	public TreeNodeVO(String type) {
		this.type = type;
	}
	public TreeNodeVO(TreeNodeVO father){
		this.type_so_far = father.type_so_far + type;
	}
	
	String type;
	String type_so_far;
	TreeNodeVO father;
	ArrayList<TreeNodeVO> sons = new ArrayList<TreeNodeVO>();
	ArrayList<GoodsModelVO> goodsModelVOs = new ArrayList<GoodsModelVO>();
	
	public String getType_so_far() {
		return type_so_far;
	}
	public void setType_so_far(String type_so_far) {
		this.type_so_far = type_so_far;
	}
	
	
	public boolean is_leaf(){
		return sons.isEmpty();
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
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ArrayList<GoodsModelVO> getGoodsModelVOs() {
		return goodsModelVOs;
	}
	public void setGoodsModelVOs(ArrayList<GoodsModelVO> goodsModelVOs) {
		this.goodsModelVOs = goodsModelVOs;
	}
	public String getInfo() {
		return type_so_far;
	}
	public void setInfo(String info) {
		this.type_so_far = info;
	}
	public TreeNodeVO getFather() {
		return father;
	}
	public void setFather(TreeNodeVO father) {
		this.father = father;
	}
	public ArrayList<TreeNodeVO> getSons() {
		return sons;
	}
	public void setSons(ArrayList<TreeNodeVO> sons) {
		this.sons = sons;
	}
	
	public String getId() {
		return type;
	}
	public void setId(String id) {
		this.type = id;
	}
	
}
