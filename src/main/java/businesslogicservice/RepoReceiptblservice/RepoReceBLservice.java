package businesslogicservice.RepoReceiptblservice;

import po.ReceiptPO;
import vo.*;

import java.util.ArrayList;


public interface RepoReceBLservice {
	
	ArrayList<RepoReceiptVO> showRepoReceipt() throws Exception;
	ArrayList<GoodsReceiptVO> showGoodsReceipt() throws Exception;
	ArrayList<GoodsModelVO> showGiftList() throws Exception;
	ArrayList<GoodsModelVO> showGoodsList() throws Exception;
	ArrayList<ReceiptPO> sendReceipt(ReceiptConditionVO condition) throws Exception;
	

	void receive_receipt(ReceiptPO po) throws Exception;
	
	String produceRepoReceipt(GoodsVO goods) throws Exception;
	boolean produceGoodsReceipt(GoodsReceiptVO goodsVO) throws Exception;
}
