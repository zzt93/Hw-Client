package businesslogicservice.RepoReceiptblservice;

import java.util.ArrayList;

import po.GoodsReceiptPO;
import po.ReceiptPO;
import po.RepoReceiptPO;
import vo.GoodsModelVO;
import vo.GoodsReceiptVO;
import vo.GoodsVO;
import vo.ReceiptConditionVO;
import vo.RepoReceiptVO;


public interface RepoReceBLservice {
	
	ArrayList<RepoReceiptVO> showRepoReceipt() throws Exception;
	ArrayList<GoodsReceiptVO> showGoodsReceipt() throws Exception;
	ArrayList<GoodsModelVO> showGiftList() throws Exception;
	ArrayList<GoodsModelVO> showGoodsList() throws Exception;
	ArrayList<ReceiptPO> sendReceipt(ReceiptConditionVO condition) throws Exception;
	

	void receive_receipt(ReceiptPO po) throws Exception;
	
	String produceRepoReceipt(ArrayList<GoodsVO> goods) throws Exception;
	boolean produceGoodsReceipt(GoodsReceiptVO goodsVO) throws Exception;
}
