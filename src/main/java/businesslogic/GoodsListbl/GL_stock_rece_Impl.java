package businesslogic.GoodsListbl;

import businesslogicservice.GoodsListblservice.GL_receipt_BLservice;
import businesslogicservice.GoodsListblservice.GL_stock_BLservice;
import po.GoodsListPO;
import po.GoodsModelPO;
import po.GoodsPO;
import vo.GoodsVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

public class GL_stock_rece_Impl implements GL_stock_BLservice,
		GL_receipt_BLservice {



	public GL_stock_rece_Impl() {

	}

	// this method will not be invoked
	public boolean check_rece(GoodsPO goods) throws Exception {
		System.err.println("this method shouldn't be invoked");
		System.exit(0);
		return false;
	}

	public GoodsListPO goodsListPO() throws RemoteException {
		return GL_controller.goodsListDataService.getGoodsList().getObj();
	}
	public GoodsModelPO getGoodsModelPO(String id) throws Exception {
		HashMap<String, GoodsModelPO> temp = goodsListPO().getGoodsModels();
		return temp.get(id);
	}

	public int amount(GoodsPO goods) throws Exception {
		HashMap<String, GoodsModelPO> temp = goodsListPO().getGoodsModels();
		GoodsModelPO goodsModelPO = temp.get(goods.getId());
		return goodsModelPO.getAmount();
	}

	public boolean checkGoodsExists(GoodsVO goodsVO) throws Exception {
		HashMap<String, GoodsModelPO> temp = goodsListPO().getGoodsModels();

		return !(temp.get(goodsVO.id) == null);
	}

//	public boolean addAmount(GoodsVO goods) throws Exception {
//		if (!checkGoodsExists(goods)) {
//			return false;
//		}
//		HashMap<String, GoodsModelPO> tempGoodsModelPOs = goodsListPO
//				.getGoodsModels();
//		HashMap<String, ArrayList<GoodsPO>> tempGoods = goodsListPO.getGoods();
//		// update the records of stock and sale
//		ArrayList<GoodsPO> batchGoods = new ArrayList<GoodsPO>();
//		batchGoods.add(new GoodsPO(goods));
//		tempGoods.put(goods.id, batchGoods);
//		// update the goods model: amount, everHas, lastInPrice
//		GoodsModelPO tempGoodsModelPO = tempGoodsModelPOs.get(goods.id);
//		tempGoodsModelPO.setAmount(tempGoodsModelPO.getAmount() + goods.amount);
//		tempGoodsModelPO.setEverHas(true);
//		tempGoodsModelPO.setLastInPrice(goods.inPrice);
//		return true;
//
//	}
//
//	public boolean addAmount(ArrayList<GoodsVO> goodsArrayList)
//			throws Exception {
//		boolean testAdd = false;
//		for (GoodsVO goodsVO : goodsArrayList) {
//			testAdd = addAmount(goodsVO);
//			if (!testAdd) {
//				return false;
//			}
//		}
//		return true;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see
//	 * businesslogicservice.GoodsListblservice.GL_stock_BLservice#reduAmount
//	 * (vo.GoodsVO) return false : no such goods or no enough goods to sell
//	 */
//	public boolean reduAmount(GoodsVO goods) throws Exception {
//		if (!checkGoodsExists(goods)) {
//			return false;
//		}
//		HashMap<String, GoodsModelPO> tempGoodsModelPOs = goodsListPO
//				.getGoodsModels();
//		HashMap<String, ArrayList<GoodsPO>> tempGoods = goodsListPO.getGoods();
//
//		GoodsModelPO tempGoodsModelPO = tempGoodsModelPOs.get(goods.id);
//		ArrayList<GoodsPO> goodsPOs = tempGoods.get(goods.id);
//		if (tempGoodsModelPO.getAmount() < goods.amount) {
//			return false;
//		}
//		// update the records of stock and sale
//		for (GoodsPO goodsPO : goodsPOs) {
//			int temAmout = goodsPO.getAmount();
//			if (temAmout >= goods.amount) {
//				goodsPO.setAmount(temAmout - goods.amount);
//			} else {
//				goodsPO.setAmount(0);
//				goods.amount -= temAmout;
//			}
//		}
//
//		// update the goods model: amount, lastInPrice
//		tempGoodsModelPO.setAmount(tempGoodsModelPO.getAmount() - goods.amount);
//		tempGoodsModelPO.setLastOutPrice(goods.outPrice);
//
//		// notify the bl_signal
//		new GL_signal_Impl(goodsListPO).update_when_sale(goods);
//		return true;
//	}
//
//	public boolean reduAmount(ArrayList<GoodsVO> goodsArrayList)
//			throws Exception {
//		boolean testRedu = false;
//		for (GoodsVO goodsVO : goodsArrayList) {
//			testRedu = reduAmount(goodsVO);
//			if (!testRedu) {
//				return false;
//			}
//		}
//		return true;
//	}

	
	@Override
	public ArrayList<String> sell_type() throws RemoteException {
		ArrayList<String> sell = new ArrayList<String>();
		HashMap<String, GoodsModelPO> goodsModels = goodsListPO().getGoodsModels();
		for (String temp : goodsModels.keySet()) {
			GoodsModelPO gm = goodsModels.get(temp);
			
			if (gm.getAmount() > 0) {
				sell.add(temp+"("+gm.getName()+")");
			} 
		}
		return sell;
	}

	@Override
	public ArrayList<String> stock_type() throws RemoteException {
		ArrayList<String> stock = new ArrayList<String>();
		HashMap<String, ArrayList<GoodsPO>> goods = goodsListPO().getGoods();
		for (String temp : goods.keySet()) {
			GoodsPO gm = goods.get(temp).get(0);
			stock.add(temp+"("+gm.getName()+")");
		}
		return stock;
	}

}
