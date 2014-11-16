package businesslogic.SetAccountbl;

import po.ClientPO;
import po.ResultMessage;
import vo.BankVO;
import vo.GoodsVO;

public class SetAccount {
	public void inherit(String name,String account)throws Exception{
		//继承上一账目的表，各数据库拷贝
		setup(name);
	}
	public ResultMessage setGoodsType(){
		//建立商品类型表
		return null;
	}
	public ResultMessage creatGoods(GoodsVO[] goods,String name){
		//建立新的商品表
		return null;
	}
	public ResultMessage creatClient(ClientPO[] client,String name){
		//建立新的客户表
		return null;
	}
	public ResultMessage creatBank(BankVO[] bank,String name){
		//建立新的银行表
		return null;
	}
	public void setup(String name)throws Exception{
		//拷贝期初信息
		//更换系统账目
	}
	public void checkGoodsType(String name){
		//查看期初商品分类
	}
	public ResultMessage<GoodsVO[]> checkGoods(String name){
		//查看期初商品
		return new ResultMessage<GoodsVO[]>("未实现",null);
	}
	public ResultMessage<ClientPO[]> checkClient(String name){
		//查看期初客户
		return new ResultMessage<ClientPO[]>("未实现",null);
	}
	public ResultMessage<BankVO[]> checkBank(String name){
		//查看期初银行
		return new ResultMessage<BankVO[]>("未实现",null);
	}
	private ResultMessage changeAccount(String account){
		return new  ResultMessage("尚未实现",null);
	}
	private ResultMessage<String> getAccount(){
		return new  ResultMessage("尚未实现",null);
	}
}
