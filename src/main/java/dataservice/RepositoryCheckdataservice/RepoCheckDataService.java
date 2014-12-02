package dataservice.RepositoryCheckdataservice;

import po.RepoFilterPO;
import po.RepoPO;
import po.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RepoCheckDataService extends Remote {
	ResultMessage<ArrayList<RepoPO>> getRepo() throws RemoteException;
	ResultMessage<Boolean> initialize(ArrayList<RepoPO> repoPOs) throws RemoteException;
	
	ResultMessage<Boolean> insert(RepoPO repoPO) throws RemoteException;
	ResultMessage<Boolean> delete(RepoPO repoPO) throws RemoteException;
	ResultMessage<Boolean> update(RepoPO repoPO) throws RemoteException;
	
	ResultMessage<RepoPO> efind(String info) throws RemoteException;
	ResultMessage<ArrayList<RepoPO>> ifind(RepoFilterPO filterPO) throws RemoteException;
	
}
