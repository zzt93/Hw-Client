package businesslogicservice.Adminblservice;

import java.util.ArrayList;

import po.UserPO;

public interface AdminBLService {
	public ArrayList<UserPO> show() throws Exception;
	public UserPO newUser() throws Exception;
	public boolean delete(UserPO po) throws Exception;
	public boolean confirm() throws Exception;
	
}
