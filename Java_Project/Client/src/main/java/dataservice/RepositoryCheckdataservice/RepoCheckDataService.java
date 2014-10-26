package dataservice.RepositoryCheckdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.RepoFilterPO;
import po.RepoPO;

public interface RepoCheckDataService {
	ArrayList<RepoPO> getRepo() throws RemoteException;
	boolean initialize(ArrayList<RepoPO> repoPOs) throws RemoteException;
	
	boolean insert(RepoPO repoPO) throws RemoteException;
	boolean delete(RepoPO repoPO) throws RemoteException;
	boolean update(RepoPO repoPO) throws RemoteException;
	
	RepoPO efind(String info) throws RemoteException;
	ArrayList<RepoPO> ifind(RepoFilterPO filterPO) throws RemoteException;
	
}
