package dataservice.ApproveDataService;

import po.ReceiptPO;
import po.ResultMessage;

import java.util.ArrayList;

public interface ApproveDataService {
	public ResultMessage uploadReceipt(ArrayList<ReceiptPO> po);
}
