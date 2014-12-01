package businesslogic.SetAccountbl;

import po.ClientPO;

import java.util.ArrayList;

public class ClientList {
ArrayList<ClientPO> list=new ArrayList<ClientPO>();
	
	public ClientPO add(ClientPO po){
		ClientPO temp=check(po);
		list.add(temp);
		return temp;
	}
	public void delete(ClientPO po){
		ClientPO temp;
		for(int i=0;i<list.size();i++){
			temp=list.get(i);
			if(temp.equals(po)){
				list.remove(i);
				break;
			}
		}
		
	}
	private ClientPO check(ClientPO po){
		//查询列表中是已有
		//查询上一个账目是否有该银行账户，有则同步
		return po;
	}
	public ClientPO[] get(){
		ClientPO[] result=new ClientPO[list.size()];
		for(int i=0;i<list.size();i++){
			result[i]=list.get(i);
		}
		return result;
	}
}
