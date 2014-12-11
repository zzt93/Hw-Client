package businesslogic.GoodsListbl;

import businesslogic.GoodsTypebl.GT_controller;
import businesslogicservice.GoodsListblservice.*;
import dataservice.GoodsListdataservice.GoodsListDataService;
import po.GoodsListPO;
import po.GoodsModelPO;
import po.GoodsPO;
import util.RMIUtility;
import vo.GoodsModelVO;
import vo.GoodsVO;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;


public class GL_controller implements GL_account_BLservice, GL_GT_BLservice,
		 GL_receipt_BLservice, GL_signal_BLservice, GL_stock_BLservice, GLBLservice {
	
	GoodsListDataService goodsListDataService;
	static String gl_service = "goodsListDataService";


	public GL_controller() throws RemoteException, NullPointerException, NotBoundException {
		goodsListDataService = (GoodsListDataService) RMIUtility.getImpl(gl_service);
		try {
			goodsListPO = goodsListDataService.getGoodsList().getObj();
		} catch (NullPointerException e) {
			e.printStackTrace();
			//goodsListPO = new GoodsListPO();
		}
		
		glbLservice = new GLBLImpl(goodsListPO);
		gl_signal_BLservice = new GL_signal_Impl(goodsListPO);
		try {
			gl_GT_BLservice = new GL_GT_Impl(goodsListPO);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		

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

	
	
	public void refresh() throws RemoteException {
		try {
			goodsListPO = ((GoodsListDataService)RMIUtility.getImpl(gl_service)).getGoodsList().getObj();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	// for glblservice
	public boolean delete(GoodsModelVO goods) throws Exception {
		boolean res = glbLservice.delete(goods);
		goodsListDataService.delete(new GoodsModelPO(goods));
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
		return res;
	}

	//for sale and stock
	public boolean checkGoodsExists(GoodsVO goodsVO) throws Exception {
		boolean res = gl_stock_BLservice.checkGoodsExists(goodsVO);
		return res;
	}

		
	/*
	 * for signal(non-Javadoc)
	 * @see businesslogicservice.GoodsListblservice.GL_signal_BLservice#checkSignalModifiable(vo.GoodsVO)
	 */
	public boolean checkSignalModifiable(GoodsVO goodsVO) throws Exception {
		boolean res = gl_signal_BLservice.checkSignalModifiable(goodsVO);
		return res;
	}

	public GoodsModelPO set_signal_name(GoodsVO goods) throws Exception {
		GoodsModelPO res = gl_signal_BLservice.set_signal_name(goods);
		goodsListDataService.update(res);
		return res; 
	}

	public int getSignal(GoodsVO goods) throws Exception {
		int res = gl_signal_BLservice.getSignal(goods);
		return res;
	}

	
	public boolean check_signal(GoodsVO goods) throws Exception {
		boolean res = gl_stock_BLservice.checkGoodsExists(goods);
		return res;
	}
	
	/*
	 *  for receipt(non-Javadoc)
	 * @see businesslogicservice.GoodsListblservice.GL_receipt_BLservice#check_rece(po.GoodsPO)
	 */
	public boolean check_rece(GoodsPO goods) throws Exception {
		boolean res = gl_stock_BLservice.checkGoodsExists(new GoodsVO(goods));
		return res;
	}

	public int amount(GoodsPO goods) throws Exception {
		int res = gl_receipt_BLservice.amount(goods);
		return res;
	}



	public GoodsModelPO getGoodsModelPO(String id) throws Exception {
		GoodsModelPO res = gl_receipt_BLservice.getGoodsModelPO(id);
		return res;
	}
	
	// for goodsType
	
	public boolean checkEverHas(String info) throws Exception {
		boolean res = gl_GT_BLservice.checkEverHas(info);
		return res;
	}

	public HashMap<String, GoodsModelPO> getGoodsModelPOs() {
		return goodsListPO.getGoodsModels();
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

	public HashMap<String, GoodsModelVO> getGoodsModelVOs() throws Exception {
		HashMap<String, GoodsModelVO> res = glbLservice.getGoodsModelVOs();
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
