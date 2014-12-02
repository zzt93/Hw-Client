package dataservice.ApproveDataService;

import po.ReceiptPO;
import po.ResultMessage;

import java.rmi.Remote;
import java.util.ArrayList;

public interface ApproveDataService extends Remote {
	public ResultMessage uploadReceipt(ArrayList<ReceiptPO> po);
}
