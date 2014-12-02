package businesslogic.BankManagebl;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.BankManagedataservice.BankManagedataservice;
import dataservice.Clientdataservice.ClientDataService;
import po.BankPO;
import po.ResultMessage;
import util.RMIUtility;
import vo.BankVO;
public class BankManage {
	private static BankManagedataservice dataService;
	public BankManage() throws RemoteException, NotBoundException {
        if (dataService == null)
            dataService = (BankManagedataservice) RMIUtility.getImpl("BankManage");
    }
	public ResultMessage add(BankPO po)throws Exception{
		ResultMessage result=dataService.insert(po);
		return result;
	}
	public ResultMessage delete(BankPO po)throws Exception{
		ResultMessage result=dataService.delete(po);
		return result;
	}
	public ResultMessage modify(BankPO po)throws Exception{
		ResultMessage result=dataService.update(po);
		return result;	
	}
	public ResultMessage search(String field)throws Exception{
		ResultMessage result=null;
		if(field==null){
			result=dataService.finds();
		}else{
			result=dataService.find(field);
		}
		return result;
	}
}
