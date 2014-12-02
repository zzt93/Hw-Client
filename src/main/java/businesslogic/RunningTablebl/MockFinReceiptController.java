package businesslogic.RunningTablebl;

import businesslogic.FinancialReceiptbl.FinReceiptController;
import po.CashPO;
import po.ReceiptPO;
import po.ReceiptType;
import po.ResultMessage;
import vo.CashVO;
import vo.ReceiptConditionVO;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class MockFinReceiptController extends FinReceiptController{
	public MockFinReceiptController() throws RemoteException, NotBoundException {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArrayList<ReceiptPO> getReceipt(ReceiptConditionVO vo)throws Exception{
		if(vo.type==ReceiptType.CASH){
			CashPO cash=new CashPO();
			ArrayList<ReceiptPO> list=new ArrayList<ReceiptPO>();
			list.add(cash);
			return list;
		}else{
			ResultMessage result=new ResultMessage("实现不完整，只能查询Cash类单据",null);
			result.throwIfFailed();
			return null;
		}
	}
	public void creditCash(CashVO vo)throws Exception{
		ResultMessage result=new ResultMessage("红冲单功能通过集成测试",null);
		result.throwIfFailed();
	}
}
