package businesslogic.Approvebl;

import businesslogicservice.Approveblservice.Approve_Detail_BLservice;
import businesslogicservice.Approveblservice.Approve_List_BLservice;
import po.ReceiptPO;

import java.util.ArrayList;


public class Approve_Mock implements Approve_Detail_BLservice,Approve_List_BLservice{
	

	public ArrayList<ReceiptPO> showList() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ReceiptPO> refresh() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean passList(ArrayList<ReceiptPO> array) {
		// TODO Auto-generated method stub
		return false;
	}

	public ReceiptPO show(int serial) {
		// TODO Auto-generated method stub
		return null;
	}

	public void confirm() {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<ReceiptPO> upload() {
		// TODO Auto-generated method stub
		return null;
	}

	public String message(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean examine(ReceiptPO r) {
		// TODO Auto-generated method stub
		return false;
	}

}
