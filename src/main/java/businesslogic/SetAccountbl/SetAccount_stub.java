package businesslogic.SetAccountbl;

import po.ClientPO;
import vo.BankVO;
import vo.GoodsVO;
import businesslogicservice.SetAccountblservice.SetAccountblservice;

public class SetAccount_stub implements SetAccountblservice {

	public void inherit(String name, String accountName) throws Exception {
		if(name.equals(accountName)){
			System.out.println("账目名重复");
		}
		else
			System.out.println("继承成功");
	}

	public void setGoodsType() throws Exception {
		System.out.println("设置商品分类成功");
	}

	public void creatGoods(GoodsVO[] vo,String name) throws Exception {
		if(name==null){
			System.out.println("不存在该账目");
		}
		else{
			System.out.println("添加商品成功");
		}

	}

	public void creatClient(ClientPO[] po,String name) throws Exception {
		if(name==null){
			System.out.println("不存在该账目");
		}
		else{
			System.out.println("添加客户成功");
		}
	}

	public void creatBank(BankVO[] vo,String name) throws Exception {
		if(name==null){
			System.out.println("不存在该账目");
		}
		else{
			System.out.println("添加银行账户成功");
		}
	}

	public void setup(String name) throws Exception {
		if(name.equals("Exist")){
			System.out.println("账目名重复");
		}
		else{
			System.out.println("建立账目成功");
		}
	}

	public void checkGoodsType(String name) throws Exception {
		if(name==null){
			System.out.println("不存在该账目");
		}
		else{
			System.out.println("显示商品分类界面");
		}
	}

	public GoodsVO[] checkGoods(String name) throws Exception {
		if(name==null){
			System.out.println("不存在该账目");
			return null;
		}
		else{
			return new GoodsVO[5];
		}
	}

	public ClientPO[] checkClient(String name) throws Exception {
		if(name==null){
			System.out.println("不存在该账目");
			return null;
		}
		else{
			return new ClientPO[5];
		}
	}

	public BankVO[] checkBank(String name) throws Exception {
		if(name==null){
			System.out.println("不存在该账目");
			return null;
		}
		else{
			return new BankVO[5];
		}
	}

	public GoodsVO addGoods(GoodsVO vo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delGoods(GoodsVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BankVO addBank(BankVO vo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delBank(BankVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClientPO addClient(ClientPO po) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delClient(ClientPO po) {
		// TODO Auto-generated method stub
		
	}



}
