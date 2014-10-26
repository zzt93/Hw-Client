package dataservice.Repositorydataservice;

import java.util.ArrayList;

import po.RepoFilterPO;
import po.RepoPO;

public interface RepoCheckDataService {
	ArrayList<RepoPO> getRepo();
	boolean initialize(ArrayList<RepoPO> repoPOs);
	
	boolean insert(RepoPO repoPO);
	boolean delete(RepoPO repoPO);
	boolean update(RepoPO repoPO);
	
	RepoPO efind(String info);
	ArrayList<RepoPO> ifind(RepoFilterPO filterPO);
	
}
