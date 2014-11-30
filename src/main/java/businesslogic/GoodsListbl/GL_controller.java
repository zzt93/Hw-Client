package businesslogic.GoodsListbl;

import businesslogic.GoodsTypebl.GT_controller;
import businesslogicservice.GoodsListblservice.*;
import dataservice.GoodsListdataservice.GoodsListDataService;
import po.GoodsListPO;
import po.GoodsModelPO;
import po.GoodsPO;
import po.RepoReceiptPO;
import vo.GoodsModelVO;
import vo.GoodsVO;
import vo.SignalVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

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
	
	/*
	 * for across modules
	 */
	GT_controller gt_controller ;
	
	public GT_controller getGt_controller() {
		return gt_controller;
	}

	public void setGt_controller(GT_controller gt_controller) {
		this.gt_controller = gt_controller;
	}

	public boolean save() throws RemoteException {
		return goodsListDataService.saveGoodsList(goodsListPO).getObj();
	}
	
	public void refresh() throws RemoteException {
		goodsListPO = new GoodsListDataImpl(null).getGoodsList().getObj();
	}

	// for glblservice
	public boolean delete(GoodsModelVO goods) throws Exception {
		boolean res = glbLservice.delete(goods);
		save();
		return res;
	}

	public ArrayList<GoodsModelVO> iSearch(String info) {
		ArrayList<GoodsModelVO> res = glbLservice.iSearch(info);
		return res;
	}

	
	public ArrayList<GoodsModelVO> iSearch(String[] infos){
		ArrayList<GoodsModelVO> res = glbLservice.iSearch(infos);
		
		return res;
	}

	public ArrayList<GoodsVO> eSearch_batch(String id){
		ArrayList<GoodsVO> res = glbLservice.eSearch_batch(id);
		return res;
	}

	public GoodsModelVO eSearch_total(String id){
		GoodsModelVO res = glbLservice.eSearch_total(id);
		return res;
	}


	public HashMap<String, ArrayList<GoodsVO>> batch_statistic() throws Exception {
		HashMap<String, ArrayList<GoodsVO>> res = glbLservice.batch_statistic();
		save();
		return res;
	}

	//for sale and stock
	public boolean checkGoodsExists(GoodsVO goodsVO) throws Exception {
		boolean res = gl_stock_BLservice.checkGoodsExists(goodsVO);
		save();
		return res;
	}

	public boolean addAmount(GoodsVO goods) throws Exception {
		boolean res = gl_stock_BLservice.addAmount(goods);
		save();
		return res;
	}

	public boolean addAmount(ArrayList<GoodsVO> goodsArrayList)
			throws Exception {
		boolean res = gl_stock_BLservice.addAmount(goodsArrayList);
		save();
		return res;
	}

	public boolean reduAmount(GoodsVO goods) throws Exception {
		boolean res = gl_stock_BLservice.reduAmount(goods);
		save();
		return res;
	}

	public boolean reduAmount(ArrayList<GoodsVO> goodsArrayList)
			throws Exception {
		boolean res = gl_stock_BLservice.reduAmount(goodsArrayList);
		save();
		return res;
	}

	
	/*
	 * for signal(non-Javadoc)
	 * @see businesslogicservice.GoodsListblservice.GL_signal_BLservice#checkSignalModifiable(vo.GoodsVO)
	 */
	public boolean checkSignalModifiable(GoodsVO goodsVO) throws Exception {
		boolean res = gl_signal_BLservice.checkSignalModifiable(goodsVO);
		save();
		return res;
	}

	public boolean setSignal(GoodsVO goods) throws Exception {
		boolean res = gl_signal_BLservice.setSignal(goods);
		save();
		return res; 
	}

	public int getSignal(GoodsVO goods) throws Exception {
		int res = gl_signal_BLservice.getSignal(goods);
		save();
		return res;
	}

	public SignalVO sendSignal(int amount, int signal, String id) throws Exception {
		SignalVO res = gl_signal_BLservice.sendSignal(amount, signal, id);
		save();
		return res;
	}

	//update is to check whether is lower than signal value
	//when stock or sales happen
	public boolean update_when_sale(GoodsVO goodsVO) throws Exception {
		boolean res = gl_signal_BLservice.update_when_sale(null);
		save();
		return res;
	}

	public boolean check_signal(GoodsVO goods) throws Exception {
		boolean res = gl_stock_BLservice.checkGoodsExists(goods);
		save();
		return res;
	}
	
	/*
	 *  for receipt(non-Javadoc)
	 * @see businesslogicservice.GoodsListblservice.GL_receipt_BLservice#check_rece(po.GoodsPO)
	 */
	public boolean check_rece(GoodsPO goods) throws Exception {
		boolean res = gl_stock_BLservice.checkGoodsExists(new GoodsVO(goods));
		save();
		return res;
	}

	public int amount(GoodsPO goods) throws Exception {
		int res = gl_receipt_BLservice.amount(goods);
		save();
		return res;
	}

	public void receiveRece(RepoReceiptPO receiptPO) throws Exception {
		gl_receipt_BLservice.receiveRece(receiptPO);
		save();
	}

	public GoodsModelPO getGoodsModelPO(String id) throws Exception {
		GoodsModelPO res = gl_receipt_BLservice.getGoodsModelPO(id);
		save();
		return res;
	}
	
	// for goodsType
	
	public boolean checkEverHas(String info) throws Exception {
		boolean res = gl_GT_BLservice.checkEverHas(info);
		save();
		return res;
	}

	public HashMap<String, GoodsModelPO> getGoodsModelPOs() {
		return goodsListPO.getGoodsModels();
	}

	
	// for account
	public GoodsListPO initialize(String account) throws Exception {
		goodsListPO = gl_account_BLservice.initialize(account);
		save();
		return goodsListPO;
	}

	/*
	 * (non-Javadoc)
	 * @see businesslogicservice.GoodsListblservice.GL_account_BLservice#add(vo.GoodsVO)
	 * they will be called both for blservice and account
	 */
	public boolean add(GoodsModelVO goodsVO) throws Exception {
		boolean res = glbLservice.add(goodsVO);
		goodsListDataService.insert(new GoodsModelPO(goodsVO));
		return res;
	}

	public boolean add(ArrayList<GoodsModelVO> goodsModelVOsVOs) throws Exception {
		boolean res = glbLservice.add(goodsModelVOsVOs);
		for (GoodsModelVO goodsModelVO : goodsModelVOsVOs) {
			goodsListDataService.insert(new GoodsModelPO(goodsModelVO));
		}
		return res;
	}

	public String getDatabase(String account) throws Exception {
		String res = gl_account_BLservice.getDatabase(account);
		save();
		return res;
	}

	public HashMap<String, GoodsModelVO> getGoodsModelVOs() throws Exception {
		HashMap<String, GoodsModelVO> res = glbLservice.getGoodsModelVOs();
		save();
		return res;
	}

	/*
	 * for goodsList ui
	 */
	public ArrayList<String> addable_type() throws Exception {
		return gt_controller.addable_type();
	}

	@Override
	public ArrayList<String> sell_type() {
		return gl_stock_BLservice.sell_type();
	}

	@Override
	public ArrayList<String> stock_type() {
		return gl_stock_BLservice.stock_type();
	}

	@Override
	public ArrayList<String> type_del() {
		return glbLservice.type_del();
		
	}
	
}
