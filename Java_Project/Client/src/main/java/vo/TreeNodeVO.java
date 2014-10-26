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
	String info;
	TreeNodeVO father;
	ArrayList<TreeNodeVO> sons;
}
