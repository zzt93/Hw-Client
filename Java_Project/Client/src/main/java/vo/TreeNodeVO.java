package vo;

import java.util.ArrayList;

import po.TreeNodePO;

public class TreeNodeVO {
	
	public TreeNodeVO(TreeNodePO temNodePO) {
		// TODO Auto-generated constructor stub
	}
	public TreeNodeVO() {
		// TODO Auto-generated constructor stub
	}
	public TreeNodeVO(TreeNodeVO father){
		this.info = father.info + type;
	}
	
	String type;
	String info;
	TreeNodeVO father;
	ArrayList<TreeNodeVO> sons;
	ArrayList<GoodsModelVO> goodsModelVOs;
	
	
	
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
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
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
