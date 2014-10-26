package businesslogicservice.Adminblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.UserPO;

public interface AdminBLService {
	public ArrayList<UserPO> show() throws RemoteException;
	public UserPO newUser() throws RemoteException;
	public boolean delete(UserPO po) throws RemoteException;
	public boolean confirm() throws RemoteException;
	
}
