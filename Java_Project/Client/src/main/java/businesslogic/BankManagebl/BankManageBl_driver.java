package businesslogic.BankManagebl;

import businesslogic.BankManagebl.BankManagebl_stub;
import po.ResultMessage;
import vo.BankVO;

public class BankManageBl_driver {
	BankVO bank=new BankVO("银行账户2",259.2,"这是备注");
	public void drive(BankManagebl_stub BankManage){
		try {
			BankManage.add(bank);
		} catch (Exception e) {
			String error=e.getMessage();
			System.out.println(error);
		}
		try {
			BankManage.delete(bank);
		} catch (Exception e) {
			String error=e.getMessage();
			System.out.println(error);
		}
		try {
			BankManage.modify(bank);
		} catch (Exception e) {
			String error=e.getMessage();
			System.out.println(error);
		}
		try {
			BankManage.search("没有");
		} catch (Exception e) {
			String error=e.getMessage();
			System.out.println(error);
		}
		
	}
}
