package businesslogic.GoodsListbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import dataservice.GoodsListdataservice.GoodsListDataService;
import po.GoodsListPO;
import po.GoodsModelPO;
import po.ResultMesPO;
import vo.GoodsModelVO;
import vo.GoodsVO;
import vo.SignalVO;
import businesslogicservice.GoodsListblservice.GLBLservice;
import businesslogicservice.GoodsListblservice.GL_GT_BLservice;
import businesslogicservice.GoodsListblservice.GL_account_BLservice;
import businesslogicservice.GoodsListblservice.GL_receipt_BLservice;
import businesslogicservice.GoodsListblservice.GL_signal_BLservice;
import businesslogicservice.GoodsListblservice.GL_stock_BLservice;

public class GL_controller implements GL_account_BLservice, GL_GT_BLservice,
		 GL_receipt_BLservice, GL_signal_BLservice, GL_stock_BLservice, GLBLservice {
	
	GoodsListDataService goodsListDataService = new GoodsListDataImpl(null);
	
	public GL_controller() throws RemoteException {
		goodsListPO = goodsListDataService.getGoodsList().getObj();

		// TODO add account name
		glbLservice = new GLBLImpl(goodsListPO);
		gl_signal_BLservice = new GL_signal_Impl(goodsListPO);
		gl_GT_BLservice = new GL_GT_Impl(goodsListPO);

		gl_stock_BLservice = new GL_stock_rece_Impl(goodsListPO);
		gl_receipt_BLservice = new GL_stock_rece_Impl(goodsListPO);
		gl_account_BLservice = new GL_account_Impl(goodsListPO);
	}
	GoodsListPO goodsListPO;
	
	GLBLservice glbLservice ;
	GL_signal_BLservice gl_signal_BLservice ;
	GL_GT_BLservice gl_GT_BLservice ;

	GL_stock_BLservice gl_stock_BLservice ;
	GL_receipt_BLservice gl_receipt_BLservice ;
	GL_account_BLservice gl_account_BLservice ;
	
	public boolean save() throws Exception {
		return glbLservice.save();
	}

	public boolean delete(GoodsVO goods) throws Exception {
		return glbLservice.delete(goods);
	}

	public ArrayList<GoodsVO> iSearch(String info) throws Exception {
		return glbLservice.iSearch(info);
	}

	public ArrayList<GoodsVO> iSearch(int amount) throws Exception {
		return glbLservice.iSearch(amount);
	}

	public ArrayList<GoodsVO> iSearch(String[] infos) throws Exception {
		return glbLservice.iSearch(infos);
	}

	public ArrayList<GoodsVO> eSearch(String id) throws Exception {
		return glbLservice.eSearch(id);
	}

	public boolean update(GoodsVO goods) throws Exception {
		return glbLservice.update(goods);
	}

	public HashMap<String, ArrayList<GoodsVO>> show() throws Exception {
		return glbLservice.show();
	}

	//for sale and stock
	public boolean checkGoodsExists(GoodsVO goodsVO) throws Exception {
		return gl_stock_BLservice.checkGoodsExists(goodsVO);
	}

	public boolean addAmount(GoodsVO goods) throws Exception {
		return gl_stock_BLservice.addAmount(goods);
	}

	public boolean addAmount(ArrayList<GoodsVO> goodsArrayList)
			throws Exception {
		return gl_stock_BLservice.addAmount(goodsArrayList);
	}

	public boolean reduAmount(GoodsVO goods) throws Exception {
		return gl_stock_BLservice.reduAmount(goods);
	}

	public boolean reduAmount(ArrayList<GoodsVO> goodsArrayList)
			throws Exception {
		return gl_stock_BLservice.reduAmount(goodsArrayList);
	}

	
	//for signal
	public boolean checkSignalModifiable(GoodsVO goodsVO) {
		return gl_signal_BLservice.checkSignalModifiable(goodsVO);
	}

	public boolean setSignal(GoodsVO goods, int amount) throws Exception {
		return gl_signal_BLservice.setSignal(goods, amount);
	}

	public boolean getSignal(GoodsVO goods) throws Exception {
		return gl_signal_BLservice.getSignal(goods);
	}

	public SignalVO sendSignal() {
		return gl_signal_BLservice.sendSignal();
	}

	//update is to check whether is lower than signal value
	//when stock or sales happen
	public ResultMesPO update() throws Exception {
		return gl_signal_BLservice.update();
	}

	
	// for receipt
	public boolean check(GoodsVO goods) throws Exception {
		return gl_receipt_BLservice.check(goods);
	}

	public ArrayList<GoodsModelPO> getGoodsModelPOs() throws Exception {
		return gl_receipt_BLservice.getGoodsModelPOs();
	}

	public int amount(GoodsVO goods) throws Exception {
		return gl_receipt_BLservice.amount(goods);
	}

	
	// for goodsType
	public boolean checkAdd(String info) throws Exception {
		return gl_GT_BLservice.checkAdd(info);
	}

	public boolean checkEverHas(String info) throws Exception {
		return gl_GT_BLservice.checkEverHas(info);
	}

	public HashMap<String, ArrayList<GoodsModelVO>> getGoodsModels() {
		return gl_GT_BLservice.getGoodsModels();
	}

	public void notifyBT() {
		gl_GT_BLservice.notifyBT();

	}

	
	// for account
	public void initialize(String account) throws Exception {
		gl_account_BLservice.initialize(account);

	}

	public boolean add(GoodsVO goodsVO) throws Exception {
		return gl_account_BLservice.add(goodsVO);
	}

	public boolean add(ArrayList<GoodsVO> goodsVOs) throws Exception {
		return gl_account_BLservice.add(goodsVOs);
	}

	public String getDatabase(String account) throws Exception {
		return gl_account_BLservice.getDatabase(account);
	}

}
