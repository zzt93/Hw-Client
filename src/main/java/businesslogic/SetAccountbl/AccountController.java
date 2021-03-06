package businesslogic.SetAccountbl;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dataservice.Clientdataservice.ClientDataService;
import dataservice.SetAccountdataservice.SetAccountdataservice;
import businesslogic.BankManagebl.BankController;
//import businesslogic.BankManagebl.BankControllerTest;
import businesslogic.Clientbl.ClientUtilityImpl;
import businesslogic.GoodsListbl.GL_controller;
import businesslogic.GoodsTypebl.GT_controller;
import businesslogicservice.SetAccountblservice.SetAccountblservice;
import po.BankPO;
import po.ClientPO;
import po.GoodsModelPO;
import po.ResultMessage;
import util.RMIUtility;
import vo.BankVO;
import vo.GoodsModelVO;
import vo.GoodsVO;

public class AccountController implements SetAccountblservice {
	private SetAccount setAccount=new SetAccount();
	private BankList bankList=new BankList();
	private ClientList clientList=new ClientList();
	private GoodsList goodsList=new GoodsList();
	private GT_controller GTcontroller;
	private ClientUtilityImpl clientController;
	private GL_controller goodsController;
	private BankController bankController;
	private static SetAccountdataservice dataService;
	public AccountController() throws Exception {
		  if (dataService == null)
	            dataService = (SetAccountdataservice) RMIUtility.getImpl("SetAccount");
		GTcontroller=new GT_controller();
		clientController=new ClientUtilityImpl();
		goodsController=new GL_controller();
		bankController=new BankController();
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
	
	public void getClientInfo(){
		//TODO,获得客户应收应付;
		
	}
	public void getGoodsInfo(){
		//TODO,获得商品进价售价;
	}
	public String[] getGoodsType() throws RemoteException{
		
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
	public void creatGoods(ArrayList<GoodsModelVO> goods) throws Exception{
		goodsController.add(goods);
	}
	public void setup(String name) throws Exception{
		ResultMessage result=dataService.setup(name);
		result.throwIfFailed();
	}
	public String[] getAllAccount()throws Exception{
		//TODO
		return null;
	}
	public String getDefaultAccount()throws Exception{
		//TODO
		return null;
	}
	public void setDefaultAccount(String name)throws Exception{
		//TODO
	}
	public void creatCopy() throws Exception{
		ResultMessage result=dataService.creatCopy();
		result.throwIfFailed();
	}
	public List<BankPO> checkBank() throws Exception{
		ResultMessage result=dataService.getBank();
		result.throwIfFailed();
		return (List<BankPO>)result.getObj();
	}
	public List<ClientPO> checkClient() throws Exception{
		ResultMessage result=dataService.getClient();
		result.throwIfFailed();
		return (List<ClientPO>)result.getObj();
	}
	public List<GoodsModelPO> checkGoods()throws Exception{
		ResultMessage result=dataService.getClient();
		result.throwIfFailed();
		return (List<GoodsModelPO>)result.getObj();
	}

}
