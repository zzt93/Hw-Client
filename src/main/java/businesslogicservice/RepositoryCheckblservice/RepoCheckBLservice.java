package businesslogicservice.RepositoryCheckblservice;

import po.RepoPO;

public interface RepoCheckBLservice {
	
	RepoPO checkAndSum() throws Exception;
	
	boolean export(int which) throws Exception;
}
