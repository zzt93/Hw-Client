package ApproveBLService;

import java.util.ArrayList;

import PO.ReceiptPO;

public interface Approve_List_BLservice {
	ArrayList<ReceiptPO> showList();
	ArrayList<ReceiptPO> refresh();
	boolean passList(ArrayList<ReceiptPO> array);
	public ArrayList<ReceiptPO> upload();
	public String message(String userName);
}
