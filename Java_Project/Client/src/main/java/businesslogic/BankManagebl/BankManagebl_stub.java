package businesslogic.BankManagebl;

import vo.BankVO;
import businesslogicservice.BankManageblservice.BankManageblservice;

public class BankManagebl_stub implements BankManageblservice {

	public void add(BankVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void delete(BankVO vo) throws Exception {
		// TODO Auto-generated method stub

	}

	public void modify(BankVO vo) throws Exception {
		// TODO Auto-generated method stub

	}

	public BankVO[] search(String field) throws Exception {
		// TODO Auto-generated method stub
		BankVO[] test=new BankVO[2];
		test[0]=new BankVO("银行账户1",3000,"这是备注");
		test[1]=new BankVO("银行账户2",2594.21,"还是备注");
		return test;
	}

}
