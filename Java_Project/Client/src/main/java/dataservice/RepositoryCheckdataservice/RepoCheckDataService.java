package dataservice.RepositoryCheckdataservice;

import java.util.ArrayList;

import po.RepoFilterPO;
import po.RepoPO;

public interface RepoCheckDataService {
	ArrayList<RepoPO> getRepo() throws Exception;
	boolean initialize(ArrayList<RepoPO> repoPOs) throws Exception;
	
	boolean insert(RepoPO repoPO) throws Exception;
	boolean delete(RepoPO repoPO) throws Exception;
	boolean update(RepoPO repoPO) throws Exception;
	
	RepoPO efind(String info) throws Exception;
	ArrayList<RepoPO> ifind(RepoFilterPO filterPO) throws Exception;
	
}
