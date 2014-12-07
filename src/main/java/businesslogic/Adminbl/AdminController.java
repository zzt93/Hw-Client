package businesslogic.Adminbl;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.Admindataservice.AdminDataService;
import dataservice.Clientdataservice.ClientDataService;
import po.ResultMessage;
import po.UserPO;
import util.RMIUtility;
import businesslogicservice.Adminblservice.AdminBLService;

public class AdminController implements AdminBLService{
	 private static AdminDataService impl;

	    public AdminController() throws RemoteException, NotBoundException {
	        if (impl == null)
	            impl = (AdminDataService) RMIUtility.getImpl("Admin");
	    }
	public ArrayList<UserPO> show() throws Exception {
		ResultMessage result=impl.show();
		result.throwIfFailed();
		return (ArrayList<UserPO>)result.getObj();
	}

	public UserPO newUser() throws Exception {
		return null;
	}


	public boolean delete(UserPO po) throws Exception {
		ResultMessage result=impl.delete(po);
		result.throwIfFailed();
		return false;
	}


	public boolean confirm(UserPO po) throws Exception {
		ResultMessage result=impl.confirm(po);
		result.throwIfFailed();
		return false;
	}
	@Override
	public String getUser() throws Exception {
		return new Adminbl().getUser();
		// TODO Auto-generated method stub
		
	}
	
		
}
	

