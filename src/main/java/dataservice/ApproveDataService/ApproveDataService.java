package dataservice.ApproveDataService;

import java.util.ArrayList;

import po.ReceiptPO;
import po.ResultMessage;

public interface ApproveDataService {
	public ResultMessage uploadReceipt(ArrayList<ReceiptPO> po);
}
