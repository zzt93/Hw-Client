package businesslogic.SetAccountbl;

import java.util.ArrayList;

import vo.BankVO;

public class BankList {
	ArrayList<BankVO> list=new ArrayList<BankVO>();
	
	public BankVO add(BankVO vo){
		BankVO temp=check(vo);
		list.add(temp);
		return temp;
	}
	public void delete(BankVO vo){
		BankVO temp;
		for(int i=0;i<list.size();i++){
			temp=list.get(i);
			if(temp.equals(vo)){
				list.remove(i);
				break;
			}
		}
		
	}
	private BankVO check(BankVO vo){
		//查询列表中是已有
		//查询上一个账目是否有该银行账户，有则同步
		return vo;
	}
	public BankVO[] get(){
		BankVO[] result=new BankVO[list.size()];
		for(int i=0;i<list.size();i++){
			result[i]=list.get(i);
		}
		return result;
	}
}
