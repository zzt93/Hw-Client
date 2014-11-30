package businesslogicservice.RepositoryExaminblservice;

import vo.InOutRepoVO;

public interface RepoExaminBLservice {
	InOutRepoVO countInOut(String start, String end) throws Exception;
}
