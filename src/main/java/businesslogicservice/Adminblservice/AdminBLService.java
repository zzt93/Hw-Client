package businesslogicservice.Adminblservice;

import po.UserPO;

import java.util.ArrayList;

public interface AdminBLService {
	public ArrayList<UserPO> show() throws Exception;
	public UserPO newUser() throws Exception;
	public boolean delete(UserPO po) throws Exception;
	public boolean confirm(UserPO po) throws Exception;
	public String getUser() throws Exception;
}
