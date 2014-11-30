package businesslogic.Adminbl;

import businesslogicservice.Adminblservice.AdminBLService;
import dataservice.Admindataservice.AdminDataService;
import po.ResultMessage;
import po.UserPO;
import util.RMIUtility;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Admin_mock implements AdminBLService{
	private static AdminDataService ads;
	private static ArrayList<UserPO> arrUser;
	Admin_mock(){
		if(ads==null){
			try {
				ads = (AdminDataService)RMIUtility.getImpl("Admin");
			} catch (RemoteException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public ArrayList<UserPO> show() throws RemoteException{
		@SuppressWarnings("unchecked")
		ResultMessage<ArrayList<UserPO>> rm = ads.show();
		if(rm.getErrMessage()==null){
			arrUser = rm.getObj();
			return rm.getObj();
		}
		// TODO Auto-generated method stub
		return null;
	}

	public UserPO newUser() throws RemoteException{
		
		return new UserPO(arrUser.size()+1);
		// TODO Auto-generated method stub

	}
	public UserPO newUser(int i ,String n,String p,String userRole) throws RemoteException{
		
		return new UserPO(i,n,p,userRole);
		// TODO Auto-generated method stub

	}

	public boolean delete(UserPO po) throws RemoteException{
		if(arrUser.contains(po)){
			arrUser.remove(po);
			return true;
		}
		return false;
	}

	public boolean confirm(UserPO po) throws RemoteException{
		// TODO Auto-generated method stub
		if(arrUser.add(po)){
			return true;
		}
		return false;
	}

	UserPO getCurrentUsers(){
		return null;
		//?
	}

}
