package businesslogicservice.Approveblservice;

import po.ReceiptPO;

public interface Approve_Detail_BLservice {
	ReceiptPO show(int serial) throws Exception;
	void confirm() throws Exception;
	boolean examine(ReceiptPO r);
	
}