package businesslogic.Approvebl;

import businesslogicservice.Approveblservice.Approve_Detail_BLservice;
import po.ReceiptPO;

public class Approve_Detail implements Approve_Detail_BLservice{

	@Override
	public ReceiptPO show(int serial) throws Exception {
		
		// TODO Auto-generated method stub
		return null;
	}
	ReceiptPO modify(ReceiptPO po){
		return null;
	}
	@Override
	public void confirm() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean examine(ReceiptPO r) {
		// TODO Auto-generated method stub
		return false;
	}

}
