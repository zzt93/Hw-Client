package businesslogicservice.RepositoryExaminblservice;

import po.InOutRepoPO;

public interface RepoExaminBLservice {
	InOutRepoPO countInOut(String start, String end) throws Exception;
}
