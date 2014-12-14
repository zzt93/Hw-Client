package po;

import vo.GoodsReceiptVO;
import vo.GoodsVO;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Edited by dzh,add extension,11.12
 *
 */
public class GoodsReceiptPO extends ReceiptPO implements Serializable {
	private static final long serialVersionUID = 1L;
	ArrayList<GoodsVO> goodsVOs;
	double sumOfGifts;
	String user;
	public GoodsReceiptPO(GoodsReceiptVO goodsReceiptVO) {
		user = goodsReceiptVO.getUser();
		for (GoodsVO goodsVO : goodsReceiptVO.getGoodsVOs()) {
			goodsVOs.add(goodsVO);
		}
		sumOfGifts = goodsReceiptVO.getSumOfGifts();
	}
	
	public ArrayList<GoodsVO> getGoods() {
		return goodsVOs;
	}
	public String getUser() {
		return user;
	}

	public void setGoodsPOs(ArrayList<GoodsVO> goodsPOs) {
		this.goodsVOs = goodsPOs;
	}
	public double getSumOfGifts() {
		return sumOfGifts;
	}
	public void setSumOfGifts(double sumOfGifts) {
		this.sumOfGifts = sumOfGifts;
	}
	public String getId(){
		return number;
	}

	
}
