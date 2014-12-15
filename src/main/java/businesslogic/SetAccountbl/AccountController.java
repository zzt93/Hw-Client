package businesslogic.SetAccountbl;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import businesslogic.BankManagebl.BankController;
//import businesslogic.BankManagebl.BankControllerTest;
import businesslogic.Clientbl.ClientUtilityImpl;
import businesslogic.GoodsListbl.GL_controller;
import businesslogic.GoodsTypebl.GT_controller;
import businesslogicservice.SetAccountblservice.SetAccountblservice;
import po.ClientPO;
import po.ResultMessage;
import vo.BankVO;
import vo.GoodsModelVO;
import vo.GoodsVO;

public class AccountController implements SetAccountblservice {
	SetAccount setAccount=new SetAccount();
	BankList bankList=new BankList();
	ClientList clientList=new ClientList();
	GoodsList goodsList=new GoodsList();
	GT_controller GTcontroller;
	ClientUtilityImpl clientController;
	GL_controller goodsController;
	BankController bankController;
	public AccountController() throws RemoteException, NullPointerException, NotBoundException{
		GTcontroller=new GT_controller();
	}
	@Override
	public void inherit(String name, String account) throws Exception {
		setAccount.inherit(name, account);
	}

	@Override
	public void setGoodsType() throws Exception {
		//待定
		
	}

	public void creatGoods(GoodsVO[] list,String name) throws Exception {
		ResultMessage result=setAccount.creatGoods(goodsList.get(), name);
		result.throwIfFailed();
	}

	@Override
	public void creatClient(ClientPO[] list,String name) throws Exception {
		ResultMessage result=setAccount.creatClient(clientList.get(),name);
		result.throwIfFailed();
	}

	@Override
	public void creatBank(BankVO[] list ,String name) throws Exception {
		ResultMessage result=setAccount.creatBank(bankList.get(),name);
		result.throwIfFailed();

	}

	@Override
	public void setup(String name) throws Exception {
		setAccount.setup(name);
	}

	@Override
	public void checkGoodsType(String name) throws Exception {
		//待定
	}

	@Override
	public GoodsVO[] checkGoods(String name) throws Exception {
		ResultMessage result=setAccount.checkGoods(name);
		result.throwIfFailed();
		return (GoodsVO[])result.getObj();
	}

	@Override
	public ClientPO[] checkClient(String name) throws Exception {
		ResultMessage result=setAccount.checkClient(name);
		result.throwIfFailed();
		return (ClientPO[])result.getObj();
	}

	@Override
	public BankVO[] checkBank(String name) throws Exception {
		ResultMessage result=setAccount.checkBank(name);
		result.throwIfFailed();
		return (BankVO[])result.getObj();
	}

	@Override
	public GoodsVO addGoods(GoodsVO vo) throws Exception {
		return goodsList.add(vo);
	}

	@Override
	public void delGoods(GoodsVO vo) {
		goodsList.delete(vo);

	}

	@Override
	public BankVO addBank(BankVO vo) throws Exception {
		return bankList.add(vo);
	}

	@Override
	public void delBank(BankVO vo) {
		bankList.delete(vo);

	}

	@Override
	public ClientPO addClient(ClientPO po) throws Exception {
		return clientList.add(po);
	}

	@Override
	public void delClient(ClientPO po) {
		clientList.delete(po);

	}
	
	public void getClient(){
		//TODO,获得客户应收应付;
		
	}
	public String[] getGoodsType() throws RemoteException{
		//TODO,获得商品分类
		List<String> type=GTcontroller.addable_type();
		return type.toArray(new String[type.size()]);
		
	}
	public void creatClient(List<ClientPO> client) throws Exception{
		for(int i=0;i<client.size();i++){
			clientController.addClient(client.get(i));
		}
	}
	public void creatBank(List<BankVO> bank) throws Exception{
		for(int i=0;i<bank.size();i++){
			bankController.add(bank.get(i));
		}
	}
	public void creatGoods(List<GoodsModelVO> goods) throws Exception{
		for(int i=0;i<goods.size();i++){
			goodsController.add(goods.get(i));
		}
	}
	public String[] getAllAccount(){
		//TODO
		return null;
	}
	public String getAccount(){
		//TODO
		return null;
	}
	public void setAccount(String name){
		//TODO
	}

}
