package businesslogic.BankManagebl;

import po.ResultMessage;
import vo.BankVO;
import businesslogicservice.BankManageblservice.BankManageblservice;

public class BankManagebl_stub implements BankManageblservice {
	ResultMessage right=new ResultMessage(null,null);
	ResultMessage error=new ResultMessage("出现了问题",null);
	public void add(BankVO vo) throws Exception {
		right.throwIfFailed();
		System.out.println("增加成功");
	}

	public void delete(BankVO vo) throws Exception {
		error.throwIfFailed();
		System.out.println("删除成功");
	}

	public void modify(BankVO vo) throws Exception {
		right.throwIfFailed();
		System.out.println("修改成功");
	}

	public BankVO[] search(String field) throws Exception {
		BankVO[] test=new BankVO[2];
		test[0]=new BankVO("银行账户1",3000,"这是备注");
		test[1]=new BankVO("银行账户2",2594.21,"还是备注");
		return test;
	}

}
