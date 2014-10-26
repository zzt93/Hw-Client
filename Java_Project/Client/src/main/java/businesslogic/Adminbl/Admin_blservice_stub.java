package businesslogic.Adminbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.UserPO;
import businesslogicservice.Adminblservice.AdminBLService;

public class Admin_blservice_stub implements AdminBLService{

	public ArrayList<UserPO> show() throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public UserPO newUser() throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(UserPO po) throws RemoteException{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean confirm() throws RemoteException{
		// TODO Auto-generated method stub
		return false;
	}
	
}
