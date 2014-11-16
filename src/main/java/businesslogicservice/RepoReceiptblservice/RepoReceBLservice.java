package businesslogicservice.RepoReceiptblservice;

import java.util.ArrayList;

import po.GoodsReceiptPO;
import po.ReceiptPO;
import vo.GoodsVO;
import vo.ReceiptConditionVO;
import vo.RepoReceVO;


public interface RepoReceBLservice {
	
	ArrayList<RepoReceVO> find(ReceiptConditionVO conditionVO) throws Exception;
	RepoReceVO showReceipt() throws Exception;
	RepoReceVO sendReceipt() throws Exception;
	
	GoodsReceiptPO giftReceipt() throws Exception;

	void receive_receipt(ReceiptPO po);
	
	String input(GoodsVO goods) throws Exception;
}
