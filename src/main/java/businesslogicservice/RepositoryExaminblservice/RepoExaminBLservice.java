package businesslogicservice.RepositoryExaminblservice;

import java.util.ArrayList;

import po.InOutRepoPO;

public interface RepoExaminBLservice {
	ArrayList<InOutRepoPO> countInOut() throws Exception;
}
