package businesslogicservice.BankManageblservice;
import vo.BankVO;

public interface BankManageblservice {
	public void add(BankVO vo) throws Exception;
	public void delete(BankVO vo)throws Exception;
	public void modify(BankVO vo)throws Exception;
	public BankVO[] search(String field)throws Exception;
}
