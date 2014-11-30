package businesslogic.SetAccountbl;

import vo.GoodsVO;

import java.util.ArrayList;

public class GoodsList {
	ArrayList<GoodsVO> list=new ArrayList<GoodsVO>();
	
	public GoodsVO add(GoodsVO vo){
		GoodsVO temp=check(vo);
		list.add(temp);
		return temp;
	}
	public void delete(GoodsVO vo){
		GoodsVO temp;
		for(int i=0;i<list.size();i++){
			temp=list.get(i);
			if(temp.equals(vo)){
				list.remove(i);
				break;
			}
		}
		
	}
	private GoodsVO check(GoodsVO vo){
		//查询列表中是已有
		//查询上一个账目是否有该银行账户，有则同步
		return vo;
	}
	public GoodsVO[] get(){
		GoodsVO[] result=new GoodsVO[list.size()];
		for(int i=0;i<list.size();i++){
			result[i]=list.get(i);
		}
		return result;
	}
}
