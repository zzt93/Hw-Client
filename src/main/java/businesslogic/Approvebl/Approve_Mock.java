package businesslogic.Approvebl;

import businesslogicservice.Approveblservice.Approve_Detail_BLservice;
import businesslogicservice.Approveblservice.Approve_List_BLservice;
import po.*;
import vo.GoodsReceiptVO;
import vo.PayVO;

import java.math.BigDecimal;
import java.util.ArrayList;


public class Approve_Mock implements Approve_Detail_BLservice, Approve_List_BLservice {
	Approve_List approveImpl;

    public ArrayList<ReceiptPO> showList() {
		ArrayList<ReceiptPO> arr = new ArrayList<ReceiptPO>();
		arr.add(new StockReceiptPO(10001,"bendan","shazi","cangku1",new BigDecimal(0)));
		arr.add(new GoodsReceiptVO(null,"user"));
		arr.add(new RepoReceiptPO("id",100,1200,"user"));
		arr.add(new PayVO("client","operator",100));
		
        // TODO Auto-generated method stub
		return arr;
    }

    public ArrayList<ReceiptPO> refresh() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean passList(ArrayList<ReceiptPO> array) {
        // TODO Auto-generated method stub
		return true;
    }

    public ReceiptPO show(int serial) {
        // TODO Auto-generated method stub
        return null;
    }

    public void confirm() {
        // TODO Auto-generated method stub

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

//    @Override
//    public ArrayList<ReceiptPO> screen(String item) {
//        // TODO Auto-generated method stub
//        return null;
//    }

    @Override
    public ArrayList<ReceiptPO> order(String item) {
        // TODO Auto-generated method stub
        return null;
    }

	@Override
	public void upload(ArrayList<ReceiptPO> po) throws Exception {
		// TODO Auto-generated method stub
		
	}





}
