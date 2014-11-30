package businesslogicservice.Approveblservice;

import po.ReceiptPO;

import java.util.ArrayList;

public interface Approve_List_BLservice {
	ArrayList<ReceiptPO> showList() throws Exception;
	ArrayList<ReceiptPO> refresh() throws Exception;
	boolean passList(ArrayList<ReceiptPO> array) throws Exception;
	public ArrayList<ReceiptPO> upload() throws Exception;
	public String message(String userName) throws Exception;
}
