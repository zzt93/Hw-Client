package dataservice.RepositoryCheckdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.RepoFilterPO;
import po.RepoPO;
import po.ResultMessage;

public interface RepoCheckDataService {
	ResultMessage<ArrayList<RepoPO>> getRepo() throws RemoteException;
	ResultMessage<Boolean> initialize(ArrayList<RepoPO> repoPOs) throws RemoteException;
	
	ResultMessage<Boolean> insert(RepoPO repoPO) throws RemoteException;
	ResultMessage<Boolean> delete(RepoPO repoPO) throws RemoteException;
	ResultMessage<Boolean> update(RepoPO repoPO) throws RemoteException;
	
	ResultMessage<RepoPO> efind(String info) throws RemoteException;
	ResultMessage<ArrayList<RepoPO>> ifind(RepoFilterPO filterPO) throws RemoteException;
	
}
